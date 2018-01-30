/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
   
    
    $('#txtCantidad').change(function(){
        validarDatos();
    });
});

function validarDatos(){
    var cantidad = $('#txtCantidad').val();
    var stock = $('#txtCantidadStock').val();
    
    if(cantidad > stock){
        alert("A sobrepasado el stock disponible de este articulo");
        $('#txtCantidad').val("1");
        $('#txtCantidad').focus();
    }
    
}


