/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('#btnCancelar').click(function(){
        $(location).attr('href',"mostrarMarcaProducto.jsp");
    });
    
    $('#btnGuardar').click(function(){
        validarDatos();
    });
});

function validarDatos(){
    var nombre = $('#txtNombre').val();
    
    if(nombre == ""){
        alert("El campo marca producto no puede estar vacio");
        $('#txtNombre').focus();
    }
    else{
        $('#frmModificarMP').submit();
    }
}

