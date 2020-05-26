package com.dominiquedamba.baseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominiquedamba.baseapp.model.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	User findBySlug(String slug);

	User findByIdAndDeletedAt(Long id, Date deletedAt);

	Collection<User> findByDeletedAt(Date deletedAt);

	Optional<User> findBySlugAndDeletedAt(String slug, Date deletedAt);

}
