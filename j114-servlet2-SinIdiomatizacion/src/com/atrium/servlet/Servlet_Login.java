package com.atrium.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;
import com.atrium.spring.Acceso_ApplicationContext;

public class Servlet_Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Servlet_Login() {
		super();
	}

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
		String salida = "jsp/login.jsp";
		// 1º RECOGER LA INFORMACION DE LA PETICION
		String nombre_usuario = peticion.getParameter("nombre_usuario");
		String clave_usuario = peticion.getParameter("clave_usuario");
		// 2º CONVERSION
		// NI ES NECESARIO EN ESTE CASO
		// 3º VALIDACION
		boolean valido = true;
		if (nombre_usuario.equals("")) {
			valido = false;
		}
		if (clave_usuario.equals("")) {
			valido = false;
		}
		// 4º NEGOCIO/LOGICA
		if (valido) {
			IGestion_Usuarios gestion_usuario = Acceso_ApplicationContext
					.getBean(IGestion_Usuarios.class);
			Usuarios usuario = gestion_usuario
					.consultar_PorNombre(nombre_usuario);
			if (usuario != null) {
				if (usuario.getPassword().equals(clave_usuario)) {
					// LOGIN CORRECTO
					salida = "jsp/menu.jsp";
				} else {
					// ERROR EN LA CLAVE
				}
			} else {
				// ERROR EN NOMBRE
			}
		}
		//5º NAVEGACION
		RequestDispatcher navegacion=peticion.getRequestDispatcher(salida);
		navegacion.forward(peticion, respuesta);
	}

}



