package com.atrium.util;

/**
 * Logica de creacion en tiempo de ejecucion de la ruta y nombre de los ficheros
 * de idiomas de la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 1.6
 * @since 15-11-2012
 * 
 */
public class Idioma {

	/**
	 * Nombre que tendran todos los ficheros de textos de idiomas.
	 */
	private final static String nombre_fichero = "textos_";
	/**
	 * Idioma base que utilizaremos en la logica de creacion de la ruta.
	 */
	private static String idioma_base = "es";

	/**
	 * Proceso de creacion de rutas para los ficheros de idiomas en la
	 * aplicacion. <br/>
	 * La logica a seguir es:
	 * <ul>
	 * <li>Se da el class de la clase para la cual se quiere obtener el fichero.
	 * </li>
	 * <li>Se da el codigo iso del idioma a utilizar.</li>
	 * <li>Con esa informacion se genera la ruta interna montado la cadena de
	 * caracteres para que se usuada por un ResourceBundle.</li>
	 * </ul>
	 * 
	 * @param objeto
	 *            Class para que se quiere obtener los textos idiomatizados.
	 * @param idioma
	 *            Codigo ISO del idioma a usar.
	 * @return Ruta del fichero.
	 */
	public static String fichero_Idioma(Class objeto, String idioma) {
		if (idioma.equals(idioma_base)) {
			idioma = "";
		} else {
			idioma = "_" + idioma;
		}
		String paquete = objeto.getPackage().getName();
		String clase = objeto.getSimpleName();
		String ruta_nombre = paquete.replace('.', '/') + "/" + nombre_fichero
				+ clase.toLowerCase() + idioma;
		return ruta_nombre;
	}

}
