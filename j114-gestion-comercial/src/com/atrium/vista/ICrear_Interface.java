package com.atrium.vista;

/**
 * Comportamiento comun de las interfaces graficas propias.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5
 * @since 16-3-2012
 */
public interface ICrear_Interface {

	/**
	 * Proceso de creaciacion y montaje de los componentes y contenedores la
	 * interface grafica.<br/>
	 * Metodo definido en la interface ICrear_Interface
	 */
	public void crear_Interface();

	/**
	 * Proceso donde utilizaremos las opciones desarrolladas con reflexion para
	 * un trabajo mas agil en los entornos graficos.
	 */
	public void ajustes_Reflexion();

	/**
	 * Proceso donde gestionaremos los cambios en el ciclo de foco de los
	 * contenedores de nuestras interfaces.
	 */

	public void establecer_GestionFoco();
}
