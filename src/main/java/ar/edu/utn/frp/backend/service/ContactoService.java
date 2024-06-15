package ar.edu.utn.frp.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.utn.frp.backend.entity.Contacto;
import ar.edu.utn.frp.backend.repository.ContactoRepository;

@Service
public class ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	public List<Contacto> findAll() {
        return contactoRepository.findAll();
    }

    public Optional<Contacto> findById(Long id) {
        return contactoRepository.findById(id);
    }

    public Contacto save(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public void deleteById(Long id) {
        contactoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return contactoRepository.existsById(id);
    }
}
