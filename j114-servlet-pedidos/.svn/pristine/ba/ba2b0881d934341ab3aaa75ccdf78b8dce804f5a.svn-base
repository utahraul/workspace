package com.atrium.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atrium.conversores.ISerializar_JSON;
import com.atrium.dominio.Clientes_Ajax;
import com.atrium.logica.ILogica_PedidoAJAX;
import com.atrium.spring.Acceso_ApplicationContext;

public class Controlador_Ajax extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		// PROPIEDADES PARA EL PROCESO A REALIZAR
		ILogica_PedidoAJAX logica_peticion;
		Clientes_Ajax cliente_ajax;
		String salida = null;
		// RECOGEMOS EL TIPO DE OPERACION PEDIDA
		String tipo_operacion = peticion.getParameter("tipo_operacion");
		// LLAMADA A LOGICA DE CONSULTA DE CLIENTES
		if (tipo_operacion.equals("consulta_cliente")) {
			String codigo_cliente = peticion.getParameter("cod_cli");
			String nombre_cliente = peticion.getParameter("nom_cli");
			// PREPARAMOS LA LOGICA DE NEGOCIO
			logica_peticion = Acceso_ApplicationContext
					.getBean(ILogica_PedidoAJAX.class);
			// LLAMAMOS AL PROCESO NECESARIO
			cliente_ajax = logica_peticion.tratamiento_ConsultaCliente(
					nombre_cliente, codigo_cliente);
			// CONVERTIRMOS EL RESULTADO DE LA LOGICA A FORMATO JSON
			ISerializar_JSON traductor = Acceso_ApplicationContext
					.getBean(ISerializar_JSON.class);
			salida = traductor.convertirClientePedido_Json(cliente_ajax);
		}

		// LLAMADA A LOGICA DE ACTUALIZACION DE ARTICULOS
		if (tipo_operacion.equals("actualiza_articulos")) {
		}

		// LLAMADA A LA LOGICA DE CARGA CLIENTES PARA LA AYUDA (PATRON PRECARGA)
		if (tipo_operacion.equals("consulta_clientesayuda")) {
		}

		// MANDAMOS LA RESPUESTA AL NAVEGADOR
		respuesta.setContentType("text/plain");
		respuesta.getWriter().write(salida);

	}

}
