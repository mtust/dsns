package com.dsns.repository;

import com.dsns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(Long id);

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
