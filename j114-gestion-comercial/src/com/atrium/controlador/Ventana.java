package com.atrium.controlador;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.atrium.imagenes.Obtener_Imagenes;
import com.atrium.log4j.Traza_Log;
import com.atrium.reflexion.Uso_Propiedades;
import com.atrium.util.Idioma;
import com.atrium.vista.ICrear_Interface;
import com.atrium.vista.clientes.Clientes_Vista;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Ventana extends JFrame implements ICrear_Interface, ActionListener {
	// *************** IDIOMATIZACION DE LA CLASE ********************
	// NO CAMBIAR LOS PUNTOS POR BARRAS EL ASISTENTE DEJA DE FUNCIONAR.
	private ResourceBundle rb = ResourceBundle
			.getBundle("com.atrium.controlador.textos_ventana"); //$NON-NLS-1$
	// *************** FIN IDIOMATIZACION DE LA CLASE ****************

	// ***** COLECCIONES PARA REFLEXION *****
	private List<JComponent> lista_jmenuitem;
	private List<JComponent> lista_jmenu;
	// ******************* PROPIEDADES DE CLASE **********************
	// BARRA DE MENUS GENERAL PARA LA VENTANA. CONTIENE TODAS LAS OPCIONES DE
	// MENUS POSIBLES
	private JMenuBar barra_menu;
	private JMenu archivo;
	private JMenu clientes;
	private JMenu proveedores;
	private JMenu almacen;
	private JMenu vencimientos;
	private JMenu ayuda;

	private JMenuItem archivo_configuracion;
	private JMenuItem archivo_salir;
	private JMenuItem clientes_gestion;
	private JMenuItem clientes_pedidos;
	private JMenuItem clientes_historico;
	private JMenu listado_clientes;
	private JMenuItem listadoclientes_activos;
	private JMenuItem listadoclientes_morosos;
	private JMenuItem listadoclientes_bajas;
	private JMenuItem proveedores_gestion;
	private JMenuItem proveedores_pedidos;
	private JMenuItem proveedores_servicios;
	private JMenuItem almacen_articulos;
	private JMenuItem almacen_almacen;
	private JMenuItem almacen_catalogo;
	private JMenuItem vencimientos_pagos;
	private JMenuItem vencimientos_cobros;
	private JMenuItem vencimientos_morosos;
	private JMenuItem vencimientos_flujo;
	private JMenu listado_vencimientos;
	private JMenuItem listadovencimientos_facturacion;
	private JMenuItem listadovencimientos_pendientes;
	private JMenuItem listadovencimientos_morosidad;
	private JMenuItem ayuda_manual;
	private JMenuItem ayuda_acercade;
	private JMenuItem ayuda_calculadora;

	// ***** PANELES DE PANTALLA ******

	public Ventana() {
		Traza_Log.registro("Creamos el jframe principal");
		setBounds(new Rectangle(0, 0, 1024, 768));
		Traza_Log.registro("tamaño de la ventana 1024X768");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setResizable(false);

		this.crear_Interface();

		setVisible(true);
	}

	// ******** AREA DE IMPLEMENTACION DE INTERFACE PROPIA ***********

	@Override
	public void crear_Interface() {
		Traza_Log.registro("Se crean los componentes de la ventana");
		System.out.println(Idioma.fichero_Idioma(Ventana.class, "en"));
		rb = ResourceBundle.getBundle(Carga_Inicial
				.getRecurso_Idiomatico(Ventana.class));
		// CREACION MENU
		// BARRRA DE MENU
		barra_menu = new JMenuBar();
		// OPCIONES DE MENU
		archivo = new JMenu(rb.getString("Ventana.archivo.text")); //$NON-NLS-1$
		clientes = new JMenu(rb.getString("Ventana.clientes.text")); //$NON-NLS-1$
		proveedores = new JMenu(rb.getString("Ventana.proveedores.text")); //$NON-NLS-1$
		almacen = new JMenu(rb.getString("Ventana.almacen.text")); //$NON-NLS-1$
		vencimientos = new JMenu(rb.getString("Ventana.vencimientos.text")); //$NON-NLS-1$
		ayuda = new JMenu(rb.getString("Ventana.ayuda.text")); //$NON-NLS-1$

		// ACCIONES DEL USUARIO
		archivo_configuracion = new JMenuItem(
				rb.getString("Ventana.archivo_configuracion.text")); //$NON-NLS-1$
		archivo_salir = new JMenuItem(
				rb.getString("Ventana.archivo_salir.text")); //$NON-NLS-1$
		clientes_gestion = new JMenuItem(
				rb.getString("Ventana.clientes_gestion.text")); //$NON-NLS-1$
		clientes_pedidos = new JMenuItem(
				rb.getString("Ventana.clientes_pedidos.text")); //$NON-NLS-1$
		clientes_historico = new JMenuItem(
				rb.getString("Ventana.clientes_historico.text")); //$NON-NLS-1$
		listado_clientes = new JMenu(
				rb.getString("Ventana.listado_clientes.text")); //$NON-NLS-1$
		listadoclientes_activos = new JMenuItem(
				rb.getString("Ventana.listadoclientes_activos.text")); //$NON-NLS-1$
		listadoclientes_morosos = new JMenuItem(
				rb.getString("Ventana.listadoclientes_morosos.text")); //$NON-NLS-1$
		listadoclientes_bajas = new JMenuItem(
				rb.getString("Ventana.listadoclientes_bajas.text")); //$NON-NLS-1$
		proveedores_gestion = new JMenuItem(
				rb.getString("Ventana.proveedores_gestion.text")); //$NON-NLS-1$
		proveedores_pedidos = new JMenuItem(
				rb.getString("Ventana.proveedores_pedidos.text")); //$NON-NLS-1$
		proveedores_servicios = new JMenuItem(
				rb.getString("Ventana.proveedores_servicios.text")); //$NON-NLS-1$
		almacen_articulos = new JMenuItem(
				rb.getString("Ventana.almacen_articulos.text")); //$NON-NLS-1$
		almacen_almacen = new JMenuItem(
				rb.getString("Ventana.almacen_almacen.text")); //$NON-NLS-1$
		almacen_catalogo = new JMenuItem(
				rb.getString("Ventana.almacen_catalogo.text")); //$NON-NLS-1$
		vencimientos_pagos = new JMenuItem(
				rb.getString("Ventana.vencimientos_pagos.text")); //$NON-NLS-1$
		vencimientos_cobros = new JMenuItem(
				rb.getString("Ventana.vencimientos_cobros.text")); //$NON-NLS-1$
		vencimientos_morosos = new JMenuItem(
				rb.getString("Ventana.vencimientos_morosos.text")); //$NON-NLS-1$
		vencimientos_flujo = new JMenuItem(
				rb.getString("Ventana.vencimientos_flujo.text")); //$NON-NLS-1$
		listado_vencimientos = new JMenu(
				rb.getString("Ventana.listado_vencimientos.text")); //$NON-NLS-1$
		listadovencimientos_facturacion = new JMenuItem(
				rb.getString("Ventana.listadovencimientos_facturacion.text")); //$NON-NLS-1$
		listadovencimientos_pendientes = new JMenuItem(
				rb.getString("Ventana.listadovencimientos_pendientes.text")); //$NON-NLS-1$
		listadovencimientos_morosidad = new JMenuItem(
				rb.getString("Ventana.listadovencimientos_morosidad.text")); //$NON-NLS-1$
		ayuda_manual = new JMenuItem(rb.getString("Ventana.ayuda_manual.text")); //$NON-NLS-1$
		ayuda_acercade = new JMenuItem(
				rb.getString("Ventana.ayuda_acercade.text")); //$NON-NLS-1$
		ayuda_calculadora = new JMenuItem(
				rb.getString("Ventana.ayuda_calculadora.text")); //$NON-NLS-1$
		// FIN CREACION DE MENU

		// MONTAJE DEL MENU
		this.setJMenuBar(barra_menu);

		// OPCIONES PRINCIPALES DEL MENU
		barra_menu.add(archivo);
		barra_menu.add(clientes);
		barra_menu.add(proveedores);
		barra_menu.add(almacen);
		barra_menu.add(vencimientos);
		barra_menu.add(ayuda);

		// OPCIONES DE ARCHIVO
		archivo.add(archivo_configuracion);
		archivo.addSeparator();
		archivo.add(archivo_salir);

		// OPCIONES DE CLIENTES
		clientes.add(clientes_gestion);
		clientes.add(clientes_pedidos);
		clientes.add(clientes_historico);
		clientes.addSeparator();
		clientes.add(listado_clientes);
		listado_clientes.add(listadoclientes_activos);
		listado_clientes.add(listadoclientes_morosos);
		listado_clientes.add(listadoclientes_bajas);

		// OPCIONES DE PROVEEDORES
		proveedores.add(proveedores_gestion);
		proveedores.add(proveedores_pedidos);
		proveedores.add(proveedores_servicios);

		// OPCIONES DE ALMACEN
		almacen.add(almacen_articulos);
		almacen.add(almacen_almacen);
		almacen.add(almacen_catalogo);

		// OPCIONES DE VENCIMIENTOS
		vencimientos.add(vencimientos_cobros);
		vencimientos.add(vencimientos_pagos);
		vencimientos.add(vencimientos_morosos);
		vencimientos.addSeparator();
		vencimientos.add(listado_vencimientos);
		listado_vencimientos.add(listadovencimientos_facturacion);
		listado_vencimientos.add(listadovencimientos_pendientes);
		listado_vencimientos.add(listadovencimientos_morosidad);
		vencimientos.addSeparator();
		vencimientos.add(vencimientos_flujo);

		// OPCIONES DE AYUDA
		ayuda.add(ayuda_manual);
		ayuda.add(ayuda_calculadora);
		ayuda.addSeparator();
		ayuda.add(ayuda_acercade);
		// FIN MONTAJE

		ajustes_Reflexion();
		Traza_Log.registro("Creado los componentes");

	}

	@Override
	public void ajustes_Reflexion() {
		Traza_Log.registro("Se inicia los ajustes por reflexion en ventana");
		// CREO LA COLECCION PARA GUARDAR TODOS LOS COMPONENTES A TRATAR
		lista_jmenuitem = new ArrayList<JComponent>();
		lista_jmenu = new ArrayList<JComponent>();
		// AÑADO LOS JMENUITEM PARA SU TRATAMIENTO
		Uso_Propiedades.cargar_Lista(lista_jmenuitem, "JMenuItem", this);
		// CARGAMOS EL ESCUCHADOR DE EVENTOS CORRESPONDIENTE
		Uso_Propiedades.cargar_Escuchadores(lista_jmenuitem, this);
		// ESTABLECEMOS EL VALOR DE LA PROPIEDAD NAME
		Uso_Propiedades.establecer_Nombre(lista_jmenuitem, this);
		// ESTABLECEMOS EL VALOR DE LA PROPIEDAD ACTIONCOMMAND
		Uso_Propiedades.establecer_ActionCommand(lista_jmenuitem, this);
		// ESTABLECEMOS LOS TEXTOS DE AYUDA DE LOS COMPONENTES
		Uso_Propiedades.establecer_TextoAyuda(lista_jmenuitem,
				"com/atrium/controlador/textos_ventana");
		// CARGAMOS LOS ICONOS
		Uso_Propiedades.cargar_Iconos(lista_jmenuitem, Obtener_Imagenes._32X32,
				"com.atrium.imagenes.iconos");

		// AÑADO LOS COMPONENTES JMENU A LA COLECCION
		Uso_Propiedades.cargar_Lista(lista_jmenu, "JMenu", this);
		// ESTABLECEMOS EL VALOR DE LA PROPIEDAD NAME
		Uso_Propiedades.establecer_Nombre(lista_jmenu, this);
		// ESTABLECEMOS LOS TEXTOS DE AYUDA DE LOS COMPONENTES
		Uso_Propiedades.establecer_TextoAyuda(lista_jmenu,
				"com/atrium/controlador/textos_ventana");
		// CARGAMOS LOS ICONOS
		Uso_Propiedades.cargar_Iconos(lista_jmenu, Obtener_Imagenes._24X24,
				"com.atrium.imagenes.iconos");

	}

	@Override
	public void establecer_GestionFoco() {
		// TODO Auto-generated method stub

	}

	// ******** FIN AREA DE IMPLEMENTACION DE INTERFACE PROPIA *******

	// *************** AREA DE LOGICA DE PROCESO *********************

	// ************** FIN AREA DE LOGICA DE PROCESO ******************

	// **************** AREA DE EVENTOS ******************************

	@Override
	public void actionPerformed(ActionEvent evento) {
		String opcion_elegida = ((JComponent) evento.getSource()).getName();
		System.out.println(opcion_elegida);
		if (opcion_elegida.equals("archivo_configuracion")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("archivo_salir")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("clientes_gestion")) {
			Clientes_Vista clientes = new Clientes_Vista(this);
		}
		if (opcion_elegida.equals("clientes_pedido")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("clientes_historico")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("listadoclientes_activos")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("listadoclientes_morosos")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("listadoclientes_bajas")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("proveedores_gestion")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("proveedores_pedidos")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("proveedores_servicios")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("almacen_almacen")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("almacen_articulos")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("almacen_catalogo")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("vencimientos_cobros")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("vencimientos_pagos")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("vencimientos_morosos")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("listadosvencimientos_facturacion")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("listadosvencimientos_pendientes")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("listadosvencimientos_morosidad")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("vencimientos_flujo")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("ayuda_acercade")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("ayuda_manual")) {
			// PENDIENTE DE DESARROLLO
		}
		if (opcion_elegida.equals("ayuda_calculadora")) {
			// PENDIENTE DE DESARROLLO
		}
	}

	// **************** FIN AREA DE EVENTOS **************************

	// ********** ACCESORES PARA LAS PROPIEDADES DE CLASE ************

	// ************ ACCESORES PARA REFLEXION *************************

	public JMenu getArchivo() {
		return archivo;
	}

	public JMenu getClientes() {
		return clientes;
	}

	public JMenu getProveedores() {
		return proveedores;
	}

	public JMenu getAlmacen() {
		return almacen;
	}

	public JMenu getVencimientos() {
		return vencimientos;
	}

	public JMenu getAyuda() {
		return ayuda;
	}

	public JMenuItem getArchivo_configuracion() {
		return archivo_configuracion;
	}

	public JMenuItem getArchivo_salir() {
		return archivo_salir;
	}

	public JMenuItem getClientes_gestion() {
		return clientes_gestion;
	}

	public JMenuItem getClientes_pedidos() {
		return clientes_pedidos;
	}

	public JMenuItem getClientes_historico() {
		return clientes_historico;
	}

	public JMenu getListado_clientes() {
		return listado_clientes;
	}

	public JMenuItem getListadoclientes_activos() {
		return listadoclientes_activos;
	}

	public JMenuItem getListadoclientes_morosos() {
		return listadoclientes_morosos;
	}

	public JMenuItem getListadoclientes_bajas() {
		return listadoclientes_bajas;
	}

	public JMenuItem getProveedores_gestion() {
		return proveedores_gestion;
	}

	public JMenuItem getProveedores_pedidos() {
		return proveedores_pedidos;
	}

	public JMenuItem getProveedores_servicios() {
		return proveedores_servicios;
	}

	public JMenuItem getAlmacen_articulos() {
		return almacen_articulos;
	}

	public JMenuItem getAlmacen_almacen() {
		return almacen_almacen;
	}

	public JMenuItem getAlmacen_catalogo() {
		return almacen_catalogo;
	}

	public JMenuItem getVencimientos_pagos() {
		return vencimientos_pagos;
	}

	public JMenuItem getVencimientos_cobros() {
		return vencimientos_cobros;
	}

	public JMenuItem getVencimientos_morosos() {
		return vencimientos_morosos;
	}

	public JMenuItem getVencimientos_flujo() {
		return vencimientos_flujo;
	}

	public JMenu getListado_vencimientos() {
		return listado_vencimientos;
	}

	public JMenuItem getListadovencimientos_facturacion() {
		return listadovencimientos_facturacion;
	}

	public JMenuItem getListadovencimientos_pendientes() {
		return listadovencimientos_pendientes;
	}

	public JMenuItem getListadovencimientos_morosidad() {
		return listadovencimientos_morosidad;
	}

	public JMenuItem getAyuda_manual() {
		return ayuda_manual;
	}

	public JMenuItem getAyuda_acercade() {
		return ayuda_acercade;
	}

	public JMenuItem getAyuda_calculadora() {
		return ayuda_calculadora;
	}

	// ************ ACCESORES PARA SPRING ****************************
}
