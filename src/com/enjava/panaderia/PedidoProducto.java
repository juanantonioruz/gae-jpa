package com.enjava.panaderia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;
@Entity
public class PedidoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	


	Key comprador;
	Key producto;

	
	
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public Key getComprador() {
		return comprador;
	}

	public void setComprador(Key comprador) {
		this.comprador = comprador;
	}

	public Key getProducto() {
		return producto;
	}

	public void setProducto(Key producto) {
		this.producto = producto;
	}



	

	
	
	
	
}
