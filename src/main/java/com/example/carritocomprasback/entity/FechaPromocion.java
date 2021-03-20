package com.example.carritocomprasback.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FECHAPROMOCION")
public class FechaPromocion {

	@Id
	@GeneratedValue
	Integer idFechaPromocion;
	Date fechaDesde;
	Date fechaHasta;
}
