package com.atrium.controlador;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.MunicipiosId;
import com.atrium.hibernate.modelo.IGestion_Municipios;
//EL EJERCICIO ES HIBERNATE-SPRING4
public class Inicio {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/applicationContext.xml");
		IGestion_Municipios gestion_Municipios = contexto
				.getBean(IGestion_Municipios.class);
		// CREAMOS EL OBJETO EN TRÁNSITO
		Municipios municipio_nuevo = new Municipios();
		municipio_nuevo.setMunicipio("j114");
		MunicipiosId clave_municipio = new MunicipiosId();
		clave_municipio.setCodigoMunicipio(new Long(10000));
		clave_municipio.setProvincia(new Byte((byte) 28));

		municipio_nuevo.setId(clave_municipio);
		try {
			gestion_Municipios.alta_Municipio(municipio_nuevo);
		} catch (Exception e) {
			System.out.println("");
		}
		
		
		municipio_nuevo.setMunicipio("otro nombre");
		try{
			gestion_Municipios.modificacion_Municipio(municipio_nuevo);
		}catch (Exception e) {
			System.out.println("");
		}
		
		//Falta la baja
	}

}
