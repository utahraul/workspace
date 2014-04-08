package com.atrium.controlador;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;

public class Inicio {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/modelo.xml");

		IGestion_Usuario gestion_usuario = contexto
				.getBean(IGestion_Usuario.class);

		Usuarios usuario = gestion_usuario.consultar_PorNombre("Juan");

		List<Usuarios> lista = gestion_usuario.consultar_Todos();

		Roles rol_abuscar = new Roles(new Byte((byte) 20));
		List<Usuarios> lista2 = gestion_usuario.consultar_PorRol(rol_abuscar);

		usuario = gestion_usuario.consultar_UsuarioConRol("Juan");

		System.out.println("");

	}

}
