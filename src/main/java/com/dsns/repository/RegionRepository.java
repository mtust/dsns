package com.dsns.repository;

import com.dsns.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "region")
public interface RegionRepository extends JpaRepository<Region, Long> {

}
