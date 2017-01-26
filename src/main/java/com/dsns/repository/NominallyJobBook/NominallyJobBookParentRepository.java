package com.dsns.repository.NominallyJobBook;

import com.dsns.domain.nominallyJobBooks.NominallyJobBookParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by mtustanovskyy on 1/22/17.
 */
@RepositoryRestResource(path = "nominallyJobBookParent")
public interface NominallyJobBookParentRepository extends JpaRepository<NominallyJobBookParent, Long> {

}
