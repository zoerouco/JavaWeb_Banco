<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="entidades.Usuario"%>
<%@ page import="entidades.Cuenta"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="util.Utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="Recursos/css/menuCliente.css">
<link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
<title>Globank | Home</title>
</head>

<body>

	<%
		Nacionalidad nac = new Nacionalidad();
		Localidad loc = new Localidad();
		Provincia prov = new Provincia();
		Genero genero = new Genero();
		Cliente cliente = new Cliente();
		Cuenta cuenta = new Cuenta();
		Usuario usuario = new Usuario();
		ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();

		cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		cliente = (Cliente) request.getSession().getAttribute("cliente_actual");
		cuenta = (Cuenta) request.getSession().getAttribute("cuenta_actual");
	%>

	<header class="encabezado" style="
    text-align: center;
">
	<div class="contenedor-menu" style="justify-content: center;">
		<a href="ServletMenuCliente"> <img class="imagen-menu"
			src="Recursos/img/BancoLogo.png" alt="nav">
		</a>
		<h1
			style="color: #ffefd5; font-weight: bolder; margin-top: 10px; margin-left: 10px;">GLOBANK</h1>


	</div>
	</header>

	<h1
		style="background-color: aliceblue; margin: 0; padding-left: 20%; padding-top: 15px;">
		Bienvenid@,
		<%=cliente.getNombre()%></h1>

	<div class="panel-cliente">
		<img src="Recursos/img/perfil-del-usuario.png" class="imagen-cliente">
		<div class="info-cliente">
			<h2>ESTÁS EN TU HOMEBANKING</h2>
			<label> <%=cliente.getNombre()%>, <%=cliente.getApellido()%></label>
			<label> <%=cliente.getId_localidades().getNombre_localidad() + " "
					+ cliente.getId_provincia().getNombre_provincia() + " "
					+ cliente.getId_nacionalidad().getNombre_pais()%></label> <label>E-mail
				dónde recibes información importante y promociones:<br> <%=cliente.getCorreo_electronico()%></label>
		</div>
		<div>
			<div class="form-mostrar-cuentas">

				<form action="ServletMenuCliente" method="post"
					style="text-align: center;">

					<h3>Seleccione la cuenta para gestionar</h3>

					<select name="cuenta-cliente" id="cuentas-cliente"
						onchange="this.form.submit()"
						style="width: 350px; height: 45px; text-align: center;">
						<%
							ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");

							if (cuentas != null) {

								for (Cuenta cuentaCliente : cuentas) {
						%>

						<option
							<%if (cuenta != null && cuentaCliente.getCBU().equals(cuenta.getCBU())) {%>
							selected="selected" <%}%>><%=cuentaCliente.getCBU()%></option>
						<%
								}
							}

							else {
						%>
						<option>NO TIENES CUENTAS CREADAS</option>
						<%
							}
						%>

					</select>
				</form>
			</div>

			<a class="links-menu-home links-menu" href="ServletMovimientos"><div
					class="form-mostrar-cuentas">Mis movimientos</div></a> <a
				class="links-menu-home links-menu" href="ServletCliente"
				id="mis-prestamos"><div class="form-mostrar-cuentas">Mis
					préstamos</div></a> <a class="links-menu-home links-menu"
				href="ServletCliente" id="mis-prestamos"><div
					class="form-mostrar-cuentas">Mis pagos</div></a>
		</div>
		<div class="info-cuenta">
			<h3>CBU</h3>
			<label><%=cuenta.getCBU()%></label>
			<h3>NÚMERO DE CUENTA</h3>
			<label><%=cuenta.getNro_cuenta()%></label>
			<h3>SALDO</h3>
			<label><%=Utils.formatMoney(cuenta.getSaldo())%></label>
		</div>

	</div>

	<div class="cartelera-avisos">

		<h3>AVISOS</h3>

		<ul>
			<li>
				<p>
					A partir del día 5/11, todas las solicitudes de préstamos y cambios
					de información personal,<br> las realizará el Administrador
					del Banco que gestionó el alta de la cuenta. <br> <br>
					Para más información por favor comuniquese vía e-mail:
					globank@support.com.ar
				</p>
			</li>

			<li>
				<p>
					Para más seguridad se agregó un botón antes de mostrar tu
					información de la cuenta. <br> ¡Además ya puedes abrirte más
					de 1 cuenta! Todas las podes gestionar entrando con tu usuario
					único<br> Y eligiendo cuál deseas ver. Ponete en contacto con
					el Administrador del banco para más información.
				</p>
			</li>

		</ul>



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
		crossorigin="anonymous">
		
	</script>
</body>