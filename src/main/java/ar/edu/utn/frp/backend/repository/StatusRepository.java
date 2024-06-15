package ar.edu.utn.frp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ar.edu.utn.frp.backend.entity.Status;

@RepositoryRestResource(path = "status")
public interface StatusRepository extends JpaRepository<Status, Long>{

}
