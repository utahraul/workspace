package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Usuarios_DAOEXT extends UsuariosDAO {

	public Usuarios consultar_UsuarioConRol(String nombre_usuario) {
		Criteria consulta = getSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		Usuarios usuario = (Usuarios) consulta.uniqueResult();
		return usuario;
	}

	public Usuarios consultar_TareasUsuario(String nombre_usuario) {
		Criteria consulta = getSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		Usuarios usuario = (Usuarios) consulta.uniqueResult();
		return usuario;

	}
}
