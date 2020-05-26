/**
 * 
 */
package com.dominiquedamba.baseapp.controller;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominiquedamba.baseapp.dao.RoleDAO;
import com.dominiquedamba.baseapp.dao.UserDAO;
import com.dominiquedamba.baseapp.model.Role;
import com.dominiquedamba.baseapp.model.User;
import com.dominiquedamba.baseapp.response.JsonObjectResponse;
import com.dominiquedamba.baseapp.util.Slugger;

/**
 * @author DOMINIQUE DAMBA
 *
 */
@RestController

public class InitAdminController {
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private PasswordEncoder encoder;
	@Autowired
	public InitAdminController(UserDAO userDAO, RoleDAO roleDAO,
			PasswordEncoder encoder) {
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.encoder = encoder;
	}

	@GetMapping("/api/init-admin")
	public ResponseEntity<?> init() {
		Date createdAt = new Date();
		Date updatedAt = new Date();
		Instant instant = Instant.now();






		User user = new User("systeme", "avatar.png", "system@fake.io", Slugger.createSlug("system"));
		user.setCreatedAt(instant);
		user.setUpdatedAt(instant);
		Role role = new Role("System", Slugger.createSlug("system"));
		role.setCreatedAt(createdAt);
		role.setUpdatedAt(updatedAt);



		String password = encoder.encode("password");
		user.setRoles(Collections.singleton(role));
		user.setPassword(password);

		Map<String, Object> map = new HashMap<>();

 
		roleDAO.store(role);

		userDAO.store(user);

		map.put("user", user);


		return ResponseEntity.ok(new JsonObjectResponse(true, "Liste des partenaires", map));
	}

}
