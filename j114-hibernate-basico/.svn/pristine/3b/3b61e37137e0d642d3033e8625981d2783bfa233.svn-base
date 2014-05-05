package com.atrium.controlador;

import java.util.List;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.modelo.Gestion_Articulos;

public class Inicio {

	public static void main(String[] args) {
		Gestion_Articulos gestion_articulo = new Gestion_Articulos();

		Articulos articulo_nuevo = new Articulos();

		articulo_nuevo.setCodigoArticulo(new Integer(999));
		articulo_nuevo.setCantidad(new Integer(10000));
		articulo_nuevo.setDescripcionArticulo("prueba j114");
		articulo_nuevo.setPrecioUnidadArticulo(new Double(1000));

		gestion_articulo.alta_Articulo(articulo_nuevo);

		articulo_nuevo.setPrecioUnidadArticulo(new Double(1));

		gestion_articulo.modificacion_Articulo(articulo_nuevo);

		Articulos otro_articulo = gestion_articulo
				.consultar_Articulo(new Integer(999));

		List<Articulos> lista = gestion_articulo.consultar_Todos();

		gestion_articulo.baja_Articulo(articulo_nuevo);
		System.out.println("");

	}

}
