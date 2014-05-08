/**
 * Proceso de validacion de los datos del login de la aplicacion.
 */
function validar_login() {
	// RECOGEMOS LA INFORMACION DEL FORMULARIO
	var nombre = document.getElementById("nombre_usuario").value;
	var clave = document.getElementById("clave_usuario").value;
	var valido = true;
	// PROCESO DE VALIDACION DE CAMPOS VACIOS
	if (!comprobar_vacio(nombre)) {
		valido = false;
	}
	if (!comprobar_vacio(clave)) {
		valido = false;
	}
	if (!comprobar_tama�o(nombre, 20)) {
		valido = false;
	}
	if (!comprobar_tama�o(clave, 10)) {
		valido = false;
	}
	// alert("Validacion: " + valido);
	return valido;
}

// ********* PROCESOS GENERICOS DE VALIDACION ***************
/**
 * Proceso de validacion de campos vacios.
 * 
 * @param campo
 *            Cadena a comprobar.
 * @returns Indicador del resultado del proceso.
 */
function comprobar_vacio(campo) {
	var valido = true;
	if (campo == "") {
		valido = false;
	}
	return valido;
}
/**
 * Proceso de validacion de tama�o en las cadenas de caractares.
 * 
 * @param campo
 *            Cadena a comprobar.
 * @param tama�o
 *            Tama�o maximo de la cadena.
 * @returns {Boolean} Indicador del proceso.
 */
function comprobar_tama�o(campo, tama�o) {
	var valido = true;
	if (campo.length > tama�o) {
		valido = false;
	}
	return valido;
}