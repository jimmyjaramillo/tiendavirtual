<%-- 
    Document   : login
    Created on : Jan 25, 2018, 3:25:45 AM
    Author     : jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Login</title>
    </head>
    <body>
       <div>
            <form method="post" action="ServletUsuario" id="frmLogin">
                <table id="tablaLogin">
                    <tr>
                        <th>
                            <h1>Login</h1>
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="txtUsuario" placeholder="Ingrese usuario" id="txtUsuario" class="textBox">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="password" name="txtClave" placeholder="Ingrese contraseña" id="txtClave" class="textBox">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" name="btnIngresar" value="Ingresar" id="btnIngresar" >
                        </td>
                    </tr>
                    <tr>
                        <td class="centrarBoton">
                            <a href="registrarCliente.jsp" id="lnkRegistrarUsuario"><h4>Registrate aqui</h4></a>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="accion" value="login">
            </form>
        </div>
    </body>
</html>
