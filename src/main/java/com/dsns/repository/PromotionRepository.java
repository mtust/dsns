package com.dsns.repository;

import com.dsns.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "promotion")
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
