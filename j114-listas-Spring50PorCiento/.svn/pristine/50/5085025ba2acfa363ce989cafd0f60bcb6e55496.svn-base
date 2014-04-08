package com.atrium.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atrium.modelo.Pais;

public class Pais_DAO {

	private Connection conexion;
	private Statement sta;
	private ResultSet rs;

	public Pais_DAO() {
		Conexion con=new Conexion();
		con.crear_ConexionAutomatica();
		conexion=con.getConexion();
	}
	
	public List<Pais> consultar_Todos(){
		List<Pais> lista=new ArrayList<>();
		try {
			sta=conexion.createStatement();
			rs=sta.executeQuery("select * from pais");
			Pais pais_nuevo;
			while(rs.next()){
				pais_nuevo=new Pais();
				pais_nuevo.setCodigopais(rs.getInt("codigo_pais"));
				pais_nuevo.setPaisiso2(rs.getString("PAIs_ISO2"));
				pais_nuevo.setPaisiso3(rs.getString("PAIs_ISO3"));
				pais_nuevo.setPaisisonum(rs.getInt("PAIs_ISONUM"));
				pais_nuevo.setPaisnombre(rs.getString("PAIs_NOMBRE"));
				lista.add(pais_nuevo);
			}
			rs.close();
			sta.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
}


