package com.atrium.configuracion.xml;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.atrium.configuracion.Configuracion_DTO;

/**
 * Proceso de lectura y escritura en el fichero xml (la fuente de datos) para su
 * posterior uso el programa.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.8
 * @since 3-12-2012
 */
public class ConfiguracionXML_DAO {
	// PROPIEDADES DE TRABAJO DE LECTURA DEL XML
	private XMLReader lector_XML;
	private Escuchador_Configuracion esc_confiXML;

	// ALMACENAMIENTO EN MEMORIA DE LOS DATOS LEIDOS EN EL XML DOS OPCIONES
	// DISTINTAS PARA USAR UNA
	// OPCION PROPERTIES
	private Properties datos_configuracion;
	// OPCION COLECCION
	private Map<String, Map<String, String>> mapa_configuracion;
	// OBJETO PARA EXPONER LOS DATOS LEIDOS DEL FICHERO XML DE CONFIGURACION
	private Configuracion_DTO configXML_DTO;

	/**
	 * Creacion del objeto si realizar ninguna accion.
	 */
	public ConfiguracionXML_DAO() {
	}

	/**
	 * Creamos el objeto disparando el proceso de lectura.
	 * 
	 * @param ficheroXML
	 *            Cadena de texto con ruta y el nombre del XML.
	 */
	public ConfiguracionXML_DAO(String ficheroXML) {
		leer_XML(ficheroXML);
	}

	/**
	 * Proceso de lectura mediante SAX.<br/>
	 * Se usan dos estruturas distintas de datos para recoger la informacion del
	 * XML. Tan solo es necesaria una, estan ambas para efectos educativos.
	 * 
	 * @param ficheroXML
	 *            Cadena de texto con ruta y el nombre del XML.
	 */
	public void leer_XML(String ficheroXML) {
		boolean valido = true;
		// CREAMOS EL OBJETO URL QUE APUNTA AL FICHERO XML A TRATAR
		URL obj_fichero = this.getClass().getResource(ficheroXML);
		// INSTANCIAMOS LAS ESTRUCTURAS DE DATOS A USAR (SOLO UNA EN LA VERSION
		// FINAL)
		datos_configuracion = new Properties();
		mapa_configuracion = new HashMap<String, Map<String, String>>();

		try {
			// CREO EL FLUJO DE LECTURA
			lector_XML = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			// ERROR EN LA CREACION DEL XMLREADER
		}
		// CREO EL ESCUCHADOR DEL LOS EVENTOS DE LECTURA
		esc_confiXML = new Escuchador_Configuracion();
		// PASAMOS EL OBJETO A EL ESCUCHADOR PARA QUE ESCRIBA LA INFORMACION AL
		// LEER EL FICHERO XML
		esc_confiXML.setDatos_configuracion(datos_configuracion);
		esc_confiXML.setMapa_configuracion(mapa_configuracion);

		// ASOCIO EL EMISOR CON EL RECEPTOR
		lector_XML.setContentHandler(esc_confiXML);
		try {
			// LEO EL CONTENIDO DEL FICHERO
			lector_XML.parse(obj_fichero.getFile());
		} catch (IOException e) {
			// ERROR EN EL ACCESO AL FICHERO
			valido = false;
			String fichero[] = { obj_fichero.getFile() };
			// Mensajes.mostrar_VentanaMensaje("error.carga.configuracionXML",
			// Mensajes.NIVEL_ERROR, fichero);
		} catch (SAXException evento_sax) {
			// ERROR EN EL TRATAMIENTO DEL FICHERO
			valido = false;
			String fichero[] = { obj_fichero.getFile(),
					evento_sax.getCause().getMessage(), evento_sax.getMessage() };
			// Mensajes.mostrar_VentanaMensaje("error.lectura.configuracionXML",
			// Mensajes.NIVEL_ERROR, fichero);
		}
		// LLAMAMOS AL METODO QUE CARGA LOS DATOS EN EL DTO
		if (valido) {
			this.cargar_DTO();
		}
	}

	/**
	 * Proceso de pasar la informacion leida de la estructura de datos al objeto
	 * DTO para su exposion en el programa.
	 */
	private void cargar_DTO() {
		// CREAMOS EL OBJETO
		configXML_DTO = new Configuracion_DTO();
		// CARGAMOS LOS DATOS EN LAS PROPIEDADES DEL DTO
		configXML_DTO.setVersion(new Float(datos_configuracion
				.getProperty("version")));
		configXML_DTO.setAutor(datos_configuracion.getProperty("autor"));
		try {
			configXML_DTO.setFecha_actualizacion(DateFormat.getDateInstance()
					.parse(datos_configuracion.getProperty(
							"fecha_actualizacion").replace("/", "-")));
		} catch (ParseException e) {
		}
		configXML_DTO.setIdioma(datos_configuracion.getProperty("preferido"));
		configXML_DTO.setModo_ejecucion(datos_configuracion
				.getProperty("modo_ejecucion"));
		configXML_DTO.setPermitir_idioma(datos_configuracion
				.getProperty("permitir_idioma"));
		configXML_DTO.setRuta_ayuda(datos_configuracion
				.getProperty("ruta_ayuda"));
		configXML_DTO.setRuta_bitacora(datos_configuracion
				.getProperty("ruta_bitacora"));
		configXML_DTO.setRuta_depuracion(datos_configuracion
				.getProperty("ruta_depuracion"));
		configXML_DTO.setRuta_enginebirt(datos_configuracion
				.getProperty("ruta_enginebirt"));
		configXML_DTO.setRuta_listados(datos_configuracion
				.getProperty("ruta_listados"));
		configXML_DTO.setRuta_logsbirt(datos_configuracion
				.getProperty("ruta_logsbirt"));
		configXML_DTO.setRuta_seguridad(datos_configuracion
				.getProperty("ruta_seguridad"));
		configXML_DTO.setRuta_serializacion(datos_configuracion
				.getProperty("ruta_serializacion"));
		configXML_DTO.setRuta_seguridad(datos_configuracion
				.getProperty("ruta_seguridad"));
		configXML_DTO.setRuta_iconos(datos_configuracion
				.getProperty("ruta_iconos"));
	}

	/**
	 * Proceso de escritura del fichero de configuracion XML con las propiedades
	 * modificadas por parte del usuario. Se divide en tres partes:
	 * <ul>
	 * <li>
	 * 1º Se lee todo el contenido del fichero para crear una estructura DOM
	 * para su modificacion.</li>
	 * <li>
	 * 2º Modificamos el elemento (solo implementado idiomas).</li>
	 * <li>3º Escribimos todo el contenido del documento DOM en el fichero.</li>
	 * </ul>
	 */
	public boolean modificar_Configuracion(String ficheroXML,
			String idioma_nuevo) {
		boolean correcto = true;
		try {
			// LEEMOS EL XML Y SE CREA LA ESTRUCTURA DOM
			DocumentBuilderFactory fact_dom = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder lector = fact_dom.newDocumentBuilder();
			// OBTENEMOS EL OBJETO QUE TIENE SU CONTENIDO PARA MODIFICARLO
			Document documento_DOM = lector.parse(this.getClass()
					.getResource(ficheroXML).getFile());
			// COGEMOS LA ETIQUETA QUE CONTIENE EL ATRIBUTO A CAMBIAR
			Node elemento_xml = documento_DOM.getElementsByTagName("idioma")
					.item(0);
			// CREAMOS UN NUEVO ATRIBUTO CON EL VALOR NUEVO DEL IDIOMA ELEGIDO
			Attr atributo_nuevo = documento_DOM.createAttribute("preferido");
			atributo_nuevo.setNodeValue(idioma_nuevo);
			// PONEMOS EL ATRIBUTO NUEVO
			elemento_xml.getAttributes().setNamedItem(atributo_nuevo);
			// ESCRIBIMOS EL DOCUMENTO MODIFICADO
			TransformerFactory fact = TransformerFactory.newInstance();
			Transformer flujo_escritura = fact.newTransformer();
			// QUE CONTENIDO VAMOS A ESCRIBIR
			DOMSource entrada_datos = new DOMSource(documento_DOM);
			// DONDE LO VAMOS A ESCRIBIR
			StreamResult apuntador = new StreamResult(this.getClass()
					.getResource(ficheroXML).getFile());
			// ESCRIBIMOS
			flujo_escritura.transform(entrada_datos, apuntador);
		} catch (Exception e) {
			correcto = false;
		}
		return correcto;
	}

	// ACCESORES PARA LAS PROPIEDADES
	public Configuracion_DTO getConfigXML_DTO() {
		return configXML_DTO;
	}
}
