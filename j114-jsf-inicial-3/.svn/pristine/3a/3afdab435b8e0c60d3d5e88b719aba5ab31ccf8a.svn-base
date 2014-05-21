package com.atrium.managedbean;

import com.atrium.util.Acceso_Contextos;

/**
 * Procesos de control del idioma en el cual se va a mostrar la aplicaicion
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2 24-1-2013
 */
public class Idioma_Bean {

	// PROPIEDADES PARA EL PROCESO
	private String idioma_elegido;
	private String boton_idioma;

	/**
	 * Cargamos en el constructor el idioma por defecto establecido por el
	 * filtro inicial.
	 */
	public Idioma_Bean() {
		System.out.println("SOY EL IDIOMA");
		idioma_elegido = (String) Acceso_Contextos.getSesion().getAttribute(
				"idioma_elegido");
	}

	//ACCESORES PARA JSF
	public String getIdioma_elegido() {
		return idioma_elegido;
	}

	public void setIdioma_elegido(String idioma_elegido) {
		this.idioma_elegido = idioma_elegido;
	}

	public String getBoton_idioma() {
		return boton_idioma;
	}

	public void setBoton_idioma(String boton_idioma) {
		this.boton_idioma = boton_idioma;
	}
	
	
}
