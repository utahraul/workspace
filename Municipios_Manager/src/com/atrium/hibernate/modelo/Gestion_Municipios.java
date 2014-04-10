package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.MunicipiosDAO;

public class Gestion_Municipios implements IGestion_Municipios {

	private MunicipiosDAO municipio_dao;

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_Municipios#alta_Municipio(com.atrium.hibernate.Municipios)
	 */
	
	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_Municipios#alta_Municipio(com.atrium.hibernate.Municipios)
	 */
	@Override
	public void alta_Municipio (Municipios municipio_nuevo){
		municipio_dao.save(municipio_nuevo);
	}
	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_Municipios#baja_Municipio(com.atrium.hibernate.Municipios)
	 */
	@Override
	public void baja_Municipio(Municipios municipio_aeliminar){
		municipio_dao.delete(municipio_aeliminar);
	}
	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_Municipios#modificacion_Municipio(com.atrium.hibernate.Municipios)
	 */
	@Override
	public void modificacion_Municipio(Municipios municipio_amodificar){
		municipio_dao.attachDirty(municipio_amodificar);
	}
	
	// ACCESORES PARA SPRING
	public void setMunicipio_dao(MunicipiosDAO municipio_dao) {
		this.municipio_dao = municipio_dao;
	}

}
