package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

public class Provincias_DAOEXT extends ProvinciasDAO {

	public Provincias consultar_ConMunicipios(Byte codigo_provincia) {
		Criteria consulta = getSession().createCriteria(Provincias.class);
		consulta.setFetchMode("lista_municipios", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(codigo_provincia));
		Provincias provincia = (Provincias) consulta.uniqueResult();
		return provincia;
	}

}
