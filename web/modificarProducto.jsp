<%-- 
    Document   : modificarProducto
    Created on : Jan 25, 2018, 10:37:46 PM
    Author     : jimmy
--%>

<%@page import="classes.MarcaProductoDB"%>
<%@page import="classes.MarcaProducto"%>
<%@page import="classes.ClaseProductoDB"%>
<%@page import="classes.ClaseProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.ProductoDB"%>
<%@page import="classes.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/modificarProducto.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Modificar Producto</title>
    </head>
    <%
        Producto producto = ProductoDB.listarProductoPorCodigo(request.getParameter("codigoP"));
        ArrayList<ClaseProducto> listaClaseProductos = ClaseProductoDB.ObtenerClasesProductosHabilitados();
        ArrayList<MarcaProducto> listaMarcaProductos = MarcaProductoDB.obtenerMarcasProductosHabilitados();
    %>
    <body onload="cargar()">
        <form name="frm" action="ServletProducto" method="post" id="frmModificarProd">
            <table id="tablaModificarProd">
                <tr>
                    <th colspan="2">
                        <h1>Modificar producto</h1>
                    </th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="hidden" name="txtCodigo" value="<%=producto.getCodigoProducto()%>">
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Codigo producto :
                    </td>
                    <td>
                        <dd> <%=producto.getCodigoProducto()%> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre Clase Producto :
                    </td>
                    <td>
                        <dd> 
                            <select name="txtNombreCP" id="txtNombreCP">
                                <% for (int i = 0; i < listaClaseProductos.size(); i++) {
                                    ClaseProducto claseProducto = listaClaseProductos.get(i);
                                    if(claseProducto.getNombreClaseProducto().equals(producto.getClaseProducto())){
                                       %>
                                       <option value="<%=claseProducto.getNombreClaseProducto() %>" selected><%=claseProducto.getNombreClaseProducto() %></option>
                               <% 
                                    }else{
                                      %>
                                <option value="<%=claseProducto.getNombreClaseProducto() %>"><%=claseProducto.getNombreClaseProducto() %></option>
                               <%  
                                    }
                                   }
                               %> 
                            </select>
                        </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre Marca Producto :
                    </td>
                    <td>
                        <dd> 
                            <select name="txtNombreMP" id="txtNombreMP">
                                <% for (int i = 0; i < listaMarcaProductos.size(); i++) {
                                    MarcaProducto marcaProducto = listaMarcaProductos.get(i);
                                    if(marcaProducto.getNombreMarcaProducto().equals(producto.getMarcaProducto())){
                                       %>
                                       <option value="<%=marcaProducto.getNombreMarcaProducto() %>" selected><%=marcaProducto.getNombreMarcaProducto() %></option>
                               <% 
                                    }else{
                                      %>
                                <option value="<%=marcaProducto.getNombreMarcaProducto() %>"><%=marcaProducto.getNombreMarcaProducto() %></option>
                               <%  
                                    }
                                   }
                               %> 
                            </select>
                        </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Descripcion producto :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtDescripcionP" id="txtDescripcionP" value="<%=producto.getDescripcionProducto()%>" size="30" maxlength="30"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Precio producto :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtPrecioP" id="txtPrecioP" value="<%=producto.getPrecioProducto()%>" size="30" maxlength="30"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Stock producto :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtStockP" id="txtStockP" value="<%= (int)producto.getStockProducto() %>" size="30" maxlength="30"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Imagen actual : 
                    </td>
                    <td>
                            <dd> <input type="radio" name="selected" value="SelectImagenActual" id="SelectImagenActual" checked="checked"> 
                            <input type="text" name="txtImagen" id="txtImagen" value="<%=producto.getImagenProducto()%>" size="30" maxlength="30"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Modificar imagen : 
                    </td>
                    <td>
                            <dd> <input type="radio" name="selected" value="SelectModificarImagen" id="SelectModificarImagen"> 
                            <input type="file" name="txtModificarImagen" id="txtModificarImagen" size="30"> </dd>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="Botones">
                        <br>
                        <input type="button" name="btnCancelar" id="btnCancelar" class="button" value="Cancelar">
                        <input type="button" name="btnGuardar" id="btnGuardar" class="button" value="Guardar">
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>
                    <input type="hidden" name="accion" value="actualizar">
        </form>
    </body>
</html>
