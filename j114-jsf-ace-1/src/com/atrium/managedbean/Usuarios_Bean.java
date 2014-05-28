package com.atrium.managedbean;

import java.util.List;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;

public class Usuarios_Bean {

	private List<Usuarios> lista_usuarios;

	public Usuarios_Bean() {
		IGestion_Usuario gestion_usuario = Acceso_ApplicationContext
				.getBean(IGestion_Usuario.class);
		lista_usuarios=gestion_usuario.consultar_UsuariosConRol();
	}

	
	public List<Usuarios> getLista_usuarios() {
		return lista_usuarios;
	}

	public void setLista_usuarios(List<Usuarios> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}

}
