package com.atrium.formbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.modelo.IGestion_Pais;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Objeto_Combo;

public class Listas_Bean extends ActionForm implements Comparator<Objeto_Combo> {
	// PAIS SELECCIONADO POR EL USUARIO
	private String pais_seleccionado;
	// PROVINCIA SELECCIONADA
	private String provincia_seleccionada;
	// MUNICIPIOS SELECCIONADO POR EL USUARIO
	private String municipio_seleccionado;

	// CONTENIDO DEL COMBO PAIS
	private List<Objeto_Combo> lista_paises;
	// CONTENIDO DEL COMBO PROVINCIAS
	private List<Objeto_Combo> lista_provincias;
	// CONTENIDO DEL COMBO MUNICIPIOS
	private List<Objeto_Combo> lista_municipios;

	public Listas_Bean() {
		// CARGA DINAMICA DE COMBO DE PAIS
		lista_paises = new ArrayList<>();
		IGestion_Pais gestion_pais = Acceso_ApplicationContext
				.getBean(IGestion_Pais.class);
		List<Pais> lista = gestion_pais.consultar_Todos();
		Objeto_Combo opcion = null;
		for (Pais pais : lista) {
			opcion = new Objeto_Combo();
			opcion.setTexto(pais.getPaisNombre());
			opcion.setValue(String.valueOf(pais.getCodigoPais()));
			lista_paises.add(opcion);
		}
		Collections.sort(lista_paises, this);
		// VALOR INICIAL DEL COMBO PROVINCIAS
		lista_provincias = new ArrayList<>();
		opcion = new Objeto_Combo();
		opcion.setTexto("Seleccione previamente un pais");
		opcion.setValue("0");
		lista_provincias.add(opcion);
		// VALOR INICIAL DEL COMBO PROVINCIAS
		lista_municipios = new ArrayList<>();
		opcion = new Objeto_Combo();
		opcion.setTexto("Seleccione previamente una provincia");
		opcion.setValue("0");
		lista_municipios.add(opcion);

	}

	/**
	 * Ordenacion de los paises a mostrar en el combo de la pagina.
	 */
	@Override
	public int compare(Objeto_Combo combo1, Objeto_Combo combo2) {
		int orden = combo1.getTexto().compareTo(combo2.getTexto());
		return orden;
	}

	// ACCESORES PARA STRUT
	public List<Objeto_Combo> getLista_paises() {
		return lista_paises;
	}

	public void setLista_paises(List<Objeto_Combo> lista_paises) {
		this.lista_paises = lista_paises;
	}

	public String getPais_seleccionado() {
		return pais_seleccionado;
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}

	public String getProvincia_seleccionada() {
		return provincia_seleccionada;
	}

	public void setProvincia_seleccionada(String provincia_seleccionada) {
		this.provincia_seleccionada = provincia_seleccionada;
	}

	public List<Objeto_Combo> getLista_provincias() {
		return lista_provincias;
	}

	public void setLista_provincias(List<Objeto_Combo> lista_provincias) {
		this.lista_provincias = lista_provincias;
	}

	public String getMunicipio_seleccionado() {
		return municipio_seleccionado;
	}

	public void setMunicipio_seleccionado(String municipio_seleccionado) {
		this.municipio_seleccionado = municipio_seleccionado;
	}

	public List<Objeto_Combo> getLista_municipios() {
		return lista_municipios;
	}

	public void setLista_municipios(List<Objeto_Combo> lista_municipios) {
		this.lista_municipios = lista_municipios;
	}

}
