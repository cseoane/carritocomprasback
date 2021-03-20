package com.example.carritocomprasback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carritocomprasback.entity.Carrito;
import com.example.carritocomprasback.repository.CarritoRepository;
import com.example.carritocomprasback.repository.CarritoRepository;

@Service
public class CarritoService {

	private CarritoRepository repository;
	
	@Autowired
	public CarritoService(CarritoRepository repository) {
		this.repository = repository;
	}
	
	public Carrito saveCarrito(Carrito Carrito) {
		return repository.save(Carrito);
	}
	
	public List<Carrito> saveCarritos(List<Carrito> Carritos) {
		return repository.saveAll(Carritos);
	}
	
	public List<Carrito> getCarritos() {
		return repository.findAll();
	}
	
	public Carrito getCarritoById(Integer idCarrito) {
		return repository.findById(idCarrito).orElse(null);
	}

	public void destroyCarritoById(int id) {
		repository.deleteById(id);
	}
}
