package com.atrium.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colecciones {

	private List<Integer> lista;

	public Colecciones() {
		lista = new ArrayList<Integer>();
	}

	public void cargar_Lista(Integer numero_nuevo) {
		lista.add(numero_nuevo);

	}

	public Integer ordenar_Lista() {
		Collections.sort(lista);
		return null;
	}

	public Integer coger_Menor() {
		Integer salida=null;
		if(!lista.isEmpty()){
			salida=lista.get(0);
		}
		return salida;
	}

	public Integer coger_Mayor() {
		return lista.get(lista.size() - 1);
	}

	public Integer calcular_Media() {
		int total = 0;
		for (Integer numero : lista) {
			total = total + numero.intValue();
		}
		int numero_elementos = lista.size() - 1;
		Integer media = new Integer(total / numero_elementos);
		return media;
	}
	
	public void vaciar_Lista(){
		lista.clear();
	}
}
