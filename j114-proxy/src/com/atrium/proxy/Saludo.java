package com.atrium.proxy;

public class Saludo implements ISaludo {

	public String saludo() {
		System.out.println("hola");
		return "Hola";
	}

	public String otro_Saludo(String texto) {
		System.out.println("Holita " + texto);
		return "Holita " + texto;
	}
}
