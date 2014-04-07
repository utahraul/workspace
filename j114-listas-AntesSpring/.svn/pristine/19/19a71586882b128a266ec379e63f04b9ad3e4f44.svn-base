package com.atrium.modelo.dao.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.atrium.modelo.Pais;
import com.atrium.modelo.Provincias;

public class Provincias_DAO {

	private Properties lector;
	
	public Provincias_DAO(){
		lector=new Properties();
	}
	
	public List<Provincias> consultar_Todos(){
		List<Provincias> lista=new ArrayList<>();
		try {
			// LEEMOS DEL PROPERTIES
			lector.load(this.getClass().getResourceAsStream(
					"/com/atrium/modelo/dao/provincias.properties"));
			// EXTRAEMOS LA COLECCION DE CLAVES DEL MAPA
			Set<Object> lista_claves = lector.keySet();
			// RECORREMOS LA COLECCION DE CLAVES PARA ACCEDERA A LOS DATOS DEL
			// MAPA
			for (Object clave : lista_claves) {
				// CON LA INFORMACION DEL MAPA CREAMOS UN OBJETO PAIS NUEVO Y LO
				// PASAMOS A LA COLECCION DE SALIDA
				String pais_texto = lector.getProperty((String) clave);
				String partes[] = pais_texto.split(",");
				Provincias pais_nuevo = new Provincias();
				pais_nuevo.setProvincia(partes[0]);
				pais_nuevo.setCodigoprovincia(new Integer(partes[1]));
				lista.add(pais_nuevo);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
}
