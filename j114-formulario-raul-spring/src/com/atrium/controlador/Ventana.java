package com.atrium.controlador;

import javax.swing.JFrame;

import com.atrium.vista.Formulario;
import javax.swing.JPanel;

public class Ventana extends JFrame implements IVentana {

	public Ventana() {
		setBounds(100, 100, 400, 350);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);

		crear_Interface();

	}

	void crear_Interface() {
		Formulario formulario = new Formulario();
		getContentPane().add(formulario);
		setVisible(true);
	}
}
