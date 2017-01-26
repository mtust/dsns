package com.dsns.repository;

import com.dsns.domain.StuffDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "stuffDocuments", path = "stuffDocuments")
public interface StuffDocumentsRepository extends JpaRepository<StuffDocuments, Long> {

}
