package com.atrium.etiquetas;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class comboproveedores extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
	}
	
	// COLECCION PARA IDIOMATIZAR LAS OPCIONES DE MENU
	// RECOJO LA LISTA DE PROVEEDORES
	// PIDO LA FACHADA AL APPLICATION CONTEXT DE SPRING
	// CREAMOS POR PRIMERA VEZ LA COLECCION DE PROVEEDORES
	// GENERACION DEL HTML PARA LA PAGINA
	// ESCRIBO EL HTML EN LA PAGINA
			//this.getJspContext().getOut().append(salida.toString());

}
