package com.atrium.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;

public class Servlet_Login extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {

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
		// OBTENEMOS EL RB PARA LA IDIOMATIZACION DE LOS MENSAJES
		ResourceBundle rb = ResourceBundle.getBundle((String) peticion
				.getSession().getAttribute("idioma_elegido"));
		// AUXILIARES DE PROCESO
		boolean valido = true;
		IGestion_Usuario gestion_usuarios;
		String salida = "jsp/login.jsp";
		String error_clave = null;
		String error_nombre = null;

		// 1º RECUPERAMOS LA INFORMACION DE LA PETICION (PARAMETROS)
		String nombre_usuario = peticion.getParameter("nombre_usuario");
		String clave_usuario = peticion.getParameter("clave_usuario");
		// 2º CONVERSION DE DATOS (PARA ESTE PROCESO NADA)

		// 3º VALIDACION DE DATOS
		if (nombre_usuario.equals("")) {
			// ERROR NOMBRE VACIO
			valido = false;
			error_nombre = rb.getString("login.error.nombrevacio");
		} else if (nombre_usuario.length() > 20) {
			valido = false;
			// ERROR EN LA VALIDACION DE TAMAÑO DE CAMPO (20 PARA NOMBRE)
			error_nombre = MessageFormat.format(
					rb.getString("login.error.nombrelargo"),
					nombre_usuario.length());
		}
		if (clave_usuario.equals("")) {
			// ERROR CLAVE VACIA
			valido = false;
			error_clave = rb.getString("login.error.clavevacio");
		} else if (clave_usuario.length() > 10) {
			valido = false;
			// ERROR EN LA VALIDACION DE TAMAÑO DE CAMPO (10 PARA CLAVE)
			error_clave = MessageFormat.format(
					rb.getString("login.error.clavelargo"),
					clave_usuario.length());
		}

		// 4º LOGICA PROCESO
		if (valido) {
			// CONSULTAMOS A LA BASE DE DATOS
			gestion_usuarios = Acceso_ApplicationContext
					.getBean(IGestion_Usuario.class);
			Usuarios usuario = gestion_usuarios
					.consultar_PorNombre(nombre_usuario);
			// COMPROBAMOS LA CLAVE
			if (usuario != null) {
				if (usuario.getPassword().equals(clave_usuario)) {
					// USUARIO CORRECTO
					// ESTABLECEMOS LA NAVEGACION
					salida = "jsp/pedido.jsp";
					// GUARDAMOS EL USUARIO PARA SU POSTERIOR USO EN OTRAS
					// PETICIONES
					peticion.getSession().setAttribute("usuario", usuario);
				} else {
					// ERROR EN LA CLAVE
					error_clave = rb.getString("login.error.claveerronea");
				}
			} else {
				// ERROR EN EL NOMBRE
				error_nombre = rb.getString("login.error.nombreerroneo");
			}
		}
		// PASO DE MENSAJES DE ERROR, SI LOS HAY
		if (error_nombre != null) {
			peticion.setAttribute("error_nombre", error_nombre);
			System.out.println(error_nombre);
		}
		if (error_clave != null) {
			peticion.setAttribute("error_clave", error_clave);
			System.out.println(error_clave);
		}
		// PEDIMOS EL SIGUIENTE COMPONENTE, UNA PAGINA JSP
		RequestDispatcher rqd = peticion.getRequestDispatcher(salida);
		rqd.forward(peticion, respuesta);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {

	}

}
