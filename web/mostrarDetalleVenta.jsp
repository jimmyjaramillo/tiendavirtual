<%-- 
    Document   : mostrarDetalleVenta
    Created on : Jan 25, 2018, 11:01:02 PM
    Author     : jimmy
--%>

<%@page import="classes.DetalleVentaDB"%>
<%@page import="classes.DetalleVenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="classes.UsuarioDB"%>
<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Mostrar Detalle Venta</title>
    </head>
    <%
        String CodigoVenta = (String) session.getAttribute("CodigoVenta");
        String CodigoCliente = (String) session.getAttribute("CodigoCliente");
        String Cliente = (String) session.getAttribute("Cliente");
        String Fecha = (String) session.getAttribute("FechaVenta");
        String Importe = (String) session.getAttribute("Importe");
    %>
    <body>
        <form action="ServletProducto" method="post" id="frmMostrarDetalleVenta">
            <br>
            <table id="tablaMostrarDetalleVenta">
                <tr>
                    <th colspan="5" class="TituloDV">
                        <h3>VENTA - <%=CodigoVenta%> </h3>
                    </th>
                </tr>
                <tr>
                    <th class="TituloDV">
                        CLIENTE :  
                    </th>
                    <td colspan="4" class="Contenido">
                        <%=Cliente%>
                    </td>
                </tr>
                <tr>
                    <td colspan="5" class="FilaEnBlanco">
                        <br>
                    </td>
                </tr>
                <tr>
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
                </tr>

                <%
                    DecimalFormat df = new DecimalFormat("0.00");
                    DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
                    dfs.setDecimalSeparator('.');
                    df.setDecimalFormatSymbols(dfs);

                    ArrayList<DetalleVenta> lista = DetalleVentaDB.obtenerDetalleVenta(CodigoVenta);
                    for (int i = 0; i < lista.size(); i++) {
                        DetalleVenta detalleVenta = lista.get(i);
                %>
                <tr>
                    <td class="Contenido"><%=detalleVenta.getNombreProducto()%></td>
                    <td class="Contenido"><%=df.format(detalleVenta.getPrecio())%></td>
                    <td class="Contenido"><%=df.format(detalleVenta.getCantidad())%></td>
                    <td class="Contenido"><%=df.format(detalleVenta.getDescuento())%></td>
                    <td class="Contenido"> <div> <%=df.format(detalleVenta.getSubTotal())%> </div> </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <th colspan="4" class="TituloDV">
                        <div> TOTAL ($.)  </div>
                    </th>
                    <th class="Contenido">
                        <div> <%=df.format(Double.parseDouble(Importe))%> </div>
                    </th>
                </tr>
                <tr>
                    <td colspan="5" class="FilaEnBlanco">
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
                        <a href="mostrarVenta.jsp" class="link">REGRESAR</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>

        </form>

        <form id="frmMostrarDatosCliente">
            <br>
            <table id="tablaMostrarDatosCliente">
                <%
                    Usuario usuario = UsuarioDB.listarUsuarioPorCodigo(CodigoCliente);
                %>
                <tr>
                    <td class="primeraColumna">
                <dd> Fecha : </dd>
                </td>
                <td>
                <dd> <%=Fecha%> </dd>
                </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                <dd> Codigo cliente : </dd>
                </td>
                <td>
                <dd> <%=usuario.getCodigoUsuario()%> </dd>
                </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                <dd> Cliente : </dd>
                </td>
                <td>
                <dd> <%=usuario.getNombreUsuario()%>, <%=usuario.getApellidosUsuario()%> </dd>
                </td>
                </tr>

                <tr>
                    <td class="primeraColumna">
                <dd> Email : </dd>
                </td>
                <td>
                <dd> <%=usuario.getEmailUsuario()%> </dd>
                </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                <dd> Domicilio : </dd>
                </td>
                <td>
                <dd> <%=usuario.getDireccionUsuario()%> </dd>
                </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                <dd> Telefono : </dd>
                </td>
                <td>
                <dd> <%=usuario.getTelefonoUsuario()%> </dd>
                </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>
        </form>            
    </body>
</html>
