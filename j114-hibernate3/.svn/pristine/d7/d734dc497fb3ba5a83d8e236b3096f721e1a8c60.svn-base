package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ext.Provincias_DAOEXT;

public class Gestion_Provincias {

	private Provincias_DAOEXT provincias_dao;

	public Gestion_Provincias() {
		provincias_dao = new Provincias_DAOEXT();
	}

	public Provincias consultar_ConMunicipios(Byte codigo_provincia) {
		Provincias provincia = provincias_dao
				.consulta_ConMunicipios(codigo_provincia);
		provincias_dao.getSession().close();
		return provincia;
	}

}
