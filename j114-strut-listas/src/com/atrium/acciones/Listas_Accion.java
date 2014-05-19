package com.atrium.acciones;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import com.atrium.formbeans.Listas_Bean;
import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_Municipios;
import com.atrium.hibernate.modelo.IGestion_Provincias;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Objeto_Combo;

public class Listas_Accion extends LookupDispatchAction {

	@Override
	protected Map getKeyMethodMap() {
		Map<String, String> mapa = new HashMap<>();
		mapa.put("ajax.provincias", "cargar_Provincias");
		mapa.put("ajax.municipios", "cargar_Municipios");
		return mapa;
	}

	public ActionForward cargar_Provincias(ActionMapping mapa_forward,
			ActionForm datos, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		Listas_Bean datos_formulario = (Listas_Bean) datos;
		String respuesta_json = null;
		if (datos_formulario.getPais_seleccionado().equals("73")) {
			datos_formulario.getLista_provincias().clear();
			// PAIS SELECCIONADO ESPA�A. SE CARGAN PROVINCIAS
			IGestion_Provincias gestion_provincia = Acceso_ApplicationContext
					.getBean(IGestion_Provincias.class);
			List<Provincias> lista = gestion_provincia.coonsultar_Todas();
			// ACTUALIZAMOS LA PROPIEDAD DEL FORMBEAN CON LOS VALORES LEIDOS
			for (Provincias provincia : lista) {
				Objeto_Combo opcion = new Objeto_Combo();
				opcion.setValue(String.valueOf(provincia.getCodigoProvincia()));
				opcion.setTexto(provincia.getProvincia());
				datos_formulario.getLista_provincias().add(opcion);
			}
			// CONVERSION A TEXTO PARA LA RESPUESTA AL CLIENTE
			// DEFINICION DE LOS ELEMENTOS DE LA LISTA
			JsonConfig configurador = new JsonConfig();
			configurador.setRootClass(Objeto_Combo.class);
			// CONVERSION DE LA LISTA A TEXTO SEGUN SU CONTENIDO
			respuesta_json = JSONArray.fromObject(lista, configurador)
					.toString();
		} else {
			// EL PAIS SELECCIONADO NO ES ESPA�A. NINGUNA ACCION
		}
		// ESCRIBIMOS LA RESPUESTA AL CLIENTE
		respuesta.setContentType("text/plain");
		respuesta.setCharacterEncoding("ISO-8859-15");
		try {
			respuesta.getOutputStream().print(respuesta_json);
		} catch (IOException e) {
			// ERROR EN LA SALIDA DE LA RESPUESTA A LA PETICION AJAX
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward cargar_Municipios(ActionMapping mapa_forward,
			ActionForm datos, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		Listas_Bean datos_formulario = (Listas_Bean) datos;
		String respuesta_json = null;
		datos_formulario.getLista_municipios().clear();
		// PAIS SELECCIONADO ESPA�A. SE CARGAN MUNICIPIOS
		IGestion_Municipios gestion_municipio = Acceso_ApplicationContext
				.getBean(IGestion_Municipios.class);
		List<Municipios> lista = gestion_municipio
				.consultar_PorProvincia(new Byte(datos_formulario
						.getProvincia_seleccionada()));
		// ACTUALIZAMOS LA PROPIEDAD DEL FORMBEAN CON LOS VALORES LEIDOS
		for (Municipios municipio : lista) {
			Objeto_Combo opcion = new Objeto_Combo();
			opcion.setValue(String.valueOf(municipio.getId()
					.getCodigoMunicipio()));
			opcion.setTexto(municipio.getMunicipio());
			datos_formulario.getLista_municipios().add(opcion);
		}
		// CONVERSION A TEXTO PARA LA RESPUESTA AL CLIENTE
		// DEFINICION DE LOS ELEMENTOS DE LA LISTA
		JsonConfig configurador = new JsonConfig();
		configurador.setRootClass(Objeto_Combo.class);
		// CONVERSION DE LA LISTA A TEXTO SEGUN SU CONTENIDO
		respuesta_json = JSONArray.fromObject(lista, configurador).toString();

		// ESCRIBIMOS LA RESPUESTA AL CLIENTE
		respuesta.setContentType("text/plain");
		respuesta.setCharacterEncoding("ISO-8859-15");
		try {
			respuesta.getOutputStream().print(respuesta_json);
		} catch (IOException e) {
			// ERROR EN LA SALIDA DE LA RESPUESTA A LA PETICION AJAX
			e.printStackTrace();
		}
		return null;
	}
}