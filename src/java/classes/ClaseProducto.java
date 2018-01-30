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
public class ClaseProducto {
    
    private String codigoClaseProducto;
    private String nombreClaseProducto;
    private String estadoClaseProducto;

    public ClaseProducto() {
    }

    public ClaseProducto(String codigoClaseProducto, String nombreClaseProducto, String estadoClaseProducto) {
        this.codigoClaseProducto = codigoClaseProducto;
        this.nombreClaseProducto = nombreClaseProducto;
        this.estadoClaseProducto = estadoClaseProducto;
    }

    /**
     * @return the codigoClaseProducto
     */
    public String getCodigoClaseProducto() {
        return codigoClaseProducto;
    }

    /**
     * @param codigoClaseProducto the codigoClaseProducto to set
     */
    public void setCodigoClaseProducto(String codigoClaseProducto) {
        this.codigoClaseProducto = codigoClaseProducto;
    }

    /**
     * @return the nombreClaseProducto
     */
    public String getNombreClaseProducto() {
        return nombreClaseProducto;
    }

    /**
     * @param nombreClaseProducto the nombreClaseProducto to set
     */
    public void setNombreClaseProducto(String nombreClaseProducto) {
        this.nombreClaseProducto = nombreClaseProducto;
    }

    /**
     * @return the estadoClaseProducto
     */
    public String getEstadoClaseProducto() {
        return estadoClaseProducto;
    }

    /**
     * @param estadoClaseProducto the estadoClaseProducto to set
     */
    public void setEstadoClaseProducto(String estadoClaseProducto) {
        this.estadoClaseProducto = estadoClaseProducto;
    }
    
    
    
}
