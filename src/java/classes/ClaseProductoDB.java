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
public class ClaseProductoDB {
    
    public static ArrayList<ClaseProducto> ObtenerClasesProductosHabilitados(){
        ArrayList<ClaseProducto> lista = new ArrayList<ClaseProducto>();
        Connection cn;
        Conexion con = new Conexion();
        cn=con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_CLASE_PRODUCTO_HABILITADOS");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                ClaseProducto claseProducto = new ClaseProducto(rs.getString("Codigo_CP"), rs.getString("Nombre_CP"), rs.getString("Estado_CP"));
                lista.add(claseProducto);
            }
        }catch(Exception e){ 
            System.out.println(e);
        }
        return lista;
    }
    
    public static ArrayList<ClaseProducto> obtenerClasesProductosInhabilitados(){
        ArrayList<ClaseProducto> lista = new ArrayList<ClaseProducto>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_CLASE_PRODUCTO_INHABILITADOS");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                ClaseProducto claseProducto = new ClaseProducto(rs.getString("Codigo_CP"), rs.getString("Nombre_CP"), rs.getString("Estado_CP"));
                lista.add(claseProducto);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return lista;
    }
    
    public static boolean insertarClaseProducto(ClaseProducto claseProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL REGISTRAR_CLASE_PRODUCTO (?)");
            cs.setString(1, claseProducto.getNombreClaseProducto());
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean actualizarClaseProducto(ClaseProducto claseProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_CLASE_PRODUCTO (?,?)");
            cs.setString(1, claseProducto.getCodigoClaseProducto());
            cs.setString(2, claseProducto.getNombreClaseProducto()); 
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean darBajaClaseProducto(ClaseProducto claseProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL ELIMINAR_CLASE_PRODUCTO (?)");
            cs.setString(1, claseProducto.getCodigoClaseProducto()); 
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean darAltaClaseProducto(ClaseProducto claseProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL RECUPERAR_CLASE_PRODUCTO (?)");
            cs.setString(1, claseProducto.getCodigoClaseProducto()); 
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
}
