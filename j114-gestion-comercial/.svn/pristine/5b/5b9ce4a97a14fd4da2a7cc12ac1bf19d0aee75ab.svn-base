package com.atrium.configuracion;

public interface IGestion_Configuracion {

	/**
	 * Proceso interno de la clase que carga la configuracion del fichero
	 * properties.
	 */
	public void leer_Configuracion();

	/**
	 * Proceso de modificacion de los valores de la configuracion del programa.
	 * 
	 * @param confi_modificada
	 *            DTO con la nueva informacion a guardar.
	 */
	public void modificar_Configuracion(
			Configuracion_DTO confi_modificada);

	/**
	 * Recarga de las opciones por defecto en el fichero de configuracion en caso
	 * de que sea necesario.
	 */
	public void recargar_Configuracion();

	/**
	 * Proceso mediante el cual calculamos el fichero properties correspondiente
	 * a cada clase y cada idioma en funcion de las preferecias establecidas.
	 * 
	 * @param objeto_atraducir
	 *            Class de la interface grafica u objeto a traducir.
	 * @return Cadena con la ruta y el nombre del properties.
	 */
	public String getRecurso_Idiomatico(Class objeto_atraducir);

	/**
	 * Accesor del DTO con la informacion de la configuracion.
	 * 
	 * @return
	 */
	public Configuracion_DTO getConfiguracion();

}