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
                      
                        <h5 align="right"><a href="catalogo.jsp" class="link"><h4> Página principal </h4></a></h5>
                   
                    </th>
                </tr>
                <tr>
                    <th>
                        Registrar Productos-Proveedor   
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
                    </td>
                    <td>    
                    </td>
                    <td>                 
                    </td>
                    <td>
                        <a href="mostrarVenta.jsp" class="link">Ir a ventas</a>
                    </td>
                    <td>
                        <a href="catalogo.jsp" class="link">Ir a catalogo</a>
                    </td>
                </t r>
                <tr>
                    <td>
                        <a href="registrarProductoTienda.jsp" class="link">Producto-Proveedor</a>
                    </td>
                    <td>
                        <a href="mostrarProductoTienda.jsp" class="link">Productos Tienda</a>
                    </td>
                    <td>
                        <a href="mostrarProductosTiendaEliminados.jsp" class="link">Productos Tienda</a>
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
