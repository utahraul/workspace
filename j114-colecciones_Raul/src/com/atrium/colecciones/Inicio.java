package com.atrium.colecciones;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Inicio {

	public static void main(String[] args) {

		

		// cargar el nuevo look and feel si se puede
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				try {
					// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
					// USADA
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
					System.out.println("Cargando nimbus......");
				} catch (Exception ex) {
					System.out.println("error en la carga de nimbus");
				}
			}
		}
		
		Ventana ventana = new Ventana();

		// Colecciones coleccion = new Colecciones();
		// coleccion.cargar_Lista();
		// coleccion.ordenar_Lista();
		// Integer menor = coleccion.coger_Menor();
		// Integer mayor = coleccion.coger_Mayor();
		// Integer media = coleccion.calcular_Media();

		// System.out.println("");
	}

}
