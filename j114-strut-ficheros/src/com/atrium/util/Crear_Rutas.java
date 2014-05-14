package com.atrium.util;

import java.io.File;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.jsf.FacesContextUtils;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;

import com.atrium.spring.Acceso_ApplicationContext;

public class Crear_Rutas {

	/**
	 * Proceso mediante el cual creamos la primera carpeta de cada usuario, sino
	 * existe. Ademas comprobamos que sea un usuario valido. A continuacion en
	 * caso de que tenga alguna preferecia en su perfil creamos una nueva
	 * carpeta para la documentacion. Se establece un sistema para
	 * autoconfigurar en nombre y ruta de la carpeta general (repositorio
	 * documental)
	 * 
	 * @param clave_usuario
	 */
	public static String crear_Carpetas(String carpeta_usuario) {
		String ruta_salida = null;
		if (carpeta_usuario != null) {
			String carpeta_principal_usuario = Acceso_ApplicationContext
					.getServletContext()
					.getRealPath(
							Acceso_ApplicationContext.getServletContext()
									.getInitParameter("repositorio_documental"));
			File carpeta = new File(carpeta_principal_usuario);
			// CREO SU CARPETA SINO EXISTE EN LA CARPETA GENERAL PARA LA
			// DOCUMENTACION
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}
			ruta_salida = carpeta.getAbsolutePath();
			// SI EXISTE SERA EL NOMBRE DEL CAMPO EN LA BASE DE DATOS
			File carpeta_personalizada = new File(carpeta.getPath() + "/"
					+ carpeta_usuario);
			if (!carpeta_personalizada.exists()) {
				carpeta_personalizada.mkdirs();
			}
			ruta_salida = carpeta_personalizada.getAbsolutePath();
		}
		return ruta_salida;
	}

}
