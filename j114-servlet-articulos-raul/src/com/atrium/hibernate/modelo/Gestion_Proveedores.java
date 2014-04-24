package com.atrium.hibernate.modelo;

import com.atrium.hibernate.dao.ProveedoresDAO;

public class Gestion_Proveedores implements IGestion_Proveedor {

	private ProveedoresDAO proveedor_dao;

	public List<Proveedores> consultar_Todos() {
		return proveedor_dao.findAll();
	}

	public void setProveedor_dao(ProveedoresDAO proveedor_dao) {
		this.proveedor_dao = proveedor_dao;
	}


}
