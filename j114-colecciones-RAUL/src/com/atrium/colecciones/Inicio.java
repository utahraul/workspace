package com.atrium.colecciones;

public class Inicio {

	public static void main(String[] args) {
		Colecciones coleccion = new Colecciones();
		coleccion.cargar_Lista();
		coleccion.ordenar_Lista();
		Integer menor = coleccion.coger_Menor();
		Integer mayor = coleccion.coger_Mayor();
		Integer media = coleccion.calcular_Media();
		System.out.println("");
	}

}
