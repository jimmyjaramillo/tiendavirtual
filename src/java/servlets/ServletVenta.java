/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Producto;
import classes.ProductoDB;
import classes.Venta;
import classes.VentaDB;
import connection.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jimmy
 */
public class ServletVenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");

            if (accion.equals("RegistrarVenta")) {
                this.RegistrarVenta(request, response);
            }
            if (accion.equals("MostrarDetalle")) {
                this.MostrarDetalleVenta(request, response);
            }
            if (accion.equals("EliminarVenta")) {
                this.EliminarVenta(request, response);
            }
            if (accion.equals("quitar")) {
                this.QuitarProducto(request, response);
            }
        }
    }

    private void RegistrarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ArrayList lista = (ArrayList) session.getAttribute("carrito");
   
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        Venta venta = new Venta();
        venta.setCliente(request.getParameter("txtCliente"));
        venta.setTotal(Double.parseDouble(request.getParameter("txtTotal")));

        boolean resp = VentaDB.registrarVenta(venta);

        if (resp) {
            // Registrar detalle vemta
            String CodigoVenta = request.getParameter("txtCodigoV");
            String NombreProducto[] = request.getParameterValues("nombreProd");
            String CodigoProducto[] = request.getParameterValues("codProd");
            String PrecioProducto[] = request.getParameterValues("precioProd");
            String CantidadProducto[] = request.getParameterValues("cantidadProd");
            String DescuentoProducto[] = request.getParameterValues("descuentoProd");
            String SubTotalProducto[] = request.getParameterValues("subTotalProd");

            if ("null".equals(CodigoVenta)) {
                CodigoVenta = "V0001";
            }
            for (int i = 0; i < CodigoProducto.length; i++) {
                double cantidad = Double.parseDouble(CantidadProducto[i]);
                Producto producto = ProductoDB.listarProductoPorCodigo(CodigoProducto[i]);
                Double newStock = 0.0;
                newStock = producto.getStockProducto()- cantidad;
                producto.setStockProducto(newStock);
                boolean status = ProductoDB.actualizarProducto(producto);
                if (status){
                    System.out.println("actualizando stock");
                }
            }
           
            for (int i = 0; i < NombreProducto.length; i++) {
                try {
                    CallableStatement cs = cn.prepareCall("CALL REGISTRAR_DETALLE_VENTA (?,?,?,?,?,?)");
                    cs.setString(1, CodigoVenta);
                    cs.setString(2, NombreProducto[i]);
                    cs.setString(3, PrecioProducto[i]);
                    cs.setString(4, CantidadProducto[i]);
                    cs.setString(5, DescuentoProducto[i]);
                    cs.setString(6, SubTotalProducto[i]);
                    int j = cs.executeUpdate();
                    if (j == 1) {
                        response.sendRedirect("mensaje2.jsp?mens='Se ha registrado su compra correctamente'");
                        lista.clear();
                    } else {
                        response.sendRedirect("mensaje2.jsp?mens='Error al registrar su compra'");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            response.sendRedirect("mensaje2.jsp?mens='Error al registrar su compra'");
        }
    }

    private void MostrarDetalleVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        request.getSession().setAttribute("CodigoVenta", request.getParameter("codigoV"));
        request.getSession().setAttribute("Cliente", request.getParameter("cliente"));
        request.getSession().setAttribute("Importe", request.getParameter("importe"));
        request.getSession().setAttribute("FechaVenta", request.getParameter("FechaV"));
        request.getSession().setAttribute("CodigoCliente", request.getParameter("codigoCli"));

        response.sendRedirect("mostrarDetalleVenta.jsp");
    }
    
    private void QuitarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false); 
        
        int numeroVenta = Integer.parseInt(request.getParameter("numero"));
        ArrayList lista = (ArrayList)session.getAttribute("carrito");
        lista.remove(numeroVenta - 1); 
        response.sendRedirect("registrarVenta.jsp"); 
    }
    
    private void EliminarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Venta venta = new Venta();
        venta.setCodigoVenta(request.getParameter("codigoV"));
        boolean resp = VentaDB.eliminarVenta(venta);
        
        if(resp){
            response.sendRedirect("mensaje.jsp?mens='Se ha eliminado la venta correctamente "+ venta.getCodigoVenta() +"'"); 
        }else{
            response.sendRedirect("mensaje.jsp?mens='Error al eliminar la venta " +venta.getCodigoVenta()+ "'"); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
