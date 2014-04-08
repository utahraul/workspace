package com.atrium.controlador;

import java.awt.Component;

import javax.swing.JFrame;

import com.atrium.vista.Formulario;
import com.atrium.vista.IFormulario;

import javax.swing.JPanel;

public class Ventana extends JFrame implements IVentana {
	
	private IFormulario formulario;

	public Ventana() {
		setBounds(100, 100, 400, 350);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
		
//		setVisible(true);
	}

	public void crear_Interface() {
//		Formulario formulario = new Formulario();
		getContentPane().add((Component)formulario);

		setVisible(true);
	}

	//ACCESORES PARA SPRING
	public void setFormulario(IFormulario formulario) {
		this.formulario = formulario;
	}
	
	
}
