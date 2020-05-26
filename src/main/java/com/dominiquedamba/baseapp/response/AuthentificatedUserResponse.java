package com.dominiquedamba.baseapp.response;

import java.util.Optional;

import com.dominiquedamba.baseapp.model.User;

public class AuthentificatedUserResponse {

	private String jwt;
	private Optional<User> loggedUser;
	private String tokenType = "Bearer";

	public AuthentificatedUserResponse(String jwt, Optional<User> loggedUser) {
		this.jwt = jwt;
		this.loggedUser = loggedUser;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	/**
	 * @return the loggedUser
	 */
	public Optional<User> getLoggedUser() {
		return loggedUser;
	}

	/**
	 * @param loggedUser the loggedUser to set
	 */
	public void setLoggedUser(Optional<User> loggedUser) {
		this.loggedUser = loggedUser;
	}

	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
