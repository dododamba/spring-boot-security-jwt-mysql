package com.dominiquedamba.baseapp.controller;

import com.dominiquedamba.baseapp.dao.RoleDAO;
import com.dominiquedamba.baseapp.dao.UserDAO;
import com.dominiquedamba.baseapp.model.Role;
import com.dominiquedamba.baseapp.model.User;
import com.dominiquedamba.baseapp.request.CreateUserRequest;
import com.dominiquedamba.baseapp.request.LoginRequest;
import com.dominiquedamba.baseapp.response.JsonObjectResponse;
import com.dominiquedamba.baseapp.response.JwtAuthenticationResponse;
import com.dominiquedamba.baseapp.security.JwtTokenProvider;
import com.dominiquedamba.baseapp.services.UserService;

import com.dominiquedamba.baseapp.util.Slugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    private Optional<User> loggedUser;

    @Autowired
    private UserService dao;


    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private PasswordEncoder encoder;

    @Autowired
    public AuthController(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder encoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.userDAO = userDAO;
        this.encoder = encoder;

    }



    protected boolean isEmail(String loginAttemp) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(loginAttemp);
        return mat.matches();
    }


    protected User getConnectedUser(String loginAttemp) {
        return isEmail(loginAttemp) ? dao.getUserByEmail(loginAttemp).get() : dao.getUserByUserName(loginAttemp).get();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {


        HashMap<String, Object> objMap = new HashMap<String, Object>();
        String loginAttempt = loginRequest.getUsernameOrEmail();

        if (dao.getUserByEmail(loginAttempt).isPresent() || dao.getUserByUserName(loginAttempt).isPresent()) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);
            User loggedUser = getConnectedUser(loginAttempt);

            /**
             * Serialisation du JWT
             */
            JwtAuthenticationResponse jwtResponse = new JwtAuthenticationResponse(jwt);

            /**
             * Map du user connecté
             *
             */


            objMap.put("user", loggedUser);
            objMap.put("jwt", jwtResponse);

            return ResponseEntity.ok(new JsonObjectResponse(true, "Credentials verified with success !", objMap));

        }


        return ResponseEntity.ok(new JsonObjectResponse(false, "Authentification error !", null));

    }

    @PostMapping("/register")
    public ResponseEntity<?> addUserAccount(@Valid @RequestBody CreateUserRequest request) {
        Role roleName = new Role();
        Optional<Role> role = roleDAO.showByNom("System");
        roleName = role.get();

        if (userDAO.getUserByUserName(request.getUsername()).isPresent()){
            return ResponseEntity.ok(new JsonObjectResponse(false, "this username is already taken! ", null));
        }

        if (userDAO.getUserByEmail(request.getEmail()).isPresent()){
            return ResponseEntity.ok(new JsonObjectResponse(false, "this email is already taken! ", null));
        }

        if (!Objects.equals(request.getPassword(), request.getConfirmation())){
            return ResponseEntity.ok(new JsonObjectResponse(false, "password and confirmation do'ent matches! ", null));
        }

        String password = encoder.encode(request.getPassword());
        User user = new User(request.getUsername(), "avatar.jpg", request.getEmail(), password,
                Slugger.createSlug("user-" + request.getUsername()));

        user.setRoles(Collections.singleton(roleName));

        userDAO.store(user);
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("user", user);

        return ResponseEntity.ok(new JsonObjectResponse(true, "User Added with success! ", objMap));

    }
}
