<%-- 
    Document   : mostrarClaseProducto
    Created on : Jan 25, 2018, 10:41:58 PM
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
        <title>Mostrar Clase Producto</title>
    </head>
    <body>
        <form id="frmMostrarCabeceraCP">
            <table id="tablaMostrarCabeceraCP">
                <tr>
                    <th>
                        <h1> Clase productos habilitados </h1>
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
        
        <form id="frmMostrarCuerpoCP">
            <table id="tablaMostrarCuerpoCP">
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
                    <th colspan="2" class="Titulo">
                        OPCION
                    </th>
                </tr>    
                
                <%
                    ArrayList<ClaseProducto> lista = ClaseProductoDB.ObtenerClasesProductosHabilitados();
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
                        <input type="button" name="btnModificar" value="Modificar" id="btnModificar" class="button" onclick="location.href='modificarClaseProducto.jsp?codigoCP=<%=claseProducto.getCodigoClaseProducto()%>&&nombreCP=<%=claseProducto.getNombreClaseProducto()%>&&estadoCP=<%=claseProducto.getEstadoClaseProducto()%>'">
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnEliminar" value="Eliminar" id="btnEliminar" class="button" onclick="location.href='ServletClaseProducto?codigoCP=<%=claseProducto.getCodigoClaseProducto()%>&&accion=eliminar'">
                    </td>
                </tr>
                
                <%
                    }
                %>

            </table>
        </form>
    </body>
</html>
