package com.atrium.imagenes;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Tratamiento general de las imagenes en nuestra apliacion.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.3
 * @since 17-3-2014
 * 
 */
public class Obtener_Imagenes implements IDefinicion_Imagenes {

	/**
	 * Proceso de escalado de imagenes.
	 * 
	 * @param ruta_nombre
	 *            Ruta interna del icono/imagen.
	 * @param tama�o
	 *            Valor entro que representa el tama�o a aplicar, definido en
	 *            constantes de clase.
	 * @return Imagen escalada.
	 */
	public static ImageIcon escalar_Imagen(String ruta_nombre, int tama�o) {
		// OBTENEMOS LA IMAGEN A ESCALAR
		ImageIcon imagen_tratada = new ImageIcon(
				Obtener_Imagenes.class.getResource(ruta_nombre));
		// ESTABLECEMOS LA ESCALA SEGUN NECESIDADES
		if (tama�o == _16X16) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		}
		if (tama�o == _24X24) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		}
		if (tama�o == _32X32) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		}
		if (tama�o == _48X48) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(48, 48, Image.SCALE_SMOOTH));
		}
		if (tama�o == _60X60) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		}

		if (tama�o == _256X256) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(256, 256, Image.SCALE_SMOOTH));
		}
		return imagen_tratada;
	}

}
