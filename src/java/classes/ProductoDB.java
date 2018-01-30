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
public class ProductoDB {

    public static ArrayList<Producto> obtenerProductosHabilitados() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            cs = cn.prepareCall("CALL MOSTRAR_PRODUCTOS_HABILITADOS");
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto(rs.getString("Codigo_P"), rs.getString("Clase_P"), rs.getString("Marca_P"), rs.getString("Descripcion_P"), rs.getDouble("Precio_P"), rs.getDouble("Stock_P"), rs.getString("Imagen_P"), rs.getString("Estado_P"));
                lista.add(producto);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public static ArrayList<Producto> obtenerProductosInhabilitados() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            cs = cn.prepareCall("CALL MOSTRAR_PRODUCTOS_ELIMINADOS");
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto(rs.getString("Codigo_P"), rs.getString("Clase_P"), rs.getString("Marca_P"), rs.getString("Descripcion_P"), rs.getDouble("Precio_P"), rs.getDouble("Stock_P"), rs.getString("Imagen_P"), rs.getString("Estado_P"));
                lista.add(producto);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public static boolean insertarProducto(Producto producto) {
        boolean resp = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL REGISTRAR_PRODUCTO (?,?,?,?,?,?)");
            cs.setString(1, producto.getClaseProducto());
            cs.setString(2, producto.getMarcaProducto());
            cs.setString(3, producto.getDescripcionProducto());
            cs.setDouble(4, producto.getPrecioProducto());
            cs.setDouble(5, producto.getStockProducto());
            cs.setString(6, producto.getImagenProducto());
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

    public static boolean actualizarProducto(Producto producto) {
        boolean resp = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_PRODUCTO (?,?,?,?,?,?,?)");
            cs.setString(1, producto.getCodigoProducto());
            cs.setString(2, producto.getClaseProducto());
            cs.setString(3, producto.getMarcaProducto());
            cs.setString(4, producto.getDescripcionProducto());
            cs.setDouble(5, producto.getPrecioProducto());
            cs.setDouble(6, producto.getStockProducto());
            cs.setString(7, producto.getImagenProducto());
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

    public static boolean eliminarProducto(Producto producto) {
        boolean resp = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL ELIMINAR_PRODUCTO (?)");
            cs.setString(1, producto.getCodigoProducto());

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

    public static boolean recuperarProducto(Producto producto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL RECUPERAR_PRODUCTO (?)");
            cs.setString(1, producto.getCodigoProducto());
            
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static Producto listarProductoPorCodigo(String Codigo){
        Producto producto = new Producto();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL BUSCAR_PRODUCTO_CODIGO (?)");
            cs.setString(1, Codigo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                producto.setCodigoProducto(rs.getString("Codigo_P"));
                producto.setClaseProducto(rs.getString("Nombre_CP"));
                producto.setMarcaProducto(rs.getString("Nombre_MP"));
                producto.setDescripcionProducto(rs.getString("Descripcion_P"));
                producto.setPrecioProducto(rs.getDouble("Precio_P"));  
                producto.setStockProducto(rs.getDouble("Stock_P"));
                producto.setImagenProducto(rs.getString("Imagen_P")); 
            }
        }catch(Exception e){System.out.println(e);}
        return producto;
    }
    
}
