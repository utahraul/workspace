package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Gestion_Usuario implements IGestion_Usuario {

	private UsuariosDAO usuario_dao;

	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	@Override
	public void alta_Usuario(Usuarios usuario_nuevo) {
		usuario_dao.save(usuario_nuevo);
	}

	@Override
	public void baja_Usuario(Usuarios usuario_nuevo) {
		usuario_dao.delete(usuario_nuevo);
	}

	@Override
	public void modificacion_Usuario(Usuarios usuario_nuevo) {
		usuario_dao.attachDirty(usuario_nuevo);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(UsuariosDAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
