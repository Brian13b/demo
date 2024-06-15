package ar.edu.utn.frp.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.utn.frp.backend.entity.Compania;
import ar.edu.utn.frp.backend.repository.CompaniaRepository;

@Service
public class CompaniaService {

	@Autowired
	private CompaniaRepository companiaRepository;
	
	public List<Compania> findAll() {
        return companiaRepository.findAll();
    }

    public Optional<Compania> findById(Long id) {
        return companiaRepository.findById(id);
    }

    public Compania save(Compania compania) {
        return companiaRepository.save(compania);
    }

    public void deleteById(Long id) {
    	companiaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return companiaRepository.existsById(id);
    }
}
