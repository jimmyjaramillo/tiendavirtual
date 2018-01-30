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
public class MarcaProductoDB {
    
    public static ArrayList<MarcaProducto> obtenerMarcasProductosHabilitados(){
        ArrayList<MarcaProducto> lista = new ArrayList<MarcaProducto>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_MARCA_PRODUCTO_HABILITADOS");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MarcaProducto marcaProducto = new MarcaProducto(rs.getString("Codigo_MP"), rs.getString("Nombre_MP"), rs.getString("Estado_MP"));
                lista.add(marcaProducto);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return lista;
    }
    
    public static ArrayList<MarcaProducto> obtenerMarcasProductosInhabilitados(){
        ArrayList<MarcaProducto> lista = new ArrayList<MarcaProducto>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_MARCA_PRODUCTO_INHABILITADOS");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MarcaProducto marcaProducto = new MarcaProducto(rs.getString("Codigo_MP"), rs.getString("Nombre_MP"), rs.getString("Estado_MP"));
                lista.add(marcaProducto);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return lista;
    }
    
    public static boolean insertarMarcaProducto(MarcaProducto marcaProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL REGISTRAR_MARCA_PRODUCTO (?)");
            cs.setString(1, marcaProducto.getNombreMarcaProducto());
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean actualizarMarcaProducto(MarcaProducto marcaProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_MARCA_PRODUCTO (?,?)");
            cs.setString(1, marcaProducto.getCodigoMarcaProducto());
            cs.setString(2, marcaProducto.getNombreMarcaProducto()); 
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean eliminarMarcaProducto(MarcaProducto marcaProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL ELIMINAR_MARCA_PRODUCTO (?)");
            cs.setString(1, marcaProducto.getCodigoMarcaProducto());
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean recuperarMarcaProducto(MarcaProducto marcaProducto){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL RECUPERAR_MARCA_PRODUCTO (?)");
            cs.setString(1, marcaProducto.getCodigoMarcaProducto());
            int i = cs.executeUpdate();
            
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
}
