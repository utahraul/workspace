package com.atrium.controlador;

public class Inicio2 {

	public static void main(String[] args) {

		OrdenaLista listaordenada = new OrdenaLista();
		listaordenada.cargar_Lista();
		listaordenada.ordenar_Lista();
		listaordenada.coger_Mayor();
		listaordenada.coger_Menor();
		Integer media = listaordenada.calcular_Media();

		System.out.println("");
	}

}
