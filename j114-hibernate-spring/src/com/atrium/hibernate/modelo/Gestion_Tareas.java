package com.atrium.hibernate.modelo;

import com.atrium.hibernate.dao.TareasDAO;

public class Gestion_Tareas {

	private TareasDAO tareas_dao;

	
	
	// ACCESORES PARA SPRING
	public void setTareas_dao(TareasDAO tareas_dao) {
		this.tareas_dao = tareas_dao;
	}

}
