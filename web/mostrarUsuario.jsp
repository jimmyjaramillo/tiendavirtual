<%-- 
    Document   : mostrarUsuario
    Created on : Jan 25, 2018, 11:53:31 PM
    Author     : jimmy
--%>

<%@page import="classes.UsuarioDB"%>
<%@page import="classes.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Mostrar Usuario</title>
    </head>
    <body>
        <form id="frmMostrarCabeceraUsuario">
            <table id="tablaMostrarCabeceraUsuario">
                <tr>
                    <th>
                        <h1> Usuarios habilitados </h1>
                    </th>
                </tr>
                <tr>
                    <td>
                        <a href="cuentaAdmin.jsp" class="link"><h4> Pagina principal </h4></a>
                    </td>
                </tr>
            </table>
        </form>
        
        <hr>
        
        <form id="frmMostrarCuerpoUsuario">
            <table id="tablaMostrarCuerpoUsuario">
                <tr>
                    <th class="Titulo">
                        CODIGO
                    </th>
                    <th class="Titulo">
                        NOMBRE
                    </th>
                    <th class="Titulo">
                        APELLIDO
                    </th>
                    <th class="Titulo">
                        CORREO
                    </th>
                    <th class="Titulo">
                        TELEFONO
                    </th>
                    <th class="Titulo">
                        USUARIO
                    </th>
                    <th class="Titulo">
                        TIPO
                    </th>
                    <th class="Titulo">
                        ESTADO
                    </th>
                    <th class="Titulo">
                        OPCION
                    </th>
                </tr>    
                
                <%
                    ArrayList<Usuario> lista = UsuarioDB.MostrarUsuarioHabilitado();
                    for(int i=0; i<lista.size(); i++){
                        Usuario usuario = lista.get(i);
                %>
                        
                <tr>
                    <td>
                        <%=usuario.getCodigoUsuario() %>
                    </td>
                    <td>
                        <%=usuario.getNombreUsuario() %>
                    </td>
                    <td>
                        <%=usuario.getApellidosUsuario() %>
                    </td>
                    <td>
                        <%=usuario.getEmailUsuario()%>
                    </td>
                    <td>
                        <%=usuario.getTelefonoUsuario()%>
                    </td>
                    <td>
                        <%=usuario.getUserNameUsuario()%>
                    </td>
                    <td>
                        <%=usuario.getTipoUsuario()%>
                    </td>
                    <td>
                        <%=usuario.getEstadoUsuario()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnEliminar" value="Eliminar" id="btnEliminar" class="button" onclick="location.href='ServletUsuario?codigoU=<%=usuario.getCodigoUsuario()%>&&accion=eliminar'">
                    </td>
                </tr>
                
                <%
                    }
                %>

            </table>
        </form>
    </body>
</html>
