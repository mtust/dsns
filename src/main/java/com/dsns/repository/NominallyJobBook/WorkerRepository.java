package com.dsns.repository.NominallyJobBook;

import com.dsns.domain.nominallyJobBooks.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by mtustanovskyy on 1/15/17.
 */
@RepositoryRestResource(path = "worker")
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
