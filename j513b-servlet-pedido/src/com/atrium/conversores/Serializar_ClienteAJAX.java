package com.atrium.conversores;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.util.JSONStringer;

import com.atrium.dominio.Clientes_Ajax;
import com.atrium.hibernate.Clientes_Pedido;

public class Serializar_ClienteAJAX implements ISerializar_JSON {

	/**
	 * Implementacion concreta para la conversion del objeto cliente_AJAX.
	 * 
	 * @param cliente
	 *            Objeto a convertir.
	 * @return Cadena de texto en formato JSON.
	 */
	public String convertirClientePedido_Json(Object cliente_obj) {
		Clientes_Ajax cliente = null;
		if (cliente_obj instanceof Clientes_Ajax) {
			cliente = (Clientes_Ajax) cliente_obj;
		} else {
			return null;
		}
		String mensaje = cliente.getMensaje();
		String texto_salida = null;
		JSON objeto_json = null;
		if (cliente.getCliente() != null) {
			// ANULAMOS LAS CARGAS VAGAS PENDIENTES PARA QUE NO DE ERROR EN EL
			// PROCESO
			cliente.getCliente().setVencimientoses(null);
			cliente.getCliente().setPedidoses(null);
			cliente.getCliente().setFormasPagoClientes(null);
			// SERIALIZAMOS A FORMATO JSON
			objeto_json = JSONSerializer.toJSON(cliente);
			texto_salida = objeto_json.toString();
			if (mensaje != null) {
				texto_salida = texto_salida.substring(0,
						texto_salida.length() - 1)
						+ ",'error_cliente':'"
						+ mensaje + "'}";
			}
		} else {
			texto_salida = "{'error_cliente':'" + mensaje + "'}";
		}
		return texto_salida;
	}

	/**
	 * Proceso de seriqalizacion a formato JSON para la consulta de clientes.
	 * 
	 * @param cliente_ajax
	 * @return
	 */
	@Override
	public String convertirClientesAyuda(Clientes_Ajax cliente_ajax) {
		// COMPROBAMOS LA COLECCION DE OBJETOS PARA ELIMINAR LAS CARGAS VAGAS
		if (cliente_ajax.getLista_clientes().size() > 0) {
			for (Clientes_Pedido cliente_pedido : cliente_ajax
					.getLista_clientes()) {
				cliente_pedido.setPedidoses(null);
				cliente_pedido.setFormasPagoClientes(null);
				cliente_pedido.setVencimientoses(null);
			}
		}
		// SERIALIZAMOS A FORMATO JSON
		String texto_salida = JSONSerializer.toJSON(cliente_ajax).toString();
		return texto_salida;
	}
}
