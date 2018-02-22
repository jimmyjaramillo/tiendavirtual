/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.Date;

public class ProductoProv {
    
    private ProdProvId prodProvId;
    
    private String nombre;
    
    private double precio;
    
    private int cantidad;
    
    private String fechaEnt;
    
    private String estado;

    /**
     * @return the prodProvId
     */
    public ProdProvId getProdProvId() {
        return prodProvId;
    }

    /**
     * @param prodProvId the prodProvId to set
     */
    public void setProdProvId(ProdProvId prodProvId) {
        this.prodProvId = prodProvId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
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
     * @return the fechaEnt
     */
    public String getFechaEnt() {
        return fechaEnt;
    }

    /**
     * @param fechaEnt the fechaEnt to set
     */
    public void setFechaEnt(String fechaEnt) {
        this.fechaEnt = fechaEnt;
    }
    
    public String toString(){
        return "CodigoProd: " + this.getProdProvId().getCod() + "\n" +
               "CodigoProv: " + this.getProdProvId().getCif() + "\n" +
               "Nombre: " + this.getNombre() + "\n" +
               "Cantidad: " + this.getCantidad() + "\n" +
               "Precio: " + this.getPrecio() +"\n"+
               "Fecha: " + this.getFechaEnt() +"\n";
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
