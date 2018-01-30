<%-- 
    Document   : mostrarClaseProductosEliminados
    Created on : Jan 25, 2018, 10:48:36 PM
    Author     : jimmy
--%>

<%@page import="classes.ClaseProductoDB"%>
<%@page import="classes.ClaseProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Clase Productos Eliminados</title>
    </head>
    <body>
        
        <form id="frmMostrarCabeceraCPEliminados">
            <table id="tablaMostrarCabeceraCPEliminados">
                <tr>
                    <th>
                        <h1> Clase de productos eliminados </h1>
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
        
        <form id="frmMostrarCuerpoCPEliminados">
            <table id="tablaMostrarCuerpoCPEliminados">
                <tr>
                    <th class="Titulo">
                        CODIGO
                    </th>
                    <th class="Titulo">
                        NOMBRE
                    </th>
                    <th class="Titulo">
                        ESTADO
                    </th>
                    <th class="Titulo">
                        OPCION
                    </th>
                </tr>
                
                <%
                    ArrayList<ClaseProducto> lista = ClaseProductoDB.obtenerClasesProductosInhabilitados();
                    for(int i=0; i<lista.size(); i++){
                        ClaseProducto claseProducto = lista.get(i);
                %>
                    
                <tr>
                    <td>
                        <%=claseProducto.getCodigoClaseProducto()%>
                    </td>
                    <td>
                        <%=claseProducto.getNombreClaseProducto()%>
                    </td>
                    <td>
                        <%=claseProducto.getEstadoClaseProducto()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnRecuperar" id="btnRecuperar" class="button" value="Recuperar" onclick="location.href='ServletClaseProducto?codigoCP=<%=claseProducto.getCodigoClaseProducto()%>&&accion=recuperar'">
                    </td>
                </tr>
                
                <%
                    }
                %>
            </table>
        </form> 
    </body>
</html>
