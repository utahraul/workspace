package com.atrium.controlador;

import javax.swing.JFrame;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculadora basica e independiente.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0
 * @since 10-3-2014
 * 
 */
public class Calculadora extends JFrame implements ActionListener {
	// PROPIEDADES DE CLASE
	private JPanel panel_visor;
	private JLabel visor;
	private JPanel panel_botones;
	private JButton boton_7;
	private JButton boton_1;
	private JButton boton_3;
	private JButton boton_5;
	private JButton boton_2;
	private JButton boton_9;
	private JButton boton_6;
	private JButton boton_borrar;
	private JButton boton_4;
	private JButton boton_8;
	private JButton boton_0;
	private JButton boton_decimal;
	private JPanel panel_operaciones;
	private JButton boton_multiplicar;
	private JButton boton_sumar;
	private JButton boton_restar;
	private JButton boton_dividir;
	private JButton boton_igual;

	// PROPIEDADES PARA LA REALIZACION DE OPERACIONES
	private int ope1 = 0;
	private int ope2 = 0;
	private boolean operacion = false;
	private char ultima_operacion;

	/**
	 * Creacion de la ventana de la calculadora.
	 */
	public Calculadora() {
		// DAMOS VALOR A LOS PROPIEDADES DE LA CLASE
		setBounds(new Rectangle(100, 100, 300, 350));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		crear_Interface();
		setVisible(true);
	}

	/**
	 * Proceso de creacion de componentes de la interface.
	 */
	public void crear_Interface() {
		// VISOR DE LA CALCULADORA
		panel_visor = new JPanel();
		panel_visor.setBounds(0, 0, 292, 47);
		getContentPane().add(panel_visor);
		panel_visor.setLayout(null);

		visor = new JLabel("0");
		visor.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		visor.setOpaque(true);
		visor.setBackground(new Color(255, 239, 213));
		visor.setForeground(new Color(0, 0, 0));
		visor.setHorizontalAlignment(SwingConstants.RIGHT);
		visor.setFont(new Font("Arial Black", Font.PLAIN, 30));
		visor.setBounds(6, 6, 280, 41);
		panel_visor.add(visor);
		// PANEL DE BOTONES NUMERICOS
		panel_botones = new JPanel();
		panel_botones.setBounds(0, 48, 181, 268);
		getContentPane().add(panel_botones);
		panel_botones.setLayout(new GridLayout(4, 3, 1, 1));

		boton_1 = new JButton("1");
		boton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_1);

		boton_2 = new JButton("2");
		boton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_2);

		boton_3 = new JButton("3");
		boton_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_3);

		boton_4 = new JButton("4");
		boton_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_4);

		boton_5 = new JButton("5");
		boton_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_5);

		boton_6 = new JButton("6");
		boton_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_6);

		boton_7 = new JButton("7");
		boton_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_7);

		boton_8 = new JButton("8");
		boton_8.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_8);

		boton_9 = new JButton("9");
		boton_9.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_9);

		boton_borrar = new JButton("CE");
		boton_borrar.setBackground(new Color(255, 0, 0));
		boton_borrar.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_botones.add(boton_borrar);

		boton_0 = new JButton("0");
		boton_0.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_0);

		boton_decimal = new JButton(".");
		boton_decimal.setBackground(new Color(107, 142, 35));
		boton_decimal.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_botones.add(boton_decimal);
		// PANEL DE OPERACIONES
		panel_operaciones = new JPanel();
		panel_operaciones.setBounds(182, 48, 110, 200);
		getContentPane().add(panel_operaciones);
		panel_operaciones.setLayout(new GridLayout(2, 2, 1, 1));

		boton_sumar = new JButton("+");
		boton_sumar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_operaciones.add(boton_sumar);

		boton_restar = new JButton("-");
		boton_restar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_operaciones.add(boton_restar);

		boton_multiplicar = new JButton("*");
		boton_multiplicar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_operaciones.add(boton_multiplicar);

		boton_dividir = new JButton("/");
		boton_dividir.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_operaciones.add(boton_dividir);
		// BOTON DE IGUAL
		boton_igual = new JButton("=");
		boton_igual.setFont(new Font("Times New Roman", Font.BOLD, 30));
		boton_igual.setBounds(182, 260, 104, 39);
		getContentPane().add(boton_igual);

		// AÑADIMOS RECPETORES DE EVENTOS A LOS BOTONES
		// TODOS LOS BOTONES EL MISMO RECEPTOR
		boton_1.addActionListener(this);
		boton_2.addActionListener(this);
		boton_3.addActionListener(this);
		boton_4.addActionListener(this);
		boton_5.addActionListener(this);
		boton_6.addActionListener(this);
		boton_7.addActionListener(this);
		boton_8.addActionListener(this);
		boton_9.addActionListener(this);
		boton_0.addActionListener(this);
		boton_sumar.addActionListener(this);
		boton_multiplicar.addActionListener(this);
		boton_restar.addActionListener(this);
		boton_dividir.addActionListener(this);
		boton_igual.addActionListener(this);
		boton_decimal.addActionListener(this);
		boton_borrar.addActionListener(this);

	}

	/**
	 * Tratamiento del evento de pulsacion de cualquier boton de la calculadora.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		// RECOGEMOS EL VALOR TECLEADO POR EL USUARIO
		String opcion_elegida = ((JButton) evento.getSource()).getText();
		// ELIMINAMOS EL CERO INICIAL DE LA CALCULADORA
		if (visor.getText().equals("0")) {
			visor.setText("");
		}
		// SI SE HA PULSADO ANTERIORMENTE UN BOTON DE OPERACION SE BORRA EL
		// VISOR PARA EMPEZAR CON UN NUEVO NUMERO
		if (operacion) {
			visor.setText("");
			operacion = false;
		}
		// AÑADIMOS EL NUMERO CORRESPONDIENTE A LA TECLA PULSADA POR EL USUARIO
		if (opcion_elegida.equals("1")) {
			visor.setText(visor.getText() + "1");
		}
		if (opcion_elegida.equals("2")) {
			visor.setText(visor.getText() + "2");
		}
		if (opcion_elegida.equals("3")) {
			visor.setText(visor.getText() + "3");
		}
		if (opcion_elegida.equals("4")) {
			visor.setText(visor.getText() + "4");
		}
		if (opcion_elegida.equals("5")) {
			visor.setText(visor.getText() + "5");
		}
		if (opcion_elegida.equals("6")) {
			visor.setText(visor.getText() + "6");
		}
		if (opcion_elegida.equals("7")) {
			visor.setText(visor.getText() + "7");
		}
		if (opcion_elegida.equals("8")) {
			visor.setText(visor.getText() + "8");
		}
		if (opcion_elegida.equals("9")) {
			visor.setText(visor.getText() + "9");
		}
		if (opcion_elegida.equals("0")) {
			visor.setText(visor.getText() + "0");
		}
		// REALIZAMOS LAS OPERACIONES ARITMETICAS
		if (opcion_elegida.equals("+")) {
			// SI NO HAY PRIMER NUMERO SE ALMACENA EN LA PRIMERA VARIABLE
			if (ope1 == 0) {
				ope1 = Integer.parseInt(visor.getText());
			} else {
				// EN CASO DE TENER UN NUMERO ESCRITO SE SUMA ACUMULATIVAMENTE
				// EN OPE1
				if (!visor.getText().equals("")) {
					ope2 = Integer.parseInt(visor.getText());
					ope1 = ope1 + ope2;
					visor.setText(String.valueOf(ope1));
				}
			}
			// REGISTRAMOS EL PROCESO
			operacion = true;
			ultima_operacion = '+';
		}
		if (opcion_elegida.equals("-")) {
			if (ope1 == 0) {
				ope1 = Integer.parseInt(visor.getText());
			} else {
				if (!visor.getText().equals("")) {
					ope2 = Integer.parseInt(visor.getText());
					ope1 = ope1 - ope2;
					visor.setText(String.valueOf(ope1));
				}
			}
			operacion = true;
			ultima_operacion = '-';
		}
		if (opcion_elegida.equals("*")) {
			if (ope1 == 0) {
				ope1 = Integer.parseInt(visor.getText());
			} else {
				if (!visor.getText().equals("")) {
					ope2 = Integer.parseInt(visor.getText());
					ope1 = ope1 * ope2;
					visor.setText(String.valueOf(ope1));
				}
			}
			operacion = true;
			ultima_operacion = '*';
		}
		if (opcion_elegida.equals("/")) {
			if (ope1 == 0) {
				ope1 = Integer.parseInt(visor.getText());
			} else {
				if (!visor.getText().equals("")) {
					ope2 = Integer.parseInt(visor.getText());
					ope1 = ope1 / ope2;
					visor.setText(String.valueOf(ope1));
				}
			}
			operacion = true;
			ultima_operacion = '/';
		}
		// CERRAMOS LA OPERACION AL PULSAR IGUAL
		if (opcion_elegida.equals("=")) {
			switch (ultima_operacion) {
			case '+':
				visor.setText(String.valueOf(ope1
						+ Integer.parseInt(visor.getText())));
				break;
			case '-':
				visor.setText(String.valueOf(ope1
						- Integer.parseInt(visor.getText())));
				break;

			case '*':
				visor.setText(String.valueOf(ope1
						* Integer.parseInt(visor.getText())));
				break;

			case '/':
				visor.setText(String.valueOf(ope1
						/ Integer.parseInt(visor.getText())));
				break;
			}
			ultima_operacion = ' ';
			ope1 = 0;
			ope2 = 0;
			operacion = true;
		}
		// BORRAMOS LA PANTALLA E INICIAMOS
		if (opcion_elegida.equals("CE")) {
			visor.setText("0");
			ultima_operacion = ' ';
			ope1 = 0;
			ope2 = 0;
			operacion = false;
		}
	}
}
