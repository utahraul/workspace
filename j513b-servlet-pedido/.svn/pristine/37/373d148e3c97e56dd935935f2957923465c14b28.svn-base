//******** FUNCIONES PARA LAS PETICIONES AJAX **********
/** VARIABLE GLOBAL PARA LAS PETICIONES AJAX */
var peticion_http;
/**
 * FUNCION QUE REALIZA LAS PETICIONES DE LA CABECERA.
 */
function actualizar_cli_ajax() {
	// VALIDAMOS LOS DATOS NECESARIOS DEL FORMULARIO
	if (!validar_formu()) {
		return;
	}
	// OBTENEMOS EL OBJETO NECESARIO PARA LA PETICION AJAX
	if (window.XMLHttpRequest) {
		peticion_http = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// Preparar la funcion de respuesta
	peticion_http.onreadystatechange = respuesta_cliente;
	// Realizar peticion HTTP
	// RECOGEMOS LOS VALORES DEL FORMULARIO
	var codigo = document.getElementById("cod_cliente").value;
	var nombre = document.getElementById("nombre_cliente").value;
	// CREAMOS DINAMICAMENTE LA URL DE LA PETICION
	var url_peticion = crear_URL(1);
	// PREPARACION DE LA PETICION
	peticion_http.open('GET', url_peticion + '&cod_cli=' + codigo + "&nom_cli="
			+ nombre, true);
	// HACEMOS LA PETICION
	peticion_http.send(null);

}
/**
 * Recoge la respuesta cuando llega y lanza el procesamiento de la peticion de
 * los clientes.
 */
function respuesta_cliente() {
	if (peticion_http.readyState == 1) {
		document.getElementById("imagen_ajax_articulos").src = "./imagenes/espera_ajax.gif";
		document.getElementById("capa_imagen").style.visibility = "visible";
	}
	if (peticion_http.readyState == 4) {
		if (peticion_http.status == 200) {
			document.getElementById("imagen_ajax_articulos").src = "";
			document.getElementById("capa_imagen").style.visibility = "hidden";
			cargar_clienteJson(peticion_http.responseText);
		}
	}
}
// ********* PROCESO DE PRECARGA DE AYUDA CLIENTES ***************
/**
 * Peticion para la informacion de la ayuda de clientes. Patron de precarga.
 */
function carga_Clientes() {
	// OBTENEMOS EL OBJETO NECESARIO PARA LA PETICION AJAX
	if (window.XMLHttpRequest) {
		peticion_http = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// Preparar la funcion de respuesta
	peticion_http.onreadystatechange = respuesta_clientesayuda;
	// CREAMOS DINAMICAMENTE LA URL DE LA PETICION
	var url_peticion = crear_URL(3);
	// PREPARACION DE LA PETICION
	peticion_http.open('GET', url_peticion, true);
	// HACEMOS LA PETICION
	peticion_http.send(null);
}

function respuesta_clientesayuda() {
	if (peticion_http.readyState == 4) {
		if (peticion_http.status == 200) {
			crear_ayudaclientes(peticion_http.responseText);
		}
	}
}
/**
 * Proceso de creacion del contenido de la ayuda de clientes.
 * 
 * @param texto_json
 */
function crear_ayudaclientes(texto_json) {
	var objeto_ayudaclientes = eval('(' + texto_json + ')');
	var tabla = document.getElementById("tabla_clientes");
	// TRATAMOS TODOS LOS CLIENTES DE LA TABLA
	for (var i = 0; i < objeto_ayudaclientes.lista_clientes.length; i++) {
		// CREO UNA FILA NUEVA
		var fila = tabla.insertRow(i);
		// INSERTAMOS UNA CELDA EN LA FILA
		var celda_nueva = fila.insertCell(0);
		celda_nueva.width = 60;
		var elemento_nuevo = document.createElement('input');
		elemento_nuevo.id = "cli" + (i + 1);
		elemento_nuevo.name = "checkito";
		elemento_nuevo.type = "checkbox";
		elemento_nuevo.onclick = new Function('comprobar_seleccion(this)');
		celda_nueva.appendChild(elemento_nuevo);
		// INSERTAMOS LA SEGUNDA CELDA
		celda_nueva = fila.insertCell(1);
		celda_nueva.width = 130;
		elemento_nuevo = document.createElement('input');
		elemento_nuevo.id = "cod" + (i + 1);
		elemento_nuevo.type = "text";
		elemento_nuevo.size = 12;
		elemento_nuevo.readonly = "readonly";
		elemento_nuevo.value = objeto_ayudaclientes.lista_clientes[i].codigoCliente;
		celda_nueva.appendChild(elemento_nuevo);
		// INSERTAMOS LA TERCERA CELDA
		celda_nueva = fila.insertCell(2);
		celda_nueva.width = 130;
		elemento_nuevo = document.createElement('input');
		elemento_nuevo.id = "nom" + (i + 1);
		elemento_nuevo.type = "text";
		elemento_nuevo.readonly = "readonly";
		elemento_nuevo.value = objeto_ayudaclientes.lista_clientes[i].nombreCliente;
		celda_nueva.appendChild(elemento_nuevo);
	}
}
// ********* FIN PROCESO DE PRECARGA DE AYUDA CLIENTES ***************
/**
 * Cargamos la respuesta del servidor que vendra en texto, pero en este caso, en
 * formato JSON.
 * 
 * @param {Object}
 *            respuesta
 */
function cargar_clienteJson(respuesta) {
	var objeto_json = eval('(' + respuesta + ')');
	var posicion = respuesta.toString().indexOf("codigoCliente", 0);
	if (posicion != -1) {
		document.getElementById("cod_cliente").value = objeto_json.cliente.codigoCliente;
		document.getElementById("nombre_cliente").value = objeto_json.cliente.nombreCliente;
		document.getElementById("telefono").value = objeto_json.cliente.telefonoCliente;
		if (objeto_json.cliente.cifCliente != "") {
			document.getElementById("cif").value = objeto_json.cliente.cifCliente;
		} else {
			document.getElementById("cif").value = objeto_json.cliente.nifCliente;
		}
		document.getElementById("calle").value = objeto_json.cliente.calleCliente;
		document.getElementById("ciudad").value = objeto_json.cliente.ciudadCliente;
		document.getElementById("provincia").value = objeto_json.cliente.provinciaCliente;
		document.getElementById("email").value = objeto_json.cliente.emailCliente;
		document.getElementById("cod_postal").value = objeto_json.cliente.cpCliente;
		if (objeto_json.cliente.error_cliente != null) {
			document.getElementById("error_cliente").innerHTML = objeto_json.cliente.error_cliente;
			cerrar_mensaje(true);
		}
		// CARGAMOS LA FORMAS DE PAGO DE LOS CLIENTES
		establecer_FormasPago(objeto_json.formasPagoClientes);
	} else {
		document.getElementById("error_cliente").innerHTML = objeto_json.error_cliente;
		cerrar_mensaje(true);
		limpiar_cabecera();
	}
}
/**
 * CALCULAMOS DINAMICAMENTE LOS VALORES DE LA URL DE LA PETICION A REALIZAR.
 * 
 * 1 CONSULTA DE CLIENTES. 2 Actualizacion de Stock.
 * 
 * @param {Object}
 *            tipo_peticion VALOR NUMERICO QUE INDICARA LA PETICION A REALIZAR
 * @return {TypeName} URL CREADA PARA LA PETICION A FALTA DE PARAMETROS
 */
function crear_URL(tipo_peticion) {
	// VALORES DE LA URL.
	var puerto_servidor = location.port;
	var servidor_web = location.hostname;
	var aplicacion = location.pathname;
	// AL NO SER LA PRIMERA PETICION ELIMINAMOS EL SERVLET ANTERIOR
	aplicacion = aplicacion.substring(0, aplicacion.indexOf("/", 1)) + "/";
	var url_pattern = "Controlar_PedidoAJAX";
	// VALORES DEL TIPO PETICION
	/** comprobar el cliente (cabecera) */
	var com_cliente = "consulta_cliente";
	var com_articulos = "actualiza_articulos";
	var com_clientesayuda = "consulta_clientesayuda";
	var url_peticion = "http://" + servidor_web + ":" + puerto_servidor
			+ aplicacion + url_pattern + "?tipo_operacion=";
	if (tipo_peticion == 1) {
		url_peticion = url_peticion + com_cliente;
	}
	if (tipo_peticion == 2) {
		url_peticion = url_peticion + com_articulos;
	}
	if (tipo_peticion == 3) {
		url_peticion = url_peticion + com_clientesayuda;
	}
	return url_peticion;
}

// ************* FUNCIONES DE LOS DATOS DE LA CABECERA ***************
/**
 * Controla la visibilidad de la capa de ayuda de cliente.
 * 
 * @param {Object}
 *            visibilidad Si vale true se muestra la ventana de ayuda y si vale
 *            false se oculta.
 */
function mostrar_ayuda(visibilidad) {
	var capa_amostrar = document.getElementById("capa_lista_clientes");
	var capa_amostrar_botones = document.getElementById("capa_cabecera_lista");
	var capa_amostrar_cabecera = document.getElementById("capa_botones");
	var codigo_cliente = document.getElementById("cod_cliente");
	var nombre_cliente = document.getElementById("nombre_cliente");
	var boton_submit = document.getElementById("boton_confirmar");
	if (visibilidad) {
		capa_amostrar.style.visibility = "visible";
		capa_amostrar_botones.style.visibility = "visible";
		capa_amostrar_cabecera.style.visibility = "visible";
		codigo_cliente.disabled = "disabled";
		nombre_cliente.disabled = "disabled";
		boton_submit.disabled = "disabled";
	} else {
		capa_amostrar.style.visibility = "hidden";
		capa_amostrar_botones.style.visibility = "hidden";
		capa_amostrar_cabecera.style.visibility = "hidden";
		codigo_cliente.disabled = "";
		nombre_cliente.disabled = "";
		boton_submit.disabled = "";
	}
}
/**
 * funcion que realiza el trabajo de limpiar el formulario en caso de error en
 * la consulta
 */
function limpiar_cabecera() {
	document.getElementById("cod_cliente").value = "";
	document.getElementById("nombre_cliente").value = "";
	document.getElementById("telefono").value = "";
	document.getElementById("cif").value = "";
	document.getElementById("calle").value = "";
	document.getElementById("ciudad").value = "";
	document.getElementById("provincia").value = "";
	document.getElementById("email").value = "";
	document.getElementById("cod_postal").value = "";
}
// **************** FIN FUNCIONES DE LA VENTANA DE MENSAJES **************
// **************** FUNCIONES DE LA VENTANA DE MENSAJES **************
/**
 * Cierra/muestra la ventana de mensajes true muestra false cierra
 * 
 * @param {Object}
 *            modo booleano para indicar la accion a realizar
 */
function cerrar_mensaje(modo) {
	var capa_error = document.getElementById("capa_error_cliente");
	if (modo) {
		capa_error.style.visibility = "visible";
	} else {
		capa_error.style.visibility = "hidden";
	}
}

// **************** FIN FUNCIONES DE LA VENTANA DE MENSAJES **************

// ********* FUNCIONES DE LA VENTANA DE AYUDA ********************
/**
 * comprueba si hay otro check seleccionado anteriormente y lo deselecciona para
 * que solo se puede tener seleccionado uno
 * 
 * @param {Object}
 *            check_seleccionado Checkbox seleccionado por el usuario.
 */
function comprobar_seleccion(check_seleccionado) {
	var clientes = document.getElementsByTagName("input");
	for (var i = 1; i <= clientes.length; i++) {
		var nombre_cli = "cli" + i;
		if (nombre_cli != check_seleccionado.id) {
			var elemento = document.getElementById(nombre_cli);
			if (elemento.checked) {
				elemento.checked = false;
			}
		}
	}
}
/**
 * comprueba el cliente seleccionado y pasa los valores a los campos del
 * formulario de la parte superior del pedido falta implementar la peticion AJAX
 * para el resto de la informacion del cliente
 */
function tratar_seleccion_cliente() {
	mostrar_ayuda(false);
	var clientes = document.getElementsByName("checkito");
	for (var i = 1; i <= clientes.length; i++) {
		var nombre_cli = "cli" + i;
		var cod_cli = "cod" + i;
		var nom_cli = "nom" + i;
		var elemento = document.getElementById(nombre_cli);
		if (elemento.checked) {
			document.getElementById("cod_cliente").value = document
					.getElementById(cod_cli).value;
			document.getElementById("nombre_cliente").value = document
					.getElementById(nom_cli).value;
			elemento.checked = false;
			actualizar_cli_ajax(document.getElementById("cod_cliente").value);
		}
	}
}

/**
 * Accion de salir de la ayuda sin seleccionar nada, por lo tanto anulamos la
 * posible seleccion echa por el usuario
 */
function anular_seleccion_cliente() {
	var clientes = document.getElementsByName("checkito");
	for (var i = 1; i <= clientes.length; i++) {
		nombre_cli = "cli" + i;
		document.getElementById(nombre_cli).checked = false;
	}
	mostrar_ayuda(false);
}

// ************* FIN FUNCIONES DE LA VENTANA DE AYUDA *******************
// ************** FUNCIONES DE VALIDACION DE FORMULARIO ******************
/**
 * FUNCION DE ALTO NIVEL PARA VALIDAR LOS CAMPOS OBLIGATARIOS DE LA CABECERA DEL
 * FORMULARIO DE PEDIDOS
 * 
 * @return BOOLEANO QUE INDICA EL PASO O NO DE LA VALIDACION.
 */
function validar_formu() {
	var valido = true;
	var campo1 = document.getElementById("cod_cliente");
	var campo2 = document.getElementById("nombre_cliente");
	if (campo_vacio(campo1) && campo_vacio(campo2)) {
		valido = false;
		alert("Uno de los dos campos son obligatorios para realizar la consulta de los datos del cliente.");
	}
	return valido;
}
/**
 * FUNCION DE BAJO NIVEL PARA COMPROBAR SI EL CAMPO TIENE O NO CONTENIDO SERA
 * REUTILIZADA POR TODOS LAS FUNCIONES DE ALTO NIVEL DE VALIDACION
 * 
 * @param campo
 *            CAMPO A COMPROBAR
 * @return BOOLEANO QUE INDICA CORRECTO O NO.
 */
function campo_vacio(campo) {
	if (campo.value == "") {
		return true;
	} else {
		return false;
	}
}
// ************** FIN FUNCIONES DE VALIDACION DE FORMULARIO ******************

