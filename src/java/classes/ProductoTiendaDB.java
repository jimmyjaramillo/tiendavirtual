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
public class ProductoTiendaDB {
    
     public static ArrayList<ProductoTienda> obtenerProductosTiendaHabilitados() {
        ArrayList<ProductoTienda> lista = new ArrayList<ProductoTienda>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            cs = cn.prepareCall("CALL MOSTRAR_PRODUCTOSTIENDA_HABILITADOS");
            rs = cs.executeQuery();
            while (rs.next()) {
                ProductoTienda productoTienda = new ProductoTienda(rs.getString("Codigo_PT"), rs.getString("Nombre_PT"), rs.getDouble("Precio_PT"), rs.getInt("Cantidad_PT"), rs.getString("Estado_PT"));
                lista.add(productoTienda);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public static ArrayList<ProductoTienda> obtenerProductosTiendaInhabilitados() {
        ArrayList<ProductoTienda> lista = new ArrayList<ProductoTienda>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            cs = cn.prepareCall("CALL MOSTRAR_PRODUCTOSTIENDA_ELIMINADOS");
            rs = cs.executeQuery();
            while (rs.next()) {
                ProductoTienda productoTienda = new ProductoTienda(rs.getString("Codigo_PT"), rs.getString("Nombre_PT"), rs.getDouble("Precio_PT"), rs.getInt("Cantidad_PT"), rs.getString("Estado_PT"));
                lista.add(productoTienda);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public static boolean agregarActualizarStockTienda(ProductoTienda productoTienda) {
        boolean resp = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL REGISTRAR_PRODUCTOTIENDA (?,?,?,?)");
            cs.setString(1, productoTienda.getCodigoProdTienda());
            cs.setString(2, productoTienda.getNombreProdTienda());
            cs.setDouble(3, productoTienda.getPrecioProdTienda());
            cs.setInt(4, productoTienda.getCantidadProdTienda());
            
            int i = cs.executeUpdate();

            if (i == 1) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return resp;
    }

    public static boolean actualizarProductoTienda(ProductoTienda productoTienda) {
        boolean resp = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_PRODUCTOTIENDA (?,?,?,?)");
            cs.setString(1, productoTienda.getCodigoProdTienda());
            cs.setString(2, productoTienda.getNombreProdTienda());
            cs.setInt(3, productoTienda.getCantidadProdTienda());
            cs.setDouble(4, productoTienda.getPrecioProdTienda());
            
            cs.executeUpdate();

            int i = cs.executeUpdate();

            if (i == 1) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return resp;
    }

    public static boolean eliminarProductoTienda(ProductoTienda productoTienda) {
        boolean resp = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL ELIMINAR_PRODUCTOTIENDA (?)");
            cs.setString(1, productoTienda.getCodigoProdTienda());

            int i = cs.executeUpdate();

            if (i == 1) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return resp;
    }

    public static boolean recuperarProductoTienda(ProductoTienda productoTienda){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL RECUPERAR_PRODUCTOTIENDA (?)");
            cs.setString(1, productoTienda.getCodigoProdTienda());
            
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static ProductoTienda listarProductoTiendaPorCodigo(String Codigo){
        ProductoTienda productoTienda = new ProductoTienda();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL BUSCAR_PRODUCTOTIENDA_CODIGO (?)");
            cs.setString(1, Codigo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                productoTienda.setCodigoProdTienda(rs.getString("Codigo_PT"));
                productoTienda.setNombreProdTienda(rs.getString("Nombre_PT"));
                productoTienda.setPrecioProdTienda(rs.getDouble("Precio_PT"));
                productoTienda.setCantidadProdTienda(rs.getInt("Cantidad_PT"));
                productoTienda.setEstadoProdTienda(rs.getString("Estado_PT"));  
            }
        }catch(Exception e){System.out.println(e);}
        return productoTienda;
    }
    
    
    
}
