package com.atrium.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.modelo.dao.Provincias_DAO;

/**
 * Solucion de parametro de constructor.
 * @author Profesor
 *
 */

public class Gestion_Provincias implements IGestion_Provincias,
		Comparator<Provincias> {

	private Provincias_DAO provincias_dao;

	public Gestion_Provincias(Provincias_DAO provincia_dao) {
		this.provincias_dao = provincia_dao;
	}

	@Override
	public List<Provincias> consultar_Todos() {
		List<Provincias> lista = provincias_dao.consultar_Todos();
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(Provincias provincia1, Provincias provincia2) {
		return provincia1.getCodigoprovincia().compareTo(
				provincia2.getCodigoprovincia());
	}
}
