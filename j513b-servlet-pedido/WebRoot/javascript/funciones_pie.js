/**
 * Proceso de calculo del pie del pedido incompleto.
 */
function calcular_total_pie() {

	var totales_linea = document.getElementsByName("total");
	var tam = totales_linea.length;
	var total_bruto = 0;
	for ( var i = 0; i < tam; i++) {
		if (totales_linea[i].value != "") {
			total_bruto = total_bruto + parseInt(totales_linea[i].value);
		}
	}
	document.getElementById("total_bruto_pie").value = total_bruto;
}
/**
 * Proceso de calculo de los vencimientos del pedido.
 */
function calcular_Pagos() {

}

function establecer_FormasPago(formas_pagocliente) {
	var lista_formas_pago = document.getElementById("formas_pago");
	// VACIAMOS LA LISTA
	lista_formas_pago.options = null;
	if (formas_pagocliente == null) {
		lista_formas_pago.options[0] = new Option("No tiene formas de pago",
				null);
	}

}