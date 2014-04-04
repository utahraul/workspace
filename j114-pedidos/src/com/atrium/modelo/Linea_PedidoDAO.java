package com.atrium.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.atrium.conexion.Conexion;

public class Linea_PedidoDAO extends Abstract_DAO {

	public Linea_PedidoDAO() {
		super();
	}

	public Linea_PedidoDAO(int tipoconexion) {
		super(tipoconexion);
	}

	public void alta_LineaPedido(Linea_Pedido linea_nueva) throws SQLException {
		pta = conexion.prepareStatement(rb.getString("alta.lineapedido"));
		this.cargar_DatosPTA(linea_nueva, ALTA);
		pta.execute();
	}

	public void baja_Pedido(Linea_Pedido linea_aborrar) {
		try {
			pta = conexion.prepareStatement(rb.getString("baja.lineapedido"));
			pta.setLong(1, linea_aborrar.getCodigo_linea_pedido());
			pta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificacion_LineaPedido(Linea_Pedido linea_amodificar) {
		try {
			pta = conexion.prepareStatement(rb
					.getString("modificacion.lineapedido"));
			this.cargar_DatosPTA(linea_amodificar, MODIFICACION);
			pta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Linea_Pedido> consultar_LineasPedido(Pedido numero_pedido) {

		return null;
	}

	/**
	 * Proceso de carga de variables de los prepare statement.
	 * 
	 * @param linea_nueva
	 *            Objeto pedido con la informacion a cargar.
	 * @param tipo_proceso
	 *            Tipo de carga (alta/modificacion).
	 * @throws SQLException
	 */
	private void cargar_DatosPTA(Linea_Pedido linea_nueva, int tipo_proceso)
			throws SQLException {
		// POSICION DE LA VARIABLE EN EL COMANDO SQL
		int posicion_variable = 0;
		// EN FUNCION DEL TIPO DE PROCESO SE ESTABLECE LA POSICION INICIAL
		if (tipo_proceso == ALTA) {
			posicion_variable = 2;
			pta.setLong(1, linea_nueva.getCodigo_linea_pedido());
		}
		if (tipo_proceso == MODIFICACION) {
			posicion_variable = 1;
			pta.setLong(6, linea_nueva.getCodigo_linea_pedido());
		}
		// UNA VEZ ESTABLECIDO EL POSICION INICIAL DE LA VARIABLE CARGAMOS LOS
		// VALORES
		if (linea_nueva.getCodigo_articulo() != null) {
			pta.setInt(posicion_variable, linea_nueva.getCodigo_articulo());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (linea_nueva.getNumero_pedido() != null) {
			pta.setInt(posicion_variable, linea_nueva.getNumero_pedido());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (linea_nueva.getPrecio_unidad_articulo() != null) {
			pta.setDouble(posicion_variable,
					linea_nueva.getPrecio_unidad_articulo());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (linea_nueva.getNumero_unidades_articulo() != null) {
			pta.setInt(posicion_variable,
					linea_nueva.getNumero_unidades_articulo());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (linea_nueva.getPorcentaje_descuento() != null) {
			pta.setFloat(posicion_variable,
					linea_nueva.getPorcentaje_descuento());
		} else {
			pta.setFloat(posicion_variable, new Float(0));
		}

	}
}
