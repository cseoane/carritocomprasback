package com.example.carritocomprasback.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRITO_PRODUCTO_ITEM")
public class ProductoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idCarrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProdcuto")
	Producto producto;
	Float cantidad;
	
	public ProductoItem(Optional<Producto> producto) {
		this.producto = producto.orElse(null);
		cantidad = 1.0f;
	}

	public Integer getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
}
