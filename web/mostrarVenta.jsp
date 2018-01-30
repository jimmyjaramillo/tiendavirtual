<%-- 
    Document   : mostrarVenta
    Created on : Jan 26, 2018, 12:01:36 AM
    Author     : jimmy
--%>

<%@page import="classes.VentaDB"%>
<%@page import="classes.Venta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Mostrar Venta</title>
    </head>
    <body>
        
        <form id="frmMostrarCabeceraVenta">
            <table id="tablaMostrarCabeceraVenta">
                <tr>
                    <th>
                        <h1> Pedidos realizados </h1>
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
        
        <form id="frmMostrarCuerpoVenta">
            <table id="tablaMostrarCuerpoVenta">
                <tr>
                    <th class="Titulo">
                        CODIGO
                    </th>
                    <th class="Titulo">
                        CLIENTE
                    </th>
                    <th class="Titulo">
                        IMPORTE ($.)
                    </th>
                    <th class="Titulo">
                        FECHA Y HORA
                    </th>
                    <th colspan="2" class="Titulo">
                        OPCION
                    </th>
                </tr>    
                
                <%
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    DecimalFormatSymbols dfs = decimalFormat.getDecimalFormatSymbols();
                    dfs.setDecimalSeparator('.');
                    decimalFormat.setDecimalFormatSymbols(dfs);
                    
                    ArrayList<Venta> lista = VentaDB.listarVentas();
                    for(int i=0; i<lista.size(); i++){
                        Venta venta = lista.get(i);
                        %>
                        
                <tr>
                    <td>
                        <%=venta.getCodigoVenta()%>
                    </td>
                    <td>
                        <%=venta.getCliente()%>
                    </td>
                    <td>
                        <%=decimalFormat.format(venta.getTotal())%>
                    </td>
                    <td>
                        <%=venta.getFecha() %>
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnDetalle" id="btnDetalle" class="button" value="Detalle venta" onclick="location.href='ServletVenta?codigoV=<%=venta.getCodigoVenta() %>&&cliente=<%=venta.getCliente() %>&&importe=<%=venta.getTotal() %>&&FechaV=<%=venta.getFecha() %>&&codigoCli=<%=venta.getCodigoCliente() %>&&accion=MostrarDetalle'">
                    </td>
                    <td class="Opcion">
                        <input type="button" name="btnEliminar" id="btnEliminar" class="button" value="Eliminar" onclick="location.href='ServletVenta?codigoV=<%=venta.getCodigoVenta() %>&&accion=EliminarVenta'"> 
                    </td>
                </tr>
                
                <%
                    }
                %>

            </table>
        </form>
        
    </body>
</html>
