/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function (){
    limpiarCampos();
    
    $('#btnRegistrar').click(function (){
        validarDatos();
    });
    
    $('#btnCancelar').click(function (){
        history.back();
    });
});

function limpiarCampos(){
    $('.textBox').val("");
}

function validarDatos(){
    var nombre = $('#txtNombre').val();
    var apellido = $('#txtApellido').val();
    var email = $('#txtEmail').val();
    var direccion = $('#txtDireccion').val();
    var telefono = $('#txtTelefono').val();
    var usuario = $('#txtUsuario').val();
    var pass1 = $('#txtClave').val();
    var pass2 = $('#txtConfirClave').val();
    
    if(nombre == ""){
        alert("El campo nombre no puede estar vacio");
        $('#txtNombre').focus();
    }else if(apellido == ""){
        alert("El campo apellido no puede estar vacio");
        $('#txtApellido').focus();
    }else if(email == ""){
        alert("El campo email no puede estar vacio");
        $('#txtEmail').focus();
    }else if(direccion == ""){
        alert("El campo direccion1 no puede estar vacio");
        $('#txtDireccion1').focus();
    }
    else if(telefono == ""){
        alert("El campo telefono no puede estar vacio");
        $('#txtTelefono').focus();
    }
    else if(usuario == ""){
        alert("El campo usuario no puede estar vacio");
        $('#txtUsuario').focus();
    }
    else if(pass1 == ""){
        alert("El campo clave no puede estar vacio");
        $('#txtClave').focus();
    }
    else if(pass2 == ""){
        alert("El campo confirmar clave no puede estar vacio");
        $('#txtConfirClave').focus();
    }
    else{
        if(pass1 != pass2){
            alert("Las contraseñas no son iguales");
        }
        else{
            $('#frmRegistrarUsuario').submit();
        }
        
    }
}

