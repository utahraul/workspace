package com.atrium.modelo;

public class Gestion_Datos implements IGestion_Datos {

	private Datos_DAO datos_dao;

	public Gestion_Datos() {
		datos_dao = new Datos_DAO();
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
