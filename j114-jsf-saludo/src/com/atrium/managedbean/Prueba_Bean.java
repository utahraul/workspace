package com.atrium.managedbean;

public class Prueba_Bean {
	private String texto_saludo;

	public Prueba_Bean() {
		texto_saludo = "hola mundo JSF2";
	}

	// ACCESORES PARA JSF
	public String getTexto_saludo() {
		return texto_saludo;
	}

	public void setTexto_saludo(String texto_saludo) {
		this.texto_saludo = texto_saludo;
	}

}
