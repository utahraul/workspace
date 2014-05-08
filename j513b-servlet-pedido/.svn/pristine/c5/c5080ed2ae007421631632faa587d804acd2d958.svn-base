function tratar_Respuesta(codigo_respuesta) {
	if (codigo_respuesta == 200) {
		// OK
	}
	if (codigo_respuesta == 301) {
		// MOVIDO DEL SERVIDOR
	}
	if (codigo_respuesta == 304) {
		// EN PETICIONES GET CONDICIONALES NO SE MODIFICA EL RECURSO
	}
	if (codigo_respuesta == 307) {
		// EL RECURSO PEDIDO ESTA TEMPORALMENTE CAMBIADO DE URL
	}
	if (codigo_respuesta == 400) {
		// PETICION INCORRECTA POR ERROR DE SINTAXSIS
	}
	if (codigo_respuesta == 401) {
		// FALTA DE AUTENTICACION EN SERVIDOR (PROCESO PROPIO DEL SERVIDOR )
	}
	if (codigo_respuesta == 403) {
		// RECURSO DESCONOCIDO
	}
	if (codigo_respuesta == 404) {
		// RECURSO NO ENCONTRADO
	}
	if (codigo_respuesta == 405) {
		// METODO NO ACCESIBLE
	}
	if (codigo_respuesta == 408) {
		// TIME OUT
	}
	if (codigo_respuesta == 414) {
		// TAMAÑO DE PETICION DEMASIADO GRANDE
	}
	if (codigo_respuesta == 500) {
		// ERROR INTERNO DEL SERVIDOR
	}
	if (codigo_respuesta == 501) {
		// EL SERVIDOR NO SOPORTA EL TIPO DE PETICION REALIZADA
	}
	if (codigo_respuesta == 502) {
		// DATOS DE PETICION ERRONEOS
	}
	if (codigo_respuesta == 503) {
		// SERVICIO NO DISPONIBLE, HABITUALMENTE POR SOBRECARGA
	}
	if (codigo_respuesta == 504) {
		// TIEMPO DE ESPERA EN EL ENLACE SOBREPASADO
	}
	if (codigo_respuesta == 505) {
		// VERSION DE HTTP NO SOPORTADA
	}
}
/**
 * Validacion numerica del contenido de un campo mediante el uso de expresiones
 * regulares.
 * 
 * @param campo
 * @returns {Boolean}
 */
function isNumero(campo) {
	var texto = campo.value;
	var expresion = /^[-]?\d*\.?\d*$/;
	texto = texto.toString();
	if (!texto.match(expresion)) {
		alert("Solo se admiten numero para el campo.");
		setTimeout("focusElement('" + campo.form.name + "', '" + campo.name
				+ "')", 0);
		return false;
	}
	return true;
}
/**
 * Validacion de un Email. Solo que el formato sea correcto no si existe
 * realmente.
 * 
 * @param campo
 * @returns {Boolean}
 */
function isEMailAddr(campo) {
	var texto = campo.value;
	var expresion = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
	if (!texto.match(expresion)) {
		alert("Verify the e-mail address format.");
		setTimeout("focusElement('" + campo.form.name + "', '" + campo.name
				+ "')", 0);
		return false;
	} else {
		return true;
	}
}
/**
 * Funcion auxiliar para pasar el foco al campo elegido.
 * 
 * @param formName
 * @param elemName
 */
function focusElement(formName, elemName) {
	var elem = document.forms[formName].elements[elemName];
	elem.focus();
	elem.select();
}
