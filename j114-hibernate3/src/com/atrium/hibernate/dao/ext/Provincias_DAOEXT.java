package com.atrium.hibernate.dao.ext;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

public class Provincias_DAOEXT extends ProvinciasDAO {

	public Provincias consulta_ConMunicipios(Byte codigo_provincia) {
		// ABRIMOS LA CONSULTA
		Criteria consulta = getSession().createCriteria(PROVINCIA.getClass());
		// TIPO DE RESOLUCION DE CARGA VAGA (ASOCIACION ENTRE CLASES DE
		// PERSISTENCIA)
		consulta.setFetchMode("municipios", FetchMode.JOIN);
		// CONDICION DE LA CONSULTA
		consulta.add(Restrictions.idEq(codigo_provincia));
		// OBTENCION DEL RESULTADO DE LA CONSULTA
		Provincias provincia = (Provincias) consulta.uniqueResult();
		return provincia;
	}
}
