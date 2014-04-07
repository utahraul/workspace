package com.atrium.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.logica.IPrueba_Texto;

public class Inicio {

	public static void main(String[] args) {

		ApplicationContext (IPrueba_Texto) contexto.getBean("pueba1"); = new ClassPathXmlApplicationContext(
				"com.atrium.spring.applicationContext.xml");

		IPrueba_Texto prueba_exe1 = (IPrueba_Texto) contexto.getBean("pueba1");
		
		IPrueba_Texto prueba_exe2 = (IPrueba_Texto) contexto.getBean("pueba2");
	}

}
