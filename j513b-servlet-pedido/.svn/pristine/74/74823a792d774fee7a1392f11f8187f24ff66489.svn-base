package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Clientes_Pedido;
import com.atrium.hibernate.dao.Clientes_PedidoDAO;

public class Gestion_Clientes implements IGestion_Clientes {

	private Clientes_PedidoDAO cli_pedDAO;

	public List<Clientes_Pedido> consultar_Todos() {
		List<Clientes_Pedido> lista = cli_pedDAO.findAll();
		return lista;
	}

	public Clientes_Pedido buscar_Cliente(Integer codigo_cliente) {
		Clientes_Pedido cliente = cli_pedDAO.findById(codigo_cliente);
		return cliente;
	}

	public List<Clientes_Pedido> consultar_PorNombre(String nombrecliente) {
		List<Clientes_Pedido> lista_Clientes = cli_pedDAO
				.findByNombreCliente(nombrecliente);
		return lista_Clientes;
	}

	// ACCESORES SPRING
	public void setCli_pedDAO(Clientes_PedidoDAO cli_pedDAO) {
		this.cli_pedDAO = cli_pedDAO;
	}

}
