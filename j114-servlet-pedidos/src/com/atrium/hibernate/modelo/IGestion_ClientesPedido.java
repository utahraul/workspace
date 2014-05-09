package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Clientes_Pedido;

public interface IGestion_ClientesPedido {

	public List<Clientes_Pedido> consultar_Todos();

	public Clientes_Pedido buscar_Cliente(Integer codigo_cliente);

	public List<Clientes_Pedido> consultar_PorNombre(String nombrecliente);

}