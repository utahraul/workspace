package com.atrium.logica;

public class Prueba_Spring implements IPrueba_Texto {

	private String texto;
	private IPrueba_Texto otra_prueba;
	private String prueba_nopasanada;

	public Prueba_Spring() {
	}

	public Prueba_Spring(String texto) {
		this.texto = texto;
	}

	public Prueba_Spring(IPrueba_Texto prueba_texto) {
		otra_prueba = prueba_texto;
	}

	@Override
	public String mostrar_Texto() {
		return "Hola mundo SPRing";
	}

	@Override
	public String mostrar_MasTexto(String otro_texto) {
		return "Hola ...... " + otro_texto;
	}

	// ACCESORES PARA SPRING
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setOtra_prueba(IPrueba_Texto otra_prueba) {
		this.otra_prueba = otra_prueba;
	}

}
