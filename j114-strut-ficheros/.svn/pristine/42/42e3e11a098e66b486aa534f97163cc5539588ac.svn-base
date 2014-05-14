package com.atrium.etiquetas;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.util.Crear_Rutas;

public class Ficheros_Subidos extends SimpleTagSupport {

	private String carpeta_usuario;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder salida = new StringBuilder();
		if (!getCarpeta_usuario().equals("")) {
			// COMPROBAMOS/CREAMOS LA CARPETA DEL USUARIO
			String carpeta = Crear_Rutas.crear_Carpetas(getCarpeta_usuario());
			// RECOGER EL CONTENIDO DE LA CARPETA
			File carpeta_usuario = new File(carpeta);
			File tabla_ficheros[] = carpeta_usuario.listFiles();
			int cuantos = tabla_ficheros.length;
			SimpleDateFormat formato = new SimpleDateFormat(
					"dd/MMMM/yyyy HH:mm");
			for (int i = 0; i < cuantos; i++) {
				salida.append("\n<tr><td>"
						+ tabla_ficheros[i].getName()
						+ "</td><td>"
						+ formato.format(new Date(tabla_ficheros[i]
								.lastModified()))
						+ " </td><td aling='right'>"
						+ Math.rint(((tabla_ficheros[i].length() / (1024 * 1024)) * 100) / 100)
						+ " </td><td>" + "<a href='descarga.do?fichero="
						+ tabla_ficheros[i].getAbsolutePath()
						+ "'> Bajar fichero</a>" + "</td></tr>\n");
				// + BigDecimal.valueOf(
				// (tabla_ficheros[i].length() / (1024 * 1024)), 2)
			}
		} else {
			salida.append("\n<tr><td colspan='4'>Usuario desconocido o sin ficheros subidos</td></tr>");
		}
		this.getJspContext().getOut().write(salida.toString());

	}

	// ACCESORES PARA RECIBIR LA INFORMACION DE LA PAGINA
	public String getCarpeta_usuario() {
		return carpeta_usuario;
	}

	public void setCarpeta_usuario(String carpeta_usuario) {
		this.carpeta_usuario = carpeta_usuario;
	}

}
