package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

public class Gestion_Provincias implements IGestion_Provincias {

	private ProvinciasDAO provincias_dao;

	@Override
	public List<Provincias> consultar_Todas() {
		return provincias_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setProvincias_dao(ProvinciasDAO provincias_dao) {
		this.provincias_dao = provincias_dao;
	}

}
