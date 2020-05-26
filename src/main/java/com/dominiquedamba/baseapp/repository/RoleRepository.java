package com.dominiquedamba.baseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominiquedamba.baseapp.model.Role;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

/**
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByNameAndDeletedAt(String nom, Date deletedAt);

	Role findByDeletedAtAndName(Date deletedAt, String name);

	Role findByIdAndDeletedAt(Long id, Date deletedAt);

	Collection<Role> findByDeletedAt(Date deletedAt);

	Optional<Role> findBySlugAndDeletedAt(String slug, Date deletedAt);

}
