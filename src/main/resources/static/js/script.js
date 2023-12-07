document.addEventListener("DOMContentLoaded", function () {
    const competenciaSelect = document.getElementById("competencia");
    const resultadoApreSelect = document.getElementById("resultadoApre");
    const resultadoApreOptions = resultadoApreSelect.querySelectorAll("option");

    competenciaSelect.addEventListener("change", function () {
        const competenciaSeleccionada = competenciaSelect.value;

        // Itera a través de las opciones y muestra u oculta según la competencia seleccionada
        resultadoApreOptions.forEach(function (option) {
            if (option.getAttribute("data-competencia") === competenciaSeleccionada || competenciaSeleccionada === "Competencia") {
                option.style.display = "block"; // Muestra la opción
            } else {
                option.style.display = "none"; // Oculta la opción
            }
        });
    });
});