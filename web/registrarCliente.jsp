<%-- 
    Document   : registrarCliente
    Created on : Jan 26, 2018, 12:09:58 AM
    Author     : jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/registrarCliente.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Registrar Cliente</title>
    </head>
    <body>
        <form name="frm" action="ServletUsuario" method="post" id="frmRegistrarUsuario">
            <input type="hidden" name="accion" value="registrar">
            <table id="tablaRegistrarUsuario">
                <tr>
                    <th colspan="3">
                        <h1>Registrate ahora</h1>
                    </th>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtNombres" id="txtNombre" class="textBox" placeholder="Nombres" size="30" maxlength="50"> </dd>          
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Apellido : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtApellidos" id="txtApellido" class="textBox" placeholder="Apellidos" size="30" maxlength="50"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Email : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtEmail" id="txtEmail" class="textBox" placeholder="Correo electronico" size="30" maxlength="50"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Direccion : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtDireccion" id="txtDireccion" class="textBox" placeholder="Direccion" size="30" maxlength="50"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna"> 
                        Telefono : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtTelefono" id="txtTelefono" class="textBox" placeholder="Telefono o Celular" size="30" maxlength="9"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Usuario : 
                    </td>
                    <td>
                        <dd> <input type="text" name="txtUsuario" id="txtUsuario" class="textBox" placeholder="Cree un usuario" size="30" maxlength="30"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Contraseña : 
                    </td>
                    <td>
                        <dd> <input type="password" name="txtClave" id="txtClave" class="textBox" placeholder="Cree una contraseña" size="30" maxlength="20"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Confirmar contraseña : 
                    </td>
                    <td>
                        <dd> <input type="password" name="txtConfirmarClave" id="txtConfirClave" class="textBox" placeholder="Confirme su contraseña" size="30" maxlength="20"> </dd>
                    </td>
                    <td>
                        <dd> * </dd>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" class="Botones">
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
        </form>
    </body>
</html>
