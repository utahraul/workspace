package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Clientes_Pedido;
import com.atrium.hibernate.dao.Clientes_PedidoDAO;

public class Gestion_ClientesPedido implements IGestion_ClientesPedido {

	private Clientes_PedidoDAO clientes_PedidoDAO;

	@Override
	public List<Clientes_Pedido> consultar_Todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientes_Pedido buscar_Cliente(Integer codigo_cliente) {
		return clientes_PedidoDAO.findById(codigo_cliente);
	}

	@Override
	public List<Clientes_Pedido> consultar_PorNombre(String nombrecliente) {
		return clientes_PedidoDAO.findByProperty("nombreCliente", nombrecliente);
	}

	// ACCESORES PARA SPRING
	public void setClientes_PedidoDAO(Clientes_PedidoDAO clientes_PedidoDAO) {
		this.clientes_PedidoDAO = clientes_PedidoDAO;
	}

}
