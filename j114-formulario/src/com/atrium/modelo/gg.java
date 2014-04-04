package com.atrium.modelo;

public class gg {

	public static void main(String[] args) {
		IGestion_Datos gestion_datos = new Gestion_Datos();

		Datos_DTO datos = new Datos_DTO();
		datos.setNombre("j114");
		datos.setApellido("no");
		datos.setCalle("cartagena");
		datos.setCiudad("madrid");

		boolean resultado = gestion_datos.escribir_Datos(datos);

		Datos_DTO ff = gestion_datos.leer_Datos();

		System.out.println("");

	}

}
