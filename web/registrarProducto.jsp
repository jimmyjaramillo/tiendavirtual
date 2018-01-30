<%-- 
    Document   : registrarProducto
    Created on : Jan 26, 2018, 12:22:35 AM
    Author     : jimmy
--%>

<%@page import="classes.MarcaProductoDB"%>
<%@page import="classes.MarcaProducto"%>
<%@page import="classes.ClaseProducto"%>
<%@page import="classes.ClaseProductoDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.ObtenerCodigoProducto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/registrarProducto.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Registrar Producto</title>
    </head>
    
    <%
        String Codigo_P = ObtenerCodigoProducto.CodigoProducto();
        ArrayList<ClaseProducto> listaClaseProductos = ClaseProductoDB.ObtenerClasesProductosHabilitados();
        ArrayList<MarcaProducto> listaMarcaProductos = MarcaProductoDB.obtenerMarcasProductosHabilitados();

    %>
    <body onload="cargar()">
        <form name="frm" action="ServletProducto" method="post" id="frmRegistrarProd" enctype="'multipart/form-data">
            <table id="tablaRegistrarProd">
                <tr>
                    <th colspan="2">
                        <h1> Registrar producto  </h1>
                    </th>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Código :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtCodigo" value="<%=Codigo_P %>" readonly="readonly"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre Clase producto :
                    </td>
                    <td>
                        <dd> 
                            <select name="txtClase" id="txtClase">
                                <option>Seleccione Clase Producto</option>
                                <% for (int i = 0; i < listaClaseProductos.size(); i++) {
                                    ClaseProducto claseProducto = listaClaseProductos.get(i);%>
                                <option value="<%=claseProducto.getNombreClaseProducto() %>"><%=claseProducto.getNombreClaseProducto() %></option>
                               <%
                                   }
                               %> 
                            </select>
                        </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre Marca producto :
                    </td>
                    <td>
                        <dd> 
                            <select name="txtMarca" id="txtMarca">
                                <option>Seleccione Marca Producto</option>
                                <% for (int i = 0; i < listaMarcaProductos.size(); i++) {
                                    MarcaProducto marcaProducto = listaMarcaProductos.get(i);%>
                                <option value="<%=marcaProducto.getNombreMarcaProducto() %>"><%=marcaProducto.getNombreMarcaProducto()%></option>
                               <%
                                   }
                               %> 
                            </select>
                        </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Descripcion :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtDescripcion" id="txtDescripcion" class="textBox"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Stock :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtStock" id="txtStock" class="textBox"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Precio :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtPrecio" id="txtPrecio" class="textBox"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Imagen :
                    </td>
                    <td>
                        <dd> <input type="file" name="txtImagen" size="30" id="txtImagen" class="textBox"> </dd>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="Botones">
                        <br>
                        <input type="button" name="btnCancelar" id="btnCancelar" class="button" value="Cancelar">
                        <input type="submit" name="btnRegistrar" id="btnRegistrar" class="button" value="Registrar">
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>
                    <input type="hidden" name="accion" value="insertar">
        </form>
    </body>
</html>
