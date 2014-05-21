package com.atrium.validadores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class Validar_DigitoControl implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// FALTA RECOGER LA INFORMACION DEL FORMULARIO, PASARLO AL OTRO METODO Y
		// EN CASO DE QUE DEVUELVA FALSO GENERAR LA EXCEPCION CORRESPONDIENTE

	}

	/**
	 * ALGORITMO DE COMPROBACION DE NUMEROS DE CUENTAS BANCARIAS. EN CASO DE QUE
	 * FALTE ALGUN CERO INICIAL EN ALGUN CAMPO SE RELLENAN AUTOMATICAMENTE.
	 * 
	 * @param banco
	 *            int NUMERO DE LA ENTIDAD BANCARIA.
	 * @param oficina
	 *            int NUMERO DE LA OFICINA.
	 * @param digito_control
	 *            int DIGITO DE CONTROL.
	 * @param cuenta
	 *            int NUMERO DE CUENTA.
	 * @return boolean INDICADOR DE SI ES CORRECTO O NO EL NUMERO.TRUE
	 *         CORRECTO.FALSE NO CORRECTO.
	 */
	public boolean comprobar_DigitoControl(int banco, int oficina,
			int digito_control, int cuenta) {
		int temporal = 0;

		String banco_s = String.valueOf(banco);
		String oficina_s = String.valueOf(oficina);
		String cuenta_s = String.valueOf(cuenta);
		String digito_s = "";
		String relleno = "0";
		if (banco_s.length() < 4) {
			for (int i = 1; i < (4 - banco_s.length()); i++) {
				relleno = relleno + "0";
			}
			banco_s = relleno + banco_s;
			relleno = "0";
		}
		if (oficina_s.length() < 4) {
			for (int i = 1; i < (4 - oficina_s.length()); i++) {
				relleno = relleno + "0";
			}
			oficina_s = relleno + oficina_s;
			relleno = "0";
		}
		if (cuenta_s.length() < 10) {
			for (int i = 1; i < (10 - cuenta_s.length()); i++) {
				relleno = relleno + "0";
			}
			cuenta_s = relleno + cuenta_s;
			relleno = "0";
		}
		temporal = temporal + Integer.parseInt(banco_s.substring(0, 1)) * 4;
		temporal = temporal + Integer.parseInt(banco_s.substring(1, 2)) * 8;
		temporal = temporal + Integer.parseInt(banco_s.substring(2, 3)) * 5;
		temporal = temporal + Integer.parseInt(banco_s.substring(3, 4)) * 10;
		temporal = temporal + Integer.parseInt(oficina_s.substring(0, 1)) * 9;
		temporal = temporal + Integer.parseInt(oficina_s.substring(1, 2)) * 7;
		temporal = temporal + Integer.parseInt(oficina_s.substring(2, 3)) * 3;
		temporal = temporal + Integer.parseInt(oficina_s.substring(3, 4)) * 6;
		temporal = 11 - (temporal % 11);
		if (temporal == 11) {
			digito_s = "0";
		}
		if (temporal == 10) {
			digito_s = "1";
		}
		if (temporal < 10) {
			digito_s = String.valueOf(temporal);
		}
		temporal = 0;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(0, 1)) * 1;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(1, 2)) * 2;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(2, 3)) * 4;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(3, 4)) * 8;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(4, 5)) * 5;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(5, 6)) * 10;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(6, 7)) * 9;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(7, 8)) * 7;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(8, 9)) * 3;
		temporal = temporal + Integer.parseInt(cuenta_s.substring(9, 10)) * 6;
		temporal = 11 - (temporal % 11);
		if (temporal == 11) {
			digito_s = digito_s + "0";
		}
		if (temporal == 10) {
			digito_s = digito_s + "1";
		}
		if (temporal < 10) {
			digito_s = digito_s + String.valueOf(temporal);
		}
		if (digito_control == Integer.parseInt(digito_s)) {
			return true;
		} else {
			return false;
		}
	}

}
