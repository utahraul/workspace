package com.atrium.eventos;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Eventos_Aplicacion implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent evento) {
		System.out.println("DESTRUIDA APLICACION *******");
	}

	@Override
	public void contextInitialized(ServletContextEvent evento) {
		System.out.println("CREADA APLICACION, VERSION... "
				+ evento.getServletContext().getServerInfo());

	}

}
