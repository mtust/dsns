package com.dsns.repository;

import com.dsns.domain.Region;
import com.dsns.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource(path = "staff")
public interface StaffRepository extends JpaRepository<Staff, Long> {


    public List<Staff> findByIsDeletedFalseAndIsDeletedByOperatorFalseAndRegionIn(Collection<Region> regions);

    public List<Staff> findByIsDeletedTrueAndIsDeletedByOperatorFalseAndRegionIn(Collection<Region> regions);

    public Staff findOneByIsDeletedFalseAndIsDeletedByOperatorFalseAndIdAndRegionIn(Long id, Collection<Region> regions);

    public List<Staff> findByIsDeletedByOperatorTrueAndRegionIn(Collection<Region> regions);

    public Staff findOneByIdAndRegionIn(Long id, Collection<Region> regions);

    public List<Staff> findByIsDeletedFalse();


}
