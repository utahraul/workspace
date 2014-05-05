package com.atrium.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Usuario_DAO {

	private Connection conexion;
	private PreparedStatement pta;
	private ResultSet rs;

	public Usuario_DAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conexion = DriverManager.getConnection(
				"jdbc:oracle:thin:@a3-server:1521:XE", "master", "master");
	}

	public void alta_Usuario(Usuario usuario_nuevo) throws SQLException {
		// CREAMOS LA ORDEN DE ALTA
		pta = conexion
				.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
		// SUSTITUIMOS VALORES EN LAS VARIABLES
		pta.setString(1, usuario_nuevo.getNombreUsuario());
		pta.setString(2, usuario_nuevo.getPassword());
		if (usuario_nuevo.getCodigoRol() != null) {
			pta.setInt(3, usuario_nuevo.getCodigoRol());
		} else {
			// SIN CODIDO DE ROL ASIGNADO
			pta.setNull(3, Types.NULL);
		}
		pta.setDate(4, new Date(usuario_nuevo.getFechaAlta().getTime()));
		if (usuario_nuevo.getFechaBaja() != null) {
			pta.setDate(5, new Date(usuario_nuevo.getFechaBaja().getTime()));
		} else {
			pta.setDate(5, null);
		}
		pta.setString(6, usuario_nuevo.getCarpetaDocumentacion());
		pta.setString(7, usuario_nuevo.getIdioma());
		// EJECUTAMOS EL ALTA
		pta.execute();
	}

	public void baja_Usuario(Usuario usuario_aeliminar) throws SQLException {
		// CREAMOS LA ORDEN DE BAJA
		pta = conexion
				.prepareStatement("delete from usuarios where nombre_usuario= ?");
		// SUSTITUIMOS VALORES EN LAS VARIABLES
		pta.setString(1, usuario_aeliminar.getNombreUsuario());
		// EJECUTAMOS LA BAJA
		pta.execute();
	}

	public void modificar_Usuario(Usuario usuario_amodificar)
			throws SQLException {
		// CREAMOS LA ORDEN DE MODIFICACION
		pta = conexion
				.prepareStatement("update usuarios set password =?, codigo_rol=?,fecha_alta=?,fecha_baja=?,carpeta_documentacion=?,idioma=? where nombre_usuario= ?");
		// SUSTITUIMOS VALORES EN LAS VARIABLES
		pta.setString(1, usuario_amodificar.getPassword());
		pta.setInt(2, usuario_amodificar.getCodigoRol());
		pta.setDate(3, new Date(usuario_amodificar.getFechaAlta().getTime()));
		if (usuario_amodificar.getFechaBaja() != null) {
			pta.setDate(4,
					new Date(usuario_amodificar.getFechaBaja().getTime()));
		} else {
			pta.setDate(4, null);
		}
		pta.setString(5, usuario_amodificar.getCarpetaDocumentacion());
		pta.setString(6, usuario_amodificar.getIdioma());
		// CONDICIONAL
		pta.setString(7, usuario_amodificar.getNombreUsuario());
		// EJECUTAMOS LA MODIFICACION
		pta.execute();
	}

	public Usuario consultar_Usuario(String nombre_usuario) throws SQLException {
		// CREAMOS LA ORDEN DE CONSULTA
		pta = conexion
				.prepareStatement("select * from usuarios where nombre_usuario= ?");
		// SUSTITUIMOS VALORES EN LAS VARIABLES
		pta.setString(1, nombre_usuario);
		// EJECUTAMOS LA CONSULTA
		rs = pta.executeQuery();
		// PASAMOS LA INFORMACION OBTENIDA A UN OBJETO
		Usuario usuario_consultado = null;
		if (rs.next()) {
			usuario_consultado = new Usuario();
			usuario_consultado.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
			usuario_consultado.setCarpetaDocumentacion(rs
					.getString("carpeta_documentacion"));
			try {
				usuario_consultado.setCodigoRol(new Integer(rs
						.getInt("codigo_rol")));
			} catch (Exception e) {
				usuario_consultado.setCodigoRol(null);
			}
			if (rs.getDate("fecha_alta") != null) {
				usuario_consultado.setFechaAlta(new java.util.Date(rs.getDate(
						"fecha_alta").getTime()));
			} else {
				usuario_consultado.setFechaAlta(null);
			}
			if (rs.getDate("fecha_baja") != null) {
				usuario_consultado.setFechaBaja(new java.util.Date(rs.getDate(
						"fecha_baja").getTime()));
			} else {
				usuario_consultado.setFechaBaja(null);
			}
			usuario_consultado.setIdioma(rs.getString("idioma"));
			usuario_consultado.setPassword(rs.getString("password"));
		}
		return usuario_consultado;
	}

	public Connection getConexion() {
		return conexion;
	}

	public PreparedStatement getPta() {
		return pta;
	}

	public ResultSet getRs() {
		return rs;
	}

}
