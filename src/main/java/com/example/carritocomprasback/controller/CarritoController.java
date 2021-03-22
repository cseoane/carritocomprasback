package com.example.carritocomprasback.controller;

import java.time.YearMonth;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carritocomprasback.entity.Carrito;
import com.example.carritocomprasback.service.CarritoService;


@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
public class CarritoController {

	@Autowired
	private CarritoService service;
	
	@PostMapping("/API/carrito/addProducto/{id}")
	public Carrito addProducto(@PathVariable int idProducto, @RequestBody Carrito carrito) {
		return service.addProducto(carrito, idProducto);
	}
	
	@PostMapping("/API/carrito")
	public Carrito saveCarrito(@RequestBody Carrito carrito) {
		checkClienteVIP(carrito);
		return service.saveCarrito(carrito);
	}

	public boolean checkClienteVIP(Carrito carrito) {
		/* Revisará el mes actual donde se finalizó una compra
		 * Si cumple los requerimientos quedará con su atributo vip en true
		 * Al aplicar el descuento vip se reseteará
		 */
		boolean esClienteVIP = false;
		float totalesAnteriores = 0;
		LocalDate currentLocalDate = LocalDate.now();
		for(Carrito carritoIterable : service.getCarritosByCliente(carrito.getCliente())) {
			if (YearMonth.from(carritoIterable.getFecha()).equals(currentLocalDate)) {
				totalesAnteriores = totalesAnteriores + carritoIterable.getTotal();
			}
		}
		if(carrito.getTotal()+totalesAnteriores > 10000f) {
			esClienteVIP = true;
		}
		return esClienteVIP;
	}
	
}
