package com.example.carritocomprasback.service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carritocomprasback.entity.FechaPromocion;
import com.example.carritocomprasback.repository.FechaPromocionRepository;

@Service
public class FechaPromocionService {

	private FechaPromocionRepository repository;
	
	@Autowired
	public FechaPromocionService(FechaPromocionRepository repository) {
		this.repository = repository;
	}
	
	public boolean esPromocionable(LocalDate fecha) {
		boolean esPromocionable = false; 
		for (FechaPromocion fechaPromocion : repository.findAll()) { //TODO realizar filtro por query
			if (fechaPromocion.getFechaDesde().compareTo(fecha) <= 0 &&
					fechaPromocion.getFechaHasta().compareTo(fecha) >= 0 ) {
				esPromocionable = true;
				break;
			}
		};
		return esPromocionable;
	}
	
}
