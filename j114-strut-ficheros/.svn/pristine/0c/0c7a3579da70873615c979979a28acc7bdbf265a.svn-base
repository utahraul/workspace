package com.atrium.acciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.atrium.formbeans.Datos_Descarga;

public class Descarga_Ficheros extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Datos_Descarga datos_peticion = (Datos_Descarga) form;
		// para guardar directamente por la opcion de guardar como
		// application/force-download
		response.setHeader(
				"Content-Disposition",
				"attachment;filename="
						+ datos_peticion.getFichero()
								.substring(
										datos_peticion.getFichero()
												.lastIndexOf("\\") + 1));
		response.setContentType("application/force-download");
		File fichero = new File(datos_peticion.getFichero());
		InputStream lectura = null;
		int cantidad_aleer;
		byte[] buffer = new byte[2048];
		try {
			lectura = new FileInputStream(fichero);
			while (true) {
				cantidad_aleer = lectura.read(buffer);
				if (cantidad_aleer == -1) {
					break;
				}
				String cadena_texto = new String(buffer);
				response.getOutputStream().write(buffer);
			}
			response.getOutputStream().flush();
		} finally {
			if (lectura != null) {
				lectura.close();
			}
		}
		return null;
	}

}
