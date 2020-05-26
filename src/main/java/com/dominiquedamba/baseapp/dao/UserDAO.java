/**
 * 
 */
package com.dominiquedamba.baseapp.dao;

import java.util.*;

import com.dominiquedamba.baseapp.model.User;

/**
 * @author dominiquedamba
 *
 */
public interface UserDAO {

	Optional<User> getUserByUserNameOrEmail(String username, String email);

	Optional<User> getUserByUserName(String username);

	Optional<User> getUserByEmail(String email);

	User findBySlug(String slug);

	User store(User string);

	boolean existBySlug(String slug);

	Optional<User> findById(Long id);

	Collection<User> all();

	Optional<User> show(String slug);

	void update(User user);

	void delete(User user);

}
