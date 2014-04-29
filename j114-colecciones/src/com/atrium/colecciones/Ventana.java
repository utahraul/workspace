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
import javax.swing.JToggleButton;

public class Ventana extends JFrame implements ActionListener {

	private Colecciones coleccion;

	private JLabel etiqueta;
	private JTextField numero;
	private JToolBar barra_botones;
	private JToggleButton cargar;
	private JToggleButton ordenar;
	private JToggleButton menor;
	private JToggleButton mayor;
	private JToggleButton media;
	private JToggleButton vaciar;
	private JToggleButton salir;

	public Ventana() {
		setBounds(new Rectangle(100, 200, 300, 250));
		getContentPane().setLayout(null);

		crear_Interface();

		setVisible(true);
	}

	public void crear_Interface() {
		etiqueta = new JLabel("Numero:");
		etiqueta.setBounds(65, 60, 55, 16);
		getContentPane().add(etiqueta);

		numero = new JTextField();
		numero.setHorizontalAlignment(SwingConstants.RIGHT);
		numero.setBounds(123, 54, 122, 28);
		getContentPane().add(numero);
		numero.setColumns(10);

		barra_botones = new JToolBar();
		barra_botones.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		barra_botones.setFloatable(false);
		barra_botones.setBounds(6, 140, 308, 28);
		getContentPane().add(barra_botones);

		cargar = new JToggleButton("Cargar");
		barra_botones.add(cargar);

		ordenar = new JToggleButton("Ordenar");
		barra_botones.add(ordenar);

		menor = new JToggleButton("Menor");
		barra_botones.add(menor);

		mayor = new JToggleButton("Mayor");
		barra_botones.add(mayor);

		media = new JToggleButton("Media");
		barra_botones.add(media);

		vaciar = new JToggleButton("Vaciar");
		barra_botones.add(vaciar);

		salir = new JToggleButton("Salir");
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
		vaciar.setName("vacia");
		salir.setName("salir");

		coleccion = new Colecciones();
	}

	public void cargar_Numero() {
		String numero_tecleado = numero.getText();
		try {
			coleccion.cargar_Lista(new Integer(numero_tecleado));
		} catch (Exception e) {
			// ERROR DE CONVERSION
			// FALTA TRATAMIENTO
		}
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
			if (resultado != null) {
				System.out.println("EL MENOR ES ... " + resultado.intValue());
			} else {
				System.out.println("Coleccion vacia");
			}
		}
		if (boton_seleccionado.equals("mayor")) {
			Integer resultado = coleccion.coger_Mayor();
			if (resultado != null) {
				System.out.println("EL MAYOR ES ... " + resultado.intValue());
			} else {
				System.out.println("Coleccion vacia");
			}
		}
		if (boton_seleccionado.equals("media")) {
			Integer resultado = coleccion.calcular_Media();
			System.out.println("LA MEDIA ES ... " + resultado.intValue());
		}
		if (boton_seleccionado.equals("vacia")) {
			coleccion.vaciar_Lista();
		}
		if (boton_seleccionado.equals("salir")) {
			System.exit(0);
		}
	}
}
