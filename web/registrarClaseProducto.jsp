<%-- 
    Document   : registrarClaseProducto
    Created on : Jan 26, 2018, 12:06:14 AM
    Author     : jimmy
--%>

<%@page import="classes.ObtenerCodigoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/registrarClaseProducto.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Registrar Clase Producto</title>
    </head>
    <%
        String Codigo_CP = ObtenerCodigoProducto.CodigoClaseProducto();
    %>
    <body onload="cargar()">
        <form name="frm" action="ServletClaseProducto" method="post" id="frmRegistrarCP">
            <table id="tablaRegistrarCP">
                <tr>
                    <td colspan="2">
                        <h1>Registrar clase producto</h1>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Codigo :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtCodigo" value="<%=Codigo_CP %>" readonly="readonly">  </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre Clase producto :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtNombre" id="txtNombre" class="textBox"> </dd>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="Botones">
                        <br>
                        <input type="button" name="btnCancelar" id="btnCancelar" class="button" value="Cancelar"> 
                        <input type="button" name="btnRegistrar" id="btnRegistrar" class="button" value="Registrar"> 
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
