/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author jimmy
 */
public class Venta {
    
    private String CodigoVenta;
    private String CodigoCliente;
    private String Cliente;
    private double Total;
    private String Fecha;

    public Venta() {
    }

    public Venta(String CodigoVenta, String CodigoCliente, String Cliente, double Total, String Fecha) {
        this.CodigoVenta = CodigoVenta;
        this.CodigoCliente = CodigoCliente;
        this.Cliente = Cliente;
        this.Total = Total;
        this.Fecha = Fecha;
    }

    /**
     * @return the CodigoVenta
     */
    public String getCodigoVenta() {
        return CodigoVenta;
    }

    /**
     * @param CodigoVenta the CodigoVenta to set
     */
    public void setCodigoVenta(String CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    /**
     * @return the CodigoCliente
     */
    public String getCodigoCliente() {
        return CodigoCliente;
    }

    /**
     * @param CodigoCliente the CodigoCliente to set
     */
    public void setCodigoCliente(String CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    /**
     * @return the Cliente
     */
    public String getCliente() {
        return Cliente;
    }

    /**
     * @param Cliente the Cliente to set
     */
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
