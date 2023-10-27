<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Recursos/css/stylesCliente.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
<title>Globank | Bienvenido</title>
</head>

<body>
	
	<main>
	
	 <header class="encabezado">
	 
      <div class="contenedor-menu">
        <img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" />
        <h1 style="color:#ffefd5;"> GLOBANK </h1>
    
        <ul class="contenedor-links-menu">  
             	
          <li class="links-menu">
            <a class="links-menu" href="#"> Home </a>
          </li>
          <li class="links-menu">
            <a class="links-menu" href="#"> Mis movimientos</a>
          </li>
          <li class="links-menu">
            <a class="links-menu" href="#"> Mis préstamos </a>
          </li>
          <li class="links-menu">
            <a class="links-menu" href="#">Ajustes de la cuenta</a>
          </li>
          
          <li class="mensaje-bienvenida"> <h1> Bienvenido, x</h1> </li>
          
        </ul>    

        </div>
              
    </header>
    

</div>

<div class="form-prestamo">

<h1>SOLICITAR PRÉSTAMO </h1>

<form action="ServletCliente" method="post">

<p> Importe: <input type="number" name="importe_pedido"></input> </p>
<p> Cantidad de cuotas: <input type="range" name="plazo_meses" min="1" max="18"></input> </p>
 <p>Seleccionar cuenta donde se depositará el préstamo: 
 <select name="cuentas-cliente">
                    <option value="cbu-1"> 01128484089</option>
                    <option value="cbu-2"> 01428884089</option>
                    <option value="cbu-3"> 01828884099</option>
                </select>
</p>

<input type="submit" name="btnSolicitarPrestamo" value="Solicitar" id="btnSolicitarPrestamo"></input>


</form>

</div>




  <div class="container-table" id="table-prestamos">
  
  <h1 class="text-center"> MIS PRÉSTAMOS </h1>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">Nro Prestamo</th>
      <th scope="col">CBU Origen</th>
      <th scope="col">Monto</th>
      <th scope="col">Nro de cuota</th>
    </tr>
  </thead>
  <tbody>
   <tr>
      <th scope="row">1</th>
      <td>533332213234565</td>
      <td>2000</td>
      <td>1</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>533332213234568</td>
      <td>30000</td>
      <td>2</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>533332213234565</td>
      <td>40020</td>
      <td>3</td>
    </tr>
  </tbody>
</table>
       
    </div>
    
	 <div class="Z-footer">
	 
	  <p>Todos los derechos reservados &copy; Globank 2023</p>
         
          <ul class="container-social-media">  
             	
         	 <li class="social-media">
         	 <img src="Recursos/img/facebook.png" alt="Facebook">
            	<a class="social-media" href="#"> Facebook </a>
            	
          	</li>
         		 <li class="social-media">
         		   <img src="Recursos/img/twitter.png" alt="Twitter">
            <a class="social-media" href="#"> Twitter</a>
          
         		 </li>
         			 <li class="social-media" >
         			  <img src="Recursos/img/instagram.png" alt="Instagram">
            <a class="social-media" href="#"> Instagram </a>
           
          			</li>
         				 <li class="social-media">
         				 <img src="Recursos/img/whatsapp.png" alt="Soporte Whatsapp">
            <a class="social-media" href="#">Soporte Whatsapp</a>
            
         				 </li>
	    </ul>  
	    
	 </div>
                  
          
       
          
        </footer>
       </main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>	
</body>
</html>