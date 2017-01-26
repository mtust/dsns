package com.dsns.repository;

import com.dsns.domain.MainEducationBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "mainEducationBlock")
public interface MainEducationBlockRepository extends JpaRepository<MainEducationBlock, Long> {

}
