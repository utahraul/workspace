package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Municipios;

public interface IGestion_Municipios {

	public void alta_Municipio(Municipios municipio_nuevo);

	public void baja_Municipio(Municipios municipio_aeliminar);

	public void modificacion_Municipio(Municipios municipio_amodificar);

}