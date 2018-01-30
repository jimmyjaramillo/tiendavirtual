/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('.textBox').val("");
    
    $('#btnCancelar').click(function(){
        history.back();
    });
    
    $('#btnRegistrar').click(function(){
        validarDatos();
    });
});

function validarDatos(){
    var nombre = $('#txtNombre').val();
    
    if(nombre == ""){
        alert("El campo marca producto no pueden estar vacio");
        $('#txtNombre').focus();
    }else{
        $('#frmRegistrarMP').submit();
    }
}