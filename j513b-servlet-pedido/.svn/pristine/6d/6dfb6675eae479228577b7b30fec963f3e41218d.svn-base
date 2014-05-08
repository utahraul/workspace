package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.dao.ArticulosDAO;

public class Articulo_DAOEXT extends ArticulosDAO {

	public List<Articulos> consultar_Stock() {
		List<Articulos> lista_arti = null;
		DetachedCriteria consulta = DetachedCriteria.forClass(Articulos.class);
		consulta.add(Restrictions.isNotNull("cantidad"));
		// FALTA LA DESAHABILITACION DEL CACHE DE SEGUNDO NIVEL
		lista_arti = getHibernateTemplate().findByCriteria(consulta);
		return lista_arti;
	}

}
