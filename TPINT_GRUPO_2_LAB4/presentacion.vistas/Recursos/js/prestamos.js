  var btnOculto = false;
  
  
document.addEventListener("DOMContentLoaded", function () {
    var btnMenuPrestamo = document.getElementById("btnMenuPrestamo");
    var formPrestamo = document.getElementById("form-prestamo");
    var confirmacion = document.getElementById("txtConfirmacion");
    var banderaMenu = document.getElementById("banderaMostrarMenu");
    var ocultar = document.getElementById("btnOcultar");

    var currentURL = window.location.href;
    var jspURL = 'http://localhost:8080/TPINT_GRUPO_2_LAB4/prestamosCliente.jsp';
    console.log(currentURL);
	 
    

    
    btnMenuPrestamo.addEventListener("click", function () {
    	
    	 formPrestamo.style.marginTop = "80px"; 
   
        });
    
    if( currentURL == "http://localhost:8080/TPINT_GRUPO_2_LAB4/ServletCliente"){
    	
    	formPrestamo.style.marginTop = "80px";
    	btnMenuPrestamo.style.display = "none";
    }
  
    
    ocultar.addEventListener("click", function () {

    	window.history.pushState({}, '', jspURL);
    	history.go(jspURL);
   	 
   	 
       });
  
    
 



});


