/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Usuario;
import classes.UsuarioDB;
import connection.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jimmy
 */
public class ServletUsuario extends HttpServlet {

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
            
            if(accion.equals("login")){
                Login(request, response); 
            }
            if(accion.equals("registrar")){
                RegistrarUsuario(request, response); 
            }
            if(accion.equals("modificarUsuario")){
                ModificarUsuario(request, response); 
            }
            if(accion.equals("modificarClave")){
                ModificarClaveUsuario(request, response); 
            }
            if(accion.equals("modificarEmail")){
                ModificarEmailUsuario(request, response); 
            }
            if(accion.equals("eliminar")){
                DarBajaUsuario(request, response); 
            }
            if(accion.equals("recuperar")){
                DarAltaUsuario(request, response); 
            }
            if(accion.equals("logout")){
                Logout(request, response); 
            }
        }
    }
    
    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
            
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
            
        try{
            Usuario usuarioQuery = UsuarioDB.VerificarUsuario(usuario);
            
            if(usuario.equals(usuarioQuery.getUserNameUsuario())){
                if(clave.equals(usuarioQuery.getClaveUsuario())){
                    if("HAB".equals(usuarioQuery.getEstadoUsuario())){
                        request.getSession().setAttribute("parametroCodigo", usuarioQuery.getCodigoUsuario());
                        response.sendRedirect("catalogo.jsp");
                    }else{
                        response.sendRedirect("respuesta.jsp?mens='Usted ha sido inhabilitado del sistema"); 
                    }
                }else{
                    response.sendRedirect("respuesta.jsp?mens='Su clave es incorrecto'"); 
                }
            }else{
                response.sendRedirect("respuesta.jsp?mens='Su id de usuario es incorrecto'"); 
            }
            
        }catch(Exception ex){out.println(ex);}
    }
    
    private void RegistrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Nombre = request.getParameter("txtNombres");
        String Apellidos = request.getParameter("txtApellidos");
        String Email = request.getParameter("txtEmail");
        String Direccion = request.getParameter("txtDireccion");
        String Telefono = request.getParameter("txtTelefono");
        String Usuario = request.getParameter("txtUsuario");
        String Clave = request.getParameter("txtClave");
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(Nombre);
        usuario.setApellidosUsuario(Apellidos);
        usuario.setEmailUsuario(Email);
        usuario.setDireccionUsuario(Direccion);
        usuario.setTelefonoUsuario(Telefono);
        usuario.setUserNameUsuario(Usuario);
        usuario.setClaveUsuario(Clave);
         
        boolean resp = UsuarioDB.RegistrarUsuario(usuario);
        if(resp){
            response.sendRedirect("respuesta.jsp?mens='Se ha registrado correctamente'");
        }else{
            response.sendRedirect("respuesta.jsp?mens='Error: Estamos solucionando un problema'"); 
        }
    }
    
    private void ModificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getParameter("txtCodigo"));
        usuario.setNombreUsuario(request.getParameter("txtNombre"));
        usuario.setApellidosUsuario(request.getParameter("txtApellidos"));
        usuario.setDireccionUsuario(request.getParameter("txtDireccion"));
        usuario.setTelefonoUsuario(request.getParameter("txtTelefono"));
        
        boolean resp = UsuarioDB.ModificarUsuario(usuario);
        if(resp){
            response.sendRedirect("mensaje2.jsp?mens='Sus datos se han modificado correctamente'");
        }else{
            response.sendRedirect("mensaje2.jsp?mens='Error al modificar uno de sus datos'");
        }
    }
    
    private void ModificarClaveUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass1 = request.getParameter("txtCaracter");
        String pass2 = request.getParameter("txtClaveActual");
        
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getParameter("txtCodigo"));
        usuario.setClaveUsuario(request.getParameter("txtClave")); 
        
        if(pass1.equals(pass2)){
            boolean resp = UsuarioDB.ModificarClaveUsuario(usuario);
            if(resp){
                response.sendRedirect("mensaje2.jsp?mens='Su password ha sido cambiado correctamente'");
            }else{
                response.sendRedirect("mensaje2.jsp?mens='Error al cambiar su contrase&ntildea'");
            }
        }else{
            response.sendRedirect("mensaje2.jsp?mens='Error el password actual no es correcta'");
        }
    }
    
    private void ModificarEmailUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        String pass1 = request.getParameter("txtCaracter");
        String pass2 = request.getParameter("txtPass");
        
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getParameter("txtCodigo"));
        usuario.setEmailUsuario(request.getParameter("txtEmail")); 
        
        if(pass1.equals(pass2)){
            boolean resp = UsuarioDB.ModificarEmailUsuario(usuario);
            if(resp){
                response.sendRedirect("mensaje2.jsp?mens='Su correo ha sido cambiado correctamente'");
            }else{
                response.sendRedirect("mensaje2.jsp?mens='Error al cambiar su correo electronico'");
            }
        }else{
            response.sendRedirect("mensaje2.jsp?mens='Error el password no es correcta'");
        }
    }
    
    private void DarBajaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getParameter("codigoU"));
        
        boolean resp = UsuarioDB.DarDeBajaUsuario(usuario);
        if(resp){
            response.sendRedirect("mensaje.jsp?mens='El usuario "+usuario.getCodigoUsuario()+" ha sido inhabilitado correctamente'");
        }else{
            response.sendRedirect("mensaje.jsp?mens='Error al eliminar el usuario'");
        }
    }
    
    private void DarAltaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getParameter("codigoU"));
        
        boolean resp = UsuarioDB.DarDeAltaUsuario(usuario);
        if(resp){
            response.sendRedirect("mensaje.jsp?mens='El usuario "+usuario.getCodigoUsuario()+" acaba de ser habilitado satisfactoriamente'");
        }else{
            response.sendRedirect("mensaje.jsp?mens='Error al recuperar el usuario'");
        }
    }
    
    private void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("catalogo.jsp");
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
