<%-- 
    Document   : mostrarMarcaProductosEliminados
    Created on : Jan 25, 2018, 11:30:56 PM
    Author     : jimmy
--%>

<%@page import="classes.MarcaProductoDB"%>
<%@page import="classes.MarcaProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Mostrar Marca Productos Eliminados</title>
    </head>
    <body>
        
        <form id="frmMostrarCabeceraMPEliminados">
            <table id="tablaMostrarCabeceraMPEliminados">
                <tr>
                    <th>
                        <h1> Marca de productos eliminados </h1>
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
        
        <form id="frmMostrarCuerpoMPEliminados">
            <table id="tablaMostrarCuerpoMPEliminados">
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
                    ArrayList<MarcaProducto> lista = MarcaProductoDB.obtenerMarcasProductosInhabilitados();
                    for(int i=0; i<lista.size(); i++){
                        MarcaProducto marcaProducto = lista.get(i);
                %>
  
                <tr>
                    <td>
                        <%=marcaProducto.getCodigoMarcaProducto()%>
                    </td>
                    <td>
                        <%=marcaProducto.getNombreMarcaProducto()%>
                    </td>
                    <td>
                        <%=marcaProducto.getEstadoMarcaProducto()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnRecuperar" id="btnRecuperar" class="button" value="Recuperar" onclick="location.href='ServletMarcaProducto?codigoMP=<%=marcaProducto.getCodigoMarcaProducto()%>&&accion=recuperar'">
                    </td>
                </tr>
                
                <%
                    }
                %>
    
            </table>
        </form>
    </body>
</html>
