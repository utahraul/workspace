package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;
import com.atrium.hibernate.dao.ext.Usuarios_DAOEXT;

public class Gestion_Usuario implements IGestion_Usuarios {

	private Usuarios_DAOEXT usuario_dao;

	public Gestion_Usuario() {
		usuario_dao = new Usuarios_DAOEXT();
	}

	@Override
	public Usuarios consultar_Usuario(String nombre_usuario) {
		Usuarios usuario = usuario_dao.findById(nombre_usuario);
		usuario_dao.getSession().close();
		return usuario;
	}

	@Override
	public Usuarios consultar_UsuarioConRol(String nombre_usuario) {
		Usuarios usuario = usuario_dao.consultar_UsuarioConRol(nombre_usuario);
		usuario_dao.getSession().close();
		return usuario;
	}

	@Override
	public Usuarios consultar_UsuarioConTareas(String nombre_usuario) {
		Usuarios usuario = usuario_dao.consultar_TareasUsuario(nombre_usuario);
		usuario_dao.getSession().close();
		return usuario;
	}
}
