package com.atrium.hibernate;

import java.util.Date;

/**
 * Clientes entity. @author MyEclipse Persistence Tools
 */

public class Clientes_Pedido implements java.io.Serializable {

	// Fields

	private Integer codigoCliente;
	private String nombreCliente;
	private String tipoEmpresa;
	private String cifCliente;
	private String nifCliente;
	private String nombreComercialCliente;
	private Date fechaAltaCliente;
	private Date fechaBajaCliente;
	private String calleCliente;
	private String ciudadCliente;
	private String cpCliente;
	private String provinciaCliente;
	private String telefonoCliente;
	private String faxCliente;
	private String emailCliente;

	private String estadoCliente;

	// Constructors

	/** default constructor */
	public Clientes_Pedido() {
	}

	/** minimal constructor */
	public Clientes_Pedido(Integer codigoCliente, String nombreCliente,
			String estadoCliente) {
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.estadoCliente = estadoCliente;
	}

	/** full constructor */
	public Clientes_Pedido(Integer codigoCliente, String nombreCliente,
			String tipoEmpresa, String cifCliente, String nifCliente,
			String nombreComercialCliente, Date fechaAltaCliente,
			Date fechaBajaCliente, String calleCliente, String ciudadCliente,
			String cpCliente, String provinciaCliente, String telefonoCliente,
			String faxCliente, String emailCliente, String contadoCliente,
			String creditoCliente, Double cifraVentasCliente,
			Double beneficiosCliente, String prepagoCliente,
			Double capitalCliente, Double inmovilizadoCliente,
			Double pasivoCliente, Double activoCliente, Date añoBalanceCliente,
			Double limiteCliente, Double pendienteCliente, Double restoCliente,
			String calleEnvioCliente, String ciudadEnvioCliente,
			String cpEnvioCliente, String provinciaEnvioCliente,
			String telefonoEnvioCliente, String faxEnvioCliente,
			String emailEnvioCliente, String observacionesCliente,
			String estadoCliente) {
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.tipoEmpresa = tipoEmpresa;
		this.cifCliente = cifCliente;
		this.nifCliente = nifCliente;
		this.nombreComercialCliente = nombreComercialCliente;
		this.fechaAltaCliente = fechaAltaCliente;
		this.fechaBajaCliente = fechaBajaCliente;
		this.calleCliente = calleCliente;
		this.ciudadCliente = ciudadCliente;
		this.cpCliente = cpCliente;
		this.provinciaCliente = provinciaCliente;
		this.telefonoCliente = telefonoCliente;
		this.faxCliente = faxCliente;
		this.emailCliente = emailCliente;

		this.estadoCliente = estadoCliente;
	}

	// Property accessors

	public Integer getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getCifCliente() {
		return this.cifCliente;
	}

	public void setCifCliente(String cifCliente) {
		this.cifCliente = cifCliente;
	}

	public String getNifCliente() {
		return this.nifCliente;
	}

	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}

	public String getNombreComercialCliente() {
		return this.nombreComercialCliente;
	}

	public void setNombreComercialCliente(String nombreComercialCliente) {
		this.nombreComercialCliente = nombreComercialCliente;
	}

	public Date getFechaAltaCliente() {
		return this.fechaAltaCliente;
	}

	public void setFechaAltaCliente(Date fechaAltaCliente) {
		this.fechaAltaCliente = fechaAltaCliente;
	}

	public Date getFechaBajaCliente() {
		return this.fechaBajaCliente;
	}

	public void setFechaBajaCliente(Date fechaBajaCliente) {
		this.fechaBajaCliente = fechaBajaCliente;
	}

	public String getCalleCliente() {
		return this.calleCliente;
	}

	public void setCalleCliente(String calleCliente) {
		this.calleCliente = calleCliente;
	}

	public String getCiudadCliente() {
		return this.ciudadCliente;
	}

	public void setCiudadCliente(String ciudadCliente) {
		this.ciudadCliente = ciudadCliente;
	}

	public String getCpCliente() {
		return this.cpCliente;
	}

	public void setCpCliente(String cpCliente) {
		this.cpCliente = cpCliente;
	}

	public String getProvinciaCliente() {
		return this.provinciaCliente;
	}

	public void setProvinciaCliente(String provinciaCliente) {
		this.provinciaCliente = provinciaCliente;
	}

	public String getTelefonoCliente() {
		return this.telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getFaxCliente() {
		return this.faxCliente;
	}

	public void setFaxCliente(String faxCliente) {
		this.faxCliente = faxCliente;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getEstadoCliente() {
		return this.estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

}