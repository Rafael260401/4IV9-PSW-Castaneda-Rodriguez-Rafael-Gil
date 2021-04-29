jQuery('document').ready(function($){
    var menuBtn = $('.menu-icon'),
        menu = $('.navigation ul');

    menuBtn.click(function(){
        if(menu.hasClass('show')){

            menu.removeClass('show');

        } else {

            menu.addClass('show')
        }
    });
});

function validarLetras(e){
    var teclado = (document.all) ? e.keyCode : e.which;

    if(teclado == 8) return true;

    var patron = /[a-z-A-Z]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba); 
}

function validarAlfaNumericos(e){
    var teclado = (document.all) ? e.keyCode : e.which;

    if(teclado == 8) return true;

    var patron = /[a-z-A-Z\d]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}

function validarNumeros(e){
    var teclado = (document.all) ? e.keyCode : e.which;

    if(teclado == 8) return true;

    var patron = /\d/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
