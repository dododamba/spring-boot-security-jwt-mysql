/**
 * 
 */
package com.dominiquedamba.baseapp.services;

import java.util.*;
import java.util.Optional;

import com.dominiquedamba.baseapp.model.User;
import com.dominiquedamba.baseapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominiquedamba.baseapp.dao.UserDAO;

/**
 * @author dominiquedamba
 *
 */

@Service
public class UserService implements UserDAO {

	@Autowired
	private UserRepository repository;

	@Override
	public Optional<User> getUserByUserNameOrEmail(String username, String email) {
		return repository.findByUsernameOrEmail(username, email);
	}

	@Override
	public Optional<User> getUserByUserName(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public User findBySlug(String slug) {

		return repository.findBySlug(slug);
	}

	@Override
	public User store(User string) {
		User storable = repository.save(string);
		return storable;
	}

	@Override
	public boolean existBySlug(String slug) {
		User string = repository.findBySlug(slug);
		Optional<User> optional = repository.findById(string.getId());
		if (optional.isPresent()) {
			return true;
		}

		return false;
	}

	@Override
	public Optional<User> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public Collection<User> all() {
		Collection<User> users = repository.findByDeletedAt(null);
		return users;
	}

	@Override
	public Optional<User> show(String slug) {
		return repository.findBySlugAndDeletedAt(slug, null);
	}

	@Override
	public void update(User user) {
		repository.saveAndFlush(user);
	}

	@Override
	public void delete(User user) {
		user.setDeletedAt(new Date());
		update(user);
	}

}
