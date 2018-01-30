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
public class VentaDB {

    public static boolean registrarVenta(Venta venta) {
        boolean resp = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL REGISTRAR_VENTA (?,?)");
            cs.setString(1, venta.getCliente());
            cs.setDouble(2, venta.getTotal());
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

    public static ArrayList<Venta> listarVentas() {
        ArrayList<Venta> lista = new ArrayList<Venta>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL MOSTRAR_VENTA");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setCodigoVenta(rs.getString("Codigo_V"));
                venta.setCodigoCliente(rs.getString("Codigo_U"));
                venta.setCliente(rs.getString("CLIENTE"));
                venta.setTotal(rs.getDouble("Total"));
                venta.setFecha(rs.getString("Fecha"));
                lista.add(venta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public static boolean eliminarVenta(Venta venta) {
        boolean resp = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        try {
            CallableStatement cs = cn.prepareCall("CALL ELIMINAR_VENTA (?)");
            cs.setString(1, venta.getCodigoVenta());
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

}
