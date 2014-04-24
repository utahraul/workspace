package com.atrium.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.modelo.IGestion_Articulos;
import com.atrium.spring.Acceso_ApplicationContext;

public class Servlet_Articulos extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest peticion,
			HttpServletResponse respuesta) throws ServletException, IOException {

		String error_proceso = "";
		boolean codigo_valido = true;
		String codigo_articulo = peticion.getParameter("codigo_articulo");
		Integer codigoarticulo_numero = null;
		try {
			codigoarticulo_numero = new Integer(codigo_articulo);
		} catch (Exception e) {
			// ERROR EN LA CONVERSION
			error_proceso = "El valor dado como codigo de articulo no es un numero entero";
			codigo_valido = false;
		}

		if (codigo_valido) {
			IGestion_Articulos gestion_articulos = Acceso_ApplicationContext
					.getBean(IGestion_Articulos.class);
			Articulos articulo_consultado = gestion_articulos
					.consultar_PorClave(codigoarticulo_numero);
			if (articulo_consultado != null) {
				peticion.setAttribute("articulo", articulo_consultado);
			} else {
				// ERROR EN EL CODIGO ARTICULO
				error_proceso = "No existe ningun articulo con ese codigo";
			}
		}
		if (error_proceso != "") {
			peticion.setAttribute("error_proceso", error_proceso);
		}
		RequestDispatcher salida = peticion
				.getRequestDispatcher("jsp/articulos.jsp");
		salida.forward(peticion, respuesta);
	}

}
