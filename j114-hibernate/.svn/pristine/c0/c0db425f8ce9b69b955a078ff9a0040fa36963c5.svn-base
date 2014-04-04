package com.atrium.comtrolador;

import java.util.List;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.modelo.Gestion_Pais;

public class Inicio {

	public static void main(String[] args) {
		Gestion_Pais gestion_pais = new Gestion_Pais();

		Pais pais = gestion_pais.consultar_PorCodigo(new Long(73));

		List<Pais> lista = gestion_pais.consultar_Todos();

		Pais pais_nuevo = new Pais();
		pais_nuevo.setCodigoPais(new Long(999));
		pais_nuevo.setPaisNombre("j114");
		
		gestion_pais.alta_Pais(pais_nuevo);
		
		pais_nuevo.setPaisNombre("otro nombre");
		
		gestion_pais.modificacion_Pais(pais_nuevo);
		
		gestion_pais.baja_Pais(pais_nuevo);
		
		System.out.println("");
	}

}
