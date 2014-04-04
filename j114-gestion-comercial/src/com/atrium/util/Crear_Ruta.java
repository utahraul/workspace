package com.atrium.util;

import java.io.File;

/**
 * Unificacion de logica y proceso respecto a la creacion y comprobacion de
 * rutas en la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0 12-3-2012
 * 
 */
public class Crear_Ruta {
	private static boolean creado;

	/**
	 * Comprueba la existencia de una trayectoria y en caso de no existir la
	 * crea.
	 * 
	 * @param directorio_nuevo
	 *            File que representa la trayectoria.
	 * @return TRUE/FALSE que indica si se ha creado o no el directorio.
	 */
	public static boolean crear_Directorios(File directorio_nuevo) {
		creado = false;
		if (!directorio_nuevo.exists()) {
			creado = directorio_nuevo.mkdirs();
		}else{
			creado=true;
		}
		return creado;
	}

	/**
	 * Comprueba la existencia de una trayectoria y en caso de no existir la
	 * crea.
	 * 
	 * @param directorio_nuevo
	 *            String que representa la trayectoria.
	 * @return TRUE/FALSE que indica si se ha creado o no el directorio.
	 */
	public static boolean crear_Directorios(String directorio_nuevo) {
		File ruta_acomprobar = new File(directorio_nuevo);
		creado = crear_Directorios(ruta_acomprobar);
		return creado;
	}

}
