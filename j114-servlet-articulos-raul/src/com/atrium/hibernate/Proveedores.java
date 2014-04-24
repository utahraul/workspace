package com.atrium.hibernate;



/**
 * Proveedores entity. @author MyEclipse Persistence Tools
 */

public class Proveedores  implements java.io.Serializable {


    // Fields    

     private Long codigoProveedor;
     private String nombreProveedor;
     private String cifProveedor;
     private String nombreComercialProveedor;
     private String calleProveedor;
     private String ciudadProveedor;
     private Integer cpProveedor;
     private String provinciaProveedor;
     private Integer telefonoProveedor;
     private Integer faxProveedor;
     private String emailProveedor;
     private String observacionesProveedor;


    // Constructors

    /** default constructor */
    public Proveedores() {
    }

	/** minimal constructor */
    public Proveedores(Long codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
    /** full constructor */
    public Proveedores(Long codigoProveedor, String nombreProveedor, String cifProveedor, String nombreComercialProveedor, String calleProveedor, String ciudadProveedor, Integer cpProveedor, String provinciaProveedor, Integer telefonoProveedor, Integer faxProveedor, String emailProveedor, String observacionesProveedor) {
        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.cifProveedor = cifProveedor;
        this.nombreComercialProveedor = nombreComercialProveedor;
        this.calleProveedor = calleProveedor;
        this.ciudadProveedor = ciudadProveedor;
        this.cpProveedor = cpProveedor;
        this.provinciaProveedor = provinciaProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.faxProveedor = faxProveedor;
        this.emailProveedor = emailProveedor;
        this.observacionesProveedor = observacionesProveedor;
    }

   
    // Property accessors

    public Long getCodigoProveedor() {
        return this.codigoProveedor;
    }
    
    public void setCodigoProveedor(Long codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return this.nombreProveedor;
    }
    
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCifProveedor() {
        return this.cifProveedor;
    }
    
    public void setCifProveedor(String cifProveedor) {
        this.cifProveedor = cifProveedor;
    }

    public String getNombreComercialProveedor() {
        return this.nombreComercialProveedor;
    }
    
    public void setNombreComercialProveedor(String nombreComercialProveedor) {
        this.nombreComercialProveedor = nombreComercialProveedor;
    }

    public String getCalleProveedor() {
        return this.calleProveedor;
    }
    
    public void setCalleProveedor(String calleProveedor) {
        this.calleProveedor = calleProveedor;
    }

    public String getCiudadProveedor() {
        return this.ciudadProveedor;
    }
    
    public void setCiudadProveedor(String ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public Integer getCpProveedor() {
        return this.cpProveedor;
    }
    
    public void setCpProveedor(Integer cpProveedor) {
        this.cpProveedor = cpProveedor;
    }

    public String getProvinciaProveedor() {
        return this.provinciaProveedor;
    }
    
    public void setProvinciaProveedor(String provinciaProveedor) {
        this.provinciaProveedor = provinciaProveedor;
    }

    public Integer getTelefonoProveedor() {
        return this.telefonoProveedor;
    }
    
    public void setTelefonoProveedor(Integer telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public Integer getFaxProveedor() {
        return this.faxProveedor;
    }
    
    public void setFaxProveedor(Integer faxProveedor) {
        this.faxProveedor = faxProveedor;
    }

    public String getEmailProveedor() {
        return this.emailProveedor;
    }
    
    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getObservacionesProveedor() {
        return this.observacionesProveedor;
    }
    
    public void setObservacionesProveedor(String observacionesProveedor) {
        this.observacionesProveedor = observacionesProveedor;
    }
   








}