package com.atrium.hibernate.ext;

import com.atrium.hibernate.Tareas;

/**
 * Extension de la clase de persistencia Tareas para incluir la traduccion del
 * texto a mostrar en el menu personalizado.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.8
 * @since 18-02-2013
 */
public class Tareas_Idioma extends Tareas {

	private String traduccion;

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}
}
