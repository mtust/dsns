package com.dsns.repository;

import com.dsns.domain.PremiumFine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "premiumFine")
public interface PremiumFineRepository extends JpaRepository<PremiumFine, Long> {

}
