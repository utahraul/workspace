package com.atrium.hibernate.dao.ext;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Usuario_DAOEXT extends UsuariosDAO {

	public List<Tareas> consultar_TareasUsuario(Usuarios usuario) {
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		consulta.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		consulta.add(Restrictions.idEq(usuario.getNombreUsuario()));
		List<Usuarios> lista_usuarios = getHibernateTemplate().findByCriteria(
				consulta);
		List<Tareas> lista_tareas = new ArrayList<>(0);
		if (!lista_usuarios.isEmpty()) {
			lista_tareas.addAll(lista_usuarios.get(0).getRoles().getTareases());
		}
		return lista_tareas;
	}

}
