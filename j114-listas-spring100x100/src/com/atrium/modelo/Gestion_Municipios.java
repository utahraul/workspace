package com.atrium.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.modelo.dao.Municipios_DAO;

/**
 * Solucion de inyeccion de dependencias.
 * 
 */
public class Gestion_Municipios implements IGestion_Municipios,
		Comparator<Municipios> {

	private Municipios_DAO municipios_dao;

	public Gestion_Municipios() {

	}

	@Override
	public List<Municipios> consultar_PorProvincias(Integer codigoprovincia) {
		List<Municipios> lista = municipios_dao
				.consultar_PorProvincia(codigoprovincia);
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(Municipios municipios1, Municipios municipios2) {

		return municipios1.getCodigomunicipio().compareTo(
				municipios2.getCodigomunicipio());
	}

	// ACCESORES PARA SPRING
	public void setMunicipios_dao(Municipios_DAO municipios_dao) {
		this.municipios_dao = municipios_dao;
	}

}
