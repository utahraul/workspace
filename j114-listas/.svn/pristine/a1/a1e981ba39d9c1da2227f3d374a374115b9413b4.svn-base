package com.atrium.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.modelo.dao.Pais_DAO;
import com.atrium.spring.Acceso_ApplicationContext;
/**
 * Solucion de creacion directa de bean por spring.
 * @author Profesor
 *
 */
public class Gestion_Pais implements IGestion_Pais, Comparator<Pais> {

	private Pais_DAO pais_dao;

	public Gestion_Pais() {
		pais_dao = Acceso_ApplicationContext.getBean(Pais_DAO.class);
	}

	/**
	 * @see com.atrium.modelo.IGestion_Pais#consultar_Todos()
	 */
	@Override
	public List<Pais> consultar_Todos() {
		List<Pais> lista = pais_dao.consultar_Todos();
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(Pais pais1, Pais pais2) {
		return pais2.getCodigopais().compareTo(pais1.getCodigopais());
	}

}
