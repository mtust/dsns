package com.dsns.repository;

import com.dsns.domain.Other;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "other")
public interface OtherRepository extends JpaRepository<Other, Long> {

}
