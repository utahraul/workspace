package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Gestion_Usuarios implements IGestion_Usuario {

	private UsuariosDAO usuarios_dao;

	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuarios_dao.findById(nombre_usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuarios_dao(UsuariosDAO usuarios_dao) {
		this.usuarios_dao = usuarios_dao;
	}

}
