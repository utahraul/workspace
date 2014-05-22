package com.atrium.validadores;

import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.atrium.managedbean.Idioma_Bean;
import com.atrium.util.Acceso_Contextos;

public class Validar_RangoFechas implements Validator {

	@Override
	public void validate(FacesContext contexto, UIComponent componente,
			Object objeto_avalidar) throws ValidatorException {
		// CONVERSION A DATE DE LA FECHA DE BAJA
		Date fecha_segunda = (Date) objeto_avalidar;
		// ACCESO A LA FECHA DE ALTA PARA COMPARARLA CON LA FECHA DE BAJA
		UIComponent fecha_componente = contexto.getViewRoot().findComponent(
				"formu_usuario:fecha_alta");
		// EXTRAEMOS LA FECHA DEL COMPONENTE PARA LA VALIDACION
		Date fecha_primera = (Date) ((HtmlInputText) fecha_componente)
				.getValue();
		// VALIDAMOS COMPARAMOS LAS FECHAS
		if (fecha_primera.after(fecha_segunda)) {
			// IDIOMATIZACION DEL MENSAJE DE ERROR
			ResourceBundle rb = ResourceBundle
					.getBundle(((Idioma_Bean) Acceso_Contextos.getSesion()
							.getAttribute("idioma_bean")).getIdioma_elegido());
			throw new ValidatorException(new FacesMessage(
					rb.getString("error.validacion.fechabaja")));
		}
	}

}
