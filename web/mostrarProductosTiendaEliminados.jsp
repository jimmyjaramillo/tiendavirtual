<%-- 
    Document   : mostrarProductosTiendaEliminados
    Created on : Feb 21, 2018, 2:57:16 AM
    Author     : jimmy
--%>

<%@page import="classes.ProductoTiendaDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.ProductoTienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Mostrar Productos Eliminados</title>
    </head>
    <body>
        <form id="frmMostrarCabeceraProdEliminados">
            <table id="tablaMostrarCabeceraProdEliminados">
                <tr>
                    <th>
                        <h1> Productos Inhabilitados </h1>
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
        
        <form id="frmMostrarCuerpoProdEliminados">
            <table id="tablaMostrarCuerpoProdEliminados">
                <tr>
                    <th class="Titulo">
                        CODIGO
                    </th>
                    <th class="Titulo">
                        NOMBRE
                    </th>
                    <th class="Titulo">
                        PRECIO
                    </th>
                    <th class="Titulo">
                        CANTIDAD
                    </th>
                    <th class="Titulo">
                        ESTADO
                    </th>
                    <th class="Titulo">
                        OPCION
                    </th>
                </tr>
                
                <% 
                    ArrayList<ProductoTienda> lista = ProductoTiendaDB.obtenerProductosTiendaInhabilitados();
                    for(int i=0; i<lista.size(); i++){
                        ProductoTienda productoTienda = lista.get(i);
                %>
                    
                <tr>
                    <td>
                        <%=productoTienda.getCodigoProdTienda()%>
                    </td>
                    
                    <td>
                        <%=productoTienda.getNombreProdTienda()%>
                    </td>
                    <td>
                        <%=productoTienda.getPrecioProdTienda()%>
                    </td>
                    <td>
                        <%=productoTienda.getCantidadProdTienda()%>
                    </td>
                    <td>
                        <%=productoTienda.getEstadoProdTienda()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnRecuperar" id="btnRecuperar" class="button" value="Recuperar" onclick="location.href='ServletProductoTienda?codigoPT=<%=productoTienda.getCodigoProdTienda()%>&&accion=recuperar'">
                    </td>
                </tr>
                
                <%
                    }
                %>
    
            </table>
        </form>
    </body>
</html>
