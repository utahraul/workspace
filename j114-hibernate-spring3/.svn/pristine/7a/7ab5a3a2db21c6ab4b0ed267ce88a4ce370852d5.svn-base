package com.atrium.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.LineaPedido;
import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.modelo.IGestion_Pedido;

public class Inicio {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/modelo.xml");

		IGestion_Pedido gestion_pedido = contexto
				.getBean(IGestion_Pedido.class);

		Pedidos pedido_nuevo = new Pedidos();
		pedido_nuevo.setFechaPedido(new Date());
		pedido_nuevo.setTotalFacturaPedido(new Double(10151));
		pedido_nuevo.setCodigoCliente(new Integer(21));

		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido linea_nueva = new LineaPedido();
		linea_nueva.setPedidos(pedido_nuevo);
		Articulos articulo = new Articulos();
		articulo.setCodigoArticulo(new Integer(101));
		linea_nueva.setArticulos(articulo);
		lineas.add(linea_nueva);
		linea_nueva = new LineaPedido();
		articulo = new Articulos();
		articulo.setCodigoArticulo(new Integer(104));
		linea_nueva.setArticulos(articulo);
		lineas.add(linea_nueva);
		Set<LineaPedido> set_articulos = new HashSet<>();
		set_articulos.addAll(lineas);

		pedido_nuevo.setLineaPedidos(set_articulos);
		boolean valido = true;
		try {
			gestion_pedido.alta_Pedido(pedido_nuevo);
		} catch (Exception e) {
			valido = false;
		}

		System.out.println("");

	}

}
