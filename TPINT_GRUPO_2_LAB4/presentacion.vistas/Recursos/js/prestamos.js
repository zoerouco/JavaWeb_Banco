document.addEventListener("DOMContentLoaded", function () {
    var btnMenuPrestamo = document.getElementById("btnMenuPrestamo");
    var formPrestamo = document.getElementById("form-prestamo");

    btnMenuPrestamo.addEventListener("click", function () {
        // Cambiar el estilo de margin-top para mostrar el formulario
        formPrestamo.style.marginTop = "70px";
        btnMenuPrestamo.style.display = "none";
    });
});
