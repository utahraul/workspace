package com.atrium.logica;

public class Prueba_Spring implements IPrueba_Texto {
	
	private String texto;

	
	/* (non-Javadoc)
	 * @see com.atrium.logica.IPrueba_Texto#mostrar_Text()
	 */
	@Override
	public String mostrar_Text(){
		return "Hola mundo SPRING";
	}
	
	/* (non-Javadoc)
	 * @see com.atrium.logica.IPrueba_Texto#mostrar_MasTexto(java.lang.String)
	 */
	@Override
	public String mostrar_MasTexto (String otro_texto){
		return "Hola ...." + otro_texto;
	}
	
	//ACCESORES PARA SPRING
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}
