package com.atrium.managedbean;

public class ConsultaFormulario_Bean {
	
	// PROPIEDADES PARA LOS PARAMETROS DE LA PETICION
	private String codigo_articulo;
	private String descripcion_articulo;
	private String precio_unidad_articulo;
	private Integer cantidad;
	
	
	// ACCESORES PARA JSF
	
	public String getCodigo_articulo() {
		return codigo_articulo;
	}
	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}
	public String getDescripcion_articulo() {
		return descripcion_articulo;
	}
	public void setDescripcion_articulo(String descripcion_articulo) {
		this.descripcion_articulo = descripcion_articulo;
	}
	public String getPrecio_unidad_articulo() {
		return precio_unidad_articulo;
	}
	public void setPrecio_unidad_articulo(String precio_unidad_articulo) {
		this.precio_unidad_articulo = precio_unidad_articulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
