package com.atrium.modelo;

/**
 * Transporte de datos de pais.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 * @since 13-3-2014
 * 
 */
public class Pais {

	// PROPIEDADES DE CLASE
	private Integer codigopais;
	private Integer paisisonum;
	private String paisiso2;
	private String paisiso3;
	private String paisnombre;

	// METODOS ACCESORES
	public Integer getCodigopais() {
		return codigopais;
	}

	public void setCodigopais(Integer codigopais) {
		this.codigopais = codigopais;
	}

	public Integer getPaisisonum() {
		return paisisonum;
	}

	public void setPaisisonum(Integer paisisonum) {
		this.paisisonum = paisisonum;
	}

	public String getPaisiso2() {
		return paisiso2;
	}

	public void setPaisiso2(String paisiso2) {
		this.paisiso2 = paisiso2;
	}

	public String getPaisiso() {
		return paisiso3;
	}

	public void setPaisiso3(String paisiso3) {
		this.paisiso3 = paisiso3;
	}

	public String getPaisnombre() {
		return paisnombre;
	}

	public void setPaisnombre(String paisnombre) {
		this.paisnombre = paisnombre;
	}

}
