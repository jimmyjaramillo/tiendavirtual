/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import connection.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jimmy
 */
public class DetalleVentaDB {
    
    public static ArrayList<DetalleVenta> obtenerDetalleVenta(String CodigoVenta){
        ArrayList<DetalleVenta> lista = new ArrayList<DetalleVenta>();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_DETALLE_VENTA_POR_CODIGO (?)");
            cs.setString(1, CodigoVenta);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                DetalleVenta detalleVenta = new DetalleVenta();
                detalleVenta.setCodigoVenta(rs.getString("Codigo_V"));
                detalleVenta.setNombreProducto(rs.getString("Producto"));
                detalleVenta.setPrecio(rs.getDouble("Precio"));
                detalleVenta.setCantidad(rs.getDouble("Cantidad"));
                detalleVenta.setDescuento(rs.getDouble("Descuento"));
                detalleVenta.setSubTotal(rs.getDouble("SubTotal")); 
                lista.add(detalleVenta);
            }
        }catch(Exception e){System.out.println(e);}
        return lista;
    }
    
}
