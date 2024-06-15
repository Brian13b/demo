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

import ar.edu.utn.frp.backend.entity.Contacto;
import ar.edu.utn.frp.backend.service.ContactoService;

@RestController
public class ContactoController {

	private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public ResponseEntity<List<Contacto>> getAllContactos() {
        List<Contacto> contactos = contactoService.findAll();
        return ResponseEntity.ok(contactos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> getContactoById(@PathVariable Long id) {
        Optional<Contacto> contacto = contactoService.findById(id);
        return contacto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contacto> createContacto(@RequestBody Contacto contacto) {
        Contacto newContacto = contactoService.save(contacto);
        return ResponseEntity.ok(newContacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacto> updateContacto(@PathVariable Long id, @RequestBody Contacto contacto) {
        if (!contactoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Contacto updatedContacto = contactoService.save(contacto);
        return ResponseEntity.ok(updatedContacto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContacto(@PathVariable Long id) {
        if (!contactoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contactoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
