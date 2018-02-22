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
public class ProductoTienda {
    private String codigoProdTienda;
    private String nombreProdTienda;
    private double precioProdTienda;
    private int cantidadProdTienda;
    private String estadoProdTienda;

    public ProductoTienda() {
    }

    public ProductoTienda(String codigoProdTienda, String nombreProdTienda, double precioProdTienda, int cantidadProdTienda, String estadoProdTienda) {
        this.codigoProdTienda = codigoProdTienda;
        this.nombreProdTienda = nombreProdTienda;
        this.precioProdTienda = precioProdTienda;
        this.cantidadProdTienda = cantidadProdTienda;
        this.estadoProdTienda = estadoProdTienda;
    }

    /**
     * @return the codigoProdTienda
     */
    public String getCodigoProdTienda() {
        return codigoProdTienda;
    }

    /**
     * @param codigoProdTienda the codigoProdTienda to set
     */
    public void setCodigoProdTienda(String codigoProdTienda) {
        this.codigoProdTienda = codigoProdTienda;
    }

    /**
     * @return the nombreProdTienda
     */
    public String getNombreProdTienda() {
        return nombreProdTienda;
    }

    /**
     * @param nombreProdTienda the nombreProdTienda to set
     */
    public void setNombreProdTienda(String nombreProdTienda) {
        this.nombreProdTienda = nombreProdTienda;
    }

    /**
     * @return the precioProdTienda
     */
    public double getPrecioProdTienda() {
        return precioProdTienda;
    }

    /**
     * @param precioProdTienda the precioProdTienda to set
     */
    public void setPrecioProdTienda(double precioProdTienda) {
        this.precioProdTienda = precioProdTienda;
    }

    /**
     * @return the cantidadProdTienda
     */
    public int getCantidadProdTienda() {
        return cantidadProdTienda;
    }

    /**
     * @param cantidadProdTienda the cantidadProdTienda to set
     */
    public void setCantidadProdTienda(int cantidadProdTienda) {
        this.cantidadProdTienda = cantidadProdTienda;
    }

    /**
     * @return the estadoProdTienda
     */
    public String getEstadoProdTienda() {
        return estadoProdTienda;
    }

    /**
     * @param estadoProdTienda the estadoProdTienda to set
     */
    public void setEstadoProdTienda(String estadoProdTienda) {
        this.estadoProdTienda = estadoProdTienda;
    }
    
    
            
    
}
