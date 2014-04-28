package com.atrium.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inicio {

	public static void main(String[] args) {
		// SE CREA UNA NUEVA LISTA 
		List lista = new ArrayList();
		// SE AÑADEN LOS ELEMENTOS
		lista.add(55);
		lista.add(440);
		lista.add(3982);
		lista.add(20);
		lista.add(1);
		// SE ORDENAN LOS ELEMENTOS Y SE MUESTRAN POR CONSOLA
		Collections.sort(lista);
		for (Object integer : lista) {
			System.out.println(integer);
		}

	}

}
