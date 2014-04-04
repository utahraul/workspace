package com.atrium.configuracion.xml;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.atrium.log4j.Traza_Log;

/**
 * Tratamiento de fichero XML. Por cada item de informacion(etiqueta) se pasa a
 * la estrutura de informacion correspondiente del la clase. Esta montado el
 * ejemplo con un propierties y con un mapa. Ambas estructuras realizan la misma
 * labor.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 29-11-2012
 */
public class Escuchador_Configuracion extends DefaultHandler {

	// ******************* PROPIEDADES DE CLASE **********************
	// PROPIEDADES PARA EL PROCESO DEL FICHERO XML
	private String etiqueta_anterior = "";
	// ALMACENAMIENTO EN MEMORIA DE LOS DATOS LEIDOS EN EL XML PASADO DEL OBJETO
	// LECTOR
	private Properties datos_configuracion;
	private Map<String, Map<String, String>> mapa_configuracion;
	private Map<String, String> valores;
	// ACUMULADORES DE LA INFORMACION TRATADA
	private int num_rutas = 0;
	private int num_propiedades = 0;
	private int num_permisos = 0;
	private int num_opciones = 0;

	/**
	 * Proceso inicial que nos sirve para conocerlo en la traza de depuracion.
	 */
	@Override
	public void startDocument() throws SAXException {
		Traza_Log.registro("***** INICIAMOS EL PROCESO DEL FICHERO XML");
	}

	/**
	 * Proceso final que nos sirve para mostrar el total de informacion
	 * procesada en la traza de depuracion.
	 */
	@Override
	public void endDocument() throws SAXException {
		Traza_Log.registro("***** SE HAN PROCESADO "
				+ String.valueOf(num_rutas) + " RUTAS "
				+ String.valueOf(num_propiedades) + " PROPIEDADES "
				+ String.valueOf(num_permisos) + " PERMISOS ");
	}

	/**
	 * Proceso de las etiquetas de apertura del fichero XML.<br/>
	 * Cada una de estas es tratada en un IF distinto para poder distinguir unas
	 * etiquetas de otras.<br/>
	 * Las que poseen atributos son tratadas aqui y las que la informacion esta
	 * el cuerpo en el metodo characters.
	 * 
	 * @param localizador_externo
	 *            Nombre de la etiqueta acompañado de la referencia externa.
	 * @param localizador_interno
	 *            Nombre de la etiqueta acompañdo de la referencia interna.
	 * @param nombre_etiqueta
	 *            Nombre de la etiqueta.
	 * @param atributos
	 *            Mapa de los atributos de la etiqueta si es que los tiene.
	 * @throws SAXException
	 *             Excepcion arrojada en caso de error.
	 */
	@Override
	public void startElement(String localizador_externo,
			String localizador_interno, String nombre_etiqueta,
			Attributes atributos) throws SAXException {
		// ETIQUETAS CON CUERPO. SE TRATA EL CONTENIDO EN CHARACTERS
		if (nombre_etiqueta.equals("propiedades")) {
			Traza_Log.registro("- Iniciamos propiedades"); //$NON-NLS-1$
		}
		if (nombre_etiqueta.equals("fecha_actualizacion")) {
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("autor")) {
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_bitacora")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_ayuda")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_enginebirt")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_logsbirt")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_listados")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_serializacion")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_depuracion")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_seguridad")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		if (nombre_etiqueta.equals("ruta_iconos")) {
			num_propiedades++;
			num_rutas++;
			etiqueta_anterior = nombre_etiqueta;
		}
		// ETIQUETAS CON ATRIBUTOS. SE TRATA AQUI EL VALOR DE LOS ATRIBUTOS
		if (nombre_etiqueta.equals("opciones_configuracion")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("version", atributos.getValue("version"));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("version", atributos.getValue("version"));
			mapa_configuracion.put("opciones_configuracion", valores);
		}
		if (nombre_etiqueta.equals("idioma")) {
			num_propiedades++;
			num_opciones++;
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("preferido",
					atributos.getValue("preferido"));
			datos_configuracion.put("defecto", atributos.getValue("defecto"));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("preferido", atributos.getValue("preferido"));
			valores.put("defecto", atributos.getValue("defecto"));
			mapa_configuracion.put("idioma", valores);
		}
		if (nombre_etiqueta.equals("permitir_idioma")) {
			num_propiedades++;
			num_permisos++;
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("permitir_idioma",
					atributos.getValue("permiso"));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("permitir_idioma", atributos.getValue("permiso"));
			mapa_configuracion.put("permitir_idioma", valores);
		}
		if (nombre_etiqueta.equals("modo_ejecucion")) {
			num_propiedades++;
			num_permisos++;
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("modo_ejecucion",
					atributos.getValue("modalidad"));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("modalidad", atributos.getValue("modalidad"));
			mapa_configuracion.put("modo_ejecucion", valores);
		}
		// ETIQUETAS SIN VALOR A TRATAR.(NI CUERPO DE TEXTO NI ATRIBUTOS)
		if (nombre_etiqueta.equals("rutas")) {
			Traza_Log.registro("- Iniciamos Rutas"); //$NON-NLS-1$
		}
		if (nombre_etiqueta.equals("opciones_usuario")) {
			Traza_Log.registro("- Iniciamos Opciones Usuario"); //$NON-NLS-1$
		}
		if (nombre_etiqueta.equals("permisos")) {
			Traza_Log.registro("- Iniciamos permisos"); //$NON-NLS-1$
		}
	}

	/**
	 * Proceso del cuerpo de texto la etiqueta, cuando esta la tenga.<br/>
	 * Para ello recordamos en una variable de clase la etiqueta anterior leida.
	 * 
	 * @param contenido_XML
	 *            Tabla de char contodo el contenido del fichero.
	 * @param inicio_cadena
	 *            Posicion inicial dentro de la tabla del cuerpo de la etiqueta.
	 * @param fin_cadena
	 *            Posicion final dentro de la tabla del cuerpo de la etiqueta.
	 */
	@Override
	public void characters(char[] contenido_XML, int inicio_cadena,
			int fin_cadena) throws SAXException {
		if (etiqueta_anterior.equals("fecha_actualizacion")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("fecha_actualizacion", new String(
					contenido_XML, inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("fecha_actualizacion", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("fecha_actualizacion", valores);
		}
		if (etiqueta_anterior.equals("autor")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("autor", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("autor", new String(contenido_XML, inicio_cadena,
					fin_cadena));
			mapa_configuracion.put("autor", valores);
		}
		if (etiqueta_anterior.equals("ruta_bitacora")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_bitacora", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_bitacora", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_bitacora", valores);
		}
		if (etiqueta_anterior.equals("ruta_ayuda")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_ayuda", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_ayuda", new String(contenido_XML, inicio_cadena,
					fin_cadena));
			mapa_configuracion.put("ruta_ayuda", valores);
		}
		if (etiqueta_anterior.equals("ruta_enginebirt")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_enginebirt", new String(
					contenido_XML, inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_enginebirt", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_enginebirt", valores);
		}
		if (etiqueta_anterior.equals("ruta_logsbirt")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_logsbirt", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_logsbirt", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_logsbirt", valores);
		}
		if (etiqueta_anterior.equals("ruta_listados")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_listados", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_listados", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_listados", valores);
		}
		if (etiqueta_anterior.equals("ruta_serializacion")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_serializacion", new String(
					contenido_XML, inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_serializacion", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_serializacion", valores);
		}
		if (etiqueta_anterior.equals("ruta_depuracion")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_depuracion", new String(
					contenido_XML, inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_depuracion", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_depuracion", valores);
		}
		if (etiqueta_anterior.equals("ruta_seguridad")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_seguridad", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_seguridad", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			mapa_configuracion.put("ruta_seguridad", valores);
		}
		if (etiqueta_anterior.equals("ruta_iconos")) {
			// TRATAMIENTO PROPERTIES
			datos_configuracion.put("ruta_iconos", new String(contenido_XML,
					inicio_cadena, fin_cadena));
			// TRATAMIENTO DE MAPA
			valores = new HashMap<String, String>();
			valores.put("ruta_iconos", new String(contenido_XML, inicio_cadena,
					fin_cadena));
			mapa_configuracion.put("ruta_iconos", valores);
		}
		etiqueta_anterior = "";
	}

	/**
	 * Proceso de las etiquetas de cierre.<br/>
	 * En este caso solo mostramos alguna informacion para la traza del proceso
	 * en el cierre de las etiuqetas que me interese.
	 * 
	 * @param localizador_externo
	 *            Nombre de la etiqueta acompañado de la referencia externa.
	 * @param localizador_interno
	 *            Nombre de la etiqueta acompañdo de la referencia interna.
	 * @param nombre_etiqueta
	 *            Nombre de la etiqueta.
	 * @throws SAXException
	 *             Excpecion arrojada en caso de error.
	 */

	@Override
	public void endElement(String localizador_externo,
			String localizador_interno, String nombre_etiqueta)
			throws SAXException {
		if (nombre_etiqueta.equals("permisos")) {
			Traza_Log.registro("LOS PERMISOS PROCESADOS SON -->>>>"
					+ num_permisos);
		}
		if (nombre_etiqueta.equals("rutas")) {
			Traza_Log.registro("LAS RUTAS PROCESADAS SON -->>>>" + num_rutas);
		}
		if (nombre_etiqueta.equals("opciones_usuario")) {
			Traza_Log.registro("LAS OPCIONES DE USUARIO PROCESADAS SON -->>>>"
					+ num_propiedades);
		}
	}

	// ACCESORES PARA RECIBIR EL OBJETO QUE ALMACENA LA INFORMACION LEIDA DEL
	// XML
	public void setDatos_configuracion(Properties datosConfiguracion) {
		datos_configuracion = datosConfiguracion;
	}

	public void setMapa_configuracion(
			Map<String, Map<String, String>> mapaConfiguracion) {
		mapa_configuracion = mapaConfiguracion;
	}
}
