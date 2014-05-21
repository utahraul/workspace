package com.atrium.managedbean;

import java.util.Date;

public class Usuario_Bean {
	
	private String nombre_usuario;
	private String clave_usuario;
	private String carpeta_documentacion;
	private String idioma_usuario;
	private Date fecha_alta;
	private Date fecha_baja;
	private Integer rol_usuario;
	
	public Usuario_Bean(){
		//VALORES POR DEFECTO
		fecha_alta = new Date();
		idioma_usuario = "es";
	}
	
	
	//ACCESORES PARA SPRING
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getClave_usuario() {
		return clave_usuario;
	}
	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}
	public String getCarpeta_documentacion() {
		return carpeta_documentacion;
	}
	public void setCarpeta_documentacion(String carpeta_documentacion) {
		this.carpeta_documentacion = carpeta_documentacion;
	}
	public String getIdioma_usuario() {
		return idioma_usuario;
	}
	public void setIdioma_usuario(String idioma_usuario) {
		this.idioma_usuario = idioma_usuario;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public Integer getRol_usuario() {
		return rol_usuario;
	}
	public void setRol_usuario(Integer rol_usuario) {
		this.rol_usuario = rol_usuario;
	}
	
}
