package com.atrium.dominio;

import java.util.List;

import com.atrium.hibernate.Clientes_Pedido;

public class Clientes_Ajax {

	private String mensaje;
	private String visibilidad;
	private Clientes_Pedido cliente;
	private List<Clientes_Pedido> lista_clientes;

	// accesores
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(String visibilidad) {
		this.visibilidad = visibilidad;
	}

	public Clientes_Pedido getCliente() {
		return cliente;
	}

	public void setCliente(Clientes_Pedido cliente) {
		this.cliente = cliente;
	}

	public List<Clientes_Pedido> getLista_clientes() {
		return lista_clientes;
	}

	public void setLista_clientes(List<Clientes_Pedido> lista_clientes) {
		this.lista_clientes = lista_clientes;
	}

}
