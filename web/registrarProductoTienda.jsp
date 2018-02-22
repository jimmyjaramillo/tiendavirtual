<%-- 
    Document   : registrarProductoTienda
    Created on : Feb 17, 2018, 5:12:55 PM
    Author     : jimmy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="client.model.ProductoProv"%>
<%@page import="java.util.List"%>
<%@page import="client.RestClient"%>
<%@page import="classes.ProductoProveedor"%>
<%@page import="classes.ProductoTienda"%>
<%@page import="classes.ProductoTiendaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/registrarProductoTienda.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <link type="text/css" rel="stylesheet" href="css/jquery-ui.css" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>

        <title>Buscar Productos-Proveedor</title>
    </head>

    <body onload="cargar()">
        <%
            String codigoProducto = (String) session.getAttribute("codProd");
            String cantidad = (String) session.getAttribute("cantidad");
            String fecha = (String) session.getAttribute("fecha");
             List<ProductoProv> listaProductosProveedores = (List)session.getAttribute("listaProdProv");
        %>
        <form name="frm" id="frmMostrarCuerpoProd" action="ServletProdProv" method="post">
            <table id="tablaMostrarCuerpoProd">
                <tr>
                    <th colspan="7">
                        <h1 align="center">Buscar Productos-Proveedor para Stock de la Tienda</h1>
                    </th>
                </tr>
                <tr>
                    <td colspan="7">
                        <a href="cuentaAdmin.jsp" class="link"><h4> Página principal </h4></a>
                    </td>
                </tr>
                <tr>
                    <td>Código Producto:</td>
                    <td>
                        <dd><input type="text" name="txtCodProd" id="txtCodProd" class="textBox"> </dd>
                    </td>
                    <td>Cantidad Producto:</td>
                    <td>
                        <input type="number" name="txtCantidad" id="txtCantidad" class="textBox" value="1">
                    </td>
                    <td>Fecha Producto:</td>
                    <td>
                        <dd><input type="text" name="datepicker" id="datepicker"></dd>
                    </td>
                    <td>
                        <input type="button" name="btnBuscar" id="btnBuscar" class="button" value="CONSULTAR"> 
                    </td>
                </tr>
                <%if(listaProductosProveedores==null){%>
                <tr>
                    <td colspan="7">
                        Por favor ingrese los datos para poder realizar la busqueda
                    </td>
                </tr>
                <%  }else{%>
                   <tr>
                    <th class="Titulo">
                        CODIGO PROVEEDOR
                    </th>
                    <th class="Titulo">
                        CODIGO PRODUCTO
                    </th>
                    <th class="Titulo">
                        NOMBRE PRODUCTO
                    </th>
                    <th class="Titulo">
                        PRECIO ($)
                    </th>
                    <th class="Titulo">
                        CANTIDAD
                    </th>
                    <th class="Titulo">
                        FECHA ENTREGA
                    </th>
                    <!--                    <th class="Titulo">
                                            ESTADO
                                        </th>-->
                    <th class="Titulo">
                        OPCION
                    </th>
                </tr>

                <%

                    for (int i = 0; i < listaProductosProveedores.size(); i++) {
                        ProductoProv productoProv = listaProductosProveedores.get(i);
                        if ((int) productoProv.getCantidad() > 0) {%>
                <tr> 
                    <%       } else {%>
                <tr bgcolor="red">
                    <%       }
                    %>

                    <td>
                        <%=productoProv.getProdProvId().getCif()%>
                    </td>
                    <td>
                        <%=productoProv.getProdProvId().getCod()%>
                    </td>
                    <td>
                        <%=productoProv.getNombre()%>
                    </td>
                    <td>
                        <%=productoProv.getPrecio()%>
                    </td>
                    <td>
                        <%=productoProv.getCantidad()%>
                    </td>
                    <td>
                        <%=productoProv.getFechaEnt()%>
                    </td> 
                    <!--                    <td>
                    <%=productoProv.getEstado()%>
                </td>-->
                    <td class="Opcion">
                        <input type="button" name="btnSolicitar" id="btnSolicitar" class="button" value="SOLICITAR" onclick="location.href = 'ServletProdProv?codProd=<%=productoProv.getProdProvId().getCod()%>&&codProv=<%=productoProv.getProdProvId().getCif()%>&&nombre=<%=productoProv.getNombre()%>&&cantidadProv=<%=productoProv.getCantidad()%>&&precio=<%=productoProv.getPrecio()%>&&fecha=<%=productoProv.getFechaEnt()%>&&accion=SOLICITAR'"> 
                    </td>

                </tr>

                <%
                    }
                %>   
                 <% }%>
            </table>
            <input type="hidden" name="accion" id="accion" value="">
        </form>
    </body>
</html>
