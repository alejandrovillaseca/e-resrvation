/**
 * 
 */
package com.aledev.ereservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledev.ereservation.model.Cliente;

/**
 * Interface para definir las operaciones de base de datos relacionadas con cliente
 * @author CAVS5692
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	/**
	 * Definición de método para  buscar los clientes por su apellido. "findBy" es una palabra reservada, y lo que 
	 * sigue es el nombre del método.
	 * @param apellidoCliente
	 * @return
	 */
	public Cliente findByApellidoCliente(String apellidoCliente);
	/*  */
	public Cliente findByIdentificacion(String identificaciónCliente);
}
