package com.enjava.panaderia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	@OneToMany()
	List<PedidoProducto> pedidos=new ArrayList<PedidoProducto>();
	
	String nombre;

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public List<PedidoProducto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoProducto> pedidos) {
		this.pedidos = pedidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
