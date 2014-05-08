package com.atrium.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.atrium.hibernate.Clientes_Pedido;
import com.atrium.hibernate.modelo.IGestion_Clientes;
import com.atrium.spring.Acceso_ApplicationContext;

public class Consultar_C_Pedidos extends BodyTagSupport {
	/**
	 * Proceso de creacion dinamica del contenido de la ayuda de clientes en
	 * pedido.
	 */
	@Override
	public int doEndTag() throws JspException {
		// ACCEDEMOS A LA FACHADA PARA CONSULTAR CLIENTES
		IGestion_Clientes ges_cli = Acceso_ApplicationContext
				.getBean(IGestion_Clientes.class);
		// CONSULTAMOS EN LA BASE DE DATOS
		List<Clientes_Pedido> lista_clientes = ges_cli.consultar_Todos();
		// flujo de escritura en la pagina
		JspWriter salida_pagina = bodyContent.getEnclosingWriter();
		// PROPIEDADES DE TRABAJO PARA GENERAR LOS ID DINAMICAMENTE
		String nombre = "cli";
		String nom_cli = "nom";
		String cod_cli = "cod";
		int i = 0;
		StringBuffer salida = new StringBuffer();
		// GENERACION DE CODIGO HTML. UNA FILA CON 3 COLUMNAS POR CLIENTE
		for (Clientes_Pedido cli : lista_clientes) {
			i++;
			salida.append("<tr>\n<td width='60'>\n<input type='checkbox' id='"
					+ nombre
					+ String.valueOf(i)
					+ "' name='checkito' onclick='comprobar_seleccion(this);'/>"
					+ "</td>\n<td width='130'>\n<input type='text' readonly size='12' value='"
					+ cli.getCodigoCliente() + "' id='" + cod_cli
					+ String.valueOf(i) + "' />\n</td>\n"
					+ "<td width='130'>\n<input type='text' readonly value='"
					+ cli.getNombreCliente() + "' id='" + nom_cli
					+ String.valueOf(i) + "' />\n</td>\n" + "</tr>\n");
		}
		salida.append("<input type='hidden' value='" + String.valueOf(i)
				+ "' id='numero_clientes'/>");
		// ESCRIBIMOS EL HTML EN LA PAGINA
		try {
			salida_pagina.write(salida.toString());
		} catch (IOException e) {
		}
		return EVAL_PAGE;
	}
}
