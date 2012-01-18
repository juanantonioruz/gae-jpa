package com.enjava;

import java.io.Serializable;

public class Contador implements Serializable{

	Integer contador=new Integer(0);

	@Override
	public String toString() {
		return "Contador [contador=" + contador + "]";
	}
	
	
	
}
