package com.atrium.modelo;

public class Modelo {

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public boolean equals(Object obj) {
		boolean igual;
		Modelo otro_modelo = (Modelo) obj;
		if (otro_modelo.getTexto().equals(this.getTexto())) {
			igual = true;
		} else {
			igual = false;
		}
		return igual;
	}
	
	public boolean equals(Modelo obj) {
		boolean igual;
		if (obj.getTexto().equals(this.getTexto())) {
			igual = true;
		} else {
			igual = false;
		}
		return igual;
	}
}






