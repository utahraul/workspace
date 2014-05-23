package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Usuario_DAOEXT extends UsuariosDAO {

	public Usuarios consultar_ConRol(String nombre_usuario) {
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		List<Usuarios> lista = getHibernateTemplate().findByCriteria(consulta);
		Usuarios usuario_consultado = null;
		if (!lista.isEmpty()) {
			usuario_consultado = lista.get(0);
		}
		return usuario_consultado;
	}

	public List<Usuarios> consultar_TodosConRol() {
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		List<Usuarios> lista = getHibernateTemplate().findByCriteria(consulta);
		return lista;
	}
}
