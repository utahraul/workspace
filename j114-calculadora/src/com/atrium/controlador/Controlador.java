package com.atrium.controlador;

import com.atrium.modelo.Modelo;
import com.atrium.vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;

	public Controlador() {
		modelo = new Modelo();
		vista = new Vista();

		menu_Opciones();
	}

	public void menu_Opciones() {
		int opcion = 0;
		// ESTRUCTURA DE CONTROL DE FLUJO DEL PROGRAMA
		while (opcion != 6) {
			// SE ENSEÑA EL MENU
			vista.mostrar_Menu();
			// SE PIDE LA OPCION AL USUARIO
			opcion = vista.tratar_Int(vista.leer_Texto());
			// EN FUNCION DEL VALOR ELEGIDO SE REALIZA ALGUNA OPCION U OTRA
			switch (opcion) {
			case 1:
				// SE OPERA CON LOS VALORES INTRODUCIDOS
				modelo.setResultado(modelo.getOpe1() + modelo.getOpe2());
				// SE MUESTAR EL RESULTADO POR CONSOLA. IGUAL EN TODAS LAS
				// OPCIONES
				vista.mostrar_Texto("EL RESULTADO DE LA SUMA ES "
						+ String.valueOf(modelo.getResultado()));
				break;
			case 2:
				modelo.setResultado(modelo.getOpe1() - modelo.getOpe2());
				vista.mostrar_Texto("EL RESULTADO DE LA RESTA ES "
						+ String.valueOf(modelo.getResultado()));
				break;
			case 3:
				modelo.setResultado(modelo.getOpe1() * modelo.getOpe2());
				vista.mostrar_Texto("EL RESULTADO DE LA multiplicacion ES "
						+ String.valueOf(modelo.getResultado()));
				break;
			case 4:
				modelo.setResultado(modelo.getOpe1() / modelo.getOpe2());
				vista.mostrar_Texto("EL RESULTADO DE LA division ES "
						+ String.valueOf(modelo.getResultado()));
				break;
			case 5:
				// PETICION DE NUEVOS VALORES NUMERICOS
				proceso_Numerico();
				break;
			default:
				// CONTROL DE ERRORES
				if (opcion > 6) {
					vista.mostrar_Texto("LAS OPCIONES VALIDAS SON DEL 1 AL 6");
				}
				if (opcion == 0) {
					vista.mostrar_Texto("SOLO SE ADMITEN CARACTERES NUMERICOS");
				}
				break;
			}
		}
	}
	
	/**
	 * Proceso de peticion de numeros. Se puede repetir cuantas veces quiera el
	 * usuario.
	 */
	public void proceso_Numerico() {
		// PEDIMOS UN NUMERO
		vista.mostrar_Texto("Teclee un numero");
		// PASAMOS EL NUMERO AL MODELO DESPUES DE PEDIRLO Y TRANSFORMARLO A
		// NUMERO	
		modelo.setOpe1(vista.tratar_Int(vista.leer_Texto()));
		// PEDIMOS EL SIGUIENTE NUMERO
		vista.mostrar_Texto("Teclee otro numero");
		// PASAMOS EL OTRO NUMERO AL MODELO DESPUES DE PEDIRLO Y TRANSFORMARLO A
		// NUMERO
		modelo.setOpe2(vista.tratar_Int(vista.leer_Texto()));
	}

}






