<%-- 
    Document   : mostrarMarcaProducto
    Created on : Jan 25, 2018, 11:20:24 PM
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
        <title>Mostrar Marca Producto</title>
    </head>
    <body>
        
        <form id="frmMostrarCabeceraMP">
            <table id="tablaMostrarCabeceraMP">
                <tr>
                    <th>
                        <h1> Marca productos habilitados </h1>
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
        
        <form id="frmMostrarCuerpoMP">
            <table id="tablaMostrarCuerpoMP">
                
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
                    ArrayList<MarcaProducto> lista = MarcaProductoDB.obtenerMarcasProductosHabilitados();
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
                        <input type="button" name="btnModificar" id="btnModificar" class="button" value="Modificar" onclick="location.href='modificarMarcaProducto.jsp?codigoMP=<%=marcaProducto.getCodigoMarcaProducto()%>&&nombreMP=<%=marcaProducto.getNombreMarcaProducto()%>&&estadoMP=<%=marcaProducto.getEstadoMarcaProducto()%>'">
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnEliminar" id="btnEliminar" class="button" value="Eliminar" onclick="location.href='ServletMarcaProducto?codigoMP=<%=marcaProducto.getCodigoMarcaProducto()%>&&accion=eliminar'">
                    </td>
                </tr>
                
                <%
                    }
                %>

            </table>
        </form>
    </body>
</html>
