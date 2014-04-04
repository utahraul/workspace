package com.atrium.modelo;

import java.sql.SQLException;

public class Gestion_Pedidos {
	
	private Pedidos_DAO pedido_dao;
	private Linea_PedidoDAO linea_dao;
	
	public Gestion_Pedidos(){
		pedido_dao=new Pedidos_DAO();
		linea_dao=new Linea_PedidoDAO();
	}
	
	
	public boolean alta_Pedido(Pedido pedido_nuevo){
		boolean valido=true;
		try {
			linea_dao.recibir_Conexion(pedido_dao.conexion);
			pedido_dao.iniciar_Transaccion();
			pedido_dao.alta_Pedido(pedido_nuevo);
			for(Linea_Pedido linea: pedido_nuevo.getLineas_pedido()){
				linea_dao.alta_LineaPedido(linea);
			}
			pedido_dao.confirmar_Transaccion();
		} catch (SQLException e) {
			try {
				pedido_dao.anular_Transaccion();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			valido=false;
		}
		return valido;
	}

}
