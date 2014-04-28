package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Proveedores;
import com.atrium.hibernate.dao.ProveedoresDAO;

public class Gestion_Proveedores implements IGestion_Proveedores {

	private ProveedoresDAO proveedor_dao;

	@Override
	public List<Proveedores> consultar_Todos() {
		return proveedor_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setProveedor_dao(ProveedoresDAO proveedor_dao) {
		this.proveedor_dao = proveedor_dao;
	}

}
