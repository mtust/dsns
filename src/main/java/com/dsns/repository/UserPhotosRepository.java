package com.dsns.repository;

import com.dsns.domain.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "userPhotos", path = "userPhotos")
public interface UserPhotosRepository extends JpaRepository<UserPhoto, Long> {

}
