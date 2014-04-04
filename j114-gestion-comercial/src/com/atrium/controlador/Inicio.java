package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Inicio {

	public static void main(String[] args) {
		// PROCESO DE INICIO DE LA APLICACION CON LA REALIZACION DE CUALQUIER
		// TAREA PREVIA NECESARIA
		ICarga_Inicial cargar_Programa = new Carga_Inicial();
		cargar_Programa.opciones_Defecto();
	}

}
