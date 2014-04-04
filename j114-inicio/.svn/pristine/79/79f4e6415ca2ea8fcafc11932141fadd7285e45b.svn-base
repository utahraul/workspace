package com.atrium.controlador;

import com.atrium.modelo.Modelo;
import com.atrium.vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;

	public Controlador() {
		modelo = new Modelo();
		vista = new Vista();

		prueba_Uno();
		prueba_Dos();
	}

	public void prueba_Uno() {
		modelo.setTexto("HOLA MUNDO JAVA 66666");
		vista.mostrar_Texto(modelo.getTexto());
	}

	public void prueba_Dos() {
		Modelo modelo2 = new Modelo();
		modelo2.setTexto("otro texto");
		if (modelo2.equals(modelo)) {
			vista.mostrar_Texto("SON IGUALES");
		} else {
			vista.mostrar_Texto("NO SON IGUALES");
		}
		modelo2.equals(vista);

		System.out.println("");
	}
}
