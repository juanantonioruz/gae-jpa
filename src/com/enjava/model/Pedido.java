package com.enjava.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Pedido {
	Key id;
	Date fecha;
	List<PedidoLinea> lineasPedido;
	Cliente cliente;
	Boolean pagado;
	String tipoPago;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@OneToMany(mappedBy="pedido")
	public List<PedidoLinea> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<PedidoLinea> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	@ManyToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

}
