package com.aledev.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

/*
 * Clase que representa la tabla reserva
 * @author aledev
 */
@Entity
@Table(name="reserva")
@Data
public class Reserva {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idReserva;
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPresonasRes;
	private String descripciónRes;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
}
