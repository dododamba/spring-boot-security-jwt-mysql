package com.dominiquedamba.baseapp.model;

import com.dominiquedamba.baseapp.model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

/**
 */

@Entity
@Table(name = "tb_tmp_finex_users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })

public class User extends DateAudit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String username;

	@NotBlank
	private String avatar;

	@NaturalId
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String slug;

	@Temporal(TemporalType.TIMESTAMP)
	private Instant createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Instant updatedAt;
	@Temporal(TemporalType.DATE)
	private Date deletedAt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_tmp_finex_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User() {

	}

	/**
	 * @param name
	 * @param surname
	 * @param username
	 * @param avatar
	 * @param email
	 * @param slug
	 * @param telephone
	 * @param fix
	 * @param adresse
	 */
	public User(@NotBlank String username, @NotBlank String avatar, @NotBlank @Email String email,
			@NotBlank String slug) {
		this.username = username;
		this.avatar = avatar;
		this.email = email;
		this.slug = slug;

	}

	/**
	 * @param username
	 * @param avatar
	 * @param email
	 * @param password
	 * @param slug
	 */
	public User(@NotBlank String username, @NotBlank String avatar, @NotBlank @Email String email,
			@NotBlank String password, @NotBlank String slug) {
		this.username = username;
		this.avatar = avatar;
		this.email = email;
		this.password = password;
		this.slug = slug;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant date) {
		this.updatedAt = date;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}