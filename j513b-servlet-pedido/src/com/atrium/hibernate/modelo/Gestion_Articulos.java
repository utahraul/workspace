package com.atrium.hibernate.modelo;

import java.util.List;
import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.dao.ext.Articulo_DAOEXT;

public class Gestion_Articulos implements IGestion_Articulos {

	private Articulo_DAOEXT art_DAO;

	public List<Articulos> consulta_General() {
		List<Articulos> lista = art_DAO.findAll();
		return lista;
	}

	public List<Articulos> consulta_GeneralSoloCantida() {
		List<Articulos> lista = art_DAO.consultar_Stock();
		for (Articulos arti : lista) {
			arti.setDescripcionArticulo(null);
			arti.setLineaPedidos(null);
			arti.setPrecioUnidadArticulo(null);
		}
		return lista;
	}

	// ACCESORES PARA SPRING
	public void setArt_DAO(Articulo_DAOEXT art_DAO) {
		this.art_DAO = art_DAO;
	}

}
