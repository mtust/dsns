package com.dsns.repository;

import com.dsns.domain.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "holiday")
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
