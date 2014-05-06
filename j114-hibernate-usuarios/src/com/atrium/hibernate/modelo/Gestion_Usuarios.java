package com.atrium.hibernate.modelo;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.Usuario_DAOEXT;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Gestion_Usuarios implements IGestion_Usuarios {

	private Usuario_DAOEXT usuarios_dao;

	public Gestion_Usuarios() {
		usuarios_dao = new Usuario_DAOEXT();
	}

	@Override
	public void alta_Usuario(Usuarios usuario_nuevo) {
		Transaction transaccion = null;
		try {
			transaccion = usuarios_dao.getSession().beginTransaction();
			usuarios_dao.save(usuario_nuevo);
			transaccion.commit();
		} catch (HibernateException e) {
			// ERROR EN EL ALTA
			transaccion.rollback();
		}
		usuarios_dao.getSession().close();
	}

	@Override
	public void baja_Usuario(Usuarios usuario_aeliminar) {
		Transaction transaccion = null;
		try {
			transaccion = usuarios_dao.getSession().beginTransaction();
			usuarios_dao.delete(usuario_aeliminar);
			transaccion.commit();
		} catch (HibernateException e) {
			// ERROR EN EL BAJA
			transaccion.rollback();
		}
		usuarios_dao.getSession().close();
	}

	@Override
	public void modificacion_Usuario(Usuarios usuario_amodificar) {
		Transaction transaccion = null;
		try {
			transaccion = usuarios_dao.getSession().beginTransaction();
			usuarios_dao.attachDirty(usuario_amodificar);
			transaccion.commit();
		} catch (HibernateException e) {
			// ERROR EN EL MODIFICACION
			transaccion.rollback();
		}
		usuarios_dao.getSession().close();
	}

	@Override
	public Usuarios consultar_Usuario(String nombre_usuario) {
		Usuarios usuario = usuarios_dao.findById(nombre_usuario);
		usuarios_dao.getSession().close();
		return usuario;
	}

	@Override
	public Usuarios consultar_ConRol(String nombre_usuario) {
		Usuarios usuario = usuarios_dao.consultar_ConRol(nombre_usuario);
		usuarios_dao.getSession().close();
		return usuario;
	}
}
