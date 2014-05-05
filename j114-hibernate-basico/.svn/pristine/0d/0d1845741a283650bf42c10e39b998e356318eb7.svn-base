package com.atrium.hibernate.modelo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.dao.ArticulosDAO;

public class Gestion_Articulos {

	private ArticulosDAO articulos_dao;

	public Gestion_Articulos() {
		articulos_dao = new ArticulosDAO();
	}

	public Articulos consultar_Articulo(Integer codigo_articulo) {
		Articulos articulo_buscado = articulos_dao.findById(codigo_articulo);
		articulos_dao.getSession().close();
		return articulo_buscado;
	}

	public void baja_Articulo(Articulos articulo_aeliminar) {
		Transaction transaccion = null;
		try {
			transaccion = articulos_dao.getSession().beginTransaction();
			articulos_dao.delete(articulo_aeliminar);
			transaccion.commit();
		} catch (HibernateException e) {
			// ERROR EN LA BAJA
			transaccion.rollback();
		}
		articulos_dao.getSession().close();
	}

	public void alta_Articulo(Articulos articulo_nuevo) {
		Transaction transaccion = null;
		try {
			transaccion = articulos_dao.getSession().beginTransaction();
			articulos_dao.save(articulo_nuevo);
			transaccion.commit();
		} catch (HibernateException e) {
			// ERROR EN EL ALTA
			transaccion.rollback();
		}
		articulos_dao.getSession().close();
	}

	public void modificacion_Articulo(Articulos articulo_amodificar) {
		Transaction transaccion = null;
		try {
			transaccion = articulos_dao.getSession().beginTransaction();
			articulos_dao.attachDirty(articulo_amodificar);
			transaccion.commit();
		} catch (HibernateException e) {
			// ERROR EN LA MODIFICACION
			transaccion.rollback();
		}
		articulos_dao.getSession().close();
	}

	public List<Articulos> consultar_Todos() {
		List<Articulos> lista = articulos_dao.findAll();
		articulos_dao.getSession().close();
		return lista;
	}
}
