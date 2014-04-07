package com.atrium.modelo.dao.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.atrium.modelo.Municipios;
import com.atrium.modelo.Provincias;

public class Municipios_DAO {

	private Properties lector;

	public Municipios_DAO() {
		lector = new Properties();
	}

	public List<Municipios> consultar_PorProvincia(Integer codigoprovincia) {
		List<Municipios> lista = new ArrayList<>();
		try {
			// LEEMOS DEL PROPERTIES
			lector.load(this.getClass().getResourceAsStream(
					"/com/atrium/modelo/dao/municipios.properties"));
			// EXTRAEMOS LA COLECCION DE CLAVES DEL MAPA
			Set<Object> lista_claves = lector.keySet();
			// RECORREMOS LA COLECCION DE CLAVES PARA ACCEDERA A LOS DATOS DEL
			// MAPA
			for (Object clave : lista_claves) {
				// CON LA INFORMACION DEL MAPA CREAMOS UN OBJETO PAIS NUEVO Y LO
				// PASAMOS A LA COLECCION DE SALIDA
				String pais_texto = lector.getProperty((String) clave);
				String partes[] = pais_texto.split(",");
				// COMPROBAMOS SI EL MUNICIPIO PERTENECE A LA PROVINCIA PEDIDA
				if (codigoprovincia.intValue() == Integer.parseInt(partes[1])) {
					Municipios pais_nuevo = new Municipios();
					pais_nuevo.setMunicipio(partes[0]);
					pais_nuevo.setCodigomunicipio(new Integer(partes[2]));
					lista.add(pais_nuevo);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

}
