package com.atrium.reflexion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Inicio extends JFrame implements ActionListener {

	private JMenuItem uno;
	private JMenuItem dos;

	public static void main(String arg[]) {

		Inicio prueba = new Inicio();

	}

	public Inicio() {
		List<JComponent> lista = new ArrayList<>();
		uno = new JMenuItem("UNO");
		dos = new JMenuItem("DOS");

		Uso_Propiedades.cargar_Lista(lista, "JMENUITEM", this);

		Uso_Propiedades.cargar_Escuchadores(lista, this);

		Uso_Propiedades.establecer_Nombre(lista, this);

		Uso_Propiedades.establecer_Valor(lista, "font", new Font(
				"Times New Roman", Font.ITALIC, 20));
		Uso_Propiedades.establecer_Valor(lista, "foreground", Color.RED);

		setBounds(100, 100, 300, 300);
		JMenuBar barra = new JMenuBar();
		JMenu prueba = new JMenu("Prueba");
		setJMenuBar(barra);
		barra.add(prueba);
		prueba.add(uno);
		prueba.add(dos);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		System.out.println(((JComponent) evento.getSource()).getName());

	}

	// ACCESORES PARA REFLEXION
	public JMenuItem getUno() {
		return uno;
	}

	public JMenuItem getDos() {
		return dos;
	}

}
