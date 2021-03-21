package com.example.carritocomprasback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carritocomprasback.entity.Producto;
import com.example.carritocomprasback.service.ProductoService;

@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@PostMapping("/API/producto")
	public Producto addProducto(@RequestBody Producto producto) {
		return service.saveProducto(producto);
	}
	
	@PostMapping("/API/productos")
	public List<Producto> addProductos(@RequestBody List<Producto> productos) {
		return service.saveProductos(productos);
	}
	
	@GetMapping("/API/productos")
	public List<Producto> findAllProductos() {
		return service.getProductos();
	}
	
	@GetMapping("/API/producto/{id}")
	public Producto findProductoById(@PathVariable int id) {
		return service.getProductoById(id);
	}
	
	@PutMapping("/API/producto/{id}")
	public Producto updateProductoById(@RequestBody Producto producto, @PathVariable int id) {
		return service.updateProductoById(producto, id);
	}
	
	@DeleteMapping("/API/producto/{id}")
	public void destroyProductoById(@PathVariable int id) {
		service.destroyProductoById(id);
	}

}
