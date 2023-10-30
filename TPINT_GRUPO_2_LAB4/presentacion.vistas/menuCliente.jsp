<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="entidades.Usuario" %>
<%@ page import="entidades.Cuenta"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="Recursos/css/stylesCliente.css">
<link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
<title>Globank | Home </title>
</head>

<body>

	<% 
	Nacionalidad nac = new Nacionalidad();
	Localidad loc = new Localidad();
	Provincia prov = new Provincia();
	Genero genero = new Genero();
	Cliente cliente = new Cliente ();
	Cuenta cuenta = new Cuenta();
	Usuario usuario = new Usuario();
	ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();
	cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
	usuario = (Usuario) request.getSession().getAttribute("usuario");
	cliente = (Cliente) request.getSession().getAttribute("cliente_actual");
	
	
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
					</a></li>

			<li class="mensaje-bienvenida">
			<h1>Bienvenid@, <%= cliente.getNombre()%></h1>
			</li>

		</ul>
		 <input type="hidden" name="clienteActual" value="<%= cliente.getDNI()%>">
	</div>
	</header>
	

	
	<div class="panel-cliente">
	<img src="Recursos/img/perfil-del-usuario.png">
	<div class="info-cliente">
	</div>
	
	<div class="">
	</div>
	
	
	
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
		crossorigin="anonymous"> </script>
</body>