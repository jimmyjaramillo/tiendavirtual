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
public class UsuarioDB {

    public static Usuario VerificarUsuario(String id_usuario) {
        Usuario usuario = new Usuario();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL LOGEAR_USUARIO (?)");
            cs.setString(1, id_usuario);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                usuario.setCodigoUsuario(rs.getString("Codigo_U"));
                usuario.setUserNameUsuario(rs.getString("UserName_U"));
                usuario.setClaveUsuario(rs.getString("Clave_U"));
                usuario.setEstadoUsuario(rs.getString("Estado_U"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }

    public static ArrayList<Usuario> MostrarUsuarioHabilitado() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_USUARIOS_CLIENTES_HABILITADOS");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigoUsuario(rs.getString("Codigo_U"));
                usuario.setNombreUsuario(rs.getString("Nombres_U"));
                usuario.setApellidosUsuario(rs.getString("Apellidos_U"));
                usuario.setEmailUsuario(rs.getString("Email_U"));
                usuario.setTelefonoUsuario(rs.getString("Telefono_U"));
                usuario.setUserNameUsuario(rs.getString("UserName_U"));
                usuario.setTipoUsuario(rs.getString("Tipo_U"));
                usuario.setEstadoUsuario(rs.getString("Estado_U"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static ArrayList<Usuario> MostrarUsuarioInhabilitado(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_USUARIOS_CLIENTES_INHABILITADOS");
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setCodigoUsuario(rs.getString("Codigo_U"));
                usuario.setNombreUsuario(rs.getString("Nombres_U"));
                usuario.setApellidosUsuario(rs.getString("Apellidos_U"));
                usuario.setEmailUsuario(rs.getString("Email_U")); 
                usuario.setTelefonoUsuario(rs.getString("Telefono_U"));
                usuario.setUserNameUsuario(rs.getString("UserName_U"));
                usuario.setTipoUsuario(rs.getString("Tipo_U"));
                usuario.setEstadoUsuario(rs.getString("Estado_U")); 
                lista.add(usuario);
            }
        }catch(Exception e){System.out.println(e);}
        return lista;
    }
    
    public static boolean RegistrarUsuario(Usuario usuario){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL REGISTRAR_USUARIO_CLIENTE (?,?,?,?,?,?,?)");
            cs.setString(1, usuario.getNombreUsuario());
            cs.setString(2, usuario.getApellidosUsuario());
            cs.setString(3, usuario.getEmailUsuario());
            cs.setString(4, usuario.getDireccionUsuario());
            cs.setString(5, usuario.getTelefonoUsuario());
            cs.setString(6, usuario.getUserNameUsuario());
            cs.setString(7, usuario.getClaveUsuario());
            int i = cs.executeUpdate();
            
            if(i == 1){
                resp = true;
            }else{
                resp = false;
            }
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean ModificarUsuario(Usuario usuario){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_USUARIO (?,?,?,?,?)");
            cs.setString(1, usuario.getCodigoUsuario());
            cs.setString(2, usuario.getNombreUsuario());
            cs.setString(3, usuario.getApellidosUsuario());
            cs.setString(4, usuario.getDireccionUsuario());
            cs.setString(5, usuario.getTelefonoUsuario());
            int i = cs.executeUpdate();
            
            if(i == 1){
                resp = true;
            }else{
                resp = false;
            }
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean ModificarClaveUsuario(Usuario usuario){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_CLAVE_USUARIO (?,?)");
            cs.setString(1, usuario.getCodigoUsuario());
            cs.setString(2, usuario.getClaveUsuario()); 
            int i = cs.executeUpdate();
            
            if(i == 1){
                resp = true;
            }else{
                resp = false;
            }
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean ModificarEmailUsuario(Usuario usuario){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MODIFICAR_EMAIL_USUARIO (?,?)");
            cs.setString(1, usuario.getCodigoUsuario());
            cs.setString(2, usuario.getEmailUsuario()); 
            int i = cs.executeUpdate();
            
            if(i == 1){
                resp = true;
            }else{
                resp = false;
            }
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean DarDeBajaUsuario(Usuario usuario){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL ELIMINAR_USUARIO (?)");
            cs.setString(1, usuario.getCodigoUsuario());
            int i = cs.executeUpdate();
            
            if(i == 1){
                resp = true;
            }else{
                resp = false;
            }
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static boolean DarDeAltaUsuario(Usuario usuario){
        boolean resp = false;
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL RECUPERAR_USUARIO (?)");
            cs.setString(1, usuario.getCodigoUsuario());
            int i = cs.executeUpdate();
            
            if(i == 1){
                resp = true;
            }else{
                resp = false;
            }
        }catch(Exception e){System.out.println(e);}
        return resp;
    }
    
    public static Usuario listarUsuarioPorCodigo(String codigo){
        Usuario usuario = new Usuario();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_USUARIO_POR_CODIGO (?)");
            cs.setString(1, codigo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                usuario.setCodigoUsuario(rs.getString("Codigo_U"));
                usuario.setNombreUsuario(rs.getString("Nombres_U"));
                usuario.setApellidosUsuario(rs.getString("Apellidos_U"));
                usuario.setEmailUsuario(rs.getString("Email_U"));
                usuario.setDireccionUsuario(rs.getString("Direccion_U"));
                usuario.setTelefonoUsuario(rs.getString("Telefono_U")); 
                usuario.setUserNameUsuario(rs.getString("UserName_U"));
                usuario.setClaveUsuario(rs.getString("Clave_U"));
                usuario.setTipoUsuario(rs.getString("Tipo_U")); 
                usuario.setEstadoUsuario(rs.getString("Estado_U")); 
            }
        }catch(Exception e){System.out.println(e);}
        return usuario;
    }
}
