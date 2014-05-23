package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.ext.Usuario_DAOEXT;

public class Gestion_Usuario implements IGestion_Usuario {

	private Usuario_DAOEXT usuario_dao;

	@Override
	public Usuarios consultar_ConRol(String nombre_usuario) {
		return usuario_dao.consultar_ConRol(nombre_usuario);
	}

	@Override
	public List<Usuarios> consultar_UsuariosConRol() {
		return usuario_dao.consultar_TodosConRol();
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(Usuario_DAOEXT usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
