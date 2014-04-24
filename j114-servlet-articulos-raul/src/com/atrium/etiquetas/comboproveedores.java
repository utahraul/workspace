package com.atrium.etiquetas;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class comboproveedores extends SimpleTagSupport {
	
	// COLECCION PARA IDIOMATIZAR LAS OPCIONES DE MENU
		private List<Lista_Proveedores> lista_proveedores;
		private ResourceBundle rb;
	
	// RECOJO LA LISTA DE PROVEEDORES
	// PIDO LA FACHADA AL APPLICATION CONTEXT DE SPRING
	// CREAMOS POR PRIMERA VEZ LA COLECCION DE PROVEEDORES
	// GENERACION DEL HTML PARA LA PAGINA
	// ESCRIBO EL HTML EN LA PAGINA
			//this.getJspContext().getOut().append(salida.toString());

}
