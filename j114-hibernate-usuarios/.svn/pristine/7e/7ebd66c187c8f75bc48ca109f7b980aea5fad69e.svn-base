package com.atrium.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Usuarios;

public class Usuario_DAOEXT extends UsuariosDAO{

	public Usuarios consultar_ConRol(String nombre_usuario){
		Usuarios usuario_consultado=null;
		Criteria consulta=getSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));		
		usuario_consultado=(Usuarios) consulta.uniqueResult();
		return usuario_consultado; 
	}
	
}
