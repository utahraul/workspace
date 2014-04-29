package com.atrium.colecciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JToggleButton;

public class Ventana extends JFrame implements ActionListener {
	private Colecciones coleccion;
	private JLabel etiqueta;
	private JTextField numero;

	public Ventana() {
		setTitle("Ejercicio Swing");
		setBounds(new Rectangle(100, 200, 300, 250));
		getContentPane().setLayout(null);

		crear_Interface();
		setVisible(true);
	}

	public void crear_Interface() {
		JLabel etiqueta = new JLabel("Numero:");
		etiqueta.setBounds(45, 59, 55, 16);
		getContentPane().add(etiqueta);

		numero = new JTextField();
		numero.setHorizontalAlignment(SwingConstants.RIGHT);
		numero.setBounds(145, 53, 122, 28);
		getContentPane().add(numero);
		numero.setColumns(10);

		JToolBar barra_botones = new JToolBar();
		barra_botones.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.GREEN, Color.BLUE));
		barra_botones.setFloatable(false);
		barra_botones.setBounds(0, 134, 314, 28);
		getContentPane().add(barra_botones);

		JToggleButton cargar = new JToggleButton("Cargar");
		barra_botones.add(cargar);

		JToggleButton ordenar = new JToggleButton("Ordenar");
		barra_botones.add(ordenar);

		JToggleButton menor = new JToggleButton("Menor");
		barra_botones.add(menor);

		JToggleButton mayor = new JToggleButton("Mayor");
		barra_botones.add(mayor);

		JToggleButton media = new JToggleButton("Media");
		barra_botones.add(media);

		JToggleButton vaciar = new JToggleButton("Vaciar");
		barra_botones.add(vaciar);

		JToggleButton salir = new JToggleButton("Salir");
		barra_botones.add(salir);

		cargar.addActionListener(this);
		ordenar.addActionListener(this);
		menor.addActionListener(this);
		mayor.addActionListener(this);
		media.addActionListener(this);
		vaciar.addActionListener(this);
		salir.addActionListener(this);

		cargar.setName("cargar");
		ordenar.setName("ordenar");
		menor.setName("menor");
		mayor.setName("mayor");
		media.setName("media");
		vaciar.setName("vaciar");
		salir.setName("salir");

		coleccion = new Colecciones();
	}

	public void cargar_Numero() {
		String numero_tecleado = numero.getText();
		try {
			coleccion.cargar_Lista(new Integer(numero_tecleado));
		} catch (Exception e) {
			// Mostrar mensaje indicando que se debe insertar un número entero
			//Falta Tratamiento
		}
		// PARA BORRAR EL CAMPO Y DEJARLO VACIO PARA AÑADIR MÁS NÚMEROS
		numero.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String boton_seleccionado = ((JToggleButton) evento.getSource())
				.getName();
		if (boton_seleccionado.equals("cargar")) {
			cargar_Numero();
			
		}
		if (boton_seleccionado.equals("ordenar")) {
			coleccion.ordenar_Lista();
		}
		if (boton_seleccionado.equals("menor")) {
			Integer resultado = coleccion.coger_Menor();
			System.out.println("El menor es ..." + resultado.intValue());
		}
		if (boton_seleccionado.equals("mayor")) {
			Integer resultado = coleccion.coger_Mayor();
			System.out.println("El mayor es ..." + resultado.intValue());
		}
		if (boton_seleccionado.equals("media")) {
			Integer resultado = coleccion.calcular_Media();
			System.out.println("La media es ..." + resultado.intValue());
		}
		if (boton_seleccionado.equals("vacio")) {
			coleccion.vaciar_Lista();
		}
		if (boton_seleccionado.equals("salir")) {
			System.exit(0);

		}

	}
}
