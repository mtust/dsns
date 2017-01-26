package com.dsns.repository;

import com.dsns.domain.MainStaffPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "mainStaffPhotos")
public interface MainStaffPhotosRepository extends JpaRepository<MainStaffPhotos, Long> {

}
