package com.atrium.vista.clientes;

import javax.swing.JPanel;

import com.atrium.controlador.Ventana;
import com.atrium.util.Idioma;
import com.atrium.vista.ICrear_Interface;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

import java.util.ResourceBundle;

public class Clientes_Vista extends JPanel implements ICrear_Interface,
		ActionListener {

	// *************** IDIOMATIZACION DE LA CLASE ********************
	// NO CAMBIAR LOS PUNTOS POR BARRAS EL ASISTENTE DEJA DE FUNCIONAR.
	private ResourceBundle rb = ResourceBundle
			.getBundle("com.atrium.vista.clientes.textos_clientes_vista"); //$NON-NLS-1$
	// *************** FIN IDIOMATIZACION DE LA CLASE ****************

	// ***** COLECCIONES PARA REFLEXION *****

	// ******************* PROPIEDADES DE CLASE **********************
	private Ventana ventana;

	// ***** PANELES DE PANTALLA ******

	// PANELES DE CONTENIDO DE CLIENTES
	// private Panel_DatosPersonales pan_personales;
	private Panel_Observaciones pan_observaciones;
	// private Panel_DatosEconomicos pan_economicos;
	// private Panel_DatosBancarios pan_bancarios;

	// CONTENEDOR SECUNDARIO DE PESTAÑAS
	private JTabbedPane panel_cliente;
	// CONTENEDOR SECUNDARIO DE BOTONES
	private JToolBar barra_botones;
	// BOTONES
	private JToggleButton boton_altas;
	private JToggleButton boton_bajas;
	private JToggleButton boton_consultas;
	private JToggleButton boton_modificaciones;
	private JToggleButton boton_salir;

	public Clientes_Vista(Ventana ventana) {
		setBounds(0, 0, 1018, 713);
		setLayout(null);
		this.ventana = ventana;

		crear_Interface();

	}

	// ******** AREA DE IMPLEMENTACION DE INTERFACE PROPIA ***********

	@Override
	public void crear_Interface() {
		rb = ResourceBundle.getBundle(Idioma.fichero_Idioma(
				Clientes_Vista.class, "en"));
		// MONTAMOS EL PANEL DE CLIENTES
		// PANEL DE PESTAÑAS
		panel_cliente = new JTabbedPane(JTabbedPane.TOP);
		panel_cliente.setBounds(0, 0, 1018, 657);
		add(panel_cliente);

		// CREAMOS LOS PANELES
		// pan_personales = new Panel_DatosPersonales();
		pan_observaciones = new Panel_Observaciones();
		// pan_bancarios = new Panel_DatosBancarios();
		// pan_economicos = new Panel_DatosEconomicos();

		// CARGAMOS EL PANEL DE PESTAÑAS
		// panel_cliente.addTab("Datos personales", pan_personales);
		// panel_cliente.addTab("Datos economicos", pan_economicos);
		// panel_cliente.addTab("Datos bancarios", pan_bancarios);
		panel_cliente.addTab("Observaciones", pan_observaciones);

		// BARRA DE BOTONES
		barra_botones = new JToolBar();
		barra_botones.setFloatable(false);
		barra_botones.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		barra_botones.setToolTipText(rb
				.getString("Clientes_Vista.barra_botones.toolTipText")); //$NON-NLS-1$
		barra_botones.setBounds(425, 664, 418, 38);
		add(barra_botones);

		// CREAMOS LOS BOTONES DE LA BARRA DE HERRAMIENTAS
		boton_altas = new JToggleButton(
				rb.getString("Clientes_Vista.boton_altas.text")); //$NON-NLS-1$
		boton_altas.setBounds(228, 670, 55, 37);
		barra_botones.add(boton_altas);

		boton_bajas = new JToggleButton(
				rb.getString("Clientes_Vista.boton_bajas.text")); //$NON-NLS-1$
		boton_bajas.setBounds(285, 670, 92, 37);
		barra_botones.add(boton_bajas);

		boton_consultas = new JToggleButton(
				rb.getString("Clientes_Vista.boton_consultas.text")); //$NON-NLS-1$
		boton_consultas.setBounds(379, 670, 92, 37);
		barra_botones.add(boton_consultas);

		boton_modificaciones = new JToggleButton(
				rb.getString("Clientes_Vista.boton_modificaciones.text")); //$NON-NLS-1$
		boton_modificaciones.setBounds(473, 670, 110, 37);
		barra_botones.add(boton_modificaciones);

		boton_salir = new JToggleButton(
				rb.getString("Clientes_Vista.boton_salir.text")); //$NON-NLS-1$
		boton_salir.setBounds(586, 670, 62, 37);
		barra_botones.add(boton_salir);

		// AGRUPACION DE BOTONES PARA LA SELECCION UNICA
		ButtonGroup grupo_botones = new ButtonGroup();
		grupo_botones.add(boton_altas);
		grupo_botones.add(boton_bajas);
		grupo_botones.add(boton_consultas);
		grupo_botones.add(boton_modificaciones);
		grupo_botones.add(boton_salir);
		// FIN BARRA DE BOTONES

		// ASOCIAMOS EL ESCUCHADOR DE EVENTOS A LOS BOTONES
		boton_altas.addActionListener(this);
		boton_bajas.addActionListener(this);
		boton_consultas.addActionListener(this);
		boton_modificaciones.addActionListener(this);
		boton_salir.addActionListener(this);

		// ESTABLECEMOS EL NAME DE LOS BOTONES
		boton_altas.setName("boton_altas");
		boton_bajas.setName("boton_bajas");
		boton_consultas.setName("boton_consultas");
		boton_modificaciones.setName("boton_modificaciones");
		boton_salir.setName("boton_salir");

		// COLOCAMOS EL CONTENIDO EN LA VENTANA
		ventana.getContentPane().add(this);
		// REPINTAMOS LA VENTANA
		ventana.validate();
		ventana.repaint();

	}

	@Override
	public void ajustes_Reflexion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void establecer_GestionFoco() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub

	}

}
