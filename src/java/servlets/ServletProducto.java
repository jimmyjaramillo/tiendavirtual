/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.DetalleVenta;
import classes.Producto;
import classes.ProductoDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jimmy
 */
//@WebServlet("/upload")
//@MultipartConfig
@WebServlet(name = "ServletProducto", urlPatterns = {"/Imagen"})
@MultipartConfig
public class ServletProducto extends HttpServlet {

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

            if (accion.equals("insertar")) {
                this.RegistrarProducto(request, response);
            }
            if (accion.equals("actualizar")) {
                this.ActualizarProducto(request, response);
            }
            if (accion.equals("eliminar")) {
                this.DarBajaProducto(request, response);
            }
            if (accion.equals("recuperar")) {
                this.DarAltaProducto(request, response);
            }
            if (accion.equals("anadirCarrito")) {
                this.AnadirCarrito(request, response);
            }
        }
    }

    private void RegistrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto = new Producto();
        producto.setClaseProducto(request.getParameter("txtClase"));
        producto.setMarcaProducto(request.getParameter("txtMarca"));
        producto.setDescripcionProducto(request.getParameter("txtDescripcion"));
        producto.setPrecioProducto(Double.parseDouble(request.getParameter("txtPrecio")));
        producto.setStockProducto(Double.parseDouble(request.getParameter("txtStock")));
        producto.setImagenProducto(request.getParameter("txtImagen"));

        boolean resp = ProductoDB.insertarProducto(producto);

        if (resp) {
            
            String relativeWebPath = "/Imagen";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            System.out.println(absoluteDiskPath);
//            String filename = FilenameUtils.getName(item.getName());
//            File file = new File(absoluteDiskPath, filename);
            response.sendRedirect("mensaje.jsp?mens='Se ha registrado un producto correctamente'");
        } else {
            response.sendRedirect("mensaje.jsp?mens='Error al registrar un producto'");
        }
    }

    private void ActualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto = new Producto();
        producto.setCodigoProducto(request.getParameter("txtCodigo"));
        producto.setClaseProducto(request.getParameter("txtNombreCP"));
        producto.setMarcaProducto(request.getParameter("txtNombreMP"));
        producto.setDescripcionProducto(request.getParameter("txtDescripcionP"));
        producto.setPrecioProducto(Double.parseDouble(request.getParameter("txtPrecioP")));
        producto.setStockProducto(Double.parseDouble(request.getParameter("txtStockP")));

        String imagen = request.getParameter("selected");

        if (imagen.equals("SelectImagenActual")) {
            producto.setImagenProducto(request.getParameter("txtImagen"));
        } else {
            producto.setImagenProducto(request.getParameter("txtModificarImagen"));
        }

        boolean resp = ProductoDB.actualizarProducto(producto);
        if (resp) {
            response.sendRedirect("mensaje.jsp?mens='Se ha modificado el producto " + producto.getCodigoProducto() + "'");
        } else {
            response.sendRedirect("mensaje.jsp?mens='Error al modificar el producto'");
        }
    }

    private void DarBajaProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto = new Producto();
        producto.setCodigoProducto(request.getParameter("codigoP"));

        boolean resp = ProductoDB.eliminarProducto(producto);
        if (resp) {
            response.sendRedirect("mensaje.jsp?mens='Se ha eliminado el producto " + producto.getCodigoProducto() + "'");
        } else {
            response.sendRedirect("mensaje.jsp?mens='Error al eliminar el producto'");
        }
    }

    private void DarAltaProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto = new Producto();
        producto.setCodigoProducto(request.getParameter("codigoP"));

        boolean resp = ProductoDB.recuperarProducto(producto);
        if (resp) {
            response.sendRedirect("mensaje.jsp?mens='Se ha recuperado el producto " + producto.getCodigoProducto() + "'");
        } else {
            response.sendRedirect("mensaje.jsp?mens='Error al recuperar el producto'");
        }
    }

    private void AnadirCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        HttpSession session = request.getSession();
        ArrayList<DetalleVenta> carritoCompra;

        if (session.getAttribute("carrito") == null) {
            carritoCompra = new ArrayList<DetalleVenta>();
        } else {
            carritoCompra = (ArrayList<DetalleVenta>) session.getAttribute("carrito");
        }

        Producto producto = ProductoDB.listarProductoPorCodigo(request.getParameter("txtCodigo"));

        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCodigoProducto(request.getParameter("txtCodigo"));
        detalleVenta.setNombreProducto(request.getParameter("txtNombreP"));
        detalleVenta.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
        detalleVenta.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));

        // Realizamos un descuento para el sub total
        double subTotal = producto.getPrecioProducto() * detalleVenta.getCantidad();
        if (subTotal > 1000) {
            detalleVenta.setDescuento(subTotal * 0.25);
        } else if (subTotal > 400) {
            detalleVenta.setDescuento(subTotal * 0.10);
        } else {
            detalleVenta.setDescuento(0);
        }

        detalleVenta.setSubTotal(detalleVenta.getPrecio() * detalleVenta.getCantidad() - detalleVenta.getDescuento());

        int indice = -1;
        for (int i = 0; i < carritoCompra.size(); i++) {
            DetalleVenta det = carritoCompra.get(i);
            if (det.getCodigoProducto().equals(producto.getCodigoProducto())) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            detalleVenta.setNumero(String.valueOf(carritoCompra.size() + 1));
            carritoCompra.add(detalleVenta);
        } else {
            detalleVenta.setNumero(String.valueOf(indice + 1));
            carritoCompra.set(indice, detalleVenta);
        }

        session.setAttribute("carrito", carritoCompra);
        request.getSession().setAttribute("parametroCliente", request.getParameter("txtCliente"));
        response.sendRedirect("registrarVenta.jsp");
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
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            // if not, we stop here
//            PrintWriter writer = response.getWriter();
//            writer.println("Error: Form must has enctype=multipart/form-data.");
//            writer.flush();
//            return;
//        }
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
