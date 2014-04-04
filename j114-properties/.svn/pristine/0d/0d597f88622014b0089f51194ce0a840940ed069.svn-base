package com.atrium.modelo;

import java.io.IOException;
import java.util.Properties;

public class Datos_DAO {

	private Properties flujo_lectura;
	private Datos_DTO datos;

	public Datos_DAO() {
		flujo_lectura = new Properties();
		datos = new Datos_DTO();
	}

	public Datos_DTO leer_Datos() {
		try {
			flujo_lectura.load(this.getClass().getResourceAsStream(
					"/com/atrium/modelo/datos.properties"));
			datos.setTexto(flujo_lectura.getProperty("texto.etiqueta"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}

}
