package com.example.carritocomprasback.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.carritocomprasback.service.FechaPromocionService;

@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
public class FechaPromocionController {

	@Autowired
	private FechaPromocionService service;
	
	public boolean checkPromocionable(LocalDate fecha) {
		return service.esPromocionable(fecha);
	}
}
