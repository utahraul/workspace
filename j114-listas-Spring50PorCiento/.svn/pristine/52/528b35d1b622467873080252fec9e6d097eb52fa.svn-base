package com.atrium.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atrium.modelo.Pais;
import com.atrium.modelo.Provincias;

public class Provincias_DAO {

	private Connection conexion;
	private Statement sta;
	private ResultSet rs;
	
	public Provincias_DAO(){
		Conexion con=new Conexion();
		con.crear_ConexionAutomatica();
		conexion=con.getConexion();
	}
	
	public List<Provincias> consultar_Todos(){
		List<Provincias> lista=new ArrayList<>();
		try {
			sta=conexion.createStatement();
			rs=sta.executeQuery("select * from provincias");
			Provincias provincia_nueva;
			while(rs.next()){
				provincia_nueva=new Provincias();
				provincia_nueva.setCodigoprovincia(rs.getInt(1));
				provincia_nueva.setProvincia(rs.getString(2));
				lista.add(provincia_nueva);
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
