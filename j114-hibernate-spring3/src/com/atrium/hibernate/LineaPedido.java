package com.atrium.hibernate;



/**
 * LineaPedido entity. @author MyEclipse Persistence Tools
 */

public class LineaPedido  implements java.io.Serializable {


    // Fields    

     private Long codigoLineaPedido;
     private Articulos articulos;
     private Pedidos pedidos;
     private Double precioUnidadArticulo;
     private Integer numeroUnidadesArticulo;
     private Double porcentajeDescuento;


    // Constructors

    /** default constructor */
    public LineaPedido() {
    }

    
    /** full constructor */
    public LineaPedido(Articulos articulos, Pedidos pedidos, Double precioUnidadArticulo, Integer numeroUnidadesArticulo, Double porcentajeDescuento) {
        this.articulos = articulos;
        this.pedidos = pedidos;
        this.precioUnidadArticulo = precioUnidadArticulo;
        this.numeroUnidadesArticulo = numeroUnidadesArticulo;
        this.porcentajeDescuento = porcentajeDescuento;
    }

   
    // Property accessors

    public Long getCodigoLineaPedido() {
        return this.codigoLineaPedido;
    }
    
    public void setCodigoLineaPedido(Long codigoLineaPedido) {
        this.codigoLineaPedido = codigoLineaPedido;
    }

    public Articulos getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public Pedidos getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Double getPrecioUnidadArticulo() {
        return this.precioUnidadArticulo;
    }
    
    public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
        this.precioUnidadArticulo = precioUnidadArticulo;
    }

    public Integer getNumeroUnidadesArticulo() {
        return this.numeroUnidadesArticulo;
    }
    
    public void setNumeroUnidadesArticulo(Integer numeroUnidadesArticulo) {
        this.numeroUnidadesArticulo = numeroUnidadesArticulo;
    }

    public Double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }
    
    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
   








}