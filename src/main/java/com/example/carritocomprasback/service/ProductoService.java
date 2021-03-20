package com.example.carritocomprasback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carritocomprasback.entity.Producto;
import com.example.carritocomprasback.repository.ProductoRepository;

@Service
public class ProductoService {

	private ProductoRepository repository;
	
	@Autowired
	public ProductoService(ProductoRepository repository) {
		this.repository = repository;
	}
	
	public Producto saveProducto(Producto producto) {
		return repository.save(producto);
	}
	
	public List<Producto> saveProductos(List<Producto> productos) {
		return repository.saveAll(productos);
	}
	
	public List<Producto> getProductos() {
		return repository.findAll();
	}
	
	public Producto getProductoById(Integer idProducto) {
		return repository.findById(idProducto).orElse(null);
	}

	public void destroyProductoById(int id) {
		repository.deleteById(id);
	}

	public Producto updateProductoById(Producto producto, int id) {
		Producto productoActual = repository.getOne(id);
		if(!producto.getNombre().isEmpty()) {productoActual.setNombre(producto.getNombre());}
		if(!producto.getDescripcion().isEmpty()) {productoActual.setDescripcion(producto.getDescripcion());}
		if(!producto.getPrecio().isNaN()) {productoActual.setPrecio(producto.getPrecio());}
		return repository.save(productoActual);
	}
}
