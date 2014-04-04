package com.atrium.configuracion;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Contiene la logica de tratamiento del fichero de configuracion.<br/>
 * Este fichero es de formato properties. Nombre configuracion y esta en el
 * mismo paquete que la clase.<	br/>
 * Esta clase es el DAO de acceso a la fuente de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @serial 26-11-2012
 */
public class Configuracion_DAO {
	// OBJETO PARA EL PROCESO LECTURA/ESCRITURA DEL PROPERTIES
	private Properties datos_configuracion;
	// DTO PARA EL TRANSPORTE DE LOS DATOS LEIDOS
	private Configuracion_DTO confi_dto;

	/**
	 * Constructor en donde se instancian las propiedes de clase necesarias para
	 * el proceso a realizar.
	 */
	public Configuracion_DAO() {
		datos_configuracion = new Properties();
		confi_dto = new Configuracion_DTO();
	}

	/**
	 * Proceso donde leemos del fichero de configuracion y a continuacion se
	 * pasan los valores leidos a propiedades de clase que seran visibles
	 * mediante accesores.
	 * 
	 * @throws IOException
	 */
	public Configuracion_DTO cargar_Configuracion() {
		// CARGAMOS LOS DATOS DEL FICHERO
		try {
			datos_configuracion.load(this.getClass().getResourceAsStream(
					"/com/atrium/configuracion/configuracion.properties"));
			// PASAMOS LA INFORMACION A LAS PROPIEDADES DEL DTO
			confi_dto.setIdioma(datos_configuracion.getProperty("idioma"));
			confi_dto.setRuta_logsbirt(datos_configuracion
					.getProperty("ruta_log"));
			confi_dto.setRuta_ayuda(datos_configuracion
					.getProperty("ruta_ayuda"));
			confi_dto.setRuta_depuracion(datos_configuracion
					.getProperty("ruta_depuracion"));
			confi_dto.setRuta_seguridad(datos_configuracion
					.getProperty("ruta_seguridad"));
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR EN LA CARGA DEL FICHERO
			confi_dto = null;
		}
		return confi_dto;
	}

	/**
	 * Proceso de modificacion del fichero de configuracion.<br/>
	 * Se reescriben todas las propiedades de nuevo con los valores modificados
	 * por el usuario.
	 * 
	 * @return boolean Indica si el proceso de grabacion se ha realizado
	 *         correctamente o no.
	 */
	public boolean modificar_Configuracion(Configuracion_DTO confi_dto) {
		boolean correcto = true;
		FileWriter salida;
		try {
			// RUTA DEL FICHERO DONDE SE ECRIBE LA INFORMACION
			salida = new FileWriter(Configuracion_DAO.class.getResource(
					"/com/atrium/configuracion/configuracion.properties")
					.getFile());
			SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			// PASAMOS LOS DATOS DEL DTO AL PROPERTIES PARA SU ESCRITURA EN EL
			// FICHERO
			datos_configuracion.setProperty("idioma", confi_dto.getIdioma());
			datos_configuracion.setProperty("ruta_log",
					confi_dto.getRuta_logsbirt());
			datos_configuracion.setProperty("ruta_ayuda",
					confi_dto.getRuta_ayuda());
			datos_configuracion.setProperty("ruta_depuracion",
					confi_dto.getRuta_depuracion());
			datos_configuracion.setProperty("ruta_seguridad",
					confi_dto.getRuta_depuracion());
			// GRABAMOS LOS DATOS NUEVOS EN EL FICHERO
			datos_configuracion.store(salida,
					"MODIFICADO EL " + fecha.format(new Date()));
		} catch (IOException e) {
			// TRATAMIENTO DE ERROR EN LA ESCRITURA
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Creacion del fichero properties con una serie de opciones por defecto.
	 * 
	 * @return boolean Indica si el proceso de grabacion se ha realizado
	 *         correctamente o no.
	 */
	public boolean establecer_OpcionesDefecto() {
		boolean valido = true;
		// ESTABLECEMOS LAS OPCIONES POR DEFECTO
		confi_dto.setIdioma("es");
		confi_dto.setRuta_ayuda("/com/atrium/ayuda/ayuda_gestioncomercial.hs");
		confi_dto.setRuta_depuracion("d:/directorio_logs/seguimiento/j114/");
		confi_dto.setRuta_logsbirt("d:/otros_logs/logs-j114/");
		confi_dto.setRuta_seguridad("d:/directorio_logs/seguridad/j114/");
		valido = modificar_Configuracion(confi_dto);
		return valido;
	}

}
