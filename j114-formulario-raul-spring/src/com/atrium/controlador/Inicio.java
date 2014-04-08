package com.atrium.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.spring.Acceso_ApplicationContext;

public class Inicio {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/applicationContext.xml");
		
		IVentana ventana = Acceso_ApplicationContext.getBean(IVentana.class);
	}

}
