package com.atrium.controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.Provincias;
import com.atrium.modelo.IGestion_Municipios;
import com.atrium.modelo.IGestion_Pais;
import com.atrium.modelo.IGestion_Provincias;
import com.atrium.spring.Acceso_ApplicationContext;

public class Ventana extends JFrame implements ItemListener, IVentana {
	private JLabel eti_paises;
	private JComboBox combo_paises;
	private JLabel eti_provincias;
	private JComboBox combo_provincias;
	private JLabel eti_municipios;
	private JComboBox combo_municipios;

	public Ventana() {
		setBounds(100, 100, 500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}

	public void crear_Interface() {
		eti_paises = new JLabel("Paises");
		eti_paises.setBounds(10, 65, 58, 14);
		getContentPane().add(eti_paises);

		// ACCESO A LA CAPA MODELO
		IGestion_Pais gestion_pais = Acceso_ApplicationContext
				.getBean(IGestion_Pais.class);
		List<Pais> lista = gestion_pais.consultar_Todos();
		// TRATAMIENTO DE LA INFORMACION RECIBIDA
		String tabla_paises[] = new String[lista.size() + 1];
		tabla_paises[0] = "Seleccione un pais";
		int posicion = 1;
		for (Pais pais : lista) {
			// CARGAMOS LA INFORMACION EN LA TABLA
			tabla_paises[posicion] = pais.getPaisNombre() + " - "
					+ String.valueOf(pais.getCodigoPais());
			posicion++;
		}

		combo_paises = new JComboBox(tabla_paises);
		combo_paises.setBounds(68, 56, 146, 26);
		combo_paises.addItemListener(this);
		combo_paises.setName("combo_paises");
		// combo_paises.setSelectedIndex(-1);
		getContentPane().add(combo_paises);

		eti_provincias = new JLabel("Provincias");
		eti_provincias.setBounds(237, 64, 67, 16);
		getContentPane().add(eti_provincias);

		combo_provincias = new JComboBox();
		combo_provincias.setBounds(316, 59, 170, 26);
		getContentPane().add(combo_provincias);

		eti_municipios = new JLabel("Municipios");
		eti_municipios.setBounds(99, 130, 78, 16);
		getContentPane().add(eti_municipios);

		combo_municipios = new JComboBox();
		combo_municipios.setBounds(237, 125, 170, 26);
		getContentPane().add(combo_municipios);

		setVisible(true);

	}

	/**
	 * Carga de provincias a partir del evento de seleccion de paises.
	 */
	@Override
	public void itemStateChanged(ItemEvent evento) {
		String combo_seleccionado = ((JComboBox) evento.getSource()).getName();
		if (combo_seleccionado.equals("combo_paises")) {
			this.cargar_Provincias();
		}
		if (combo_seleccionado.equals("combo_provincias")) {
			this.cargar_Municipios();
		}
	}

	private void cargar_Municipios() {
		// COGEMOS EL MUICIPIO SELECCIONADO POR EL USUARIO
		String provincia_seleccionadA = (String) combo_provincias
				.getSelectedItem();
		// EXTRAEMOS EL CODIGO DE LA CADENA DE TEXTO
		String codigo_provincia = provincia_seleccionadA.substring(
				provincia_seleccionadA.indexOf("-") + 1).trim();
		// CONSULTAMOS A EL MODELO LA INFORMACION A CARGAR
		IGestion_Municipios gestion_municipios = Acceso_ApplicationContext
				.getBean(IGestion_Municipios.class);
		List<Municipios> lista = gestion_municipios
				.consultar_PorProvincias(new Integer(codigo_provincia));
		// CREAMOS LOS DATOS DEL COMBO
		String tabla_municipios[] = new String[lista.size()];
		int posicion = 0;
		for (Municipios municipio : lista) {
			tabla_municipios[posicion] = municipio.getMunicipio() + " - "
					+ String.valueOf(municipio.getId().getCodigoMunicipio());
			posicion++;
		}
		// INSTANCIAMOS EL COMBO DE NUEVO CON LA INFORMACION RECOGIDA
		getContentPane().remove(combo_municipios);
		combo_municipios = new JComboBox(tabla_municipios);
		combo_municipios.setBounds(237, 125, 170, 26);
		getContentPane().add(combo_municipios);

	}

	private void cargar_Provincias() {
		// COGEMOS EL PAIS SELECCIONADO POR EL USUARIO
		String pais_seleccionado = (String) combo_paises.getSelectedItem();
		// EXTRAEMOS EL CODIGO DE LA CADENA DE TEXTO
		String codigo_pais = pais_seleccionado.substring(
				pais_seleccionado.indexOf("-") + 1).trim();
		// COMPROBAMOS SI ES ESPAÑA
		if (codigo_pais.equals("73")) {
			// CONSULTAMOS A EL MODELO LA INFORMACION A CARGAR
			IGestion_Provincias gestion_provincia = Acceso_ApplicationContext
					.getBean(IGestion_Provincias.class);
			List<Provincias> lista = gestion_provincia.consultar_Todos();
			// CREAMOS LOS DATOS DEL COMBO
			String tabla_provincias[] = new String[lista.size()];
			int posicion = 0;
			for (Provincias provincia : lista) {
				tabla_provincias[posicion] = provincia.getProvincia() + " - "
						+ String.valueOf(provincia.getCodigoProvincia());
				posicion++;
			}
			// INSTANCIAMOS EL COMBO DE NUEVO CON LA INFORMACION RECOGIDA
			getContentPane().remove(combo_provincias);
			combo_provincias = new JComboBox(tabla_provincias);
			combo_provincias.addItemListener(this);
			combo_provincias.setName("combo_provincias");
			combo_provincias.setBounds(316, 59, 170, 26);
			getContentPane().add(combo_provincias);
		} else {
			// RETIRAMOS EL COMBO ANTERIOR PARA DEJAR UNO NUEVO VACIO Y CUBRIR
			// TODAS LAS POSIBLES ACCCIONES DEL USUARIO
			getContentPane().remove(combo_provincias);
			combo_provincias = new JComboBox();
			combo_provincias.setBounds(316, 59, 170, 26);
			getContentPane().add(combo_provincias);
		}
	}
}
