var peticion_http;
// ************ FUNCIONES PARA LA PETICION DE MUNICIPIOS ************
/**
 * Funcion para realizar la peticon de provincias al servidor.
 */
function actualizar_provincias() {
	if (window.XMLHttpRequest) {
		peticion_http = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// Preparar la funcion de respuesta
	peticion_http.onreadystatechange = respuesta_provincias;
	// Realizar peticion HTTP
	paises = document.getElementsByName("pais_seleccionado")[0];
	var pais_seleccionado = paises.options[paises.selectedIndex].value;
	peticion_http.open('GET', crear_URL(1) + "&pais_seleccionado="
			+ pais_seleccionado, true);
	peticion_http.send(null);
}

/**
 * Funcion que recoge la respuesta mandada por el servidor.
 */
function respuesta_provincias() {
	if (peticion_http.readyState == 4) {
		if (peticion_http.status == 200) {
			cargar_Provincias(peticion_http.responseText);
		}
	}
}

/**
 * Funcion para actualizar la pagina con la respuesta del servidor.
 * 
 * @param datos_provincias
 */
function cargar_Provincias(datos_provincias) {
	var texto_aconvertir = "{'provincias':" + datos_provincias + "}";
	var objeto_respuesta = eval('(' + texto_aconvertir + ')');
	var lista_pro = document.getElementsByName("provincia_seleccionada")[0];
	lista_pro.options.length = 0;
	var posiciones = objeto_respuesta.provincias.length;
	for (i = 0; i < posiciones; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_respuesta.provincias[i].provincia);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_respuesta.provincias[i].codigoProvincia;
		lista_pro.appendChild(opcion);
	}
}
// ************ FIN FUNCIONES PARA LA PETICION DE MUNICIPIOS ************

// ************ FUNCIONES PARA LA PETICION DE MUNICIPIOS ************

/**
 * Funcion para realizar la peticon de provincias al servidor.
 */
function actualizar_municipios() {
	if (window.XMLHttpRequest) {
		peticion_http = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// Preparar la funcion de respuesta
	peticion_http.onreadystatechange = respuesta_municipios;
	// Realizar peticion HTTP
	provincias = document.getElementsByName("provincia_seleccionada")[0];
	var provincia_seleccionada = provincias.options[provincias.selectedIndex].value;
	peticion_http.open('GET', crear_URL(2) + "&provincia_seleccionada="
			+ provincia_seleccionada, true);
	peticion_http.send(null);
}

/**
 * Funcion que recoge la respuesta mandada por el servidor.
 */
function respuesta_municipios() {
	if (peticion_http.readyState == 4) {
		if (peticion_http.status == 200) {
			cargar_municipios(peticion_http.responseText);
		}
	}
}

/**
 * Funcion para actualizar la pagina con la respuesta del servidor.
 * 
 * @param datos_provincias
 */
function cargar_municipios(datos_municipios) {
	alert(datos_municipios);
	var texto_aconvertir = "{'municipios':" + datos_municipios + "}";
	alert(texto_aconvertir);
	var objeto_respuesta = eval('(' + texto_aconvertir + ')');
	alert("Objeto navegador " + objeto_respuesta);
	var lista_pro = document.getElementsByName("municipio_seleccionado")[0];
	lista_pro.options.length = 0;
	var posiciones = objeto_respuesta.municipios.length;
	for (i = 0; i < posiciones; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_respuesta.municipios[i].municipio);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_respuesta.municipios[i].codigoMunicipio;
		lista_pro.appendChild(opcion);
	}
}
// ************ FIN FUNCIONES PARA LA PETICION DE MUNICIPIOS ************
/**
 * CALCULAMOS DINAMICAMENTE LOS VALORES DE LA URL DE LA PETICION A REALIZAR.
 * 
 * @return {TypeName} URL CREADA PARA LA PETICION A FALTA DE PARAMETROS
 */
function crear_URL(tipo_peticion) {
	// VALORES DE LA URL.
	var puerto_servidor = location.port;
	var servidor_web = location.hostname;
	var aplicacion = location.pathname;
	var valor_parametro;
	if (tipo_peticion == 1) {
		valor_parametro = "cargar_provincias";
	}
	if (tipo_peticion == 2) {
		valor_parametro = "cargar_municipios";
	}
	aplicacion = aplicacion.substring(0, aplicacion.lastIndexOf("/"));
	var url_pattern = "/listas_accion.do";
	var url_peticion = "http://" + servidor_web + ":" + puerto_servidor
			+ aplicacion + url_pattern + "?tipo_peticion=" + valor_parametro;
	return url_peticion;
}

function recibir_datoscliente() {
	if (peticion_ajax.readyState == 4) {
		if (peticion_ajax.status == 200) {
			if (tipo_ajax == "provincia") {
				cargar_datos_provincias(peticion_ajax.responseText);
			} else {
				cargar_datos_municipios(peticion_ajax.responseText);
			}
		}
	}
}

function cargar_datos_provincias(texto_respuesta) {
	var texto_aconvertir = "{'provincias':" + texto_respuesta + "}";
	var objeto_respuesta = eval('(' + texto_aconvertir + ')');
	var lista_pro = document.getElementById("lista_provincias");
	var posiciones = objeto_respuesta.provincias.length;
	for (i = 0; i < posiciones; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_respuesta.provincias[i].provincia);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_respuesta.provincias[i].codigoProvincia;
		lista_pro.appendChild(opcion);
	}
}

function cargar_datos_municipios(texto_respuesta) {
	eval(texto_respuesta);
	var texto_aconvertir = "{'municipios':" + texto_respuesta + "}";
	var objeto_respuesta = eval('(' + texto_aconvertir + ')');
	var lista_pro = document.getElementById("lista_municipios");
	var posiciones = objeto_respuesta.municipios.length;
	lista_pro.options.length = 0;
	for (i = 0; i < posiciones; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_respuesta.municipios[i].municipio);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_respuesta.municipios[i].id.codigoMunicipio;
		lista_pro.appendChild(opcion);
	}
}
