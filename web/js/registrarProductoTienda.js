/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('.textBox').val("");
    
    $("#txtCantidad").keypress(function (evt) {
        evt.preventDefault();
    });
    
    $('#btnBuscar').click(function(){
        $('#accion').val("CONSULTAR");
        validarDatos();
    });
    
    $('#btnSolicitar').click(function(){
        $('#accion').val("SOLICITAR");
//        $('#frmMostrarCuerpoProd').submit();
    });
    
    $("#datepicker").datepicker();
    
    
    
    
});

function validarDatos(){
    var productoId = $('#txtCodProd').val();
    var cantidad = $('#txtCantidad').val();
    var fecha = $('#datepicker').val();
    if((productoId != "" && cantidad != "" && fecha == "")||(productoId != "" && cantidad != "" && fecha != "")){ 
        $('#frmMostrarCuerpoProd').submit();
    }else{
        alert("Existen campos vacios para la busqueda");
    }
    
}