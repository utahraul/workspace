package com.atrium.controlador;

import javax.swing.JFrame;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

import com.atrium.modelo.Gestion_Datos;

public class Ventana extends JFrame implements ActionListener{
	private JLabel etiqueta;
	private JButton boton;

	public Ventana() {
		setBounds(new Rectangle(100, 100, 300, 300));
		getContentPane().setLayout(null);

		crear_Intefarce();
		
		setVisible(true);
	}

	public void crear_Intefarce() {
		etiqueta = new JLabel("texto");
		etiqueta.setBounds(86, 30, 102, 33);
		getContentPane().add(etiqueta);

		boton = new JButton("Leer");
		boton.setBounds(86, 157, 89, 23);
		getContentPane().add(boton);
		boton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Gestion_Datos gestion_datos=new Gestion_Datos();
		etiqueta.setText(gestion_datos.consultar_Datos().getTexto());
	}
}



