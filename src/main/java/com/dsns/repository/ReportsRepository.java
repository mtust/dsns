package com.dsns.repository;

import com.dsns.domain.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "reports")
public interface ReportsRepository extends JpaRepository<Reports, Long> {

}
