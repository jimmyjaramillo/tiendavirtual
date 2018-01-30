/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var tipo = $('#txtTipo').val();

    if (tipo == "ADMINISTRADOR") {
        cuentaAdministrador()
    } else if (tipo == "CLIENTE") {
        cuentaUsuario();
    } else {
        cuentaNegada();
        $('.BotonADD').click(function () {
            $(location).attr('href', "login.jsp");
        });
    }
});

function cuentaAdministrador() {
    $('#lnkAdm').show();
    $('#lnkLogout').show();
    $('#lnkLogin').hide();
    $('.BotonModificar').show();
}
function cuentaUsuario() {
    $('#lnkLogout').show();
    $('#lnkLogin').hide();
    $('#lnkAdm').hide();
    $('.BotonModificar').hide();
}
function cuentaNegada() {
    $('#lnkLogin').show();
    $('#lnkLogout').hide();
    $('#lnkAdm').hide();
    $('#lnkPerfil').hide();
    $('.BotonModificar').hide();
}

