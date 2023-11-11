<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Movimiento"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="entidades.Usuario"%>
<%@ page import="entidades.Cuenta"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
<link rel="stylesheet" type="text/css"
	href="Recursos/css/stylesCliente.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
<title>Globank | Bienvenido</title>
</head>
<body>
 <%
        Nacionalidad nac = new Nacionalidad();
        Localidad loc = new Localidad();
        Provincia prov = new Provincia();
        Genero genero = new Genero();
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();
    	
    	
    	
    	cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
    	usuario = (Usuario) request.getSession().getAttribute("usuario");
    	cliente = (Cliente) request.getSession().getAttribute("cliente_actual");
    	cuenta = (Cuenta) request.getSession().getAttribute("cuenta_actual"); 
    %>
	<header class="encabezado">
	<div class="contenedor-menu">
			<a href="ServletMenuCliente">
           		<img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" /> 
          	</a> 
		<h1 style="color: #ffefd5;">GLOBANK</h1>

		<ul class="contenedor-links-menu">
			<li class="links-menu"><a class="links-menu" href="#"> Home
			</a></li>
			<li class="links-menu"><a class="links-menu"
				href="ServletMovimientos"> Mis movimientos</a></li>
			<li class="links-menu"><a class="links-menu"
				href="prestamosCliente.jsp"> Mis préstamos </a></li>
			<li class="links-menu"><a class="links-menu" href="#">Ajustes
					de la cuenta</a></li>

			<li class="mensaje-bienvenida">
				<h1>Bienvenid@, <%= cliente.getNombre()%></h1>
			</li>

		</ul>
	</div>
	</header>
	<main>
	<div class="container-table" id="table-movimientos">
		<% ArrayList<Movimiento> movimientosCliente = (ArrayList <Movimiento>) request.getAttribute("movimientosCliente");
		int itemsPerPage = 6;
        int totalPages = (int) Math.ceil((double) movimientosCliente.size() / itemsPerPage);
        int currentPage = 1;
        if (request.getParameter("page") != null) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }
        int startIndex = (currentPage - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, movimientosCliente.size());
		%>
		
		<h1>MIS MOVIMIENTOS</h1>
<%
            if (movimientosCliente != null) {
        %>
		  <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID Movimiento</th>
                            <th scope="col">CBU Origen</th>
                            <th scope="col">CBU Destino</th>
                            <th scope="col">Detalle</th>
                            <th scope="col">Fecha de transacción</th>
                            <th scope="col">Importe</th>
                            <th scope="col">Tipo de movimiento</th>
                           
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = startIndex; i < endIndex; i++) {
                                Movimiento movimiento = movimientosCliente.get(i);
                        %>
                                <tr>
                                    <td><%= movimiento.getID_Movimiento() %></td>
                                    <td><%= movimiento.getCBU_Destino().getCBU() %></td>
                                    <td><%= movimiento.getCBU().getCBU() %></td>
                                    <td><%= movimiento.getDetalle() %></td>
                                    <td><%= movimiento.getFecha_Transaccion() %></td>
                                    <td><%= movimiento.getImporte() %></td>
                                    <td><%= movimiento.getTipoMovimiento() %></td>                                                                    
                        <%  
                            }
                        %>
			</tbody>
		</table>
 <div class="paginado">
                <% 
                    for (int i = 1; i <= totalPages; i++) {
                %>
                    <a href="?page=<%= i %>"><%= i %></a>

                <%
                    }
                %>
                   </div>
        <%
            }
        %>
	</div>
	<div class="form-movimientos">

		<h1>TRANSFERENCIAS</h1>

		<form action="ServletCliente" method="post">

			<p>
				Importe: <input type="number" name="importe_pedido"></input>
			</p>
			<p>
				Indique CBU: <input type="number" name="importe_pedido"></input>
			</p>
			<p>
				Seleccionar cuenta donde se depositará transferencias : <select name="cuentas-propias">
					<option value="cbu-1"></option>
					<option value="cbu-2"></option>
					<option value="cbu-3"></option>
				</select>
			</p>

			<input type="submit" name="btnMovimiento" value="Realizar"
				id="btnMovimiento"></input>
		</form>
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
	</footer> </main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>