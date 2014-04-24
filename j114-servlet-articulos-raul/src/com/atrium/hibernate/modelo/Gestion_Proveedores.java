package com.atrium.hibernate.modelo;

import com.atrium.hibernate.dao.ProveedoresDAO;

public class Gestion_Proveedores implements IGestion_Proveedor {
	
	private ProveedoresDAO proveedor_dao;

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_proveedor#getProveedor_dao()
	 */
	@Override
	public ProveedoresDAO getProveedor_dao() {
		return proveedor_dao;
	}

	public void setProveedor_dao(ProveedoresDAO proveedor_dao) {
		this.proveedor_dao = proveedor_dao;
	}
	
	

}
