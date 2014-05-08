package com.atrium.etiquetas;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.modelo.IGestion_Articulos;
import com.atrium.spring.Acceso_ApplicationContext;

public class Consultar_A_Pedidos extends BodyTagSupport implements
		Comparator<Articulos> {
	// PROPIEDADES PARA RECIBIR LOS VALORES DE LA PAGINA
	private String sentido;
	private String campo_ordenacion;

	@Override
	public int doEndTag() throws JspException {
		// ACCEDEMOS A LA FACHADA PARA CONSULTAR CLIENTES
		IGestion_Articulos ges_art = Acceso_ApplicationContext
				.getBean(IGestion_Articulos.class);
		// CONSULTAMOS EN LA BASE DE DATOS
		List<Articulos> lista_articulos = ges_art.consulta_General();
		// ORDENAMOS LA COLECCION POR LOS CRITERIOS DICHOS EN LA ETIQUETA
		Collections.sort(lista_articulos, this);
		// GENEREMOS EL HTML PARA LA PAGINA
		String inicio_fila = "<tr>\n";
		String fin_fila = "</tr>\n";
		int posicion = 0;
		StringBuilder salida = new StringBuilder();
		for (Articulos articulo : lista_articulos) {
			salida.append(inicio_fila);
			salida.append("\n<td width='30' > \n <input type='checkbox' id='check_art"
					+ String.valueOf(posicion)
					+ "' name='check_art'/> </td> \n");
			salida.append("<td width='60'> \n <input type='text' id='cod_"
					+ String.valueOf(posicion)
					+ "' name='codigo_articulo' readonly size='6' style='text-align:right' value='"
					+ String.valueOf(articulo.getCodigoArticulo())
					+ "'/> </td> \n");
			salida.append("<td width='340'> \n <input type='text' id='des"
					+ String.valueOf(posicion) + "' readonly size='51' value='"
					+ String.valueOf(articulo.getDescripcionArticulo())
					+ "'/> </td> \n");
			salida.append("<td width='80'> \n <input type='text' id='pre"
					+ String.valueOf(posicion)
					+ "' readonly size='8' style='text-align:right' value='"
					+ String.valueOf(articulo.getPrecioUnidadArticulo())
					+ "'/> </td> \n");
			salida.append("<td width='50'> \n <input id='num_art"
					+ String.valueOf(posicion)
					+ "' type='text' name='num_art' readonly size='5' style='text-align:right' value='"
					+ String.valueOf(articulo.getCantidad()) + "'/>\n </td> \n");
			salida.append(fin_fila);
			posicion++;
		}
		// ESCRIBIMOS EN LA PAGINA
		try {
			bodyContent.getEnclosingWriter().write(salida.toString());
		} catch (IOException e) {
			System.out.println("Error al escribir en el cuerpo");
		}
		return EVAL_PAGE;
	}

	// METODO DE ORDENACION
	public int compare(Articulos arti_1, Articulos arti_2) {
		int ordenacion = 0;
		if (campo_ordenacion.equalsIgnoreCase("codigo")
				&& sentido.equalsIgnoreCase("d")) {
			ordenacion = arti_1.getCodigoArticulo().compareTo(
					arti_2.getCodigoArticulo());
		}
		if (campo_ordenacion.equalsIgnoreCase("codigo")
				&& sentido.equalsIgnoreCase("a")) {
			ordenacion = arti_2.getCodigoArticulo().compareTo(
					arti_1.getCodigoArticulo());
		}
		if (campo_ordenacion.equalsIgnoreCase("descripcion")
				&& sentido.equalsIgnoreCase("d")) {
			ordenacion = arti_1.getDescripcionArticulo().compareTo(
					arti_2.getDescripcionArticulo());
		}
		if (campo_ordenacion.equalsIgnoreCase("descripcion")
				&& sentido.equalsIgnoreCase("a")) {
			ordenacion = arti_2.getDescripcionArticulo().compareTo(
					arti_1.getDescripcionArticulo());
		}
		return ordenacion;
	}

	// ACCESORES PARA RECIBIR LOS VALORES DE LA PAGINA
	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public String getCampo_ordenacion() {
		return campo_ordenacion;
	}

	public void setCampo_ordenacion(String campoOrdenacion) {
		campo_ordenacion = campoOrdenacion;
	}

}
