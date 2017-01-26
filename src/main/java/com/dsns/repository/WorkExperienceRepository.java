package com.dsns.repository;

import com.dsns.domain.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "workExperience", path = "workExperience")
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {

}
