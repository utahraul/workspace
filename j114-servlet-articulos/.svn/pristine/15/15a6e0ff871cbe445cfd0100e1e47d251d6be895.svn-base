package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.dao.ArticulosDAO;

public class Gestion_Articulos implements IGestion_Articulos {

	private ArticulosDAO articulo_dao;

	@Override
	public Articulos consultar_PorClave(Integer codigo_articulo) {
		return articulo_dao.findById(codigo_articulo);
	}

	// ACCESORES PARA SPRING
	public void setArticulo_dao(ArticulosDAO articulo_dao) {
		this.articulo_dao = articulo_dao;
	}

}
