package ar.edu.utn.frp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.frp.backend.entity.Contacto;

@RepositoryRestResource(path = "contacto")
public interface ContactoRepository extends JpaRepository<Contacto, Long>{

}
