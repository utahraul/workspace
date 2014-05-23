package com.atrium.managedbean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.event.ActionEvent;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Acceso_Contextos;

public class Usuario_Bean implements Serializable{
	
	// PROPIEDADES DEL FORMULARIO
	private String nombre_usuario;
	private String clave_usuario;
	private String carpeta_documentacion;
	private String idioma_usuario;
	private Date fecha_alta;
	private Date fecha_baja;
	private Integer rol_usuario;

	// PROPIEDADES PARA EL CONTROL DE LOS BOTONES
	private boolean activacion_alta;
	private boolean activacion_bajamodi;
	
	//PROPIEDAD PARA EL ACCESO A MODELO
	private IGestion_Usuario gestion_usuario;

	public Usuario_Bean() {
		// VALORES POR DEFECTO
		fecha_alta = new Date();
		idioma_usuario = "es";
		activacion_alta = false;
		activacion_bajamodi = true;
	}

	// **** ZONA DE TRATRAMIENTO DE EVENTOS DEL FORMULARIO *****
	public void alta_Usuario(ActionEvent evento) {
		Usuarios usuario_nuevo = new Usuarios();
		usuario_nuevo.setNombreUsuario(getNombre_usuario());
		usuario_nuevo.setIdioma(getIdioma_usuario());
		usuario_nuevo.setCarpetaDocumentacion(getCarpeta_documentacion());
		usuario_nuevo.setFechaAlta(getFecha_alta());
		usuario_nuevo.setFechaBaja(getFecha_baja());
		if (getRol_usuario() != null) {
			usuario_nuevo.setRoles(new Roles(getRol_usuario().byteValue()));
		}
		usuario_nuevo.setPassword(getClave_usuario());
		
		try {
			gestion_usuario.alta_Usuario(usuario_nuevo);
			// ALTA CORRECTA
			Acceso_Contextos.addMensaje_Idioma("confirmacion.alta.valida",
					null, null, "confirmacion_accion");
		} catch (Exception e) {
			// ERROR EN EL ALTA
			Acceso_Contextos.addMensaje_Idioma("confirmacion.alta.error", null,
					null, "confirmacion_accion");
		}
	}

	public void baja_Usuario(ActionEvent evento) {

	}

	public void modificacion_Usuario(ActionEvent evento) {

	}

	public void consulta_Usuario(ActionEvent evento) {

		Usuarios usuario = gestion_usuario
				.consultar_PorNombre(getNombre_usuario());
		if (usuario != null) {
			// EXISTE EL USUARIO
			setNombre_usuario(usuario.getNombreUsuario());
			setClave_usuario(usuario.getPassword());
			setCarpeta_documentacion(usuario.getCarpetaDocumentacion());
			setIdioma_usuario(usuario.getIdioma());
			setFecha_alta(usuario.getFechaAlta());
			setFecha_baja(usuario.getFechaBaja());
			if (usuario.getRoles() != null) {
				setRol_usuario(new Integer(usuario.getRoles().getCodigoRol()));
			}
			activacion_alta=true;
			activacion_bajamodi=false;
		} else {
			// ERROR EN LA CONSULTA
		}

	}

	// **** FIN ZONA DE TRATRAMIENTO DE EVENTOS DEL FORMULARIO *****

	// ACCESORES PARA JSF
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

	public boolean isActivacion_alta() {
		return activacion_alta;
	}

	public void setActivacion_alta(boolean activacion_alta) {
		this.activacion_alta = activacion_alta;
	}

	public boolean isActivacion_bajamodi() {
		return activacion_bajamodi;
	}

	public void setActivacion_bajamodi(boolean activacion_bajamodi) {
		this.activacion_bajamodi = activacion_bajamodi;
	}

	//ACCESORES PARA SPRING
	public void setGestion_usuario(IGestion_Usuario gestion_usuario) {
		this.gestion_usuario = gestion_usuario;
	}

	
}