<%-- 
    Document   : registrarVenta
    Created on : Jan 26, 2018, 12:31:09 AM
    Author     : jimmy
--%>

<%@page import="classes.DetalleVenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="classes.ObtenerCodigoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/registrarVenta.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Registrar Venta</title>
    </head>

    <body>

        <%
            String codigoVenta = ObtenerCodigoProducto.CodigoVenta();
            String cliente = (String) session.getAttribute("parametroCliente");
        %>

        <form action="ServletVenta" method="post" id="frmRegistrarVenta">
            <br>
            <table id="tablaRegistrarVenta">
                <tr>
                    <th colspan="7" class="TituloDV">
                        <h3>CARRITO DE COMPRAS</h3>
                        <input type="text" name="txtCodigoV" value="<%=codigoVenta%>">
                    </th>
                </tr>
                <tr>
                    <th colspan="2" class="TituloDV">
                        CLIENTE :  
                    </th>
                    <td colspan="5" class="Contenido">
                        <%if(cliente!=null){%>
                                <%=cliente%>
                                <input type="hidden" name="txtCliente" value="<%=cliente%>" size="50" readonly="readonly">
                        <%}%>  
                    </td>
                </tr>
                <tr>
                    <td colspan="7" class="FilaEnBlanco">
                        <br>
                    </td>
                </tr>
                <tr>
                    <th class="TituloDV">
                        N°
                    </th>
                    <th class="TituloDV">
                        PRODUCTO 
                    </th>
                    <th class="TituloDV">
                        PRECIO UNITARIO ($.)
                    </th>
                    <th class="TituloDV">
                        CANTIDAD 
                    </th>
                    <th class="TituloDV">
                        DESC ($.)
                    </th>
                    <th class="TituloDV">
                        SUBTOTAL ($.)
                    </th>
                    <th class="TituloDV">
                        OPCION
                    </th>
                </tr>

                <%
                    DecimalFormat df = new DecimalFormat("0.00");
                    DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
                    dfs.setDecimalSeparator('.');
                    df.setDecimalFormatSymbols(dfs);

                    double total = 0;
                    ArrayList<DetalleVenta> lista = (ArrayList<DetalleVenta>) session.getAttribute("carrito");

                    if (lista != null) {
                        for (DetalleVenta dv : lista) {
                %>

                <tr>
                    <td class="Contenido">
                        <%=dv.getNumero()%>
                    </td>
                    <td class="Contenido">
                        <%=dv.getNombreProducto()%>
                        <input type="hidden" name="nombreProd" value="<%=dv.getNombreProducto()%>">
                        <input type="hidden" name="codProd" value="<%=dv.getCodigoProducto()%>">
                    </td>
                    <td class="Contenido">
                        <%=df.format(dv.getPrecio())%>
                        <input type="hidden" name="precioProd" value="<%=dv.getPrecio()%>">
                    </td>
                    <td class="Contenido">
                        <%=dv.getCantidad()%>
                        <input type="hidden" name="cantidadProd" value="<%=dv.getCantidad()%>">
                    </td>
                    <td class="Contenido">
                        <%=df.format(dv.getDescuento())%>
                        <input type="hidden" name="descuentoProd" value="<%=dv.getDescuento()%>">
                    </td>
                    <td class="Contenido">
                        <div> <%=df.format(dv.getSubTotal())%> </div>
                        <input type="hidden" name="subTotalProd" value="<%=dv.getSubTotal()%>">
                    </td> 
                    <td whidh="100" class="Opcion">
                        <input type="button" name="btnEliminar" id="btnEliminar" class="button" value="Eliminar" onclick="location.href = 'ServletVenta?numero=<%=dv.getNumero()%>&&accion=quitar'">
                    </td>
                </tr>
                <%
                            total = total + dv.getSubTotal();
                        }
                    }
                %>
                <tr>
                    <th colspan="5" class="TituloDV">
                        <div> TOTAL ($)  </div>
                    </th>
                    <th class="Contenido">
                        <div> <%=String.valueOf(df.format(total))%> </div>
                        <input type="hidden" name="txtTotal" value="<%=String.valueOf(df.format(total))%>" readonly="readonly">
                    </th>
                    <th class="FilaEnBlanco">
                    </th>
                </tr>
                <tr>
                    <td colspan="7" class="FilaEnBlanco">
                        <br>
                    </td>
                </tr>
            </table>

            <table id="tablaRegresar">
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <%
                            if(lista != null && lista.size() > 0){%>
                                <input type="button" name="btnRegistrar" id="btnRegistrarVenta" class="button" value="Registrar Compra">
                        <%}%>   
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>        
            <input type="hidden" name="accion" value="RegistrarVenta"><br>

        </form>
        <h3 align="center">
            <a href="catalogo.jsp" class="link">Seguir comprando</a>
        </h3>
    </body>
</html>
