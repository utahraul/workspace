package com.atrium.vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vista {

	// METODO BASICO DE MOSTRAR TEXTO
	public void mostrar_Texto(String texto) {
		System.out.println(texto);
	}

	// METODO DE CAPTURA DE TECLADO
	public String leer_Texto() {
		// FLUJO DE LECTURA
		InputStreamReader flujo = new InputStreamReader(System.in);
		// ENVOLTORIO DEL FLUJO PARA SU USO
		BufferedReader lector = new BufferedReader(flujo);
		// OBJETO DE SALIDA CON EL TEXTO ESCRITO POR EL USUARIO
		String texto = null;
		try {
			// LECTURA DEL TECLADO HASTA INTRO
			texto = lector.readLine();
		} catch (IOException e) {
			// TRATAMIENTO DEL ERROR SI SE PROCEDE
		}
		// DEVOLUCION DEL TEXTO ESCRITO
		return texto;
	}

	// CONVERSION DE TEXTO A VALOR NUMERICO ENTERO PARA OPERAR
	public int tratar_Int(String numero) {
		int numero_letra = 0;
		try {
			// CONVERSION A PARTIR DE CLASE ENVOLTORIO INTEGER
			numero_letra = Integer.parseInt(numero);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// NO PERMITIMOS NEGATIVOS
		if (numero_letra < 0) {
			numero_letra = 0;
		}
		return numero_letra;
	}

	// MENU DE LA APLICACION
	public void mostrar_Menu() {
		mostrar_Texto("MENU DE LA APLICACION.");
		mostrar_Texto("1 SUMAR.");
		mostrar_Texto("2 RESTAR.");
		mostrar_Texto("3 MULTIPLICAR.");
		mostrar_Texto("4 DIVIDIR.");
		mostrar_Texto("5 INTRODUCIR VALORES NUMERICOS");
		mostrar_Texto("6 SALIR.");
	}
}
