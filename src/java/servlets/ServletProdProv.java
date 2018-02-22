/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.ProductoTienda;
import classes.ProductoTiendaDB;
import client.RestClient;
import client.model.ProdProvId;
import client.model.ProductoProv;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jimmy
 */
public class ServletProdProv extends HttpServlet {

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

            if (accion.equals("SOLICITAR")) {
                this.RegistrarProductoTienda(request, response);
            } else if (accion.equals("CONSULTAR")) {
                this.BusquedaProductos(request, response);
            }

        }
    }

    private void RegistrarProductoTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codProd = request.getParameter("codProd");
        String codProv = request.getParameter("codProv");
        String cantidadSolicitada = (String) request.getSession().getAttribute("cantidad");
        String cantidadProv = request.getParameter("cantidadProv");
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String fecha = request.getParameter("fecha");

        System.out.println(codProd);
        System.out.println(codProv);
        System.out.println(cantidadSolicitada);
        System.out.println(cantidadProv);
        System.out.println(nombre);
        System.out.println(precio);
        System.out.println(fecha);

        ProductoTienda productoTienda = new ProductoTienda();
        productoTienda.setCodigoProdTienda(codProd);
        productoTienda.setNombreProdTienda(nombre);
        productoTienda.setCantidadProdTienda(Integer.parseInt(cantidadSolicitada));
        productoTienda.setPrecioProdTienda(Double.parseDouble(precio));

        ProdProvId prodProvId = new ProdProvId();
        prodProvId.setCif(codProv);
        prodProvId.setCod(codProd);

        ProductoProv productoProv = new ProductoProv();
        productoProv.setProdProvId(prodProvId);
        productoProv.setNombre(nombre);
        productoProv.setFechaEnt(fecha);
        productoProv.setPrecio(Double.parseDouble(precio));
        productoProv.setCantidad(Integer.parseInt(cantidadProv) - Integer.parseInt(cantidadSolicitada));
        productoProv.setEstado("HAB");

        RestClient restClient = new RestClient();
        restClient.updateProductoProv(productoProv, codProv, codProd);

        request.getSession().setAttribute("codProd", null);
        request.getSession().setAttribute("cantidad", null);
        request.getSession().setAttribute("fecha", null);
        request.getSession().setAttribute("listaProdProv", null);
        //response.sendRedirect("registrarProductoTienda.jsp");

        boolean resp = ProductoTiendaDB.agregarActualizarStockTienda(productoTienda);
        if (resp) {
            response.sendRedirect("mensaje.jsp?mens='Se ha registrado un producto correctamente'");
        } else {
            response.sendRedirect("mensaje.jsp?mens='Error al registrar un producto'");
        }

    }

    private void BusquedaProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codProd = request.getParameter("txtCodProd");
        String cantidad = request.getParameter("txtCantidad");
        String fecha = request.getParameter("datepicker");
        request.getSession().setAttribute("codProd", codProd);
        request.getSession().setAttribute("cantidad", cantidad);
        request.getSession().setAttribute("fecha", fecha);

        RestClient restClient = new RestClient();

        List<ProductoProv> listaProductosProveedores = restClient.listarProductoProv();
        List<ProductoProv> listaFiltrada = new ArrayList<>();
        boolean condicion = false;
        if (!codProd.equals("") && !cantidad.equals("") && !fecha.equals("")) {
            condicion = true;
        }

        for (int i = 0; i < listaProductosProveedores.size(); i++) {
            ProductoProv productoProv = listaProductosProveedores.get(i);
            if (condicion) {
                if (codProd.equals(productoProv.getProdProvId().getCod())
                        && productoProv.getCantidad() >= Integer.parseInt(cantidad) && fecha.equals(productoProv.getFechaEnt())) {
                    listaFiltrada.add(productoProv);
                }
            } else {
                if (codProd.equals(productoProv.getProdProvId().getCod())
                        && productoProv.getCantidad() >= Integer.parseInt(cantidad)) {
                    listaFiltrada.add(productoProv);

                }
            }

        }
        request.getSession().setAttribute("listaProdProv", listaFiltrada);
        response.sendRedirect("registrarProductoTienda.jsp");
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
