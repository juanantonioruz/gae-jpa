package com.enjava.panaderia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Comprador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	String nombre;


	
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
