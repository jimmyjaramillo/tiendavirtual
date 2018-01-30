<%-- 
    Document   : anadirCarrito
    Created on : Jan 25, 2018, 3:16:45 AM
    Author     : jimmy
--%>

<%@page import="classes.ProductoDB"%>
<%@page import="classes.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/registrarCliente.js"></script>
        <script type="text/javascript" src="js/validaStock.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Carrito de Compras</title>
    </head>
    <%
        String cliente = request.getParameter("cliente");
        Producto producto = ProductoDB.listarProductoPorCodigo(request.getParameter("codigoP"));
    %>
    <body>
        <form name="frm" action="ServletProducto" method="post" id="frmAnadirCarrito">
            <input type="hidden" name="txtCliente" value="<%=cliente %>">
            <table id="tablaAnadirCarrito">
                <tr>
                    <th colspan="2">
                        <h1>Añadir a carrito</h1>
                    </th>
                </tr>
                <tr>
                    <td colspan="2">
                        <dd> <input type="hidden" name="txtCodigo" value="<%=producto.getCodigoProducto()%>" size="20" maxlength="30"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre producto :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtNombreP" class="campoNoEditable" value="<%=producto.getClaseProducto() %> <%=producto.getMarcaProducto() %> - <%=producto.getDescripcionProducto()%>" 
                               size="60" readonly="readonly"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Precio producto :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtPrecio" class="campoNoEditable" value="<%=producto.getPrecioProducto()%>" size="20" maxlength="30" readonly="readonly"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Cantidad :
                    </td>
                    <td>
                        <dd> <input type="number" name="txtCantidad" id="txtCantidad" value="1" min="1"> 
                            <input type="hidden" name="txtCantidadStock" id="txtCantidadStock" value="<%=producto.getStockProducto()%>" min="1"></dd>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="Botones">
                        <br>
                        <input type="button" name="btnCancelar" id="btnCancelar" class="button" value="Cancelar">
                        <input type="submit" name="btnGuardar" id="btnGuardar" class="button" value="ADD carrito">
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>
                    <input type="hidden" name="accion" value="anadirCarrito">
        </form>
    </body>
</html>
