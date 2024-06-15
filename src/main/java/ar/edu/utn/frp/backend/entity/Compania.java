package ar.edu.utn.frp.backend.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compania")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Compania extends AbstractEntity{

	@Column(name = "nombre")
	@NotNull(message = "El NOMBRE no puede ser nulo")
	@NotEmpty
	private String nombre = "";
	
	@OneToMany(mappedBy = "compania", fetch = FetchType.EAGER)
	@Nullable
	private List<Contacto> empleados = new LinkedList<>();
}
