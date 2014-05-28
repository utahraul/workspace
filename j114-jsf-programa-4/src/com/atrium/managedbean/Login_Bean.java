package com.atrium.managedbean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Acceso_Contextos;
import com.atrium.util.Ejecucion_Expresiones;

public class Login_Bean implements Serializable {
	// PROPIEDADES PARA EL FORMULARIO
	private String nombre_usuario;
	private String clave_usuario;
	// PROPIEDADES PARA EL CONTROL DEL PROCESO
	private boolean login_visible;

	public Login_Bean() {
		// VALORES POR DEFECTO PARA LAS PROPIEDADES DEL MANAGEDBEAN
		login_visible = true;
	}

	public void comprobar_Credenciales(ActionEvent evento) {
		IGestion_Usuario gestion_usuario = Acceso_ApplicationContext
				.getBean(IGestion_Usuario.class);
		Usuarios usuario = gestion_usuario
				.consultar_PorNombre(getNombre_usuario());
		if (usuario != null) {
			if (usuario.getPassword().equals(getClave_usuario())) {
				// USUARIO CORRECTO
				login_visible = false;
				Acceso_Contextos.getSesion().setAttribute("usuario", usuario);
				// ACCEDEMOS AL MANAGEDBEAN QUE SE NECESITA
				Menu_DinamicoBean menu_bean = Ejecucion_Expresiones
						.tratar_Expresion("#{menu_bean}",
								Menu_DinamicoBean.class);
				// MODIFICAMOS EL VALOR A LA PROPIEDAD
				menu_bean.setMenu_visible(true);
				//CREAMOS EL MENU DINAMICAMENTE
				menu_bean.crear_Menu();
			} else {
				// ERROR EN LA CLAVE
				Acceso_Contextos.addMensaje_Idioma("error.login.clave", null,
						null, "");
			}
		} else {
			// ERROR EN EL NOMBRE
			Acceso_Contextos.addMensaje_Idioma("error.login.nombre", null,
					null, "clave");
		}
	}

	// ACCESORES PARA SPRING
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getClave_usuario() {
		return clave_usuario;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}

	public boolean isLogin_visible() {
		return login_visible;
	}

	public void setLogin_visible(boolean login_visible) {
		this.login_visible = login_visible;
	}

}
