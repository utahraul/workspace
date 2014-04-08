package com.atrium.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;

import com.atrium.modelo.Datos_DTO;
import com.atrium.modelo.Gestion_Datos;
import com.atrium.modelo.IGestion_Datos;
import java.awt.Font;

public class Formulario extends JPanel implements ActionListener {

	private JLabel eti_nombre;
	private JTextField nombre_usuario;
	private JLabel eti_apellido;
	private JTextField apellido_usuario;
	private JLabel eti_direccion;
	private JTextField direccion;
	private JLabel eti_ciudad;
	private JTextField ciudad;
	private JToolBar barra_botones;
	private JButton boton_leer;
	private JButton boton_escribir;
	private JButton boton_salir;
	private JLabel resultado;

	public Formulario() {
		setLayout(null);
		setBounds(0, 0, 394, 318);

		crear_Interface();
	}

	public void crear_Interface() {
		eti_nombre = new JLabel("Nombre:");
		eti_nombre.setBounds(26, 98, 64, 14);
		add(eti_nombre);

		nombre_usuario = new JTextField();
		nombre_usuario.setBounds(111, 95, 133, 20);
		add(nombre_usuario);
		nombre_usuario.setColumns(10);

		eti_apellido = new JLabel("Apellido:");
		eti_apellido.setBounds(26, 137, 63, 14);
		add(eti_apellido);

		apellido_usuario = new JTextField();
		apellido_usuario.setBounds(111, 134, 133, 20);
		add(apellido_usuario);
		apellido_usuario.setColumns(10);

		eti_direccion = new JLabel("Direccion:");
		eti_direccion.setBounds(26, 165, 70, 14);
		add(eti_direccion);

		direccion = new JTextField();
		direccion.setBounds(111, 162, 224, 20);
		add(direccion);
		direccion.setColumns(10);

		eti_ciudad = new JLabel("Ciudad:");
		eti_ciudad.setBounds(26, 204, 68, 14);
		add(eti_ciudad);

		ciudad = new JTextField();
		ciudad.setBounds(111, 201, 224, 20);
		add(ciudad);
		ciudad.setColumns(10);

		barra_botones = new JToolBar();
		barra_botones.setFloatable(false);
		barra_botones.setBounds(126, 251, 168, 29);
		add(barra_botones);

		boton_leer = new JButton("Leer");
		barra_botones.add(boton_leer);

		boton_escribir = new JButton("Escribir");
		barra_botones.add(boton_escribir);

		boton_salir = new JButton("Salir");
		barra_botones.add(boton_salir);

		boton_escribir.addActionListener(this);
		boton_leer.addActionListener(this);
		boton_salir.addActionListener(this);

		boton_escribir.setName("boton_escribir");
		boton_salir.setName("boton_salir");
		boton_leer.setName("boton_leer");

		resultado = new JLabel("");
		resultado.setFont(new Font("Times New Roman", Font.BOLD, 20));
		resultado.setBounds(71, 21, 264, 35);
		add(resultado);

	}

	public void leer_Datos() {
		IGestion_Datos gestion_datos = new Gestion_Datos();
		Datos_DTO datos = gestion_datos.leer_Datos();
		nombre_usuario.setText(datos.getNombre());
		apellido_usuario.setText(datos.getApellido());
		direccion.setText(datos.getCalle());
		ciudad.setText(datos.getCiudad());
	}

	public void escribir_Datos() {
		Datos_DTO datos_nuevos = new Datos_DTO();
		datos_nuevos.setNombre(nombre_usuario.getText());
		datos_nuevos.setApellido(apellido_usuario.getText());
		datos_nuevos.setCalle(direccion.getText());
		datos_nuevos.setCiudad(ciudad.getText());
		IGestion_Datos gestion_datos = new Gestion_Datos();
		boolean valido = gestion_datos.escribir_Datos(datos_nuevos);

		if (valido) {
			resultado.setText("Actualizacion correcta");
		} else {
			resultado.setText("Error escribiendo");
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String boton_seleccion = ((JButton) evento.getSource()).getName();
		if (boton_seleccion.equals("boton_escribir")) {
			escribir_Datos();
		}
		if (boton_seleccion.equals("boton_leer")) {
			leer_Datos();
		}
		if (boton_seleccion.equals("boton_salir")) {
			System.exit(0);
		}
	}
}
