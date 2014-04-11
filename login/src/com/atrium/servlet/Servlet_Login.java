package com.atrium.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// 1º RECOGEMOS LA INFORMACIÓN DE LA PETICIÓN
		String nombre_usuario=peticion.getParameter("nombre_usuario");
		String clave_usuario=peticion.getParameter("clave_usuario");
		//2º CONVERSIÓN 
		//EN ESTE CASO NO HACE FALTA PORQUENOMBRE DE USUARIO Y PASSWORD SON STRING
		//3º VALIDACIÓN DE LO QUE EL USUARIO HA ENVIADO. VER SI PODEMOS TRABAJAR CON LOS DATOS ENVIADOS
		boolean valido=true;
		if(nombre_usuario.equals("")){
			valido=false;
		}
		if(clave_usuario.equals("")){
			valido=false;
		}
		//4º NEGOCIO/LÓGICA
		if(valido) {
			
		}
	}

}
