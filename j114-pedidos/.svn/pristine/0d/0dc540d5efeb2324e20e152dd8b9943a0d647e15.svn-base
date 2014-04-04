package com.atrium.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atrium.modelo.Gestion_Pedidos;
import com.atrium.modelo.Linea_Pedido;
import com.atrium.modelo.Linea_PedidoDAO;
import com.atrium.modelo.Pedido;
import com.atrium.modelo.Pedidos_DAO;

public class Inicio {

	public static void main(String[] args) {

		Gestion_Pedidos gestion_pedido = new Gestion_Pedidos();

		Pedido pedido_nuevo = new Pedido();
		pedido_nuevo.setNumero_pedido(new Integer(998));
		pedido_nuevo.setFecha_pedido(new Date());
		pedido_nuevo.setTotal_factura_pedido(new Double(10151));
		pedido_nuevo.setCodigo_cliente(new Integer(21));

		List<Linea_Pedido> lineas = new ArrayList<>();
		Linea_Pedido linea_nueva = new Linea_Pedido();

		linea_nueva.setCodigo_linea_pedido(new Long(1001));
		linea_nueva.setNumero_pedido(new Integer(998));
		linea_nueva.setCodigo_articulo(new Integer(101));
		lineas.add(linea_nueva);
		linea_nueva = new Linea_Pedido();
		linea_nueva.setCodigo_linea_pedido(new Long(1002));
		linea_nueva.setNumero_pedido(new Integer(998));
		linea_nueva.setCodigo_articulo(new Integer(104));
		lineas.add(linea_nueva);

		pedido_nuevo.setLineas_pedido(lineas);

		gestion_pedido.alta_Pedido(pedido_nuevo);

	}

}
