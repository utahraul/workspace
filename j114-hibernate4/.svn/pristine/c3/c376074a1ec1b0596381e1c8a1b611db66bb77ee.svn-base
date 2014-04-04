package com.atrium.hibernate.modelo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;
import com.atrium.hibernate.dao.ext.Provincias_DAOEXT;

public class Gestion_Provincias implements IGestion_Provincias {

	private Provincias_DAOEXT provincias_dao;

	public Gestion_Provincias() {
		provincias_dao = new Provincias_DAOEXT();
	}

	@Override
	public Provincias consultar_ConMunicipios(Byte codigo_provincia) {
		Provincias provincia = provincias_dao
				.consultar_ConMunicipios(codigo_provincia);
		provincias_dao.getSession().close();
		return provincia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atrium.hibernate.modelo.IGestion_Provincias#consultar_ProvinciaPorCodigo
	 * (java.lang.Byte)
	 */
	@Override
	public Provincias consultar_ProvinciaPorCodigo(Byte codigo_provincia) {
		Provincias provincia_consultada = provincias_dao
				.findById(codigo_provincia);
		provincias_dao.getSession().close();
		return provincia_consultada;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atrium.hibernate.modelo.IGestion_Provincias#consultar_ProvinciaPorNombre
	 * (java.lang.String)
	 */
	@Override
	public Provincias consultar_ProvinciaPorNombre(String nombre_provincia) {
		List<Provincias> lista = provincias_dao.findByProperty("provincia",
				nombre_provincia);
		provincias_dao.getSession().close();
		Provincias provincia_consultada = null;
		if (!lista.isEmpty()) {
			provincia_consultada = lista.get(0);
		}
		return provincia_consultada;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atrium.hibernate.modelo.IGestion_Provincias#consultar_Todas()
	 */
	@Override
	public List<Provincias> consultar_Todas() {
		List<Provincias> lista = provincias_dao.findAll();
		provincias_dao.getSession().close();
		return lista;
	}

	@Override
	public void alta_Provincia(Provincias provincia_nueva) {
		Transaction tran = provincias_dao.getSession().beginTransaction();
		try {
			provincias_dao.save(provincia_nueva);
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		}
	}

	@Override
	public void baja_Provincia(Provincias provincia_aeliminar) {
		Transaction tran = provincias_dao.getSession().beginTransaction();
		try {
			provincias_dao.delete(provincia_aeliminar);
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		}
	}

	@Override
	public void modificacion_Provincia(Provincias provincia_amodificar) {
		Transaction tran = provincias_dao.getSession().beginTransaction();
		try {
			provincias_dao.attachDirty(provincia_amodificar);
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		}
	}
}
