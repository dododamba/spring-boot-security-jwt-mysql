/**
 * 
 */
package com.dominiquedamba.baseapp.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.dominiquedamba.baseapp.dao.RoleDAO;
import com.dominiquedamba.baseapp.model.Role;
import com.dominiquedamba.baseapp.response.JsonObjectResponse;

/**
 * @author DOMINIQUE DAMBA
 *
 */
@RestController
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
public class RoleRestController {
	private RoleDAO roleDAO;

	@Autowired
	public RoleRestController(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@GetMapping("/api/role")
	public ResponseEntity<?> fecth() {
		Collection<Role> roles = roleDAO.all();
		if (roles.isEmpty()) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "Liste role vide", null));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("roles", roles);
		return ResponseEntity.ok(new JsonObjectResponse(true, "Liste des roles", map));
	}

	@PostMapping("/api/role")
	public ResponseEntity<?> create(@Valid @RequestBody Role role) {
		if (role.getId() != null) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La role existe !", null));
		}
		roleDAO.store(role);
		return ResponseEntity.ok(new JsonObjectResponse(true, "Role crée avec succès !", null));
	}

	@PutMapping("/api/role")
	public ResponseEntity<?> set(@Valid @RequestBody Role role) {
		if (role.getId() == null) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La role n'existe pas !", null));
		}
		roleDAO.update(role);
		Map<String, Object> map = new HashMap<>();
		map.put("role", role);
		return ResponseEntity.ok(new JsonObjectResponse(false, "Role mise à jours avec succès", map));
	}

	@PutMapping("/api/role/delete")
	public ResponseEntity<?> drop(@Valid @RequestBody Role role) {
		if (role.getId() == null) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La role n'existe pas !", null));
		}
		roleDAO.delete(role);
		Map<String, Object> map = new HashMap<>();
		map.put("role", role);
		return ResponseEntity.ok(new JsonObjectResponse(false, "Role supprimé avec succès", map));
	}

	@PostMapping("/api/role/show")
	public ResponseEntity<?> select(@Valid @RequestBody String slug) {
		if (roleDAO.show(slug).isPresent()) {
			return ResponseEntity.ok(new JsonObjectResponse(false, "La role n'existe pas !", null));
		}
		Optional<Role> role = roleDAO.show(slug);
		Map<String, Object> map = new HashMap<>();
		map.put("role", role);
		return ResponseEntity.ok(new JsonObjectResponse(false, "Role mise à jours avec succès", map));
	}

}
