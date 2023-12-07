document.getElementById('buttonR').addEventListener('click',
    function() {
        document.querySelector('.Container-modal').style.display = 'flex';
    });

document.querySelector('.closeB').addEventListener('click',
    function() {
        document.querySelector('.Container-modal').style.display = 'none';
    });


    function comprobarInactivar() {
        // Mensaje de confirmación
        var mensaje = "¿Está seguro que desea inactivar la ficha?";
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
        var mensaje = "¿Está seguro que desea activar la ficha?";
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
        var mensaje = "¿Está seguro que desea actualizar la ficha?";
        var eleccion = confirm(mensaje);
    
        if (eleccion) {
            return true;
        } else {
            location.reload(); 
            alert("Operación cancelada.");
            return false;  
        }
    }