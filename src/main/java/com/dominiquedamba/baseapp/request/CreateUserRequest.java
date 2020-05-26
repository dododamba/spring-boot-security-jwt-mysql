package com.dominiquedamba.baseapp.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CreateUserRequest {
	@NotEmpty(message = "enter your email")
	@Email(message = "enter a valid email !")
	private String email;
	@NotEmpty(message = "enter the username")
	private String username;
	@NotEmpty(message = "enter the password")
	private String password;
	@NotEmpty(message = "enter the password confirmation")
	private String confirmation;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the employeSlug
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the employeSlug to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the role
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the role to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
}
