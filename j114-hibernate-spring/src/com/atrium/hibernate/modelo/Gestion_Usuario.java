package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.IUsuarios_DAO;

public class Gestion_Usuario implements IGestion_Usuario {

	private IUsuarios_DAO usuario_dao;

	/**
	 * Consulta de un usuario por el nombre (clave primaria en esta tabla)
	 */
	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	/**
	 * Consulta de todos los usuarios
	 */
	@Override
	public List<Usuarios> consultar_Todos() {
		return usuario_dao.findAll();
	}

	/**
	 * Consulta de usuarios de u nrol determinado
	 */
	@Override
	public List<Usuarios> consultar_PorRol(Roles rol_aconsultar) {
		return usuario_dao.findByProperty("roles.codigoRol",
				rol_aconsultar.getCodigoRol());
	}

	/**
	 * Consulta de resolucion de carga vaga.
	 */
	@Override
	public Usuarios consultar_UsuarioConRol(String nombre_usuario) {
		return usuario_dao.consultar_UsuarioConRol(nombre_usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(IUsuarios_DAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
