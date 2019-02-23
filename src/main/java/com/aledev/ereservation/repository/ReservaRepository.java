/**
 * 
 */
package com.aledev.ereservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aledev.ereservation.model.Reserva;

/**
 * @author CAVS5692
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {
	/* fechaInicio y fechaSalida son parámetros creados... =: */
	@Query("Select r from Reserva r where r.fechaIngresoRes =: fechaInicio and r.fechaSalidaRes =: fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio,@Param("fechaSalida") Date fechaSalida);
}
