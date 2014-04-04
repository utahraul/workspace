package com.atrium.configuracion.xml;

import com.atrium.configuracion.Configuracion_DTO;
import com.atrium.configuracion.IGestion_Configuracion;
import com.atrium.log4j.Traza_Log;
import com.atrium.util.Idioma;

public class Gestion_ConfiguracionXML implements IGestion_Configuracion {
	// OBJETO UNICO PARA LA GESTION DE LA CONFIGURACION (SINGLENTON) OPCION XML
	private ConfiguracionXML_DAO config_XMLDAO;
	// OBJETO DTO QUE OBTENEMOS DE LA CONSULTA DEL DAO OPCION XML
	private Configuracion_DTO configXML_DTO;
	private final String fichero_XML = "/com/atrium/configuracion/xml/configuracion_xsd.xml";

	/**
	 * Proceso de lectura de la fuente de datos.
	 */
	@Override
	public void leer_Configuracion() {
		String valores[] = { fichero_XML };
		Traza_Log.registro("aviso.carga.xml", valores);
		if (config_XMLDAO == null) {
			config_XMLDAO = new ConfiguracionXML_DAO(fichero_XML);
		}
		configXML_DTO = config_XMLDAO.getConfigXML_DTO();
	}

	/**
	 * Modificacion, de momento, solo del idioma en el fichero XML.
	 */
	@Override
	public void modificar_Configuracion(Configuracion_DTO confi_modificada) {
		// FALTA MODIFICAR EL METODO TOSTRING EN EL DTO PARA SU USO CORRECTO
		String valores[] = { fichero_XML, "" };
		Traza_Log.registro("aviso.modificacion.xml", valores);
		if (config_XMLDAO == null) {
			config_XMLDAO = new ConfiguracionXML_DAO(fichero_XML);
		}
		boolean correcto = config_XMLDAO.modificar_Configuracion(fichero_XML,
				confi_modificada.getIdioma());
		String valores2[] = { "idioma", confi_modificada.getIdioma() };
		if (correcto) {
			// MENSAJE DE REALIZACION CORRECTA
			// Mensajes.mostrar_VentanaMensaje("confirmacion.cambio.xml",
			// Mensajes.NIVEL_INFO, valores2);
		} else {
			// MENSAJE DE ERROR EN EL CAMBIO
			// Mensajes.mostrar_VentanaMensaje("error.cambio.xml",
			// Mensajes.NIVEL_ERROR, valores2);
		}
	}

	/**
	 * Creacion/restauracion de los valores por defecto en la configuracion.
	 */
	@Override
	public void recargar_Configuracion() {
		// PENDIENTE
	}

	/**
	 * Devuelve el fichero de idiomas segun la configuracion leida en el XML.
	 */
	@Override
	public String getRecurso_Idiomatico(Class objeto_atraducir) {
		String idioma = null;
		if (getConfiguracion() != null) {
			idioma = getConfiguracion().getIdioma();
		}
		return Idioma.fichero_Idioma(objeto_atraducir, idioma);
	}

	// ACCESOR PARA LA PROPIEDAD DE CLASE
	@Override
	public Configuracion_DTO getConfiguracion() {
		return configXML_DTO;
	}

}
