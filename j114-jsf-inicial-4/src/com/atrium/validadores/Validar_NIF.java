package com.atrium.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class Validar_NIF implements Validator {

	/**
	 * El formato del NIF consiste b�sicamente en ocho n�meros m�s un d�gito de
	 * control para espa�oles con DNI o bien en una letra, siete n�meros y un
	 * d�gito de control para el resto de personas f�sicas:
	 * <table>
	 * <tbody>
	 * <tr>
	 * <td>
	 * Tipo</td>
	 * <td>Formato</td>
	 * <td>Comentario</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * DNI</td>
	 * <td>Ocho n�meros + d�g. de control</td>
	 * <td>Espa�oles con documento nacional de identidad asignado por el
	 * Ministerio del Interior</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * NIF K</td>
	 * <td>K + 7 n�meros + d�gito de control</td>
	 * <td>Espa�oles menores de 14 a�os...</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * NIF L</td>
	 * <td>L + 7 n�meros + d�gito de control</td>
	 * <td>Espa�oles residentes en el extranjero sin DNI</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * NIF M</td>
	 * <td>M + 7 n�meros + d�gito de control NIF</td>
	 * <td>que otorga la Agencia Tributaria a extranjeros que no tienen NIE</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * NIF X</td>
	 * <td>X + 7 n�meros + d�gito de control</td>
	 * <td>Extranjeros identificados por la Polic�a con un n�mero de identidad
	 * de extranjero, NIE, asignado hasta el 15 de julio de 2008</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * NIF Y</td>
	 * <td>Y + 7 n�meros + d�gito de control</td>
	 * <td>Extranjeros identificados por la Polic�a con un NIE, asignado desde
	 * el 16 de julio de 2008 (Orden INT/2058/2008, BOE del 15 de julio )</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * NIF Z</td>
	 * <td>Z + 7 n�meros + d�gito de control</td>
	 * <td>Letra reservada para cuando se agoten los 'Y' para Extranjeros
	 * identificados por la Polic�a con un NIE</td>
	 * </tr>
	 * <tr>
	 * </tbody>
	 * </table>
	 * 
	 * @param contexto
	 * @param componente
	 * @param valor_validar
	 */
	public void validate(FacesContext contexto, UIComponent componente,
			Object valor_validar) throws ValidatorException {
		// Si el valor es null, lo transformamos en un valor vac�o
		String valor1 = String.valueOf(valor_validar);
		String cadenas[] = valor1.split("-");
		if (cadenas.length == 2) {
			valor1 = cadenas[0] + cadenas[1];
		} else {
			throw new ValidatorException(new FacesMessage(
					"SE DEBE INCLUIR UN GUION EN EL CAMPO"));
		}
		// el valor debe tener 9 posiciones, de las cuales las primeras deben
		// ser d�gitos y la �ltima letra
		valor1 = valor1.toUpperCase();
		Pattern mask = Pattern.compile("[0-9]{8,8}[A-Z]");
		Matcher matcher = mask.matcher(valor1);
		if (!matcher.matches()) {
			throw new ValidatorException(new FacesMessage(
					"EL FORMATO NO ES VALIDO PARA UN NIF"));
		} else {
			String dni = valor1.substring(0, 8);
			String digitoControl = valor1.substring(8, 9);
			// Calculamos la letra de control
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int posicion_modulo = Integer.parseInt(dni) % 23;
			String digitoControlCalculado = letras.substring(posicion_modulo,
					posicion_modulo + 1);
			if (!digitoControl.equalsIgnoreCase(digitoControlCalculado)) {
				throw new ValidatorException(new FacesMessage(
						"LA LETRA NO ES CORRECTA"));
			}
		}
	}

}
