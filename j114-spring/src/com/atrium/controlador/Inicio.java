package com.atrium.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.logica.IPrueba_Texto;

public class Inicio {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/applicationContext.xml");

		IPrueba_Texto prueba_exe1 = (IPrueba_Texto) contexto.getBean("prueba1");

		IPrueba_Texto prueba_exe3 = (IPrueba_Texto) contexto.getBean("prueba2");

		IPrueba_Texto prueba_exe4 = (IPrueba_Texto) contexto.getBean("prueba2");

		IPrueba_Texto prueba_exe5 = (IPrueba_Texto) contexto.getBean("prueba3");

		IPrueba_Texto prueba_exe6 = (IPrueba_Texto) contexto.getBean("prueba4");

		IPrueba_Texto prueba_exe7 = (IPrueba_Texto) contexto.getBean("prueba5");

		IPrueba_Texto prueba_exe8 = (IPrueba_Texto) contexto.getBean("prueba6");

		

		System.out.println("");

	}

}
