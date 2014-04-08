package com.atrium.modelo;

import com.atrium.spring.Acceso_ApplicationContext;

public class Gestion_Datos implements IGestion_Datos {

	private Datos_DAO datos_dao;

	public Gestion_Datos() {
		//datos_dao = new Datos_DAO();
		datos_dao = Acceso_ApplicationContext.getBean(Datos_DAO.class);
	}

	@Override
	public Datos_DTO leer_Datos() {
		return datos_dao.leer_Datos();
	}

	@Override
	public boolean escribir_Datos(Datos_DTO datos) {
		return datos_dao.escribir_Datos(datos);
	}
	
}
