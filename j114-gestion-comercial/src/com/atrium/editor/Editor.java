package com.atrium.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.undo.UndoManager;

import com.atrium.imagenes.Obtener_Imagenes;
import com.atrium.vista.ICrear_Interface;

public class Editor extends JPanel implements ICrear_Interface, ActionListener {

	// *************** IDIOMATIZACION DE LA CLASE ********************
	// NO CAMBIAR LOS PUNTOS POR BARRAS EL ASISTENTE DEJA DE FUNCIONAR.

	// *************** FIN IDIOMATIZACION DE LA CLASE ****************

	// ***** COLECCIONES PARA REFLEXION *****

	// ******************* PROPIEDADES DE CLASE **********************
	// variables de clase para indicar el tamaño y posicion del componente
	private int x;
	private int y;
	private int ancho;
	private int alto;
	// propiedad que indica si aparecen o no las opciones de abrir/guardar
	private boolean mostrar_ag;
	// gestiona la ventana de abrir/guardar fichero
	private JFileChooser selector_ficheros;
	// variable que contendra el texto leido del fichero
	private StringBuilder texto_total;
	// GUARDA EL FILE PREVIAMENTE ABIERTO POR EL USUARIO PARA SOBREESCRIBIR
	// DIRECTAMENTE
	private File fichero_seleccionado;

	// objeto que gestiona hacer/deshacer
	private UndoManager gestor_undo;
	private boolean elegido = false;

	// botones de la barra de herramientas
	private JButton cortar;
	private JButton copiar;
	private JButton pegar;
	private JButton rehacer;
	private JButton deshacer;
	private JButton abrir;
	private JButton cerrar;
	private JButton cerrar_directo;
	private JButton imprimir;

	// MENU DE DESPLIEGLE RAPIDO
	private JPopupMenu menu_rapido;
	private JMenuItem cortar_m;
	private JMenuItem copiar_m;
	private JMenuItem pegar_m;

	// ***** PANELES DE PANTALLA ******
	// componentes del editor
	// BARRA DE HERRAMIENTAS
	private JToolBar barra_botones;
	// CONTENDOR DE SCROLL PARA VISUALIZAR EL CONTENDO DEL TEXTO
	private JScrollPane ventana_editor;
	// EDITOR PARA TEXTO SIN FORMATO
	private JTextArea area_texto;
	// EDITOR PARA TEXTO CON FORMATO (RTF) SIN IMPLEMENTAR.
	private JEditorPane area_texto_formato;

	// *********CONSTRUCTORES DE CLASE ***************
	/**
	 * Constructor por defecto. <br/>
	 * Nos sirve para seguir la norma javabean.
	 */
	public Editor() {
	}

	/**
	 * Constructor que establece de forma dinamica la posicion (x,y) y el ancho
	 * y alto necesario en cada momento.<br/>
	 * La unidad de medida es pixels.<br/>
	 * El valor por defecto para el indicador de uso de ficheros externos es
	 * falso (no se usan). Por lo tanto puede ser un valor nulo.
	 * 
	 * @param x
	 *            Posicion en el contenedor.
	 * @param y
	 *            Posicion en el contenedor.
	 * @param ancho
	 *            Tamaño del componente.
	 * @param alto
	 *            Tamaño del componente.
	 * @param mostar_ag
	 *            Indicador del uso de las herramientas de abrir/guardar/guardar
	 *            como.
	 */
	public Editor(int x, int y, int ancho, int alto, Boolean mostar_ag) {
		// PARAMETROS DE POSICION Y TAMAÑO
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		if (mostar_ag != null) {
			this.mostrar_ag = mostar_ag.booleanValue();
		}
		// CONFIGURACION DE PROPIEDADES DEL CONTENDOR
		this.setBounds(this.x, this.y, this.ancho, this.alto);
		this.setLayout(null);

		this.crear_Interface();
	}

	/**
	 * Constructor que establece de forma dinamica la posicion (x,y) y el ancho
	 * y alto necesario en cada momento.<br/>
	 * La unidad de medida es pixels.<br/>
	 * El valor por defecto para el indicador de uso de ficheros externos es
	 * TRUE (se usan).
	 * 
	 * @param x
	 *            Posicion en el contenedor.
	 * @param y
	 *            Posicion en el contenedor.
	 * @param ancho
	 *            Tamaño del componente.
	 * @param alto
	 *            Tamaño del componente.
	 */
	public Editor(int x, int y, int ancho, int alto) {
		// PARAMETROS DE POSICION Y TAMAÑO
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		// POLITICA POR DEFECTO
		mostrar_ag = true;
		// CONFIGURACION DE PROPIEDADES DEL CONTENDOR
		this.setBounds(this.x, this.y, this.ancho, this.alto);
		this.setLayout(null);

		this.crear_Interface();
	}

	// ********* FIN CONSTRUCTORES DE CLASE ***************

	// ******** AREA DE IMPLEMENTACION DE INTERFACE PROPIA ***********

	@Override
	public void crear_Interface() {
		// CREAMOS LA ZONA DE EDICION DE TEXTO Y SU CONTENEDOR
		// creamos y preparamos el area de edicion de texto
		area_texto = new JTextArea();
		// GESTION DE LAS OPCIONES DE REHACER/DESHACER MEDIANTE EL UN
		// ESCUCHADOR DE EVENTOS
		gestor_undo = new UndoManager();
		area_texto.getDocument().addUndoableEditListener(gestor_undo);
		// CONTROL DEL PASO DE LAS PALABRAS COMPLETAS A LA SIGUIENTE LINEA
		area_texto.setWrapStyleWord(true);
		area_texto.setLineWrap(true);
		// CREAMOS Y PREPARAMOS EL CONTENEDOR DEL AREA DE TEXTO
		ventana_editor = new JScrollPane();
		ventana_editor.setBounds(0, 46, ancho, alto - 45);
		// PASAMOS EL CONTENIDO AL CONTENEDOR
		ventana_editor.setViewportView(area_texto);
		// ESTABLECEMOS LAS PROPIEDADES DE LAS BARRAS DE SCROLL SEGUN NECESIDAD
		// DE DISEÑO
		ventana_editor
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ventana_editor
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// ACTIVAMOS EL RECONOCIMIENTO DE LA RUEDA DEL RATON
		ventana_editor.setWheelScrollingEnabled(true);
		// MONTAMOS EL SCROLLPANE EN EL JPANEL
		this.add(ventana_editor);

		// CREAMOS LA BARA DE BOTONES Y SUS BOTONES
		// creo los botones con iconos
		cortar = new JButton(Obtener_Imagenes.escalar_Imagen(
				"/com/atrium/imagenes/iconos/cortar.png",
				Obtener_Imagenes._32X32));
		copiar = new JButton(Obtener_Imagenes.escalar_Imagen(
				"/com/atrium/imagenes/iconos/copiar.png",
				Obtener_Imagenes._32X32));
		pegar = new JButton(Obtener_Imagenes.escalar_Imagen(
				"/com/atrium/imagenes/iconos/pegar.png",
				Obtener_Imagenes._32X32));
		rehacer = new JButton(Obtener_Imagenes.escalar_Imagen(
				"/com/atrium/imagenes/iconos/rehacer.png",
				Obtener_Imagenes._32X32));
		deshacer = new JButton(Obtener_Imagenes.escalar_Imagen(
				"/com/atrium/imagenes/iconos/deshacer.png",
				Obtener_Imagenes._32X32));
		imprimir = new JButton(Obtener_Imagenes.escalar_Imagen(
				"/com/atrium/imagenes/iconos/imprimir.png",
				Obtener_Imagenes._32X32));
		// BOTONES OPCIONALES CARA GESTION DE FICHEROS
		if (mostrar_ag) {
			abrir = new JButton(Obtener_Imagenes.escalar_Imagen(
					"/com/atrium/imagenes/iconos/abrir.png",
					Obtener_Imagenes._32X32));
			cerrar = new JButton(Obtener_Imagenes.escalar_Imagen(
					"/com/atrium/imagenes/iconos/guardar_como.png",
					Obtener_Imagenes._32X32));
			cerrar_directo = new JButton(Obtener_Imagenes.escalar_Imagen(
					"/com/atrium/imagenes/iconos/guardar.png",
					Obtener_Imagenes._32X32));
		}
		// INICIO LA BARRA DE BOTONES
		barra_botones = new JToolBar();
		barra_botones.setFloatable(false);
		barra_botones.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		// CONFIGURO EL TAMAÑO DE LA BARRA DE BOTONES
		barra_botones.setBounds(1, 3, ancho - 2, 40);
		// añado la barra al panel
		this.add(barra_botones);
		// CARGO LA BARRA DE BOTONES CON LOS MISMOS
		barra_botones.add(cortar);
		barra_botones.add(copiar);
		barra_botones.add(pegar);
		barra_botones.add(rehacer);
		barra_botones.add(deshacer);
		barra_botones.addSeparator();
		barra_botones.add(imprimir);
		if (mostrar_ag) {
			barra_botones.addSeparator();
			barra_botones.add(abrir);
			barra_botones.add(cerrar);
			barra_botones.add(cerrar_directo);
		}
		// ESTABLEZCO ESCUCHADORES PARA LOS BOTONES
		cortar.addActionListener(this);
		copiar.addActionListener(this);
		pegar.addActionListener(this);
		rehacer.addActionListener(this);
		deshacer.addActionListener(this);
		imprimir.addActionListener(this);
		if (mostrar_ag) {
			abrir.addActionListener(this);
			cerrar.addActionListener(this);
			cerrar_directo.addActionListener(this);
		}
		// DAMOS VALOR A LA PROPIEDAD NAME
		cortar.setName("cortar");
		copiar.setName("copiar");
		pegar.setName("pegar");
		rehacer.setName("rehacer");
		deshacer.setName("deshacer");
		imprimir.setName("imprimir");
		if (mostrar_ag) {
			abrir.setName("abrir");
			cerrar.setName("cerrar");
			cerrar_directo.setName("cerrar_directo");
		}
		// establezco las ayudas contextuales de los botones
		cortar.setToolTipText("Boton de cortar texto");
		copiar.setToolTipText("Boton de copiar texto");
		pegar.setToolTipText("Boton de pegar texto");
		rehacer.setToolTipText("Boton de repetir la ultima accion");
		deshacer.setToolTipText("Boton de anular la ultima accion");
		imprimir.setToolTipText("Boton de imprimir");
		if (mostrar_ag) {
			abrir.setToolTipText("Boton de abrir fichero");
			cerrar.setToolTipText("Boton de cerrar fichero");
			cerrar_directo
					.setToolTipText("Guardar sobre escribiendo el fichero");
		}
		// preparamos el objeto para la gestion de ficheros
		if (mostrar_ag) {
			selector_ficheros = new JFileChooser();
		}
	}

	@Override
	public void ajustes_Reflexion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void establecer_GestionFoco() {
		// TODO Auto-generated method stub

	}

	// ******** FIN AREA DE IMPLEMENTACION DE INTERFACE PROPIA *******

	// *************** AREA DE LOGICA DE PROCESO *********************

	/**
	 * Proceso de lectura del fichero seleccionado por el usuario en la ventana
	 * de abrir.<br/>
	 * En caso de que el fichero elegido no exista se crea vacio para su
	 * posterior uso.<br/>
	 * Una vez leido se vuelca al jtextarea.
	 */
	private void leer_Fichero() {
		// RECOGEMOS EL FICHERO SELECCIONADO DEL JFILECHOOSER
		fichero_seleccionado = selector_ficheros.getSelectedFile();
		// CREAMOS EL FLUJO DE LECTURA
		FileReader flujo = null;
		try {
			flujo = new FileReader(fichero_seleccionado);
		} catch (FileNotFoundException e) {
			// EL FICHERO NO EXISTE
			try {
				// SE CREA EL FICHERO EN BLANCO
				FileWriter escritor = new FileWriter(fichero_seleccionado);
				escritor.write("");
				escritor.flush();
				escritor.close();
				flujo = new FileReader(fichero_seleccionado);
			} catch (Exception exception) {
				// ERROR EN LA CREACION
			}
		}
		BufferedReader lector = new BufferedReader(flujo);
		String texto_leido = "";
		texto_total = new StringBuilder();
		// REALIZAMOS EL PROCESO DE LECTURA
		while (texto_leido != null) {
			try {
				texto_leido = lector.readLine();
				if (texto_leido != null) {
					texto_leido = texto_leido
							+ System.getProperty("line.separator");
				}
			} catch (IOException e) {
			}
			if (texto_leido != null) {
				// ACUMULAMOS EL TEXTO TOTAL YA LEIDO DEL FICHERO
				texto_total.append(texto_leido);
			}
		}
		// CARGAMOS EL TEXTO EN EL AREA DE TEXTO
		area_texto.setText(texto_total.toString());
		try {
			// CERRAMOS EL FLUJO PARA DESBLOQUEAR EL FICHERO
			flujo.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Proceso de escritura el fichero.<br/>
	 * Se gestiona una copia de seguridad de la version anterior, si es que
	 * existe previamente el fichero.
	 * 
	 * @param fichero
	 *            . Nombre y ruta del fichero a guardar.
	 */
	private void escribir_Fichero(File fichero) {
		FileWriter escritor = null;
		File fichero_ruta = null;
		try {
			if (fichero == null) {
				fichero_ruta = selector_ficheros.getSelectedFile();
			} else {
				escritor = new FileWriter(fichero);
				fichero_ruta = fichero;
			}
			// GESTION DE COPIA DE SEGURIDAD EN CASO DE EXISTIR PREVIAMENTE
			if (fichero_ruta.exists()) {
				String ruta = selector_ficheros.getSelectedFile()
						.getAbsolutePath();
				SimpleDateFormat formato = new SimpleDateFormat(
						"yyyy-MM-dd HH-mm");
				File copia_seguridad = new File(ruta + "."
						+ formato.format(new Date()));
				copia_seguridad.setReadOnly();
				FileWriter copia_s = new FileWriter(copia_seguridad);
				// LEEMOS EL CONTENIDO DEL FICHERO existente
				FileReader flujo = new FileReader(fichero_ruta);
				BufferedReader lector = new BufferedReader(flujo);
				String texto_leido = "";
				texto_total = new StringBuilder();
				// REALIZAMOS EL PROCESO DE LECTURA
				while (texto_leido != null) {
					try {
						texto_leido = lector.readLine();
						if (texto_leido != null) {
							texto_leido = texto_leido
									+ System.getProperty("line.separator");
						}
					} catch (IOException e) {
					}
					if (texto_leido != null) {
						// ACUMULAMOS EL TEXTO TOTAL YA LEIDO DEL FICHERO
						texto_total.append(texto_leido);
					}
				}
				copia_s.write(texto_total.toString());
				copia_s.flush();
				copia_s.close();
			}
			if (escritor == null) {
				escritor = new FileWriter(fichero_ruta);
			}
			// ESCRITURA DEL TEXTO
			escritor.write(area_texto.getText());
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Proceso de guardado del fichero con el mismo nombre y ruta que tenia
	 * previamente.
	 */
	private void guardar_Fichero() {
		if (fichero_seleccionado != null) {
			this.escribir_Fichero(fichero_seleccionado);
		}
		fichero_seleccionado = null;
	}

	// ************** FIN AREA DE LOGICA DE PROCESO ******************

	// **************** AREA DE EVENTOS ******************************

	/**
	 * Gestion de las acciones de eventos de boton.<br/>
	 * <br/>
	 * <table border=1>
	 * <thead>
	 * <tr aling="center">
	 * <th colspan="2" >
	 * Procesos definidos</td></th>
	 * <tr>
	 * <th>
	 * Nombre Evento</th>
	 * <th>
	 * Accion</th>
	 * </tr>
	 * </thead> <tbody>
	 * <tr>
	 * <td>
	 * Cortar</td>
	 * <td>
	 * Cortar el texto previamente seleccionado</td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>
	 * Copiar</td>
	 * <td>
	 * Copia el texto previamente seleccionado</td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>
	 * Pegar</td>
	 * <td>
	 * Pega el texto previamente seleccionado</td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>
	 * Rehacer</td>
	 * <td>
	 * Repite la ultima accion de texto echa</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Deshacer</td>
	 * <td>
	 * Elimina el ultimo texto o accion echa</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Abrir</td>
	 * <td>
	 * El usuario seleccion en la ventana de abrir un nuevo fichero</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Guardar</td>
	 * <td>
	 * Se guarda el contenido de la modificacion del texto echa por el usuario</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Guardar como</td>
	 * <td>
	 * Se guarda el contenido de la modificacion del texto con un nuevo nombre
	 * y/o ruta</td>
	 * </tr>
	 * <td>
	 * Imprimir</td>
	 * <td>
	 * Se imprimira el contenido del campo de texto. (Pendiente de desarrollo)</td>
	 * </tr> </tbody>
	 * </table>
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		String nombre_boton = ((JComponent) evento.getSource()).getName();
		if (nombre_boton.equals("cortar")) {
			if (area_texto.getSelectedText() != null) {
				// METODO QUE CORTA
				area_texto.cut();
				elegido = true;
			}
		}
		if (nombre_boton.equals("copiar")) {
			if (area_texto.getSelectedText() != null) {
				// METODO QUE COPIA
				area_texto.copy();
				elegido = true;
			}
		}
		if (nombre_boton.equals("pegar")) {
			if (elegido) {
				// METODO QUE PEGA
				area_texto.paste();
				// elegido = false;
			}
		}
		if (nombre_boton.equals("rehacer")) {
			if (gestor_undo.canRedo()) {
				// METODO QUE REPITE LA ULTIMA OPERACION
				gestor_undo.redo();
			}
		}
		if (nombre_boton.equals("deshacer")) {
			if (gestor_undo.canUndo()) {
				// METODO QUE DESHACE LA ULTIMA OPERACION
				gestor_undo.undo();
			}
		}
		if (nombre_boton.equals("abrir")) {
			int boton_pulsado = selector_ficheros.showOpenDialog(this);
			if (boton_pulsado == JFileChooser.APPROVE_OPTION) {
				this.leer_Fichero();
			}
		}
		if (nombre_boton.equals("cerrar")) {
			int boton_pulsado = selector_ficheros.showSaveDialog(this);
			if (boton_pulsado == JFileChooser.APPROVE_OPTION) {
				 this.escribir_Fichero(null);
			}
		}
		if (nombre_boton.equals("cerrar_directo")) {
			 this.guardar_Fichero();
		}
	}

	// **************** FIN AREA DE EVENTOS **************************

	// ********** ACCESORES PARA LAS PROPIEDADES DE CLASE ************

	// ************ ACCESORES PARA REFLEXION *************************

	// ************ ACCESORES PARA SPRING ****************************
}
