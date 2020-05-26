/**
 * 
 */
package com.dominiquedamba.baseapp.controller;

import java.util.*;

import javax.validation.Valid;

import com.dominiquedamba.baseapp.model.User;
import com.dominiquedamba.baseapp.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.dominiquedamba.baseapp.dao.RoleDAO;
import com.dominiquedamba.baseapp.dao.UserDAO;
import com.dominiquedamba.baseapp.model.Role;
import com.dominiquedamba.baseapp.response.JsonObjectResponse;
import com.dominiquedamba.baseapp.util.Slugger;

/**
 * @author DOMINIQUE DAMBA
 *
 */

@RestController
public class UserRestController {
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private PasswordEncoder encoder;

	@Autowired
	public UserRestController(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder encoder) {
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.userDAO = userDAO;
		this.encoder = encoder;

	}

	@GetMapping("/api/user")
	public ResponseEntity<?> fecth() {
		Collection<User> users = userDAO.all();
		if (users.isEmpty()) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "Liste user vide", null));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("users", users);
		return ResponseEntity.ok(new JsonObjectResponse(true, "Liste des users", map));
	}

	@PostMapping("/api/user")
	public ResponseEntity<?> create(@Valid @RequestBody User user) {
		if (user.getId() != null) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La user existe !", null));
		}
		userDAO.store(user);
		return ResponseEntity.ok(new JsonObjectResponse(true, "User crée avec succès !", null));
	}

	@PutMapping("/api/user")
	public ResponseEntity<?> set(@Valid @RequestBody User user) {
		if (user.getId() == null) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La user n'existe pas !", null));
		}
		userDAO.update(user);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		return ResponseEntity.ok(new JsonObjectResponse(false, "User mise à jours avec succès", map));
	}

	@PutMapping("/api/user/delete")
	public ResponseEntity<?> drop(@Valid @RequestBody User user) {
		if (user.getId() == null) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La user n'existe pas !", null));
		}
		userDAO.delete(user);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		return ResponseEntity.ok(new JsonObjectResponse(false, "User supprimé avec succès", map));
	}



	@PostMapping("/api/user/show")
	public ResponseEntity<?> select(@Valid @RequestBody String slug) {
		if (userDAO.show(slug).isPresent()) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La user n'existe pas !", null));
		}
		Optional<User> user = userDAO.show(slug);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		return ResponseEntity.ok(new JsonObjectResponse(false, "User mise à jours avec succès", map));
	}

}
