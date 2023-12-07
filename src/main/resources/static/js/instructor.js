
function comprobarInactivar() {
    // Mensaje de confirmación
    var mensaje = "¿Está seguro que desea inactivar al instructor?";
    var eleccion = confirm(mensaje);

    // Verificar la elección del usuario
    if (eleccion) {
        return true;
    } else {
        return false; 
    }
}

function comprobarActivar() {
    // Mensaje de confirmación
    var mensaje = "¿Está seguro que desea activar al instructor?";
    var eleccion = confirm(mensaje);

    // Verificar la elección del usuario
    if (eleccion) {
        return true;
    } else {
        return false; 
    }
}

function comprobarActualizar() {

    // Mensaje de confirmación
    var mensaje = "¿Está seguro que desea actualizar al instructor?";
    var eleccion = confirm(mensaje);

    if (eleccion) {
        return true;
    } else {
        location.reload(); 
        alert("Operación cancelada.");
        return false;  
    }
}

function comprobarActualizarUs() {

    // Mensaje de confirmación
    var mensaje = "¿Está seguro que desea actualizar su información?";
    var eleccion = confirm(mensaje);

    if (eleccion) {
        return true;
    } else {
        location.reload();
        alert("Operación cancelada.");
        return false;
    }
}