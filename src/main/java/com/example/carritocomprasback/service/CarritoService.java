package com.example.carritocomprasback.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carritocomprasback.entity.Carrito;
import com.example.carritocomprasback.entity.Cliente;
import com.example.carritocomprasback.repository.CarritoRepository;
import com.example.carritocomprasback.repository.ProductoRepository;

@Service
public class CarritoService {

	private CarritoRepository repository;
	private ProductoRepository repositoryProducto;
	
	@Autowired
	public CarritoService(CarritoRepository repository) {
		this.repository = repository;
	}
	
	public Carrito saveCarrito(Carrito Carrito) {
		return repository.save(Carrito);
	}
	
	public List<Carrito> getCarritosByCliente(Cliente cliente) {
		return repository.findAllByCliente(cliente);
	}
	
	public Carrito addProducto(Carrito carrito, int productoID) {
		carrito.addProducto(repositoryProducto.findById(productoID));
		return carrito;
	}
}
