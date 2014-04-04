package com.atrium.controlador;

import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.Gestion_Municipios;
import com.atrium.hibernate.modelo.Gestion_Provincias;
import com.atrium.hibernate.modelo.Gestion_Usuario;
import com.atrium.hibernate.modelo.IGestion_Municipios;
import com.atrium.hibernate.modelo.IGestion_Provincias;
import com.atrium.hibernate.modelo.IGestion_Usuarios;

public class Inicio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IGestion_Provincias gestion_provincias = new Gestion_Provincias();

		Provincias provincia = gestion_provincias
				.consultar_ProvinciaPorCodigo(new Byte((byte) 28));

		provincia = gestion_provincias.consultar_ConMunicipios(new Byte(
				(byte) 28));

		IGestion_Municipios gestion_municipios = new Gestion_Municipios();

		List<Municipios> lista_muni = gestion_municipios
				.consultar_PorProvincia(new Byte((byte) 28));

		provincia = gestion_provincias.consultar_ProvinciaPorNombre("Badajoz");

		List<Provincias> lista = gestion_provincias.consultar_Todas();

		Provincias provincia_nueva = new Provincias();
		provincia_nueva.setCodigoProvincia(new Byte((byte) 99));
		provincia_nueva.setProvincia("j513b");
		gestion_provincias.alta_Provincia(provincia_nueva);
		provincia_nueva.setProvincia("pa probar");
		gestion_provincias.modificacion_Provincia(provincia_nueva);

		gestion_provincias.baja_Provincia(provincia_nueva);
		
		
		IGestion_Usuarios gestion_usuarios = new Gestion_Usuario();
		Usuarios usuario = gestion_usuarios.consultar_Usuario("Juan");

		System.out.println("");

		usuario = gestion_usuarios.consultar_UsuarioConRol("Juan");

		usuario = gestion_usuarios.consultar_UsuarioConTareas("Juan");

	}

}
