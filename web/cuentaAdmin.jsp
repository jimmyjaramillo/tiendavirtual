<%-- 
    Document   : cuentaAdmin
    Created on : Jan 25, 2018, 3:22:09 AM
    Author     : jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Administrador</title>
    </head>
    <body>
        <form id="frmAdministrador">
            <table id="tablaAdministrador">
                <tr>
                    <th colspan="5">
                        <h2> Menu administrador </h2>
                    </th>
                </tr>
                <tr>
                    <th>
                        Registrar nuevo
                    </th>
                    <th>
                        Registros habilitados
                    </th>
                    <th>
                        Registros inhabilitados
                    </th>
                    <th>
                        Pedidos realizados
                    </th>
                    <th>
                        Mi catalogo
                    </th>
                </tr>
                <tr>
                    <td>
                        <a href="registrarClaseProducto.jsp" class="link">Clase producto</a>
                    </td>
                    <td>
                        <a href="mostrarClaseProducto.jsp" class="link">Clase producto</a>
                    </td>
                    <td>
                        <a href="mostrarClaseProductosEliminados.jsp" class="link">Clase producto</a>
                    </td>
                    <td>
                        <a href="mostrarVenta.jsp" class="link">Ir a ventas</a>
                    </td>
                    <td>
                        <a href="catalogo.jsp" class="link">Ir a catalogo</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="registrarMarcaProducto.jsp" class="link">Marca producto</a>
                    </td>
                    <td>
                        <a href="mostrarMarcaProducto.jsp" class="link">Marca producto</a>
                    </td>
                    <td>
                        <a href="mostrarMarcaProductosEliminados.jsp" class="link">Marca producto</a>
                    </td>
                    <td>
                        
                    </td>
                    <td>
                        
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="registrarProducto.jsp" class="link">Producto</a>
                    </td>
                    <td>
                        <a href="mostrarProducto.jsp" class="link">Producto</a>
                    </td>
                    <td>
                        <a href="mostrarProductosEliminados.jsp" class="link">Producto</a>
                    </td>
                    <td>
                        
                    </td>
                    <td>
                        
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <a href="mostrarUsuario.jsp" class="link">Usuario</a>
                    </td>
                    <td>
                        <a href="mostrarUsuarioEliminado.jsp" class="link">Usuario</a>
                    </td>
                    <td>
                        
                    </td>
                    <td>
                        
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
