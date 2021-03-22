package com.example.carritocomprasback.entity;

import java.util.Optional;
import java.util.Vector;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.carritocomprasback.controller.FechaPromocionController;

@Entity
@Table(name="CARRITO")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idCarrito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente")
	Cliente cliente;
	
	Vector<ProductoItem> productoItems;
	
	LocalDate fecha;
	
	boolean promocionable = false;
	
	Float total = 0f;
	Float descuento = 0f;
	
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void addProducto(Optional<Producto> producto) {
		this.productoItems.add(new ProductoItem(producto));
		updateTotal();
	}
	
	public void updateTotal() {
		checkPromocionable();
		total = 0f;
		descuento = 0f;
		int cantidadItems = 0;
		for(ProductoItem item: productoItems) {
			total = total + (item.cantidad * item.producto.precio);
			cantidadItems++;
		}
		if(cantidadItems == 4) {
			descuento = Math.round(total * 25f)/100f;
		}else if(cantidadItems >= 10) {
			if(this.promocionable) {
				descuento = 300f;
			}else {
				descuento = 100f;
			}
			if(total > 4000f && getCliente().isVip()) {
				descuento = 2000f;
			}
		}
	}
	
	private void checkPromocionable() {
		FechaPromocionController fechaPromocionController = new FechaPromocionController();
		this.promocionable = fechaPromocionController.checkPromocionable(this.fecha);
	}
	public boolean isPromocionable() {
		return promocionable;
	}
	public void setPromocionable(boolean promocionable) {
		this.promocionable = promocionable;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
}
