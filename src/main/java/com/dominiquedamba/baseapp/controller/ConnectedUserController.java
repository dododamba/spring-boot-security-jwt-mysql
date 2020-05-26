/**
 * 
 */
package com.dominiquedamba.baseapp.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.dominiquedamba.baseapp.request.GetConnectedUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominiquedamba.baseapp.util.Routes;

/**
 * @author dominiquedamba
 *
 */
@RestController
@RequestMapping(Routes.CONNECTED_USER_MAPPING)
public class ConnectedUserController {

	Optional<String> connectedOptional;

	public ResponseEntity<String> getConnectedUser(@Valid GetConnectedUserRequest request) {
		return null;

	}
}
