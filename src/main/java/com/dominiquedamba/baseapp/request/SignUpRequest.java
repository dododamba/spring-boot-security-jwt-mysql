/**
 * 
 */
package com.dominiquedamba.baseapp.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author dominiquedamba
 *
 */
public class SignUpRequest {

	@NotEmpty(message = "Le nom est obligatore ! ")
	private String name;

	@NotEmpty(message = "Le prenom est obligatore ! ")
	private String surname;

	@NotEmpty(message = "Le email est obligatore ! ")
	@Email(message = "Entrez une adresse email valide !")
	private String email;

	@NotEmpty(message = "Le numero de téléphone est obligatore ! ")
	private String telephone;

	@NotEmpty(message = "Le pseudo est obligatore ! ")
	private String username;

	@NotEmpty(message = "Le mot de pass est obligatore ! ")
	private String password;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

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
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
