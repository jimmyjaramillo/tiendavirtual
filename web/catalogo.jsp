<%-- 
    Document   : catalogo
    Created on : Jan 25, 2018, 3:03:18 AM
    Author     : jimmy
--%>

<%@page import="classes.ProductoDB"%>
<%@page import="classes.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.UsuarioDB"%>
<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/catalogo.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Tienda Virtual</title>
    </head>
    <body onload="cargar()">
        <%
            String codigo = (String) session.getAttribute("parametroCodigo");

            Usuario usuario = UsuarioDB.listarUsuarioPorCodigo(codigo);
            String cliente = usuario.getNombreUsuario() + ", " + usuario.getApellidosUsuario();
        %>
        <form action="ServletUsuario" method="post" id="frmCabecera">
            <input type="hidden" value="<%=usuario.getTipoUsuario()%>" name="txtTipo" id="txtTipo">
            <table id="tablaCabecera">
                <tr>
                    <td colspan="5" align="center" >
                        <%
                            if (usuario.getNombreUsuario() != null) {%>
                        <h1>Bienvenido : <%=usuario.getNombreUsuario()%>, <%=usuario.getApellidosUsuario()%></h1>
                        <%    } else {%>
                        <h1>BIENVENIDOS A LA TIENDA VIRTUAL</h1>
                        <%    }%>

                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="registrarVenta.jsp" class="link" id="lnkCompra"><h4>Mi compra</h4></a>
                    </td>
                    <td>
                        <a href="perfil.jsp?codigoU=<%=usuario.getCodigoUsuario()%>" class="link" id="lnkPerfil">Mi cuenta</a>  
                    </td>
                    <td>
                        <a href="cuentaAdmin.jsp" class="link" id="lnkAdm">Administrar</a>
                    </td>
                    <td>
                        <a href="login.jsp" class="link" id="lnkLogin">Login</a>
                    </td>
                    <td>
                        <a href="ServletUsuario?accion=logout" class="link" id="lnkLogout">Salir</a>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="accion" value="logout">
        </form>
        <hr>
        <form id="frmCatalogo">

            <table width="800" id="tablaCatalogo">
                <tr>
                    <th colspan="3">
                        <h1> Catálogo de Productos </h1>
                    </th>
                </tr>

                <tbody>
                    <%
                        ArrayList<Producto> lista = ProductoDB.obtenerProductosHabilitados();
                        int salto = 0;
                        for (int i = 0; i < lista.size(); i++) {
                            Producto producto = lista.get(i);
        if ((int) producto.getStockProducto() > 0 && producto.getEstadoProducto().equals("HAB")) {%>
                <th><img src="Imagen/<%=producto.getImagenProducto()%>" width="100" height="100"><br>
                    <%=producto.getClaseProducto()%> <%=producto.getMarcaProducto()%> <br>
                    <%=producto.getDescripcionProducto()%><br>
                    $ <%=producto.getPrecioProducto()%><br>
                    <input type="button" class="BotonModificar" name="btnModificar" value="Modificar" onclick="location.href = 'modificarProducto.jsp?codigoP=<%=producto.getCodigoProducto()%>'">
                    <input type="button" class="BotonADD" name="btnADD" value="ADD Carrito" onclick="location.href = 'anadirCarrito.jsp?codigoP=<%=producto.getCodigoProducto()%>&&cliente=<%=cliente%>'"><br>
                </th>
                <%        }

                    salto++;
                    if (salto == 3) {
                %>

                <tr>

                    <%
                                salto = 0;
                            }
                        }
                    %>
                    </tbody>
            </table>
        </form>
    </body>
</html>
