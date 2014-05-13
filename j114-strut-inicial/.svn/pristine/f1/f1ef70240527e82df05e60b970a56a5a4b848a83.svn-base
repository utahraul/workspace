package com.atrium.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.atrium.formbeans.Login_Bean;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;

public class Login_Accion extends Action {

	@Override
	public ActionForward execute(ActionMapping mapa_forward,
			ActionForm datos_formulario, HttpServletRequest peticion,
			HttpServletResponse response) throws Exception {
		ActionForward salida = new ActionForward();
		salida = mapa_forward.findForward("incorrecto");
		Login_Bean datos = (Login_Bean) datos_formulario;

		IGestion_Usuario gestion_usuarios = Acceso_ApplicationContext
				.getBean(IGestion_Usuario.class);
		Usuarios usuario = gestion_usuarios.consultar_PorNombre(datos
				.getNombre_usuario());
		if (usuario != null) {
			if (usuario.getPassword().equals(datos.getClave_usuario())) {
				// USUARIO CORRECTO
				salida = mapa_forward.findForward("correcto");
				peticion.getSession().setAttribute("usuario", usuario);
			} else {
				// ERROR EN LA CLAVE
			}

		} else {
			// ERROR EN EL NOMBRE DAOD
		}
		return salida;
	}

}
