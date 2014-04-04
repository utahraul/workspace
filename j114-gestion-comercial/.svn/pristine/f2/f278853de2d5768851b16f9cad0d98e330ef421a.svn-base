package com.atrium.controlador;

public interface ICarga_Inicial {
	// CONSTANTES DE CLASE PARA LAS DISTINTAS CARGAS DE CONFIGURACION
	public final int FICHERO_PROPERTIES = 1;
	public final int FICHERO_XML = 2;

	/**
	 * Proceso de arranque por defecto. Tiene todas las opciones.
	 */
	public void opciones_Defecto();

	/**
	 * Proceso de carga del programa leyendo del fichero de configuracion XML.
	 */
	public void opciones_XML();

	/**
	 * Proceso de carga del lookandfeel nimbus para la interface grafica.
	 */
	public void establecer_Nimbus();

	/**
	 * Lectura de los parametros de configuracion de la aplicacion.<br/>
	 * De momento se establecen dos tipos de arranque en funcion de la
	 * configuracion.<br/>
	 * Si vale 1 es un properties.<br/>
	 * Si vale 2 es un XML.
	 * 
	 * @param tipo_ficheroconfiguracion
	 *            Valor numerico entero que define el tipo de fichero de
	 *            configuracion.
	 */
	public void cargar_Configuracion(int tipo_ficheroconfiguracion);

}