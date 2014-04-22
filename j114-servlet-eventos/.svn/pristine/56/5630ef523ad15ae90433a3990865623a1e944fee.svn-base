package com.atrium.eventos;



import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Eventos_Sesion implements HttpSessionListener {

	private long tiempo_transcurrido;
	private long tiempo_creacion;
	@Override
	public void sessionCreated(HttpSessionEvent evento) {
		System.out.println("SE CREA LA SESION... "+evento.getSession().getId());
		evento.getSession().setMaxInactiveInterval(25);
		tiempo_creacion=evento.getSession().getCreationTime();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evento) {
		System.out.println("SE DESTRUYE LA SESION... "+evento.getSession().getId());
		Date ahora=new Date();
		tiempo_transcurrido=ahora.getTime()-tiempo_creacion;
		System.out.println("Transcurrido "+tiempo_transcurrido/1000+" segundos");
	}

}


