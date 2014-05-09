package com.atrium.logica;

import java.util.List;

import com.atrium.dominio.Clientes_Ajax;
import com.atrium.hibernate.Clientes_Pedido;
import com.atrium.hibernate.modelo.IGestion_ClientesPedido;

public class Logica_PedidoAJAX implements ILogica_PedidoAJAX {

	private IGestion_ClientesPedido gestion_clientes;
	private Clientes_Ajax cliente_ajax;
	private String mensaje;

	/**
	 * Consultar los datos de clientes a partir de la informacion dada en la
	 * peticion.
	 */
	@Override
	public Clientes_Ajax tratamiento_ConsultaCliente(String nombre_cliente,
			String codigo_cliente) {
		// PROPIEDADES PARA EL PROCESO
		cliente_ajax = new Clientes_Ajax();
		Integer codigo_clienteNUM = null;
		Clientes_Pedido cliente = null;
		boolean valido = true;
		String visibilidad = "style='visibility:visible'";
		// SI EXISTE EL CODIGO SE CONSULTA POR CODIGO SINO POR NOMBRE
		if (codigo_cliente != "") {
			// VALIDAMOS SI EL VALOR DEL CODIGO ES NUMERICO ENTERO
			try {
				codigo_clienteNUM = Integer.decode(codigo_cliente);
			} catch (Exception e) {
				// ERROR EN EL FORMATO DEL CODIGO DE CLIENTE
				valido = false;
				mensaje = "EL CODIGO DADO NO ES NUMERICO";
			}
			if (valido) {
				// CONSULTAMOS POR CODIGO
				cliente = gestion_clientes.buscar_Cliente(codigo_clienteNUM);
				if (cliente != null) {
					if (nombre_cliente != "") {
						if (cliente.getNombreCliente().equals(nombre_cliente)) {
							// CLIENTE CORRECTO
							visibilidad = "style='visibility:hidden'";
						} else {
							// ERROR EN EL NOMBRE DE CLENTE
							mensaje = "EL NOMBRE DEL CLIENTE NO COINCIDE CON EL CODIGO";
						}
					} else {
						// no hay nombre de cliente
						mensaje = "NO SEA INTRODUCIDO NOMBRE DE CLIENTE";
					}
				} else {
					// ERROR EN EL CODIGO
					mensaje = "NO EXISTE NINGUN CLIENTE CON EL CODIGO DADO";
				}
			}
		} else {
			List<Clientes_Pedido> lista_clientes = gestion_clientes
					.consultar_PorNombre(nombre_cliente);
			if (lista_clientes.size() == 0) {
				// NINGUN CLIENTE CON ESE NOMBRE
				mensaje = "NO HAY NINGUN CLIENTE CON ESE NOMBRE";
			}
			if (lista_clientes.size() == 1) {
				// UN SOLO CLIENTE CON ESE NOMBRE
				cliente = lista_clientes.get(0);
				visibilidad = "style='visibility:hidden'";
			}
			if (lista_clientes.size() > 1) {
				// MULTIPLES CLIENTES CON ESE NOMBRE
				mensaje = "HAY MAS DE UN CLIENTE CON ESE NOMBRE. SE MUESTRA EL PRIMERO";
				cliente = lista_clientes.get(0);
			}
		}
		// CARGAMOS LA INFORMACION DEL PROCESO EN EL OBJETO DE DOMINIO
		cliente_ajax.setCliente(cliente);
		cliente_ajax.setMensaje(mensaje);
		cliente_ajax.setVisibilidad(visibilidad);
		return cliente_ajax;
	}

	@Override
	public String consultar_StockArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientes_Ajax consultar_ClientesAyuda() {
		// TODO Auto-generated method stub
		return null;
	}

	// ACCESORES PARA SPRING
	public void setGestion_clientes(IGestion_ClientesPedido gestion_clientes) {
		this.gestion_clientes = gestion_clientes;
	}

}
