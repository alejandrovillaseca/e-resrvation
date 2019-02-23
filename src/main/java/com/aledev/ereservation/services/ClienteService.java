/**
 * 
 */
package com.aledev.ereservation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aledev.ereservation.model.Cliente;
import com.aledev.ereservation.repository.ClienteRepository;

/**
 * Clase para definir los servicios de cliente
 * 
 * @author CAVS5692
 *
 */
@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		// TODO Auto-generated constructor stub
		this.clienteRepository = clienteRepository;
	}
	/**
	 * Método para realizar la operación de guardado de un cliente
	 * @param cliente
	 * @return
	 */
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	/**
	 * Método para realizar la operacion de actualización de un cliente
	 * @param cliente
	 * @return
	 */
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	/**
	 * Método para realizar la operacion de eliminar un cliente
	 * @param cliente
	 */
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	/**
	 * Método par aconsultar un cliente por su identificación
	 * @param identificaciónCliente
	 * @return
	 */
	public Cliente findByIdentificacion(String identificaciónCliente) {
		return this.clienteRepository.findByIdentificacion(identificaciónCliente);
	}
	/**
	 * Método para buscar apellido por cliente
	 * @param apellidoCliente
	 * @return
	 */
	public Cliente findByApellidoCliente(String apellidoCliente) {
		return this.clienteRepository.findByApellidoCliente(apellidoCliente);
	}
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
}
