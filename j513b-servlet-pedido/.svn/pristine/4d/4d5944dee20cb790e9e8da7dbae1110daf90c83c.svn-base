// ******** FUNCIONES PARA LAS PETICIONES AJAX **********

var peticion_http_articulo;
/**
 * Funcion para realizar una peticion AJAX al servidor de articulos
 * 
 * @param peticion
 * @param funcion
 */
function actualizar_art_ajax(peticion, funcion) {
	if (window.XMLHttpRequest) {
		peticion_http_articulo = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_http_articulo = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// Preparar la funcion de respuesta
	peticion_http_articulo.onreadystatechange = muestraContenido;
	// Realizar peticion HTTP
	var url_peticion = crear_URL(2);
	peticion_http_articulo.open('GET', url_peticion, true);
	peticion_http_articulo.send(null);
}

/**
 * Lanza el procesamiento de la peticion de los articulos
 */
function muestraContenido() {
	if (peticion_http_articulo.readyState == 4) {
		if (peticion_http_articulo.status == 200) {
			cargar_nuevas_unidades(peticion_http_articulo.responseText);
		}
	}
}

/**
 * Comprobamos el numero de articulos llegados en la respuesta con los que estan
 * ya en la pagina. <br/>Si son el mismo numero procesamos. Se busca el articulo
 * con el mismo codigo y se comprueba si ha cambiado de valor el stock. <br/>En
 * caso afirmativo se pone el nuevo numero y se cambia de color.
 * 
 * @param {Object}
 *            lista_articulos
 * @return {TypeName}
 */
function cargar_nuevas_unidades(lista_articulos) {
	alert(lista_articulos);
	var objeto_respuesta = eval('({tabla_articulos:' + lista_articulos + '})');
	var numero_articulos = objeto_respuesta.tabla_articulos.length;
	// tratamiento real
	var lista_art_ayuda = document.getElementsByName("codigo_articulo");
	var tam_artayuda = lista_art_ayuda.length;
	if ((numero_articulos) != tam_artayuda) {
		alert("No se pueden actualizar las unidades de los articulos.Problemas de sincronia ");
	} else {
		for (i = 0; i < numero_articulos; i++) {
			codigo_articulorespuesta = objeto_respuesta.tabla_articulos[i].codigoArticulo;
			for (ii = 0; ii < tam_artayuda; ii++) {
				if (lista_art_ayuda[ii].value == codigo_articulorespuesta) {
					stock_actual = document.getElementById("num_art" + ii).value;
					if (stock_actual != objeto_respuesta.tabla_articulos[i].cantidad) {
						document.getElementById("num_art" + ii).value = objeto_respuesta.tabla_articulos[i].cantidad;
						document.getElementById("num_art" + ii).style.color = "red";
					}
				}
			}
		}
	}
}

// ******** FIN FUNCIONES PARA LAS PETICIONES AJAX **********

// ******** FUNCIONES DE OPERATIVA DEL PEDIDO *******************

/**
 * Oculta muestra las capas con la informacion de los pedidos
 * 
 * @param {Object}
 *            mostrar
 */
function mostrar_articulos(mostrar) {
	var cab = document.getElementById("capa_cabecera_articulos");
	var cuerpo = document.getElementById("capa_articulos");
	var botones = document.getElementById("capa_botones_articulos");
	if (mostrar) {
		cab.style.visibility = "visible";
		cuerpo.style.visibility = "visible";
		botones.style.visibility = "visible";
	} else {
		cab.style.visibility = "hidden";
		cuerpo.style.visibility = "hidden";
		botones.style.visibility = "hidden";
	}
}
/**
 * Calculamos la fecha del dia y se lo ponemois al campo fecha del pedido.
 */
function fecha_pedido() {
	var fecha = new Date();
	document.getElementById("fe_pedido").value = fecha.getDate() + "/"
			+ (fecha.getMonth() + 1) + "/" + fecha.getFullYear();
}

/**
 * Cargara los articulos seleccionados en el cuerpo del pedido
 */
function actualizar_pedido(tabla_pedido) {
	mostrar_articulos(false);
	var articulos = document.getElementsByName("check_art");
	var penultima_linea = tabla_pedido.rows.length - 1;
	for ( var i = 0; i <= articulos.length; i++) {
		var elemento_check = "check_art" + i;
		var selecionado = document.getElementById(elemento_check);
		if (selecionado.checked) {
			selecionado.checked = null;
			document.getElementById(elemento_check).setAttribute("disabled",
					"disabled");
			document.getElementById("codigo_" + penultima_linea).value = document
					.getElementById("cod_" + i).value;
			document.getElementById("descripcion_" + penultima_linea).value = document
					.getElementById("des" + i).value;
			document.getElementById("p_unidad_" + penultima_linea).value = document
					.getElementById("pre" + i).value;
			filaNueva(tabla_pedido);
			penultima_linea = penultima_linea + 1;
		}
	}
}

/**
 * Calculo de los totales de linea. Ademas llama al calculo de total de pedido.
 * 
 * @param celda
 *            Celda en la que se ha introducido el valor.
 */
function calcular_total(celda) {
	var nombre_celda = document.getElementById(celda.id);
	var tipo_celda = nombre_celda.id.substring(0, nombre_celda.id.indexOf('_'));
	var numero_celda = nombre_celda.id.substring(nombre_celda.id
			.lastIndexOf('_') + 1);
	var unidades = document.getElementById(("unidades_" + numero_celda));
	var precio_unidad = document.getElementById(("p_unidad_" + numero_celda));
	var descuento = document.getElementById(("descuento_" + numero_celda));
	var total_pedido = document.getElementById(("total_" + numero_celda));
	var total_articulo = 0;
	// calculamos el total sin descuento
	if (precio_unidad.value != "" && unidades.value != "") {
		total_articulo = precio_unidad.value * unidades.value;
		total_pedido.value = total_articulo;
	}
	// se le aplica el descuento si lo hay
	if (descuento.value != "") {
		total_articulo = total_articulo * (1 - (descuento.value / 100));
		total_pedido.value = total_articulo;
	}
	// actualizamos el total general del pedido
	calcular_total_pie();
}

// *********** FUNCIONES DE TRATAMIENTO DE LA TABLA DEL PEDIDO

function inicio_tabla() {
	document.getElementById("tabla_pedido").rows[0].ondblclick = resaltar_fila_seleccionada;
}

/**
 * VARIABLE GLOBAL PARA CONTROLAR LA FILA SELECCIONADA
 * 
 * @memberOf {TypeName}
 */
var fila_seleccionada = null;
/**
 * establecemos la forma de saber la fila seleccionada
 */
function resaltar_fila_seleccionada() {
	if (fila_seleccionada == this) {
		this.style.backgroundColor = "transparent";
		fila_seleccionada = null;
	} else {
		if (fila_seleccionada == null) {
			this.style.backgroundColor = "#e0b";
			fila_seleccionada = this
		}
	}
}
/**
 * elimina de la tabla la fila previamente seleccionada
 * 
 * @param tabla_pedido
 */
function quitarFila(tabla_pedido) {
	if (fila_seleccionada == null) {
		alert("es necesario tener una fila seleccionada para poder usar la opcion de borrar");
	} else {
		fila_seleccionada.parentNode.removeChild(fila_seleccionada);
		fila_seleccionada = null;
	}
}
/**
 * añadir una fila nueva programaticamente a una tabla. En este caso al cuerpo
 * de pedidos
 */
function filaNueva(tabla_pedido) {
	if (tabla_pedido == null) {
		tabla_pedido = document.getElementById("tabla_pedido");
	}
	// añadimos una fila nueva a la tabla en ultimo lugar
	var ultimo_elemento = tabla_pedido.rows.length;
	var posicion = ultimo_elemento - 1;
	var row = tabla_pedido.insertRow(posicion);
	posicion++;
	// creamos celda codigo pedido
	var celda_nueva = row.insertCell(0);
	var elemento_texto = document.createElement('input');
	elemento_texto.setAttribute("value", "");
	elemento_texto.type = "text";
	elemento_texto.name = "codigo";
	elemento_texto.id = "codigo" + posicion;
	elemento_texto.setAttribute("id", "codigo_" + posicion);
	elemento_texto.style.width = "60px";
	elemento_texto.style.textAlign = "right";
	celda_nueva.appendChild(elemento_texto);
	elemento_texto.focus();

	// celda descripcion de producto
	var celda_nueva = row.insertCell(1);
	var elemento_texto = document.createElement('input');
	elemento_texto.type = 'text';
	elemento_texto.name = 'descripcion' + posicion;
	elemento_texto.id = 'descripcion_' + posicion;
	elemento_texto.style.width = "375px";
	celda_nueva.appendChild(elemento_texto);

	// celda precio unidad
	var celda_nueva = row.insertCell(2);
	var elemento_texto = document.createElement('input');
	elemento_texto.type = 'text';
	elemento_texto.name = 'p_unidad' + posicion;
	elemento_texto.id = 'p_unidad_' + posicion;
	elemento_texto.style.width = "120px";
	elemento_texto.style.textAlign = "right";
	elemento_texto.onchange = new Function('calcular_total(this)');
	celda_nueva.appendChild(elemento_texto);

	// celda unidades
	var celda_nueva = row.insertCell(3);
	var elemento_texto = document.createElement('input');
	elemento_texto.type = 'text';
	elemento_texto.name = 'unidades' + posicion;
	elemento_texto.id = 'unidades_' + posicion;
	elemento_texto.style.width = "80px";
	elemento_texto.style.textAlign = "right";
	elemento_texto.onchange = new Function('calcular_total(this)');
	celda_nueva.appendChild(elemento_texto);

	// celda descuento
	var celda_nueva = row.insertCell(4);
	var elemento_texto = document.createElement('input');
	elemento_texto.type = 'text';
	elemento_texto.name = 'descuento' + posicion;
	elemento_texto.id = 'descuento_' + posicion;
	elemento_texto.style.width = "80px";
	elemento_texto.style.textAlign = "right";
	elemento_texto.onchange = new Function('calcular_total(this)');
	celda_nueva.appendChild(elemento_texto);

	// celda total
	var celda_nueva = row.insertCell(5);
	var elemento_texto = document.createElement('input');
	elemento_texto.type = 'text';
	elemento_texto.name = 'total';
	elemento_texto.id = 'total_' + posicion;
	elemento_texto.style.width = "120px";
	elemento_texto.style.textAlign = "right";
	elemento_texto.readOnly = "readonly";
	celda_nueva.appendChild(elemento_texto);

	// volvemos a aplicar el evento de resalte de fila
	row.ondblclick = resaltar_fila_seleccionada;
	if (posicion == 1) {
		// alert("existe " + tabla_pedido.getRow(1));
		tabla_pedido.getRow(1).ondblclick = resaltar_fila_seleccionada;
	}
}