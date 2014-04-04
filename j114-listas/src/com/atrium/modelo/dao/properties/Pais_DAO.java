package com.atrium.modelo.dao.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.jws.Oneway;

import com.atrium.modelo.Pais;

/**
 * Dao de la entidad Pais.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0
 * @since 13-3-2014
 * 
 */
public class Pais_DAO {

	private Properties lector;

	public Pais_DAO() {
		lector = new Properties();
	}

	/**
	 * Proceso de acceso a la fuente de datos.</br> Simulacion, datos no reales.
	 * 
	 * @return Coleccion con los objetos persistentes obtenidos en la consulta.
	 */
	public List<Pais> consultar_Todos() {
		// CREACION DE LA COLECCION
		List<Pais> lista = new ArrayList<>();
		try {
			// LEEMOS DEL PROPERTIES
			lector.load(this.getClass().getResourceAsStream(
					"/com/atrium/modelo/dao/pais.properties"));
			// EXTRAEMOS LA COLECCION DE CLAVES DEL MAPA
			Set<Object> lista_claves = lector.keySet();
			// RECORREMOS LA COLECCION DE CLAVES PARA ACCEDERA A LOS DATOS DEL
			// MAPA
			for (Object clave : lista_claves) {
				// CON LA INFORMACION DEL MAPA CREAMOS UN OBJETO PAIS NUEVO Y LO
				// PASAMOS A LA COLECCION DE SALIDA
				String pais_texto = lector.getProperty((String) clave);
				String partes[] = pais_texto.split(",");
				Pais pais_nuevo = new Pais();
				pais_nuevo.setPaisnombre(partes[0]);
				pais_nuevo.setCodigopais(new Integer(partes[1]));
				lista.add(pais_nuevo);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DEVOLVEMOS LA INFORMACION OBTENIDA
		return lista;
	}

}
