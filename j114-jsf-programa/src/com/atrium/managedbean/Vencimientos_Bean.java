package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.icefaces.ace.event.DateSelectEvent;
import org.icefaces.ace.event.ExpansionChangeEvent;

import com.atrium.hibernate.Clientes;
import com.atrium.hibernate.Vencimientos;
import com.atrium.hibernate.modelo.IGestion_Vencimientos;
import com.atrium.spring.Acceso_ApplicationContext;

public class Vencimientos_Bean implements Serializable {

	// PROPIEDADES PARA LA PAGINA JSF
	// coleccion de vencimientos a mostrar en el datatable
	private List<Vencimientos> lista_vencimientos;

	// PROPIEDADES PROCESO DE BUSQUEDA DE VENCIMIENTOS
	private Date primer_diames;
	private Date ultimo_dia;

	// PROPIEDADES PARA LOS PROCESOS DE MODELO
	private IGestion_Vencimientos gestion_vencimientos;

	/**
	 * Damos los valores iniciales a las fechas con el primer y el ultimo dia
	 * del mes de la fecha en curso.
	 */
	public Vencimientos_Bean() {
		// POR DEFECTO MOSTRAMOS LOS VENCIMIENTOS DEL MES EN CURSO
		GregorianCalendar hoy = new GregorianCalendar();
		// PRIMER DIA DEL MES
		hoy.set(Calendar.DAY_OF_MONTH, 1);
		// INICIO DEL DIA
		hoy.set(Calendar.HOUR, 0);
		hoy.set(Calendar.MINUTE, 0);
		hoy.set(Calendar.SECOND, 0);
		setPrimer_diames(hoy.getTime());

		// ULTIMO DIA DEL MES
		hoy.set(Calendar.DAY_OF_MONTH, hoy.getMaximum(Calendar.DAY_OF_MONTH));
		// FIN DEL DIA
		hoy.set(Calendar.HOUR, 23);
		hoy.set(Calendar.MINUTE, 59);
		hoy.set(Calendar.SECOND, 59);
		setUltimo_dia(hoy.getTime());

		gestion_vencimientos = Acceso_ApplicationContext
				.getBean(IGestion_Vencimientos.class);

		this.inicio_Bean();
	}

	/**
	 * Proceso de consulta de los vencimientos entre dos fechas dadas.<br/>
	 * Las fechas corresponden a los valores de las propiedades de clase
	 * primerdia_mes y ultimodia_mes.
	 */
	public void inicio_Bean() {
		// CONSULTAMOS LOS VENCIMIENTOS DEL MES
		List<Vencimientos> lista_vencidos = gestion_vencimientos
				.consultar_Vencimientos(primer_diames, ultimo_dia);
		// CREAMOS LA COLECCION PARA LOS VENCIMIENTOS SELECCIONABLES DE LA TABLA
		setLista_vencimientos(new ArrayList<Vencimientos>(0));
		// CARGAMOS LA TABLA CON LOS VENCIMIENTOS ENCONTRADOS
		lista_vencimientos.addAll(lista_vencidos);
	}

	// ********** ZONA DE EVENTOS ****************
	/**
	 * Evento de cambio de fecha. A partir de este evento modificamos la fecha
	 * inicial o final de busqueda y se recarga el contenido del datatable.
	 * 
	 * @param evento
	 */
	public void cambiar_Fecha(DateSelectEvent evento) {
		// CAMBIAMOS LA FECHA ELEGIDA POR EL USUARIO
		if (evento.getComponent().getId().equals("fecha_inicial")) {
			setPrimer_diames((Date) evento.getDate());
		} else {
			setUltimo_dia((Date) evento.getDate());
		}
		// RECARGAMOS LA COLECCION DE DATOS A MOSTRAR EN EL DATATABLE
		this.inicio_Bean();
	}

	/**
	 * opcion para el rowselector.
	 * 
	 * @param evento
	 */
	public void recuperar_Pedido(ExpansionChangeEvent evento) {

	}

	// ACCESORES PARA JSF
	public List<Vencimientos> getLista_vencimientos() {
		return lista_vencimientos;
	}

	public void setLista_vencimientos(List<Vencimientos> lista_vencimientos) {
		this.lista_vencimientos = lista_vencimientos;
	}

	public Date getPrimer_diames() {
		return primer_diames;
	}

	public void setPrimer_diames(Date primer_diames) {
		this.primer_diames = primer_diames;
	}

	public Date getUltimo_dia() {
		return ultimo_dia;
	}

	public void setUltimo_dia(Date ultimo_dia) {
		this.ultimo_dia = ultimo_dia;
	}

}
