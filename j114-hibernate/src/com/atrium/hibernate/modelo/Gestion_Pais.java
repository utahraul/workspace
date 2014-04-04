package com.atrium.hibernate.modelo;

import java.util.List;

import org.hibernate.Transaction;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.dao.PaisDAO;

public class Gestion_Pais {

	private PaisDAO pais_dao;

	public Gestion_Pais() {
		pais_dao = new PaisDAO();
	}

	public List<Pais> consultar_Todos() {
		List<Pais> lista = pais_dao.findAll();
		pais_dao.getSession().close();
		return lista;
	}

	public Pais consultar_PorCodigo(Long clave_pais) {
		Pais pais = pais_dao.findById(clave_pais);
		pais_dao.getSession().close();
		return pais;
	}

	public void alta_Pais(Pais pais_nuevo) {
		Transaction tran = pais_dao.getSession().beginTransaction();
		try {
			pais_dao.save(pais_nuevo);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}
		pais_dao.getSession().close();
	}

	public void baja_Pais(Pais pais_nuevo) {
		Transaction tran = pais_dao.getSession().beginTransaction();
		try {
			pais_dao.delete(pais_nuevo);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}
		pais_dao.getSession().close();
	}

	public void modificacion_Pais(Pais pais_nuevo) {
		Transaction tran = pais_dao.getSession().beginTransaction();
		try {
			pais_dao.attachDirty(pais_nuevo);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}
		pais_dao.getSession().close();
	}

}
