package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.dao.PedidosDAO;

public class Gestion_Pedido implements IGestion_Pedido {

	private PedidosDAO pedido_dao;

	@Override
	public void alta_Pedido(Pedidos pedido) {
		pedido_dao.save(pedido);
	}

	// ACCESORES PARA SPRING
	public void setPedido_dao(PedidosDAO pedido_dao) {
		this.pedido_dao = pedido_dao;
	}

}
