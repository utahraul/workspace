package com.atrium.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Ventana extends JFrame implements ActionListener {
	private JLabel nombre;
	public Ventana() {
		setBounds(new Rectangle(100, 100, 600, 400));
		getContentPane().setLayout(null);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(31, 37, 46, 14);
		getContentPane().add(nombre);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
