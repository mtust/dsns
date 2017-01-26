package com.dsns.repository.NominallyJobBook;

import com.dsns.domain.Region;
import com.dsns.domain.nominallyJobBooks.NominallyJobBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by mtustanovskyy on 1/15/17.
 */
@RepositoryRestResource(path = "nominallyJobBook")
public interface NominallyJobBookRepository extends JpaRepository<NominallyJobBook, Long> {

    List<NominallyJobBook> findOneByRegionIn(Collection<Region> regions);

    List<NominallyJobBook> findByRegionId(Long regionId);
}
