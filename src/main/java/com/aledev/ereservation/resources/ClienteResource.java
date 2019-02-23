/**
 * 
 */
package com.aledev.ereservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aledev.ereservation.model.Cliente;
import com.aledev.ereservation.resources.vo.ClienteVO;
import com.aledev.ereservation.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de cliente, que expone todas las
 * operaciones (SERVICIO WEB API REST)
 * 
 * @author CAVS5692
 *
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {
	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear cliente", notes = "Servicio que crea un cliente nuevo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {
		Cliente cliente = new Cliente();
		cliente.setNombreCliente(clienteVo.getNombreCliente());
		cliente.setApellidoCliente(clienteVo.getApellidoCliente());
		cliente.setDireccionCliente(clienteVo.getDireccionCliente());
		cliente.setTelefonoCliente(clienteVo.getTelefonoCliente());
		cliente.setEmailCliente(clienteVo.getEmailCliente());
		String strArr[] = new String[20];
		
		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar cliente", notes = "Servicio que actualiza un cliente nuevo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") String id, ClienteVO clienteVo) {
		Cliente cliente = this.clienteService.findByIdentificacion(id);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setNombreCliente(clienteVo.getNombreCliente());
			cliente.setApellidoCliente(clienteVo.getApellidoCliente());
			cliente.setDireccionCliente(clienteVo.getDireccionCliente());
			cliente.setTelefonoCliente(clienteVo.getTelefonoCliente());
			cliente.setEmailCliente(clienteVo.getEmailCliente());
		}
		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar cliente", notes = "Servicio que elimina un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public void removeCliente(@PathVariable("id") String id) {
		Cliente cliente = this.clienteService.findByIdentificacion(id);
		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes listados correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrados") })
	public ResponseEntity<List<Cliente>> getCliente() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
}
