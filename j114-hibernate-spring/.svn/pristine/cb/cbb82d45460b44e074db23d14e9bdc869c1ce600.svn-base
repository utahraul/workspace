package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Usuario_DAOEXT extends UsuariosDAO {

	/**
	 * Consulta de resolucion de carga vaga a partir del detachedcriteria. No es
	 * accesibel al session de hibernate.
	 */
	public Usuarios consultar_UsuarioConRol(String nombre_usuario) {
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		List<Usuarios> usuarios = getHibernateTemplate().findByCriteria(
				consulta);
		Usuarios usuario = null;
		if (!usuarios.isEmpty()) {
			usuario = usuarios.get(0);
		}
		return usuario;
	}

}
