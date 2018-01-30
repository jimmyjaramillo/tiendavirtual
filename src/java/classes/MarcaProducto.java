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
public class MarcaProducto {
    
    private String codigoMarcaProducto;
    private String nombreMarcaProducto;
    private String estadoMarcaProducto;

    public MarcaProducto() {
    }

    public MarcaProducto(String codigoMarcaProducto, String nombreMarcaProducto, String estadoMarcaProducto) {
        this.codigoMarcaProducto = codigoMarcaProducto;
        this.nombreMarcaProducto = nombreMarcaProducto;
        this.estadoMarcaProducto = estadoMarcaProducto;
    }

    /**
     * @return the codigoMarcaProducto
     */
    public String getCodigoMarcaProducto() {
        return codigoMarcaProducto;
    }

    /**
     * @param codigoMarcaProducto the codigoMarcaProducto to set
     */
    public void setCodigoMarcaProducto(String codigoMarcaProducto) {
        this.codigoMarcaProducto = codigoMarcaProducto;
    }

    /**
     * @return the nombreMarcaProducto
     */
    public String getNombreMarcaProducto() {
        return nombreMarcaProducto;
    }

    /**
     * @param nombreMarcaProducto the nombreMarcaProducto to set
     */
    public void setNombreMarcaProducto(String nombreMarcaProducto) {
        this.nombreMarcaProducto = nombreMarcaProducto;
    }

    /**
     * @return the estadoMarcaProducto
     */
    public String getEstadoMarcaProducto() {
        return estadoMarcaProducto;
    }

    /**
     * @param estadoMarcaProducto the estadoMarcaProducto to set
     */
    public void setEstadoMarcaProducto(String estadoMarcaProducto) {
        this.estadoMarcaProducto = estadoMarcaProducto;
    }
    
    
    
}
