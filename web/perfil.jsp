<%-- 
    Document   : perfil
    Created on : Jan 25, 2018, 3:40:48 AM
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
        <script type="text/javascript" src="js/perfil.js"></script>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <title>Perfil Cliente</title>
    </head>
     <%
        Usuario usuario = UsuarioDB.listarUsuarioPorCodigo(request.getParameter("codigoU"));
    %>
    <body>
        <form action="ServletUsuario" method="post" id="frmModificarUsuario">
            <table id="tablaModificarUsuario">
                <tr>
                    <th colspan="3">
                        <h1>Mi perfil</h1>
                    </th>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="hidden" name="txtCodigo" value="<%=usuario.getCodigoUsuario() %>"> 
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Nombre : 
                    </td>
                    <td>
                        <dd class="soloTexto"> <%=usuario.getNombreUsuario() %> </dd>
                        <dd> <input type="text" name="txtNombre" id="txtNombre" class="campoOculto" value="<%=usuario.getNombreUsuario() %>" size="30" maxlength="50"> </dd>
                        
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Apellidos : 
                    </td>
                    <td>
                        <dd class="soloTexto"> <%=usuario.getApellidosUsuario()%> </dd>
                        <dd> <input type="text" name="txtApellidos" id="txtApellido" class="campoOculto" value="<%=usuario.getApellidosUsuario() %>" size="30" maxlength="50"> </dd>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Email :
                    </td>
                    <td>
                        <dd> <%=usuario.getEmailUsuario()%> </dd>
                    </td>
                    <td>
                        <dd> <a href="modificarEmail.jsp?codigoU=<%=usuario.getCodigoUsuario() %>" class="Enlace">Cambiar email</a> </dd>
                    </td>
                </tr>
                <tr>
                    <td class="primeraColumna">
                        Contraseña :
                    </td>
                    <td>
                        <dd> ********** </dd>
                    </td>
                    <td>
                        <dd> <a href="modificarContrasena.jsp?codigoU=<%=usuario.getCodigoUsuario() %>" class="Enlace">Cambiar contraseña</a> </dd>
                    </td>
                </tr>
                
               
               
                <tr>
                    <td class="primeraColumna">
                        Direccion :
                    </td>
                    <td>
                        <dd class="soloTexto"> <%=usuario.getDireccionUsuario()%> </dd>
                        <dd> <input type="text" name="txtDireccion1" id="txtDireccion1" class="campoOculto" value="<%=usuario.getDireccionUsuario()%>" size="30" maxlength="50"> </dd>
                    </td>
                    <td></td>
                </tr>
               
                <tr>
                    <td class="primeraColumna">
                        Telefono :
                    </td>
                    <td>
                        <dd class="soloTexto"> <%=usuario.getTelefonoUsuario()%> </dd>
                        <dd> <input type="text" name="txtTelefono" id="txtTelefono" class="campoOculto" value="<%=usuario.getTelefonoUsuario() %>" size="30" maxlength="9"> </dd>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    
                </tr>
                <tr>
                    <td colspan="3" class="Botones">
                        <br>
                        <input type="button" name="btnCancelar" id="btnCancelar" class="button" value="Cancelar">
                        <input type="button" name="btnModificar" id="btnModificar" class="button" value="Modificar">
                        <input type="button" name="btnGuardar" id="btnGuardar" class="campoOculto" value="Guardar">
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
            </table>
                    <input type="hidden" name="accion" value="modificarUsuario">
        </form>
    </body>
</html>
