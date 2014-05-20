package com.atrium.managedbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_Municipios;
import com.atrium.hibernate.modelo.IGestion_Pais;
import com.atrium.hibernate.modelo.IGestion_Provincias;
import com.atrium.spring.Acceso_ApplicationContext;

public class Listas_Bean implements Comparator<Pais> {
	// PROPIEDADES PARA LOS VALORES SELECCIONADOS
	private String pais_selecionado;
	private String provincia_seleccionada;
	private String municipio_seleccionado;

	// COLECCIONES PARA LOS CONTENIDOS DINAMICOS DE LOS COMBOS
	private List<SelectItem> lista_paises;
	private List<SelectItem> lista_provincias;
	private List<SelectItem> lista_municipios;

	/**
	 * Constructor con valores iniciales de propiedades.
	 */
	public Listas_Bean() {
		// CARGA DINAMICA DE PAISES
		lista_paises = new ArrayList<>();
		IGestion_Pais gestion_pais = Acceso_ApplicationContext
				.getBean(IGestion_Pais.class);
		List<Pais> lista = gestion_pais.consultar_Todos();
		Collections.sort(lista, this);
		SelectItem opcion;
		for (Pais pais : lista) {
			opcion = new SelectItem();
			opcion.setLabel(pais.getPaisNombre());
			opcion.setValue(pais.getCodigoPais());
			lista_paises.add(opcion);
		}
		// VALOR INICIAL PARA PROVINCIAS
		opcion = new SelectItem();
		opcion.setLabel("Seleccione un pais");
		opcion.setValue(0);
		lista_provincias = new ArrayList<>();
		lista_provincias.add(opcion);
		// VALOR INICIAL DE MUNICIPIOS
		lista_municipios = new ArrayList<>();
		opcion = new SelectItem();
		opcion.setLabel("Seleccione una provincia");
		opcion.setValue(0);
		lista_municipios.add(opcion);
	}

	/**
	 * Tratamiento de evento de paises.
	 * 
	 * @param evento
	 */
	public void tratar_Pais(ValueChangeEvent evento) {
		String pais_seleccionado = (String) evento.getNewValue();
		lista_provincias.clear();
		SelectItem opcion;
		if (pais_seleccionado.equals("73")) {
			// EL PAIS SELECCIONADO ES ESPAÑA
			IGestion_Provincias gestion_provincia = Acceso_ApplicationContext
					.getBean(IGestion_Provincias.class);
			List<Provincias> lista = gestion_provincia.consultar_Todas();
			for (Provincias provi : lista) {
				opcion = new SelectItem();
				opcion.setLabel(provi.getProvincia());
				opcion.setValue(provi.getCodigoProvincia());
				lista_provincias.add(opcion);
			}
		} else {
			// EL PAIS SELECCIONADO NO ES ESPAÑA
			opcion = new SelectItem();
			opcion.setLabel("Seleccione un pais");
			opcion.setValue(0);
			lista_provincias.add(opcion);
			// INICIO MUNICIPIOS
			lista_municipios.clear();
			opcion = new SelectItem();
			opcion.setLabel("Seleccione una provincia");
			opcion.setValue(0);
			lista_municipios.add(opcion);
		}
	}

	/**
	 * Tratamiento de evento de provincias.
	 * 
	 * @param evento
	 */
	public void cargar_Municipios(ValueChangeEvent evento) {
		String provincia_seleccionada = (String) evento.getNewValue();
		IGestion_Municipios gestion_municipio = Acceso_ApplicationContext
				.getBean(IGestion_Municipios.class);
		List<Municipios> lista = gestion_municipio
				.consultar_PorProvincia(new Byte(provincia_seleccionada));
		lista_municipios.clear();
		SelectItem opcion;
		for (Municipios muni : lista) {
			opcion = new SelectItem();
			opcion.setLabel(muni.getMunicipio());
			opcion.setValue(muni.getId().getCodigoMunicipio());
			lista_municipios.add(opcion);
		}
	}

	@Override
	public int compare(Pais pais1, Pais pais2) {
		return pais1.getPaisNombre().compareTo(pais2.getPaisNombre());
	}

	// ACCESORES PARA JSF
	public String getPais_selecionado() {
		return pais_selecionado;
	}

	public void setPais_selecionado(String pais_selecionado) {
		this.pais_selecionado = pais_selecionado;
	}

	public List<SelectItem> getLista_paises() {
		return lista_paises;
	}

	public void setLista_paises(List<SelectItem> lista_paises) {
		this.lista_paises = lista_paises;
	}

	public String getProvincia_seleccionada() {
		return provincia_seleccionada;
	}

	public void setProvincia_seleccionada(String provincia_seleccionada) {
		this.provincia_seleccionada = provincia_seleccionada;
	}

	public List<SelectItem> getLista_provincias() {
		return lista_provincias;
	}

	public void setLista_provincias(List<SelectItem> lista_provincias) {
		this.lista_provincias = lista_provincias;
	}

	public String getMunicipio_seleccionado() {
		return municipio_seleccionado;
	}

	public void setMunicipio_seleccionado(String municipio_seleccionado) {
		this.municipio_seleccionado = municipio_seleccionado;
	}

	public List<SelectItem> getLista_municipios() {
		return lista_municipios;
	}

	public void setLista_municipios(List<SelectItem> lista_municipios) {
		this.lista_municipios = lista_municipios;
	}

}
