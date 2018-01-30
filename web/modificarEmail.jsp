<%-- 
    Document   : modificarEmail
    Created on : Jan 25, 2018, 3:55:08 AM
    Author     : jimmy
--%>

<%@page import="classes.UsuarioDB"%>
<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/cambiarEmail.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Modificar Email</title>
    </head>
    <%
        Usuario usuario = UsuarioDB.listarUsuarioPorCodigo(request.getParameter("codigoU"));
    %>
    <body onload="cargar()">
        <form action="ServletUsuario" method="post" id="frmModificarEmail">
            <table id="tablaModificarEmail">
                <tr>
                    <th colspan="2">
                        <h1>Cambiar E-mail</h1>
                    </th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="hidden" name="txtCodigo" value="<%=usuario.getCodigoUsuario() %>">
                        <input type="hidden" name="txtCaracter" value="<%=usuario.getClaveUsuario() %>">
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Correo actual : 
                    </td>
                    <td>
                        <dd> <%=usuario.getEmailUsuario() %> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Ingrese nuevo Email : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtEmail" id="txtEmail" class="textBox" size="30" maxlength="50"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Confirmar su Email :
                    </td>
                    <td>
                        <dd> <input type="text" name="txtConfirmarEmail" id="txtConfirEmail" class="textBox" size="30" maxlength="50"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Ingrese su contraseña :
                    </td>
                    <td>
                        <dd> <input type="password" name="txtPass" id="txtPass" class="textBox" size="30" maxlength="50"> </dd>
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
                    <input type="hidden" name="accion" value="modificarEmail">
        </form>
    </body>
</html>
