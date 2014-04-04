package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Provincias;

public interface IGestion_Provincias {

	public Provincias consultar_ProvinciaPorCodigo(Byte codigo_provincia);

	public Provincias consultar_ProvinciaPorNombre(String nombre_provincia);

	public List<Provincias> consultar_Todas();

	public abstract void modificacion_Provincia(Provincias provincia_amodificar);

	public abstract void baja_Provincia(Provincias provincia_aeliminar);

	public abstract void alta_Provincia(Provincias provincia_nueva);

	public abstract Provincias consultar_ConMunicipios(Byte codigo_provincia);

}