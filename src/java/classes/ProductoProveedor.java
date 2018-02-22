/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author jimmy
 */
public class ProductoProveedor {
    
    private String codigoProducto;
    private String codigoProveedor;
    private String nombreProductoProveedor;
    private double precioProductoProveeedor;
    private int cantidad;
    private Date fecha;
    private String estadoProductoProveedor;

    public ProductoProveedor() {
    }

    public ProductoProveedor(String codigoProducto, String codigoProveedor, String nombreProductoProveedor, double precioProductoProveeedor, int cantidad, Date fecha, String estadoProductoProveedor) {
        this.codigoProducto = codigoProducto;
        this.codigoProveedor = codigoProveedor;
        this.nombreProductoProveedor = nombreProductoProveedor;
        this.precioProductoProveeedor = precioProductoProveeedor;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estadoProductoProveedor = estadoProductoProveedor;
    }

    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the codigoProveedor
     */
    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    /**
     * @param codigoProveedor the codigoProveedor to set
     */
    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    /**
     * @return the nombreProductoProveedor
     */
    public String getNombreProductoProveedor() {
        return nombreProductoProveedor;
    }

    /**
     * @param nombreProductoProveedor the nombreProductoProveedor to set
     */
    public void setNombreProductoProveedor(String nombreProductoProveedor) {
        this.nombreProductoProveedor = nombreProductoProveedor;
    }

    /**
     * @return the precioProductoProveeedor
     */
    public double getPrecioProductoProveeedor() {
        return precioProductoProveeedor;
    }

    /**
     * @param precioProductoProveeedor the precioProductoProveeedor to set
     */
    public void setPrecioProductoProveeedor(double precioProductoProveeedor) {
        this.precioProductoProveeedor = precioProductoProveeedor;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estadoProductoProveedor
     */
    public String getEstadoProductoProveedor() {
        return estadoProductoProveedor;
    }

    /**
     * @param estadoProductoProveedor the estadoProductoProveedor to set
     */
    public void setEstadoProductoProveedor(String estadoProductoProveedor) {
        this.estadoProductoProveedor = estadoProductoProveedor;
    }

    
    
}
