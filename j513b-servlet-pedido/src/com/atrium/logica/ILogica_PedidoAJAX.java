package com.atrium.logica;

import com.atrium.dominio.Clientes_Ajax;

public interface ILogica_PedidoAJAX {

	public Clientes_Ajax tratamiento_ConsultaCliente(String nombre_cliente,
			String codigo_cliente);
	
	public String consultar_StockArticulos();

	public abstract Clientes_Ajax consultar_ClientesAyuda();
}
