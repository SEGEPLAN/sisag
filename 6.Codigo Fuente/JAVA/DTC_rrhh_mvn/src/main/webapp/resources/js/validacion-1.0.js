// VALIDAR SOLO LETRAS
function validarLetras(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla === 8)
        return true;
    patron = /[A-Za-z\s]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

// VALIDAR SOLO NUMEROS
function validarNumeros(e) {
   var keynum = window.event ? window.event.keyCode : e.which;
if ((keynum === 8))
return true;
if((keynum === 9)|| (keynum === 46))
return false; 
return /\d/.test(String.fromCharCode(keynum));
}


// VALIDAR E-MAIL
    function validarEmail(valor) {
    if (/[\w\.-]*[a-zA-Z0-9_]@[\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]/.test(valor)){
    return 0;
    } else {
    return -1;
    }
    }
 // 
 
 //VALIDAR QUE NO CONTENGA ESPACIO EN BLANCO
 function validarSpace(e) { // 1
    tecla = (document.all) ? e.keyCode : e.which; // 2
         if (tecla===32) return false;

    patron = /[A-Za-z/.ñÑ'áéíóúÁÉÍÓÚàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛÑñäëïöüÄËÏÖÜ0123456789\s\t]/; // 4
 
    te = String.fromCharCode(tecla); // 5
    return patron.test(te); // 6
} 