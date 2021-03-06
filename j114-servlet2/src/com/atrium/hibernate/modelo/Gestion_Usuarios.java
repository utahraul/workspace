package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;
import com.atrium.hibernate.dao.ext.Usuario_DAOEXT;

public class Gestion_Usuarios implements IGestion_Usuarios {

	private Usuario_DAOEXT usuarios_dao;

	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuarios_dao.findById(nombre_usuario);
	}

	@Override
	public List<Tareas> consultar_TareasUsuario(Usuarios usuario) {
		return usuarios_dao.consultar_TareasUsuario(usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuarios_dao(Usuario_DAOEXT usuarios_dao) {
		this.usuarios_dao = usuarios_dao;
	}

}
