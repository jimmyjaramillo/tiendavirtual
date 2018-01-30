/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('.campoOculto').hide();

    $('#btnModificar').click(function () {
        botonModificar();
        $('#btnGuardar').addClass("button");
    });

    $('#btnGuardar').click(function () {
        validarDatos();
    });

    $('#btnCancelar').click(function () {
        $(location).attr('href', "catalogo.jsp");
    });
});

function botonModificar() {
    $('.campoOculto').show();
    $('.soloTexto').hide();
    $('#btnModificar').hide();
}

function validarDatos() {
    var nombre = $('#txtNombre').val();
    var apellido = $('#txtApellido').val();
    var direccion = $('#txtDireccion').val();
    var telefono = $('#txtTelefono').val();

    if (nombre == "") {
        alert("El campo nombre no puede estar vacio");
        $('#txtNombre').focus();
        botonModificar();
    } else if (apellido == "") {
        alert("El campo apellido no puede estar vacio");
        $('#txtApellido').focus();
        botonModificar();
    } else if (direccion == "") {
        alert("El campo direccion no puede estar vacio");
        $('#txtDireccion1').focus();
        botonModificar();
    } else if (telefono == "") {
        alert("El campo telefono no puede estar vacio");
        $('#txtTelefono').focus();
        botonModificar();
    } else {
        $('#frmModificarUsuario').submit();
    }
}