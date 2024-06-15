package ar.edu.utn.frp.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacto")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Contacto extends AbstractEntity{

	@Column(name = "email")
	@NotNull(message = "El EMAIL no puede ser nulo")
	@NotEmpty
	private String email;
	
	@Column(name = "nombre")
	@NotNull(message = "El NOMBRE no puede ser nulo")
	@NotEmpty
	private String nombre;
	
	@Column(name = "apellido")
	@NotNull(message = "El APELLIDO no puede ser nulo")
	@NotEmpty
	private String apelldio;
	
	@ManyToOne
	@NotNull(message = "La COMPANIA no puede ser nulo")
	@NotEmpty
	@JoinColumn(name = "idcompania")
	private Compania compania;
	
	@OneToOne
	@NotNull(message = "El STATUS no puede ser nulo")
	@NotEmpty
	@JoinColumn(name = "idstatus")
	private Status status;
}
