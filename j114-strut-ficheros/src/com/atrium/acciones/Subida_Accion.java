package com.atrium.acciones;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.atrium.formbeans.Subida_Bean;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Copiar_Ficheros;
import com.atrium.util.Crear_Rutas;

/**
 * Proceso que regoge el fichero subido por el usuario y lo almacena en su
 * carpeta del repositorio documental.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 14-5-2013.
 * 
 */
public class Subida_Accion extends Action {

	/**
	 * Accion que cumple las reglas definidas en cuanto a calculo de limites
	 * para acceptar y grabar el fichero elegido por el usuario.
	 */
	@Override
	public ActionForward execute(ActionMapping mapa_forward, ActionForm datos,
			HttpServletRequest peticion, HttpServletResponse respuesta)
			throws Exception {
		String mensaje = null;
		// RECOGEMOS DE LA SESION LA INFORMACION DE LA SUBIDA DE FICHEROS
		Subida_Bean datos_formulario = (Subida_Bean) datos;
		mensaje = "SUBIDA REALIZADA";
		IGestion_Usuario gestion_usuario = Acceso_ApplicationContext
				.getBean(IGestion_Usuario.class);
		Usuarios usuario = gestion_usuario.consultar_PorNombre(datos_formulario
				.getNombre_usuario());
		if (usuario != null) {
			// GUARDAMOS LA CARPETA EN LA SESION PARA POSTERIORES USOS
			peticion.getSession().setAttribute("carpeta",
					usuario.getCarpetaDocumentacion());
			// COMPROBAMOS/CREAMOS LA CARPETA DEL USUARIO
			String carpeta = Crear_Rutas.crear_Carpetas(usuario
					.getCarpetaDocumentacion());
			// DEFINIMOS EL FICHERO DE SALIDA DONDE SE GUARDARA LO SUBIDO
			// POR EL CLIENTE
			File fichero_entrada = new File(carpeta + "/"
					+ datos_formulario.getFichero_subido().getFileName());
			try {
				Copiar_Ficheros.copiar_FicherosIO11(datos_formulario
						.getFichero_subido().getInputStream(), fichero_entrada);
			} catch (Exception e) {
				mensaje = "ERROR EN LA SUBIDA, INTENTELO DE NUEVO";
			}
		} else {
			// ERROR EN EL NOMBRE DADO
			mensaje = "el usuario dado no es correcto";
		}
		// ELIMINAMOS EL FICHERO TEMPORAL SUBIDO PASE LO QUE PASE
		datos_formulario.getFichero_subido().destroy();
		peticion.setAttribute("mensaje_subida", mensaje);
		return mapa_forward.getInputForward();
	}

}
