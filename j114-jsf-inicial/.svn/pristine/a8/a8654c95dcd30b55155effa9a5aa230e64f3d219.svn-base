package com.atrium.managedbean;

import javax.faces.event.ActionEvent;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;

public class Login_Bean {
	// PROPIEDADES PARA LOS PARAMETROS DE LA PETICION
	private String nombre_usuario;
	private String clave_usuario;
	// PROPIEDADES PARA EL PROCESO
	private String salida;

	/**
	 * Tratamiento de accion. Fase 6.
	 * 
	 * @return
	 */
	public String comprobar_Credenciales() {
		IGestion_Usuario gestion_usuario = Acceso_ApplicationContext
				.getBean(IGestion_Usuario.class);
		Usuarios usuario = gestion_usuario
				.consultar_PorNombre(getNombre_usuario());
		if (usuario != null) {
			if (usuario.getPassword().equals(getClave_usuario())) {
				// CREDENCIALES CORRECTAS
				salida = "correcto";
			} else {
				// ERROR EN LA CLAVE
				salida = "incorrecto";
			}
		} else {
			// ERROR EN EL NOMBRE
			salida = "incorrecto";
		}
		return salida;
	}

	/**
	 * Tratamineto de evento. Previo a la fase 6 , despues de la fase 5.
	 * 
	 * @param evento
	 */
	public void evento_Boton(ActionEvent evento) {
		System.out.println("soy el evento");
	}

	// ACCESORES PARA JSF
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

}
