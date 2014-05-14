package com.atrium.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * Conjunto de procesos de copia de ficheros. Cada metodo es capaz de copiar un
 * fichero, usando cada uno de ellos una metodlogia y unas apis distintas.<br/>
 * Sirven como ejemplo del uso de las apis de ficheros.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 14-5-2013
 * 
 */
public class Copiar_Ficheros {

	/**
	 * COPIA DE FICHEROS USANDO LAS APIS NUEVAS DE FLUJOS. POSIBLES PROBLEMAS EN
	 * ALGUN TIPO DE ORDENADOR. OPCION MAS RAPIDA
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws IOException
	 */
	public static void copiar_FicherosNIO(File fichero_entrada,
			File fichero_salida) throws IOException {
		FileChannel inChannel = new FileInputStream(fichero_entrada)
				.getChannel();
		FileChannel outChannel = new FileOutputStream(fichero_salida)
				.getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (inChannel != null)
				inChannel.close();
			if (outChannel != null)
				outChannel.close();
		}
	}

	/**
	 * Opcion de copia de ficheros con IO. Segura en fucionamiento pero mas
	 * lenta que la opcion con NIO:
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws Exception
	 */
	public static void copiar_FicherosIO1(File fichero_entrada,
			File fichero_salida) throws Exception {
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(
				fichero_entrada));
		BufferedOutputStream fos = new BufferedOutputStream(
				new FileOutputStream(fichero_salida));
		try {
			byte[] buf = new byte[2048];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}

	/**
	 * Opcion de copia de ficheros para IO.
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws Exception
	 */

	public static void copiar_FicherosIO11(InputStream fichero_entrada,
			File fichero_salida) throws Exception {
		BufferedInputStream fis = new BufferedInputStream(fichero_entrada);
		BufferedOutputStream fos = new BufferedOutputStream(
				new FileOutputStream(fichero_salida));
		try {
			byte[] buf = new byte[2048];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}

	/**
	 * COPIA DE FICHEROS SEGURA , MAS LENTA QUE LA SOLUCION DE NIO. UN POCO MAS
	 * RAPIDA QUE LA ANTERIOR, PERO AUN ASI MAS LENTA QUE LA NIO.
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws IOException
	 */

	public static void copiar_FicherosIO2(String fichero_entrada,
			String fichero_salida) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		int amountRead;
		byte[] buffer = new byte[2048];
		try {
			in = new FileInputStream(fichero_entrada);
			out = new FileOutputStream(fichero_salida);
			while (true) {
				amountRead = in.read(buffer);
				if (amountRead == -1) {
					break;
				}
				out.write(buffer, 0, amountRead);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
