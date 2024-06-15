package ar.edu.utn.frp.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frp.backend.entity.Compania;
import ar.edu.utn.frp.backend.service.CompaniaService;

@RestController
public class CompaniaController {

	private CompaniaService companiaService;
	
	@Autowired
	public CompaniaController(CompaniaService companiaService) {
		this.companiaService = companiaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Compania>> getAllCompania() {
		List<Compania> companias = companiaService.findAll();
		return ResponseEntity.ok(companias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compania> getCompaniaById(@PathVariable Long id){
		Optional<Compania> compania = companiaService.findById(id);
		return compania.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Compania> createCompania(@RequestBody Compania compania) {
		Compania newCompania = companiaService.save(compania);
		return ResponseEntity.ok(newCompania);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Compania> updateCompania(@PathVariable Long id, @RequestBody Compania compania) {
        if (!companiaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Compania updateCompania = companiaService.save(compania);
        return ResponseEntity.ok(updateCompania);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompania(@PathVariable Long id) {
        if (!companiaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        companiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
