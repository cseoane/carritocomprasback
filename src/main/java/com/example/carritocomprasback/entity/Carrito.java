package com.example.carritocomprasback.entity;

import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRITO")
public class Carrito {

	@Id
	@GeneratedValue
	Integer idCarrito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente")
	Cliente cliente;
	
	Vector<ProductoItem> productoItems;
	
	Date fecha;
	
	public Integer getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vector<ProductoItem> getProductoItems() {
		return productoItems;
	}
	public void setProductoItems(Vector<ProductoItem> productoItems) {
		this.productoItems = productoItems;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
