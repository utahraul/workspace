package com.atrium.log4j;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * Proceso general de tratamiento de mensajes dentro de al aplicacion.<br/>
 * Indicamos el nivel atravea de constantes de clase que pasamos como argumento
 * en el metodo. Se incluye una version con un solo argumento que por defecto
 * usa el nivel trace.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5
 * @since 5-11-2013
 * 
 */
public class Traza_Log {
	// REGISTRO DE LA PROPIA CLASE EN EL SISTEMA DE LOG.
	private static Logger log = Logger.getLogger(Traza_Log.class);

	// AÑADIDO OBJETO RESOURCE BUMDLE PARA LA OPCION DE MENSAJES DE TRAZA
	// PERSONALIZABLES
	private static ResourceBundle rb;

	// constantes que representan los niveles de mensaje para el servicio log4j
	public static final int LOG_TRACE = 0;
	public static final int LOG_DEBUG = 1;
	public static final int LOG_INFO = 2;
	public static final int LOG_WARNING = 3;
	public static final int LOG_ERROR = 4;
	public static final int LOG_FATAL = 5;

	/**
	 * Sobrecarga de metodo para no tener que poner el nivel trace puesto que
	 * sera el nivel adjudicado por defecto.
	 * 
	 * @param mensaje
	 *            Texto a registrar.
	 */
	public static void registro(String mensaje) {
		registro(mensaje, LOG_TRACE);
	}

	/**
	 * Proceso que sobrecarga el metodo añadiendo la posibilidad de uso de
	 * externalizacion de cadenas y uso de variables en tiempo de ejecucion.
	 * 
	 * @param mensaje
	 *            Clave del properties.
	 * @param nivel
	 *            Nivel con el que se va a mostrar el mensaje.
	 * @param valores
	 *            Valores para las variables en los mensajes.
	 */
	public static void registro(String mensaje, int nivel, String valores[]) {
		if (rb == null) {
			rb = ResourceBundle.getBundle("com.atrium.log4j.textos_trazas");
		}
		String mensa = rb.getString(mensaje);
		mensa = MessageFormat.format(mensa, (Object[]) valores);
		registro(mensa, nivel);
	}

	/**
	 * Sobrecarga del metodo {@link #registro(String, int, String[])} para
	 * notener que indicar el nivel siempre.<BR/>
	 * Por defecto se usa el nivel trace.
	 * 
	 * @param mensaje
	 *            Clave del properties.
	 * @param valores
	 *            Valores para las variables en los mensajes.
	 */
	public static void registro(String mensaje, String valores[]) {
		if (rb == null) {
			rb = ResourceBundle.getBundle("com.atrium.log4j.textos_trazas");
		}
		String mensa = rb.getString(mensaje);
		mensa = MessageFormat.format(mensa, (Object[]) valores);
		registro(mensa, LOG_TRACE);
	}

	/**
	 * Proceso de escritura mediante el sistema de log4j.<br/>
	 * Ademas segun el nivel se formatea el texto de la siguiente manera:
	 * <ul>
	 * <li>
	 * Para trace las palabras capitalizadas.</li>
	 * <li>
	 * Para debug las palabras todo minusculas.</li>
	 * <li>
	 * Para info las palabras todo mayusculas.</li>
	 * <li>
	 * Para warn, error y fatal las palabras fraseadas.</li>
	 * </ul>
	 * 
	 * @param mensaje
	 *            Texto del mensaje a tratar.
	 * @param nivel
	 *            Prioridad dentro del sistema de log4j.
	 */
	public static void registro(String mensaje, int nivel) {
		if (nivel == LOG_TRACE) {
			if (log.isTraceEnabled()) {
				mensaje = capitalizar_texto(mensaje);
				log.trace(mensaje);
			}
		}
		if (nivel == LOG_DEBUG) {
			if (log.isDebugEnabled()) {
				mensaje = mensaje.toLowerCase().trim();
				log.debug(mensaje);
			}
		}

		if (nivel == LOG_INFO) {
			if (log.isInfoEnabled()) {
				mensaje = mensaje.toUpperCase().trim();
				log.info(mensaje);
			}
		}
		if (nivel == LOG_WARNING) {
			mensaje = fraseado_Texto(mensaje);
			log.warn(mensaje);
		}
		if (nivel == LOG_ERROR) {
			if (Priority.ERROR_INT == nivel) {
				log.error(mensaje);
			}
		}
		if (nivel == LOG_FATAL) {
			if (Priority.FATAL_INT == nivel) {
				log.fatal(mensaje);
			}
		}
	}

	/**
	 * Proceso interno en donde capitalizamos el texto recibido.
	 * 
	 * @param texto_recibido
	 *            Texto a capitalizar
	 * @return Testo capitalizado
	 */
	private static String capitalizar_texto(String texto_recibido) {
		if (texto_recibido == null) {
			return "";
		}
		StringBuffer texto_atratar = new StringBuffer(texto_recibido.trim()
				.toLowerCase());
		if (texto_atratar.length() == 0) {
			return texto_atratar.toString();
		}
		Character siguiente_caracter;
		int i = 0;
		siguiente_caracter = texto_atratar.charAt(i);
		while (i < texto_atratar.length()) {
			texto_atratar.setCharAt(i++,
					Character.toUpperCase(siguiente_caracter.charValue()));
			if (i == texto_atratar.length()) {
				return texto_atratar.toString();
			}
			// Miramos los espacios en blanco
			siguiente_caracter = texto_atratar.charAt(i);
			while (i < texto_atratar.length() - 2
					&& !Character.isWhitespace(siguiente_caracter.charValue())) {
				siguiente_caracter = texto_atratar.charAt(++i);
			}
			if (!Character.isWhitespace(siguiente_caracter.charValue())) {
				// si no hay espacio en blanco es el final del texto
				return texto_atratar.toString();
			}
			// quitamos todos los espacios en blanco
			siguiente_caracter = texto_atratar.charAt(++i);
			while (i < texto_atratar.length()
					&& Character.isWhitespace(siguiente_caracter.charValue())) {
				texto_atratar.deleteCharAt(i);
				siguiente_caracter = texto_atratar.charAt(i);
			}
		}
		return texto_atratar.toString();
	}

	/**
	 * Damos el formato de parrafo al texto recibido.
	 * 
	 * @param texto
	 *            Texto a formatear.
	 * @return Texto ya formateado.
	 */
	private static String fraseado_Texto(String texto) {
		// int posicion = texto.indexOf("\n");
		// int posicion_inicio = 0;
		// while (posicion != -1) {
		// texto = texto.substring(posicion_inicio, posicion)
		// + texto.substring(posicion + 1).toUpperCase()
		// + texto.substring(posicion + 2);
		// posicion_inicio = posicion + 2;
		// posicion = texto.indexOf("\n", posicion);
		// }
		// texto = texto.substring(posicion + 1).toUpperCase();

		StringBuilder frasemayuscula = new StringBuilder();
		texto = texto.toLowerCase();
		String[] parrafos = texto.split("\\n");
		for (int i = 0, l = parrafos.length; i < l; ++i) {
			if (i > 0) {
				frasemayuscula.append(" ");
			}
			frasemayuscula.append(Character.toUpperCase(parrafos[i].charAt(0)))
					.append(parrafos[i].substring(1));
		}
		return texto;
	}
}
