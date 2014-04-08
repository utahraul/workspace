package com.atrium.hibernate.modelo;

import com.atrium.hibernate.dao.RolesDAO;

public class Gestion_Roles {

	private RolesDAO rol_dao;

	
	
	// ACCESORES PARA SPRING
	public void setRol_dao(RolesDAO rol_dao) {
		this.rol_dao = rol_dao;
	}

}
