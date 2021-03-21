package com.example.carritocomprasback.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FECHAPROMOCION")
public class FechaPromocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idFechaPromocion;
	LocalDate fechaDesde;
	LocalDate fechaHasta;
	public Integer getIdFechaPromocion() {
		return idFechaPromocion;
	}
	public void setIdFechaPromocion(Integer idFechaPromocion) {
		this.idFechaPromocion = idFechaPromocion;
	}
	public LocalDate getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public LocalDate getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}
