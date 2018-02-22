<%-- 
    Document   : mostrarProductoTienda
    Created on : Feb 21, 2018, 2:30:34 AM
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
        <title>Productos Tienda</title>
    </head>
    <body>
        <form id="frmMostrarCabeceraProd">
            <table id="tablaMostrarCabeceraProd">
                <tr>
                    <th>
                        <h1> PRODUCTOS HABILITADOS</h1>
                    </th>
                </tr>
                <tr>
                    <td>
                        <a href="cuentaAdmin.jsp" class="link"><h4> Página principal </h4></a>
                    </td>
                </tr>
                <tr>
                    <th>
                        <h4> PRODUCTOS SIN STOCK SE ENCUENTRAN EN ROJO</h4>
                    </th>
                </tr>
            </table>
        </form>
        
        <hr>
        
        <form id="frmMostrarCuerpoProd">
            <table id="tablaMostrarCuerpoProd">
                <tr>
                    <th class="Titulo">
                        CODIGO
                    </th>
                    <th class="Titulo">
                        NOMBRE
                    </th>
                    <th class="Titulo">
                        STOCK
                    </th>
                    <th class="Titulo">
                        PRECIO ($)
                    </th>
                    <th class="Titulo">
                        ESTADO
                    </th>
                    <th class="Titulo">
                        OPCION
                    </th>
                </tr>
                
                <%
                    ArrayList<ProductoTienda> lista = ProductoTiendaDB.obtenerProductosTiendaHabilitados();
                    for(int i=0; i<lista.size(); i++){
                        ProductoTienda productoTienda = lista.get(i);
                        if((int)productoTienda.getCantidadProdTienda()>0){%>
                           <tr> 
                 <%       }else{%>
                            <tr bgcolor="red">
                 <%       }
                %>
                    <td>
                        <%=productoTienda.getCodigoProdTienda()%>
                    </td>
                    <td>
                        <%=productoTienda.getNombreProdTienda()%>
                    </td>
                    <td>
                        <%=(int)productoTienda.getCantidadProdTienda()%>
                    </td>
                    <td>
                        <%=productoTienda.getPrecioProdTienda()%>
                    </td>
                    <td>
                        <%=productoTienda.getEstadoProdTienda()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnEliminar" id="btnEliminar" class="button" value="Eliminar" onclick="location.href='ServletProductoTienda?codigoPT=<%=productoTienda.getCodigoProdTienda()%>&&accion=eliminar'">
                    </td>
                </tr>
                
                <%
                    }
                %>
    
            </table>
        </form>
    </body>
</html>
