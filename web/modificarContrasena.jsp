<%-- 
    Document   : modificarContrasena
    Created on : Jan 25, 2018, 3:51:43 AM
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
        <script type="text/javascript" src="js/cambiarPassword.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Cambiar Contraseña</title>
    </head>
     <%
        Usuario usuario = UsuarioDB.listarUsuarioPorCodigo(request.getParameter("codigoU"));
    %>
    <body onload="cargar()">
        
        <form action="ServletUsuario" method="post" id="frmModificarClave">
            <table id="tablaModificarClave">
                <tr>
                    <th colspan="2">
                        <h1>Cambiar contrase&ntildea</h1>
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
                        Ingrese su contrase&ntildea actual : 
                    </td>
                    <td>
                        <dd> <input type="password" name="txtClaveActual" id="txtClaveActual" class="textBox" size="20" maxlength="20"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Ingrese nueva contrase&ntildea : 
                    </td>
                    <td>
                        <dd> <input type="password" name="txtClave" id="txtClave" class="textBox" size="20" maxlength="20"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Confirmar su contrase&ntildea :
                    </td>
                    <td>
                        <dd> <input type="password" name="txtConfirmarClave" id="txtConfirClave" class="textBox" size="20" maxlength="20"> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="Botones">
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
                    <input type="hidden" name="accion" value="modificarClave">
        </form>
    </body>
</html>
