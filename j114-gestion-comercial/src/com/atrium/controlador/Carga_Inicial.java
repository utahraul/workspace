package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.log4j.PropertyConfigurator;

import com.atrium.configuracion.Configuracion_DTO;
import com.atrium.configuracion.Gestion_Configuracion;
import com.atrium.configuracion.IGestion_Configuracion;
import com.atrium.configuracion.xml.Gestion_ConfiguracionXML;
import com.atrium.log4j.Traza_Log;
import com.atrium.util.Crear_Ruta;

/**
 * Procesos de inicio de la aplicion.<br/>
 * Permite distintas secuencias de arranque y creacion del controlador
 * principal.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.2
 * @since 17-1-2013
 * 
 */
public class Carga_Inicial implements ICarga_Inicial {

	private static IGestion_Configuracion gestion_configuracion;

	/**
	 * Proceso de arranque por defecto. Tiene todas las opciones.
	 */
	@Override
	public void opciones_Defecto() {
		this.cargar_Configuracion(Carga_Inicial.FICHERO_PROPERTIES);
		this.cargar_SistemaLOG(FICHERO_PROPERTIES);
		Traza_Log.registro("Cargamos las opciones por defecto");
		this.establecer_Nimbus();
		cargamos_Ventana();
	}

	/**
	 * Proceso de creacion del controlador de la aplicacion.
	 */
	private void cargamos_Ventana() {
		Traza_Log.registro("se crea el controlador principal");
		Ventana ventana = new Ventana();
	}

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
	@Override
	public void cargar_Configuracion(int tipo_ficheroconfiguracion) {
		switch (tipo_ficheroconfiguracion) {
		case FICHERO_PROPERTIES:
			gestion_configuracion = new Gestion_Configuracion();
			gestion_configuracion.leer_Configuracion();
			break;
		case FICHERO_XML:
			gestion_configuracion = new Gestion_ConfiguracionXML();
			gestion_configuracion.leer_Configuracion();
			break;
		}
	}

	/**
	 * Se establece las variables de entorno necesarias, junto con el arranque
	 * del sistema de log para la aplicacion.
	 */
	public void cargar_SistemaLOG(int tipo_ficheroconfiguracion) {
		Configuracion_DTO config_DTO = Gestion_Configuracion.getConfig_DTO();
		// SE CREAN LAS VARIABLES DE ENTORNO NECESARIAS PARA LA CONFIGURACION DE
		// LAS OPCIONES DEL LOG4J
		System.setProperty("ruta_depuracion", config_DTO.getRuta_depuracion());
		System.setProperty("ruta_seguridad", config_DTO.getRuta_seguridad());
		// COMPROBAMOS SI EXISTE LA RUTA
		boolean existe = Crear_Ruta.crear_Directorios(config_DTO
				.getRuta_depuracion());
		existe = Crear_Ruta.crear_Directorios(config_DTO.getRuta_seguridad());
		// EN CASO DE EXISTIR SE CARGA LA CONFIGURACION DEL LOG4J
		if (existe) {
			// LEEMOS DE NUEVO EL FICHERO DE CONFIGURACION DEL LOG4J(LOG4J API)
			PropertyConfigurator.configure(this.getClass().getResource(
					"/com/atrium/log4j/log4j.properties"));
		} else {
			// GESTION DE ERROR NO IMPLEMENTADA
		}
	}

	@Override
	public void opciones_XML() {
		// TODO Auto-generated method stub

	}

	/**
	 * Proceso de carga del lookandfeel nimbus para la interface grafica.
	 */
	@Override
	public void establecer_Nimbus() {
		Traza_Log.registro("Esgtablecemos nimbus como apariencia por defecto");
		// cargar el nuevo look and feel si se puede
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				try {
					// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
					// USADA
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
					System.out.println("Cargando nimbus......");
				} catch (Exception ex) {
					System.out.println("error en la carga de nimbus");
				}
			}
		}
	}

	/**
	 * Acceso al objeto gestion de configuracion.
	 * 
	 * @return Objeto configuracion.
	 */
	public static IGestion_Configuracion getGestion_configuracion() {
		return gestion_configuracion;
	}

	/**
	 * Metodo de conveniencia para la llamada directa al valor idiomatico.
	 * 
	 * @param objeto_class
	 *            Parametro requerido por el metodo llamado.
	 * @return Cadena de texto que representa el recurso idiomatico (properties)
	 *         a usar.
	 */
	public static String getRecurso_Idiomatico(Class objeto_class) {
		return gestion_configuracion.getRecurso_Idiomatico(objeto_class);
	}

}
