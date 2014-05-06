package com.atrium.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.Rectangle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.Gestion_Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;

public class Formulario_Usuario extends JFrame implements ActionListener {

	private JLabel eti_nombre;
	private JLabel eti_clave;
	private JLabel eti_fechaalta;
	private JLabel eti_fechabaja;
	private JLabel eti_idiomas;
	private JLabel eti_carpeta;
	private JLabel eti_rol;
	private JTextField nombre_usuario;
	private JTextField clave_usuario;
	private JTextField fecha_alta;
	private JTextField fecha_baja;
	private JTextField carpeta;
	private JComboBox combo_roles;
	private JRadioButton idioma_es;
	private JRadioButton idioma_in;
	private JRadioButton idioma_fr;
	private JToolBar barra_botones;
	private JButton boton_alta;
	private JButton boton_baja;
	private JButton boton_modificacion;
	private JButton boton_consultas;
	private JButton boton_salir;

	private IGestion_Usuarios gestion_usuario;

	private SimpleDateFormat formato_fecha;

	public Formulario_Usuario() {
		setBounds(new Rectangle(100, 100, 350, 360));
		getContentPane().setLayout(null);

		crear_Interface();

		setVisible(true);
	}

	public void crear_Interface() {
		// CREACION DEL FORMULARIO
		eti_nombre = new JLabel("Nombre:");
		eti_nombre.setBounds(6, 23, 55, 16);
		getContentPane().add(eti_nombre);

		eti_clave = new JLabel("Clave:");
		eti_clave.setBounds(6, 51, 55, 16);
		getContentPane().add(eti_clave);

		eti_fechaalta = new JLabel("Fecha Alta:");
		eti_fechaalta.setBounds(6, 79, 75, 16);
		getContentPane().add(eti_fechaalta);

		eti_fechabaja = new JLabel("Fecha Baja:");
		eti_fechabaja.setBounds(6, 107, 75, 16);
		getContentPane().add(eti_fechabaja);

		eti_idiomas = new JLabel("Idiomas");
		eti_idiomas.setBounds(6, 135, 55, 16);
		getContentPane().add(eti_idiomas);

		eti_carpeta = new JLabel("Carpeta documentacion:");
		eti_carpeta.setBounds(6, 163, 143, 16);
		getContentPane().add(eti_carpeta);

		eti_rol = new JLabel("Rol asignado:");
		eti_rol.setBounds(6, 191, 98, 16);
		getContentPane().add(eti_rol);

		nombre_usuario = new JTextField();
		nombre_usuario.setBounds(85, 17, 166, 28);
		getContentPane().add(nombre_usuario);
		nombre_usuario.setColumns(10);

		clave_usuario = new JTextField();
		clave_usuario.setBounds(85, 45, 166, 28);
		getContentPane().add(clave_usuario);
		clave_usuario.setColumns(10);

		// FORMATO DE FECHAS
		formato_fecha = new SimpleDateFormat("dd/MM/yyyy");

		fecha_alta = new JTextField();
		fecha_alta.setBounds(85, 73, 166, 28);
		// FECHA DEL DIA POR DEFECTO
		fecha_alta.setText(formato_fecha.format(new Date()));
		getContentPane().add(fecha_alta);
		fecha_alta.setColumns(10);

		fecha_baja = new JTextField();
		fecha_baja.setBounds(85, 107, 166, 28);
		getContentPane().add(fecha_baja);
		fecha_baja.setColumns(10);

		carpeta = new JTextField();
		carpeta.setBounds(146, 157, 162, 28);
		getContentPane().add(carpeta);
		carpeta.setColumns(10);

		combo_roles = new JComboBox();
		combo_roles.setBounds(85, 191, 166, 26);
		getContentPane().add(combo_roles);

		ButtonGroup idioma_unico = new ButtonGroup();
		idioma_es = new JRadioButton("Espa\u00F1ol");
		idioma_es.setBounds(85, 134, 75, 18);
		getContentPane().add(idioma_es);

		idioma_in = new JRadioButton("Ingles");
		idioma_in.setBounds(162, 134, 65, 18);
		getContentPane().add(idioma_in);

		idioma_fr = new JRadioButton("Frances");
		idioma_fr.setBounds(233, 134, 75, 18);
		getContentPane().add(idioma_fr);

		idioma_unico.add(idioma_es);
		idioma_unico.add(idioma_fr);
		idioma_unico.add(idioma_in);

		barra_botones = new JToolBar();
		barra_botones.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		barra_botones.setFloatable(false);
		barra_botones.setBounds(40, 254, 261, 36);
		getContentPane().add(barra_botones);

		boton_alta = new JButton("Alta");
		barra_botones.add(boton_alta);

		boton_baja = new JButton("Baja");
		barra_botones.add(boton_baja);

		boton_modificacion = new JButton("Modificacion");
		barra_botones.add(boton_modificacion);

		boton_consultas = new JButton("Consultas");
		barra_botones.add(boton_consultas);

		boton_salir = new JButton("Salir");
		barra_botones.add(boton_salir);
		// FIN CREACION FORMULARIO

		// ASOCIAMOS EL ESCUCHADORES DE EVEBTOS A LOS BOTONES
		boton_alta.addActionListener(this);
		boton_baja.addActionListener(this);
		boton_modificacion.addActionListener(this);
		boton_consultas.addActionListener(this);
		boton_salir.addActionListener(this);
		// LE DAMOS VALOR A LA PROPIEDAD NAME PARA SU USO EN EL EVENTO
		boton_alta.setName("boton_alta");
		boton_baja.setName("boton_baja");
		boton_modificacion.setName("boton_modificacion");
		boton_consultas.setName("boton_consultas");
		boton_salir.setName("boton_salir");

	}

	public void alta_Usuario() {
		gestion_usuario = new Gestion_Usuarios();
		Usuarios usuario_nuevo = new Usuarios();
		usuario_nuevo.setNombreUsuario(nombre_usuario.getText());
		usuario_nuevo.setPassword(clave_usuario.getText());
		if (combo_roles.getSelectedItem() != null) {
			usuario_nuevo.setRoles(new Roles((byte) combo_roles
					.getSelectedItem()));
		} else {
			usuario_nuevo.setRoles(null);
		}
		try {
			usuario_nuevo
					.setFechaAlta(formato_fecha.parse(fecha_alta.getText()));
		} catch (ParseException e) {
			// ERROR EN EL FORMATO DE FECHA DE ALTA
		}
		try {
			usuario_nuevo
					.setFechaBaja(formato_fecha.parse(fecha_baja.getText()));
		} catch (ParseException e) {
			// ERROR EN EL FORMATO DE FECHA DE BAJA O FECHA VACIA
		}
		usuario_nuevo.setCarpetaDocumentacion(carpeta.getText());
		if (idioma_es.isSelected()) {
			usuario_nuevo.setIdioma("es");
		}
		if (idioma_fr.isSelected()) {
			usuario_nuevo.setIdioma("fr");
		}
		if (idioma_in.isSelected()) {
			usuario_nuevo.setIdioma("en");
		}

		gestion_usuario.alta_Usuario(usuario_nuevo);
	}

	public void baja_Usuario() {
		gestion_usuario = new Gestion_Usuarios();
		Usuarios usuario_nuevo = new Usuarios();
		usuario_nuevo.setNombreUsuario(nombre_usuario.getText());
		gestion_usuario.baja_Usuario(usuario_nuevo);
	}

	public void modificar_Usuario() {
		gestion_usuario = new Gestion_Usuarios();
		Usuarios usuario_nuevo = new Usuarios();
		usuario_nuevo.setNombreUsuario(nombre_usuario.getText());
		usuario_nuevo.setPassword(clave_usuario.getText());
		if (combo_roles.getSelectedItem() != null) {
			usuario_nuevo.setRoles(new Roles((byte) combo_roles
					.getSelectedItem()));
		} else {
			usuario_nuevo.setRoles(null);
		}
		try {
			usuario_nuevo
					.setFechaAlta(formato_fecha.parse(fecha_alta.getText()));
		} catch (ParseException e) {
			// ERROR EN EL FORMATO DE FECHA DE ALTA
		}
		try {
			usuario_nuevo
					.setFechaBaja(formato_fecha.parse(fecha_baja.getText()));
		} catch (ParseException e) {
			// ERROR EN EL FORMATO DE FECHA DE BAJA O FECHA VACIA
		}
		usuario_nuevo.setCarpetaDocumentacion(carpeta.getText());
		if (idioma_es.isSelected()) {
			usuario_nuevo.setIdioma("es");
		}
		if (idioma_fr.isSelected()) {
			usuario_nuevo.setIdioma("fr");
		}
		if (idioma_in.isSelected()) {
			usuario_nuevo.setIdioma("en");
		}
		gestion_usuario.modificacion_Usuario(usuario_nuevo);
	}

	public void consultar_Usuario() {
		gestion_usuario = new Gestion_Usuarios();
		Usuarios usuario_consultado = gestion_usuario
				.consultar_ConRol(nombre_usuario.getText());
		if (usuario_consultado != null) {
			clave_usuario.setText(usuario_consultado.getPassword());
			carpeta.setText(usuario_consultado.getCarpetaDocumentacion());
			fecha_alta.setText(formato_fecha.format(usuario_consultado
					.getFechaAlta()));
			if (usuario_consultado.getFechaBaja() != null) {
				fecha_baja.setText(formato_fecha.format(usuario_consultado
						.getFechaBaja()));
			} else {
				fecha_baja.setText("");
			}
			if (usuario_consultado.getIdioma().equals("es")) {
				idioma_es.setSelected(true);
			}
			if (usuario_consultado.getIdioma().equals("fr")) {
				idioma_fr.setSelected(true);
			}
			if (usuario_consultado.getIdioma().equals("en")) {
				idioma_in.setSelected(true);
			}

			// FALTA COLOCAR EL ROL DEL USUARIO - SOLO SE PODRA PONER CUANDO SE
			// DEFINA LA CARGA DEL COMBO
		} else {
			// USUARIO NO EXISTENTE
		}

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String boton_seleccionado = ((JButton) evento.getSource()).getName();
		if (boton_seleccionado.equals("boton_alta")) {
			alta_Usuario();
		}
		if (boton_seleccionado.equals("boton_baja")) {
			baja_Usuario();
		}
		if (boton_seleccionado.equals("boton_modificacion")) {
			modificar_Usuario();
		}
		if (boton_seleccionado.equals("boton_consultas")) {
			consultar_Usuario();
		}
		if (boton_seleccionado.equals("boton_salir")) {
			System.exit(0);
		}
	}
}
