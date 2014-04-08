package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuario {

	public Usuarios consultar_PorNombre(String nombre_usuario);

	public List<Usuarios> consultar_Todos();

	public List<Usuarios> consultar_PorRol(Roles rol_aconsultar);

	public abstract Usuarios consultar_UsuarioConRol(String nombre_usuario);
	
	

}