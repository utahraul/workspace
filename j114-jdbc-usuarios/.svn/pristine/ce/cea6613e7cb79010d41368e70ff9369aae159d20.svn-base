package com.atrium.modelo;

import java.sql.SQLException;
import java.util.Date;

public class Gestion_Usuarios {

	private Usuario_DAO usuario_dao;

	public Gestion_Usuarios() {
		try {
			usuario_dao = new Usuario_DAO();
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR EN LA CARGA DEL DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR EN LA CONEXION");
		}
	}

	public void alta_Usuario(Usuario usuario_nuevo) {
		try {
			usuario_dao.alta_Usuario(usuario_nuevo);
		} catch (SQLException e) {
			// ERROR EN EL ALTA
			e.printStackTrace();
		}
		try {
			usuario_dao.getPta().close();
			usuario_dao.getConexion().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void baja_Usuario(Usuario usuario_aeliminar) {
		try {
			usuario_dao.baja_Usuario(usuario_aeliminar);
		} catch (SQLException e) {
			// ERROR EN EL BAJA
			e.printStackTrace();
		}
		try {
			usuario_dao.getPta().close();
			usuario_dao.getConexion().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificacion_Usuario(Usuario usuario_amodificar) {
		try {
			usuario_dao.modificar_Usuario(usuario_amodificar);
		} catch (SQLException e) {
			// ERROR EN EL MODIFICACION
			e.printStackTrace();
		}
		try {
			usuario_dao.getPta().close();
			usuario_dao.getConexion().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario consultar_Usuario(String nombre_usuario) {
		Usuario usuario_consultado = null;
		try {

			usuario_consultado = usuario_dao.consultar_Usuario(nombre_usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario_consultado;
	}

	public static void main(String arg[]) {
		Gestion_Usuarios gestion = new Gestion_Usuarios();
		System.out.println("");
		Usuario usuario_nuevo = new Usuario();

		usuario_nuevo.setNombreUsuario("prueba j114");
		usuario_nuevo.setCarpetaDocumentacion("mia");
		usuario_nuevo.setCodigoRol(new Integer(1));
		usuario_nuevo.setFechaAlta(new Date());
		usuario_nuevo.setFechaBaja(null);
		usuario_nuevo.setIdioma("es");
		usuario_nuevo.setPassword("prueba");

		gestion.alta_Usuario(usuario_nuevo);

		usuario_nuevo.setCarpetaDocumentacion("tuya");

		gestion = new Gestion_Usuarios();
		gestion.modificacion_Usuario(usuario_nuevo);

		gestion = new Gestion_Usuarios();
		Usuario usuario_consultado = gestion.consultar_Usuario("Juan");
		gestion = new Gestion_Usuarios();
		usuario_consultado = gestion.consultar_Usuario("JuanXXX");
		gestion = new Gestion_Usuarios();
		gestion.baja_Usuario(usuario_nuevo);

		System.out.println("");

	}
}
