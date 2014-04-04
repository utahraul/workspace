package com.atrium.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.atrium.conexion.Conexion;

public class Pedidos_DAO extends Abstract_DAO {

	public Pedidos_DAO() {
		super();
	}

	public Pedidos_DAO(int tipoconexion) {
		super(tipoconexion);
	}

	public void alta_Pedido(Pedido pedido_nuevo) throws SQLException {
		pta = conexion.prepareStatement(rb.getString("alta.pedido"));
		this.cargar_DatosPTA(pedido_nuevo, ALTA);
		pta.execute();
	}

	public void baja_Pedido(Pedido pedido_aeliminar) {
		try {
			pta = conexion.prepareStatement(rb.getString("baja.pedido"));
			pta.setInt(1, pedido_aeliminar.getNumero_pedido());
			boolean resultado = pta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificar_Pedido(Pedido pedido_amodificar) {
		try {
			pta = conexion
					.prepareStatement(rb.getString("modificacion.pedido"));
			this.cargar_DatosPTA(pedido_amodificar, MODIFICACION);
			pta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Pedido consultar_PedidoPorNumero(Integer numero_pedido) {

		return null;
	}

	/**
	 * Proceso de carga de variables de los prepare statement.
	 * 
	 * @param pedido_nuevo
	 *            Objeto pedido con la informacion a cargar.
	 * @param tipo_proceso
	 *            Tipo de carga (alta/modificacion).
	 * @throws SQLException
	 */
	private void cargar_DatosPTA(Pedido pedido_nuevo, int tipo_proceso)
			throws SQLException {
		// POSICION DE LA VARIABLE EN EL COMANDO SQL
		int posicion_variable = 0;
		// EN FUNCION DEL TIPO DE PROCESO SE ESTABLECE LA POSICION INICIAL
		if (tipo_proceso == ALTA) {
			posicion_variable = 2;
			pta.setInt(1, pedido_nuevo.getNumero_pedido());
		}
		if (tipo_proceso == MODIFICACION) {
			posicion_variable = 1;
			pta.setInt(11, pedido_nuevo.getNumero_pedido());
		}
		// UNA VEZ ESTABLECIDO EL POSICION INICIAL DE LA VARIABLE CARGAMOS LOS
		// VALORES
		if (pedido_nuevo.getFecha_pedido() != null) {
			pta.setDate(posicion_variable, new Date(pedido_nuevo
					.getFecha_pedido().getTime()));
		} else {
			pta.setDate(posicion_variable,
					new Date(new java.util.Date().getTime()));
		}
		posicion_variable++;
		if (pedido_nuevo.getPorte_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getPorte_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getSeguro_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getSeguro_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getOtros_cargos_pedio() != null) {
			pta.setDouble(posicion_variable,
					pedido_nuevo.getOtros_cargos_pedio());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getTotal_cargos_pedido() != null) {
			pta.setDouble(posicion_variable,
					pedido_nuevo.getTotal_cargos_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getTotal_bruto_pedido() != null) {
			pta.setDouble(posicion_variable,
					pedido_nuevo.getTotal_bruto_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getPorcentaje_iva_pedido() != null) {
			pta.setInt(posicion_variable,
					pedido_nuevo.getPorcentaje_iva_pedido());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getIva_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getIva_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getTotal_factura_pedido() != null) {
			pta.setDouble(posicion_variable,
					pedido_nuevo.getTotal_factura_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		pta.setInt(posicion_variable, pedido_nuevo.getCodigo_cliente());
	}
}
