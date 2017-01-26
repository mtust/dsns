package com.dsns.repository;

import com.dsns.domain.Benefits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "benefit")
public interface BenefitsRepository extends JpaRepository<Benefits, Long> {

}
