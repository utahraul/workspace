package com.atrium.configuracion;

import com.atrium.log4j.Traza_Log;
import com.atrium.util.Idioma;

/**
 * Fachada del proceso de gestion de carga configuracion y datos de la misma.<br/>
 * Se divide en dos partes (objetos) distintos:
 * <ul>
 * <li>
 * Configuracion. Lee y escribe los datos del properties</li>
 * <li>
 * Idioma. Calcula el fichero properties que corresponde en cada momento a cada
 * una de las clases de vista.</li>
 * </ul>
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0
 * @since 26-11-2012
 */
public class Gestion_Configuracion implements IGestion_Configuracion {

	// OBJETO UNICO PARA LA GESTION DE LA CONFIGURACION (SINGLENTON) OPCION
	// PROPERTIES
	private static Configuracion_DAO config_DAO;
	// OBJETO DTO QUE OBTENEMOS DE LA CONSULTA DEL DAO OPCION PROPERTIES
	private static Configuracion_DTO config_DTO;

	public Gestion_Configuracion() {

	}

	/**
	 * Proceso interno de la clase que carga la configuracion del fichero
	 * properties.
	 */
	public void leer_Configuracion() {
		if (config_DAO == null) {
			config_DAO = new Configuracion_DAO();
		}
		config_DTO = config_DAO.cargar_Configuracion();
		if (config_DTO == null) {
			// FALTA EL TRATAMIENTO EN CASO DE ERROR EN LA LECTURA
			Traza_Log
					.registro("ERROR EN LA CREACION DEL DTO DE CONFIGURACION en properties");
		}
	}

	/**
	 * Proceso de modificacion de los valores de la configuracion del programa.
	 * 
	 * @param confi_modificada
	 *            DTO con la nueva informacion a guardar.
	 */
	public void modificar_Configuracion(Configuracion_DTO confi_modificada) {
		if (config_DAO == null) {
			config_DAO = new Configuracion_DAO();
		}
		// RECIBIMOS LA CONFIRMACION/NEGACION DE LA REALIZACION DE LA ACCION POR
		// EL DAO
		boolean correcto = config_DAO.modificar_Configuracion(confi_modificada);
		// ESTABLECEMOS LAS PAUTAS DE ACCION TANTO PARA SI SE HACE BIEN COMO SI
		// SE HACE MAL EL PROCESO
		if (correcto) {
			// FALTA ACCION EN CASO DE CORRECTO
		} else {
			// FALTA ACCION EN CASO DE ERROR
			Traza_Log
					.registro("Error en la modificacion de las opciones de configuracion en properties");
		}
	}

	/**
	 * Recarga de las opciones por defecto en el fichero de configuracion en
	 * caso de que sea necesario.
	 */
	public void recargar_Configuracion() {
		if (config_DAO == null) {
			config_DAO = new Configuracion_DAO();
		}
		// RECIBIMOS LA CONFIRMACION/NEGACION DE LA REALIZACION DE LA ACCION POR
		// EL DAO
		boolean correcto = config_DAO.establecer_OpcionesDefecto();
		// ESTABLECEMOS LAS PAUTAS DE ACCION TANTO PARA SI SE HACE BIEN COMO SI
		// SE HACE MAL EL PROCESO
		if (correcto) {
			// FALTA ACCION EN CASO DE CORRECTO
		} else {
			// FALTA ACCION EN CASO DE ERROR
			Traza_Log
			.registro("Error en la creacion de valores por defecto de las opciones de configuracion en properties");
		}
	}

	/**
	 * Proceso mediante el cual calculamos el fichero properties correspondiente
	 * a cada clase y cada idioma en funcion de las preferecias establecidas.
	 * 
	 * @param objeto_atraducir
	 *            Class de la interface grafica u objeto a traducir.
	 * @return Cadena con la ruta y el nombre del properties.
	 */
	public String getRecurso_Idiomatico(Class objeto_atraducir) {
		String idioma = null;
		if (getConfig_DTO() != null) {
			idioma = getConfig_DTO().getIdioma();
		}
		return Idioma.fichero_Idioma(objeto_atraducir, idioma);
	}

	/**
	 * Proceso de conveniencia para agrupar la llamada a metodos.
	 * 
	 * @return {@link Configuracion_DTO}.
	 */
	public Configuracion_DTO obtener_NuevaConfiguracion() {
		leer_Configuracion();
		return getConfig_DTO();
	}

	// ACCESORES DEL DTO
	public static Configuracion_DTO getConfig_DTO() {
		return config_DTO;
	}

	@Override
	public Configuracion_DTO getConfiguracion() {
		return config_DTO;
	}

}
