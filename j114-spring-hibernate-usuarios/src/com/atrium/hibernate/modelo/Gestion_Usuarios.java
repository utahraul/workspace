package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;
import com.atrium.hibernate.dao.ext.Usuarios_DAOEXT;

public class Gestion_Usuarios implements IGestion_Usuarios {

	private Usuarios_DAOEXT usuarios_dao;

	@Override
	public void alta_Usuario(Usuarios usuario_nuevo) {
		usuarios_dao.save(usuario_nuevo);
	}

	@Override
	public void baja_Usuario(Usuarios usuario_aeliminar) {
		usuarios_dao.delete(usuario_aeliminar);
	}

	@Override
	public void modificacion_Usuario(Usuarios usuario_amodificar) {
		usuarios_dao.attachDirty(usuario_amodificar);
	}

	@Override
	public Usuarios consultar_UsuarioPorNombre(String nombre_usuario) {
		return usuarios_dao.findById(nombre_usuario);
	}

	@Override
	public Usuarios consultar_ConRol(String nombre_usuario) {
		return usuarios_dao.consultar_ConRol(nombre_usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuarios_dao(Usuarios_DAOEXT usuarios_dao) {
		this.usuarios_dao = usuarios_dao;
	}

}
