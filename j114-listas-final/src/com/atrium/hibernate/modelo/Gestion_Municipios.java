package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.dao.MunicipiosDAO;
import com.atrium.modelo.IGestion_Municipios;

public class Gestion_Municipios implements IGestion_Municipios{
	
	private MunicipiosDAO municipios_dao;

	@Override
	public List<Municipios> consultar_PorProvincias(Integer codigoprovincia) {
		return municipios_dao.findByProperty("id.provincia", codigoprovincia.byteValue());
	}

	//ACCESORES PARA SPRING
	public void setMunicipios_dao(MunicipiosDAO municipios_dao) {
		this.municipios_dao = municipios_dao;
	}

}
