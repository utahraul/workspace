package com.atrium.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenaLista {

	private List<Integer> lista;

	public OrdenaLista() {
		lista = new ArrayList<Integer>();
	}

	public void cargar_Lista() {
		lista.add(55);
		lista.add(440);
		lista.add(3982);
		lista.add(20);
		lista.add(1);
	}

	public void ordenar_Lista() {
		Collections.sort(lista);

	}

	public Integer coger_Menor() {
		return lista.get(0);
	}

	public Integer coger_Mayor() {
		return lista.get(4);
	}
	
	public Integer calcular_Media() {
		int total= 0;
		for(Integer numero:lista){
			total=total+numero.intValue();
		}
		
		Integer media=new Integer(total/5);
		return media;
		
	}
	
}
