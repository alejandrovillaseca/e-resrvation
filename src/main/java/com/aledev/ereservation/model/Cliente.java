package com.aledev.ereservation.model;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
/*
 * Clase que representa la clase de cliente
 * @autor aledev
 */
@Entity
@Table(name="cliente")
@Data
/* Esto es JPQL, lenguaje "SQL" de Java.*/
@NamedQuery(name="Cliente.findByIdentificacion", query="Select c from Cliente c where c.identificaciónCliente = ?1")
public class Cliente {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String identificaciónCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private String emailCliente;
	@OneToMany(mappedBy="cliente")
	private Set<Reserva> reservas;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}	
	
	
	
}
