package com.dsns.repository;

import com.dsns.domain.MainStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "mainStaff")
public interface MainStaffRepository extends JpaRepository<MainStaff, Long> {

}
