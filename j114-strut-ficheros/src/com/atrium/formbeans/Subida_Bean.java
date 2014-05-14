package com.atrium.formbeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class Subida_Bean extends ActionForm {

	private String nombre_usuario;
	private FormFile fichero_subido;

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errores = new ActionErrors();
		// VALIDACION DE NOMBRE USUARIO
		if (nombre_usuario.equals("")) {
			errores.add("error_nombre", new ActionMessage(
					"error.validacion.nombresubida"));
		}
		// VALIDACION DE FICHERO SELECCIONADO
		if (fichero_subido == null) {
			errores.add("error_fichero", new ActionMessage(
					"error.validacion.ficherosubida"));
		}
		return errores;
	}

	// ACCESORES PARA STRUT
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public FormFile getFichero_subido() {
		return fichero_subido;
	}

	public void setFichero_subido(FormFile fichero_subido) {
		this.fichero_subido = fichero_subido;
	}

}
