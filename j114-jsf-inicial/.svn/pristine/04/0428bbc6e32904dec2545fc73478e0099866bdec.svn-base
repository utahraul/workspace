package com.atrium.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atrium.managedbean.Idioma_Bean;

/**
 * Utilidad para el acceso a los distintos contextos necesarios dentro de la
 * aplicacion. Aprovecha el echo de que los accesos a los mismo son todos
 * objetos estaticos y los expone de la misma forma estatica.
 * 
 * @author profesor Juan Antonio Solves Garcia
 * @since 3-12-2013 1.5
 */
public class Acceso_Contextos {

	/**
	 * Metodo de conveniencia para la inclusion de mensajes en los managedbean
	 * sin tener que llamar todo el rato al facescontext.
	 * 
	 * @param mensaje
	 * @param identificador
	 */
	public static void addMensaje(String mensaje_sumario,
			String mensaje_detalle, FacesMessage.Severity nivel,
			String identificador) {
		if (nivel == null) {
			nivel = FacesMessage.SEVERITY_INFO;
		}
		FacesContext.getCurrentInstance().addMessage(identificador,
				new FacesMessage(nivel, mensaje_sumario, mensaje_detalle));
	}

	/**
	 * Metodo de conveniencia para la inclusion de mensajes en los managedbean
	 * sin tener que llamar todo el rato al facescontext.<br/>
	 * En esta metodo no se envian los textos, solo las claves para los
	 * properties. Por lo tanto es necesario crear el ResourceBundle que lea del
	 * properties correspondiente.
	 * 
	 * @param mensaje
	 * @param identificador
	 */
	public static void addMensaje_Idioma(String clave_sumario,
			String clave_detalle, FacesMessage.Severity nivel,
			String identificador) {
		System.out.println("");
		try {
			// CREO EL RB PARA LEER DEL PROPERTIES ADECUADO
			ResourceBundle rb = ResourceBundle
					.getBundle(((Idioma_Bean) getSesion().getAttribute(
							"idioma_bean")).getIdioma_elegido());
			// COMPRUEBO QUE NO VENGAN VACIOS O NULOS
			String sumario = "";
			String detalle = "";
			if (clave_detalle != null && !clave_detalle.equals("") ) {
				detalle = rb.getString(clave_detalle);
			}
			if (clave_sumario != null && !clave_sumario.equals("") ) {
				sumario = rb.getString(clave_sumario);
			}
			if (nivel == null) {
				nivel = FacesMessage.SEVERITY_INFO;
			}
			FacesContext.getCurrentInstance().addMessage(identificador,
					new FacesMessage(nivel, sumario, detalle));
		} catch (Exception e) {
			System.out
					.println("NO EXISTE PROPERTIES DEFINIDO. REVISAR ATRIBUTO DE SESION IDIOMA_ELEGIDO");
		}
	}

	/**
	 * Devuelve la sesion si existe. De no existir no devuelve nada, no crea una
	 * nueva
	 * 
	 * @return Sesion en curso. (HTTPSESSION)
	 */
	public static HttpSession getSesion() {
		HttpSession salida = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return salida;
	}

	/**
	 * Devuelve la peticion de en curso.
	 * 
	 * @return Peticion en curso. (HTTPSERVLETREQUEST)
	 */
	public static HttpServletRequest getPeticion() {
		HttpServletRequest peticion = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return peticion;
	}

	/**
	 * Devuelve el contexto de aplicacion correspondiente.
	 * 
	 * @return Contexto de aplicion JEE. (SERVLETCONTEXT).
	 */
	public static ServletContext getAplicacion() {
		ServletContext aplicacion = ((HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false))
				.getServletContext();
		return aplicacion;
	}

	/**
	 * Devuelve la respuesta de en curso.
	 * 
	 * @return Respuesta en curso. (HTTPSERVLETRESPONSE)
	 */
	public static HttpServletResponse getRespuesta() {
		HttpServletResponse respuesta = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		return respuesta;
	}

	/**
	 * Devuelve el applicationContext de spring para su uso.
	 * 
	 * @return ApplicationContext de spring. (APPLICATIONCONTEXT)
	 */
	public static ApplicationContext getApplication_Context() {
		ApplicationContext application = WebApplicationContextUtils
				.getWebApplicationContext(Acceso_Contextos.getAplicacion());
		return application;
	}

}
