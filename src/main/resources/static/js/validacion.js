function comprobarClave() {
    var pass1 = document.getElementById("pass1").value;
    var pass2 = document.getElementById("pass2").value;
    var mensajeError = document.getElementById("mensajeError");

    if (pass1 !== pass2) {
        mensajeError.innerHTML = "Las contraseñas no coinciden.";
        return false;
    } else {
        mensajeError.innerHTML = "";
        return true;
    }
}

function comprobarCodigo() {
    var cod = document.getElementById("cod").value;
    var mensajeError = document.getElementById("mensajeError");

    if (cod !== "15D49") {
        mensajeError.innerHTML =  "El codigo de acceso es incorrecto.";
        return false;
    } else {
        mensajeError.innerHTML = "";
        return true;
    }
}