<%-- 
    Document   : mostrarProducto
    Created on : Jan 25, 2018, 11:44:13 PM
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
        <title>Mostrar Producto</title>
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
                        CLASE
                    </th>
                    <th class="Titulo">
                        MARCA
                    </th>
                    <th class="Titulo">
                        DESCRIPCION
                    </th>
                    <th class="Titulo">
                        STOCK
                    </th>
                    <th class="Titulo">
                        PRECIO ($)
                    </th>
                    <th class="Titulo">
                        IMAGEN
                    </th>
                    <th class="Titulo">
                        ESTADO
                    </th>
                    <th colspan="2" class="Titulo">
                        OPCION
                    </th>
                </tr>
                
                <%
                    ArrayList<Producto> lista = ProductoDB.obtenerProductosHabilitados();
                    for(int i=0; i<lista.size(); i++){
                        Producto producto = lista.get(i);
                        if((int)producto.getStockProducto()>0){%>
                           <tr> 
                 <%       }else{%>
                            <tr bgcolor="red">
                 <%       }
                %>
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
                        <%=(int)producto.getStockProducto()%>
                    </td>
                    <td>
                        <%=producto.getPrecioProducto()%>
                    </td>
                    <td>
                        <img src="Imagen/<%=producto.getImagenProducto()%>" width="40" height="40">
                    </td>
                    <td>
                        <%=producto.getEstadoProducto()%>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnModificar" id="btnModificar" class="button" value="Modificar" onclick="location.href='modificarProducto.jsp?codigoP=<%=producto.getCodigoProducto()%>'"> 
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnEliminar" id="btnEliminar" class="button" value="Eliminar" onclick="location.href='ServletProducto?codigoP=<%=producto.getCodigoProducto()%>&&accion=eliminar'">
                    </td>
                </tr>
                
                <%
                    }
                %>
    
            </table>
        </form>
    </body>
</html>
