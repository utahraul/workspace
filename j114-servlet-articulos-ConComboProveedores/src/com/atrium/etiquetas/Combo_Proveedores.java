package com.atrium.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.hibernate.Proveedores;
import com.atrium.hibernate.modelo.IGestion_Proveedores;
import com.atrium.spring.Acceso_ApplicationContext;

public class Combo_Proveedores extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		IGestion_Proveedores gestion_proveedores = Acceso_ApplicationContext
				.getBean(IGestion_Proveedores.class);
		List<Proveedores> lista = gestion_proveedores.consultar_Todos();
		StringBuffer salida = new StringBuffer();
		for (Proveedores proveedor : lista) {
			salida.append("\n<option value='" + proveedor.getCodigoProveedor()
					+ "'>" + proveedor.getCodigoProveedor() + " - "
					+ proveedor.getNombreProveedor() + "</option>");
		}
		this.getJspContext().getOut().append(salida.toString());
	}
}
