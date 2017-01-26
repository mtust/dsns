package com.dsns.repository;

import com.dsns.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "education")
public interface EducationRepository extends JpaRepository<Education, Long> {

}
