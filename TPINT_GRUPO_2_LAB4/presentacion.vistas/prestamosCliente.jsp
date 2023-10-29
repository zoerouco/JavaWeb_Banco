<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="entidades.Cuenta"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="Recursos/css/stylesCliente.css">
<link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="Recursos/js/prestamos.js"></script>
<link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />


    
<title>Globank | Mis préstamos</title>

</head>

<body>

<% 
	//este scriplet seria como el pageLoad donde inicializo todo lo que voy a necesitar en el form solicitar prestamo:
	Nacionalidad nac = new Nacionalidad();
	Localidad loc = new Localidad();
	Provincia prov = new Provincia();
	Genero genero = new Genero();
	Prestamo prestamo = new Prestamo("x");
	Cliente cliente = new Cliente ("01", "Jose", true);
	Cuenta cuenta = new Cuenta();
	   
	%>

	<header class="encabezado">
	<div class="contenedor-menu">
		<img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" />
		<h1 style="color: #ffefd5;">GLOBANK</h1>

		<ul class="contenedor-links-menu">
			<li class="links-menu"><a class="links-menu" href="#"> Home
			</a></li>
			<li class="links-menu"><a class="links-menu"
				href="movimientosCliente.jsp"> Mis movimientos</a></li>
			<li class="links-menu"><a class="links-menu"
				href="prestamosCliente.jsp" id="mis-prestamos"> Mis préstamos </a></li>
			<li class="links-menu"><a class="links-menu" href="#">Ajustes
					de la cuenta</a></li>

			<li class="mensaje-bienvenida">
			<h1>Bienvenido, <%= cliente.getNombre()%></h1>
			</li>

		</ul>
		 <input type="hidden" name="clienteActual" value="<%= cliente.getDNI() %>">
	</div>
	</header>
	
	

	<div class="form-prestamo" id="form-prestamo">

		<h1>SOLICITAR PRÉSTAMO</h1>

		<form action="ServletCliente" method="post">
		
		 <input type="hidden" name="clienteActual" value="<%= cliente.getDNI() %>">

			<p class="importe_prestamo">
				Importe:<input type="number"  required name="importe_pedido" min="1000"
					max="100000000" step="1000"></input>
			</p>

			<p>
				Cantidad de cuotas: <select name="cant_cuotas">
					<option value="1">1 cuota - 3% interés</option>
					<option value="3">3 cuotas - 5% interés</option>
					<option value="6">6 cuotas - 10% interés</option>
					<option value="12">12 cuotas - 20% interés</option>
					<option value="18">18 cuotas - 25% interés</option>
				</select>

			</p>
			<p>
				Cuenta donde se depositará el préstamo: 
				<select required name="cuentas-cliente" id="cuentas-cliente">
				<% 
				ArrayList <Cuenta> cuentas = (ArrayList <Cuenta>) request.getAttribute("listaCuentas");
				
				if(cuentas != null){
					 
				   for(Cuenta cuentaCliente : cuentas){				   
				  %>

					<option><%=cuentaCliente.getCBU()%></option>
				 <%
				   }
				}
			    
			    else { 
                            %>
                                <option>NO HAY</option>
                       <% }
				%>  
                              
                               </select>
			
		    <input type="submit" name="btnSolicitarPrestamo" value="Aceptar"
					id="btnSolicitarPrestamo"></input>

		</form>
		
		<button id="btnOcultar" value="Ocultar">Ocultar</button>
		
		
		<% 
		Boolean inserto = (Boolean) request.getAttribute("inserto");
		
		if(inserto != null && inserto){
			%>
			
			<p class="mensajeSucceed"> Se solicitó el préstamo correctamente. Por favor revisa el estado de tu solicitud en la pestaña "Mis préstamos". ¡Gracias!</p>
			
		<% 
		}
		%>
			</div>
		

<form action="ServletCliente" method="post">
	

<div id="btnMenuPrestamo">

 <input type="hidden" name="clienteActual" value="<%= cliente.getDNI() %>">
 <img src="Recursos/img/prestamo-icon.png" height="64px"> <input type="submit" name=btnMenuPrestamo id="btnMenuPrestamo" value="Solicitar préstamo"></input> <img>
  
</div>

	</form>
	
	
	<div class="container-table" id="table-prestamos">

		<h1 class="text-center">MIS PRÉSTAMOS</h1>
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
	<footer class="Z-footer">
	<p>Todos los derechos reservados &copy; Globank 2023</p>

	<ul class="container-social-media">

		<li class="social-media"><img src="Recursos/img/facebook.png"
			alt="Facebook"> <a class="social-media" href="#"> Facebook
		</a></li>
		<li class="social-media"><img src="Recursos/img/twitter.png"
			alt="Twitter"> <a class="social-media" href="#"> Twitter</a></li>
		<li class="social-media"><img src="Recursos/img/instagram.png"
			alt="Instagram"> <a class="social-media" href="#">
				Instagram </a></li>
		<li class="social-media"><img src="Recursos/img/whatsapp.png"
			alt="Soporte Whatsapp"> <a class="social-media" href="#">Soporte
				Whatsapp</a></li>

	</ul>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>