/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jimmy
 */
public class Conexion {
    
    Connection conectar = null;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendavirtual","root","");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: "+e.getMessage());
        }
        return conectar;
    }
}
