package com.dsns.repository;

import com.dsns.domain.Benefits;
import com.dsns.domain.Role;
import com.dsns.security.Secured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "benefit")
@Secured(Role.ROLE_OPERATOR)
public interface BenefitsRepository extends JpaRepository<Benefits, Long> {

}
