package com.atrium.etiquetas;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.ext.Tareas_Idioma;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.hibernate.modelo.IGestion_Usuarios;
import com.atrium.spring.Acceso_ApplicationContext;

/**
 * Etiqueta personalizada para la generacion dinamica del menu personalizado de
 * cada usuario que inicia la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0
 * @since 6-9-2013
 */
public class Menu_Personalizado extends SimpleTagSupport {

	// PROPIEDAD PARA RECOGER EL ATRIBUTO DE LA ETIQUETA
	private boolean sentido;
	// COLECCION PARA IDIOMATIZAR LAS OPCIONES DE MENU
	private List<Tareas_Idioma> lista_tareas_traducidas;
	private ResourceBundle rb;
	private String idioma_elegido;

	@Override
	public void doTag() throws JspException, IOException {
		// RESOLVEMOS LA IDIOMATIZACION DEL MENU
		idioma_elegido = (String) this.getJspContext().getAttribute(
				"idioma_elegido", PageContext.SESSION_SCOPE);
		rb = ResourceBundle.getBundle(idioma_elegido);

		// RECOGEMOS EL USUARIO DE LA SESION
		Usuarios usuario = (Usuarios) this.getJspContext().getAttribute(
				"usuario", PageContext.SESSION_SCOPE);
		// PIDO LA FACHADA AL APPLICATION CONTEXT DE SPRING
		IGestion_Usuarios gestion_usuario = Acceso_ApplicationContext
				.getBean(IGestion_Usuarios.class);
		// REALIZO LA CONSULTA QUE ME RESUELVE LA CARGA VAGA DE HIBERNATE
		List<Tareas> lista_tareas = gestion_usuario
				.consultar_TareasUsuario(usuario);

	}

	// ACCESORES PARA LA INYECCION DE VALORES
	public boolean isSentido() {
		return sentido;
	}

	public void setSentido(boolean sentido) {
		this.sentido = sentido;
	}

}
