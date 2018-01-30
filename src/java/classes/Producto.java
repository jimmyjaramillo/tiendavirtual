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
public class Producto {
    private String CodigoProducto;
    private String ClaseProducto;
    private String MarcaProducto;
    private String DescripcionProducto;
    private double PrecioProducto;
    private double StockProducto;
    private String ImagenProducto;
    private String EstadoProducto;

    public Producto() {
    }

    public Producto(String CodigoProducto, String ClaseProducto, String MarcaProducto, String DescripcionProducto, double PrecioProducto, double StockProducto, String ImagenProducto, String EstadoProducto) {
        this.CodigoProducto = CodigoProducto;
        this.ClaseProducto = ClaseProducto;
        this.MarcaProducto = MarcaProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.StockProducto = StockProducto;
        this.PrecioProducto = PrecioProducto;
        this.ImagenProducto = ImagenProducto;
        this.EstadoProducto = EstadoProducto;
    }

    

    /**
     * @return the CodigoProducto
     */
    public String getCodigoProducto() {
        return CodigoProducto;
    }

    /**
     * @param CodigoProducto the CodigoProducto to set
     */
    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    /**
     * @return the ClaseProducto
     */
    public String getClaseProducto() {
        return ClaseProducto;
    }

    /**
     * @param ClaseProducto the ClaseProducto to set
     */
    public void setClaseProducto(String ClaseProducto) {
        this.ClaseProducto = ClaseProducto;
    }

    /**
     * @return the MarcaProducto
     */
    public String getMarcaProducto() {
        return MarcaProducto;
    }

    /**
     * @param MarcaProducto the MarcaProducto to set
     */
    public void setMarcaProducto(String MarcaProducto) {
        this.MarcaProducto = MarcaProducto;
    }

    /**
     * @return the DescripcionProducto
     */
    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    /**
     * @param DescripcionProducto the DescripcionProducto to set
     */
    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    /**
     * @return the PrecioProducto
     */
    public double getPrecioProducto() {
        return PrecioProducto;
    }

    /**
     * @param PrecioProducto the PrecioProducto to set
     */
    public void setPrecioProducto(double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    /**
     * @return the ImagenProducto
     */
    public String getImagenProducto() {
        return ImagenProducto;
    }

    /**
     * @param ImagenProducto the ImagenProducto to set
     */
    public void setImagenProducto(String ImagenProducto) {
        this.ImagenProducto = ImagenProducto;
    }

    /**
     * @return the EstadoProducto
     */
    public String getEstadoProducto() {
        return EstadoProducto;
    }

    /**
     * @param EstadoProducto the EstadoProducto to set
     */
    public void setEstadoProducto(String EstadoProducto) {
        this.EstadoProducto = EstadoProducto;
    }

    /**
     * @return the StockProducto
     */
    public double getStockProducto() {
        return StockProducto;
    }

    /**
     * @param StockProducto the StockProducto to set
     */
    public void setStockProducto(double StockProducto) {
        this.StockProducto = StockProducto;
    }
    
    
    
}
