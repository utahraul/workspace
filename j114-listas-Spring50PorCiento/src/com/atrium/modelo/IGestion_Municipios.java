package com.atrium.modelo;

import java.util.List;

public interface IGestion_Municipios {

	public List<Municipios> consultar_PorProvincias(Integer codigoprovincia);

}