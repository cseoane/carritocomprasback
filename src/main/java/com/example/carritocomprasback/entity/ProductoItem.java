package com.example.carritocomprasback.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRITO_PRODUCTO_ITEM")
public class ProductoItem {

	@Id
	@GeneratedValue
	Integer idCarrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProdcuto")
	Producto producto;
	Float cantidad;
}
