package com.aledev.ereservation.resources.vo;

import lombok.Data;

/*
 * Clase que representa la clase de cliente
 * @autor aledev
 */
@Data

public class ClienteVO {
	private String idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String identificaciónCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private String emailCliente;

}
