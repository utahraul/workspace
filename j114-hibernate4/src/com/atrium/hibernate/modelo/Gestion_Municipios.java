package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.dao.MunicipiosDAO;

public class Gestion_Municipios implements IGestion_Municipios {

	private MunicipiosDAO municipios_dao;

	public Gestion_Municipios() {
		municipios_dao = new MunicipiosDAO();
	}

	@Override
	public List<Municipios> consultar_PorProvincia(Byte codigo_provincia) {
		List<Municipios> lista = municipios_dao.findByProperty("id.provincia",
				codigo_provincia);
		municipios_dao.getSession().close();
		return lista;
	}
}
