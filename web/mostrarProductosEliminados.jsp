<%-- 
    Document   : mostrarProductosEliminados
    Created on : Jan 25, 2018, 11:47:58 PM
    Author     : jimmy
--%>

<%@page import="classes.ProductoDB"%>
<%@page import="classes.Producto"%>
<%@page import="java.util.ArrayList"%>
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
                        CLASE
                    </th>
                    <th class="Titulo">
                        MARCA
                    </th>
                    <th class="Titulo">
                        DESCRIPCION
                    </th>
                    <th class="Titulo">
                        PRECIO
                    </th>
                    <th class="Titulo">
                        IMAGEN
                    </th>
                    <th class="Titulo">
                        ESTADO
                    </th>
                    <th class="Titulo">
                        OPCION
                    </th>
                </tr>
                
                <% 
                    ArrayList<Producto> lista = ProductoDB.obtenerProductosInhabilitados();
                    for(int i=0; i<lista.size(); i++){
                        Producto producto = lista.get(i);
                %>
                    
                <tr>
                    <td>
                        <%=producto.getCodigoProducto()%>
                    </td>
                    <td>
                        <%=producto.getClaseProducto() %>
                    </td>
                    <td>
                        <%=producto.getMarcaProducto() %>
                    </td>
                    <td>
                        <%=producto.getDescripcionProducto()%>
                    </td>
                    <td>
                        <%=producto.getPrecioProducto()%>
                    </td>
                    <td>
                        <%=producto.getImagenProducto()%>
                    </td>
                    <td>
                        <%=producto.getEstadoProducto()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnRecuperar" id="btnRecuperar" class="button" value="Recuperar" onclick="location.href='ServletProducto?codigoP=<%=producto.getCodigoProducto()%>&&accion=recuperar'">
                    </td>
                </tr>
                
                <%
                    }
                %>
    
            </table>
        </form>
    </body>
</html>
