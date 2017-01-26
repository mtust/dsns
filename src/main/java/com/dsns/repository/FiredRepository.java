package com.dsns.repository;

import com.dsns.domain.Fired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "find")
public interface FiredRepository extends JpaRepository<Fired, Long> {

}
