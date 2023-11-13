<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/mainAdmin.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Modificar Clientes</title>
	</head>
	<body>
	<%
	Usuario admin = new Usuario ();
	admin = (Usuario) request.getAttribute("admin_actual");
	%>
		<header class="encabezado">
            <div class="contenedor-menu">
			<a href="ServletMenuAdmin">
           		<img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" /> 
          	</a> 
                <h1 style="color:#ffefd5;"> GLOBANK </h1>
                <ul class="contenedor-links-menu">  
                    <li class="nav-item dropdown">
                        <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           Cuentas
                        </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="ServletAltaCuenta">Alta de cuentas</a>
                            <a class="dropdown-item" href="ServletModificarCuenta">Modificar Cuentas</a>
                            <a class="dropdown-item" href="ServletListarCuenta">Listar Cuentas</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="ServletEliminarCuenta">Baja de cuentas</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Clientes
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="ServletAltaCliente">Alta de clientes</a>
                        <a class="dropdown-item" href="ServletModificarCliente">Modificar clientes</a>
                        <a class="dropdown-item" href="ServletListadoCliente">Listar clientes</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="ServletEliminarCliente">Baja de clientes</a>
                    </div>
                </li>
                    <li class="nav-item dropdown">
                        <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           Reportes de prestamos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="ServletListarPrestamos">Ver todos los prestamos</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="ServletGestionarPrestamos">Gestionar prestamos</a>
                        </div>
                    </li>
                    <li class="mensaje-bienvenida">
                        <h1> Bienvenid@, <%=admin.getNombreUsuario() %></h1> 
                    </li>
                </ul>
            </div> 
        </header>
        <form action="ServletModificarCliente" method="post">
         <label for="DNI">Buscar cliente por DNI:<span class="required-fields"></span></label>
        	<input type="text" name="DNI" id="DNI" placeholder=" " required>
        	<input type="submit" name="btnBuscarXDNI" value="Aceptar" style="margin-top: 200px">
        	<div class="error-message">
    				<%= (request.getAttribute("errorMessage") != null) ? request.getAttribute("errorMessage") : "" %>
			</div>
		</form>
		    <form action="ServletModificarCliente" method="post">
			<div class="error-message">
    				<%= (request.getAttribute("mensaje") != null) ? request.getAttribute("mensaje") : "" %>
			</div>
			
        	<%  Cliente cliente = (Cliente) request.getAttribute("clienteDNI");
        		if (cliente != null) {
        	%>
        	<br>
        	<br>
		    <label for="nombre">Nombre:</label>
		    <input type="text" name="nombre" value="<%= cliente.getNombre() %>" required>
		    <br>
		    <label for="apellido">Apellido:</label>
		    <input type="text" name="apellido" value="<%= cliente.getApellido() %>" required>
		    <br>
		    <label for="dni1">DNI:</label>
			<label><%= cliente.getDNI() %></label>
			<input type="hidden" name="dni1" value="<%= cliente.getDNI() %>" >
		    <br>
                        <label for="gender">Genero: </label>
                        <label><%= cliente.getId_genero().getDescripcion() %></label>
                        <br>  
                         
		    <select name="gender" name="gender">
                           	<% ArrayList <Genero> generos = (ArrayList <Genero>)request.getAttribute("listaGeneros");
                        		if (generos != null){
                        			for(Genero genero : generos) { %>
                        				<option value="<%=genero.getId_genero()%>"><%=genero.getDescripcion()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select><br>
		    <label for="nationality">Nacionalidad: </label>
		    <label><%= cliente.getId_nacionalidad().getNombre_pais() %></label>
                        <br> 
                        <select name="nationality" name="nationality">
                            <% ArrayList <Nacionalidad> nacionalidades = (ArrayList <Nacionalidad>)request.getAttribute("listaNacionalidades");
                           	   if (nacionalidades != null){
                        			for(Nacionalidad nacionalidad : nacionalidades) { %>
                        				<option value="<%=nacionalidad.getId()%>"><%=nacionalidad.getNombre_pais()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
		    <br>
		     <label for="province">Provincia: </label>
		     <label><%= cliente.getId_provincia().getNombre_provincia() %></label>
             <br> 
                        <select name="province" name="province"> <!--onchange="habilitarLocalidades()"-->
                            <% ArrayList <Provincia> provincias = (ArrayList <Provincia>)request.getAttribute("listaProvincias");
                        		if (provincias != null){
                        			for(Provincia provincia : provincias) { %>
                        				<option value="<%=provincia.getId()%>"><%=provincia.getNombre_provincia()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
		    <br>
		    <label for="locality">Localidad: </label>
		    <label><%= cliente.getId_localidades().getNombre_localidad() %></label>
                        <br> 
                        <select name="locality" name="locality"> <!--disabled-->
                            <% ArrayList <Localidad> localidades = (ArrayList <Localidad>)request.getAttribute("listaLocalidades");
                        		if (localidades != null){
                        			for(Localidad localidad : localidades) { %>
                        				<!--<option value="">Selecciona una provincia primero</option>-->
                        				<option value="<%=localidad.getId()%>"><%=localidad.getNombre_localidad()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
		    <br>
		    <label for="idCUIL">CUIL:</label>
		    <input type="text" name="idCUIL" value="<%= cliente.getCUIL() %>" required>
		    <br>
		    <label for="fechaNac">Fecha de nacimiento:</label>
			<label id="fechaNac"><%= cliente.getFecha_nacimiento() %></label>
		    <br>
			<label for="direc">Dirección:</label>
		    <input type="text" name="direc" value="<%= cliente.getDireccion() %>" required>
		    <br>
		    <label for="correo">Correo electrónico:</label>
		    <input type="text" name="correo" value="<%= cliente.getCorreo_electronico() %>" required>
		    <br>
		    <label for="telPrimario">Teléfono primario:</label>
		    <input type="text" name="telPrimario" value="<%= cliente.getTelefono_primario() %>" required>
		    <br>
		    <label for="telSec">Teléfono secundario:</label>
		    <input type="text" name="telSec" value="<%= cliente.getTelefono_secundario() %>" required>
		    <br>
		    <!--<label for="estado">Estado:</label>
		    <input type="checkbox" name="estado" <% if (cliente.isEstado()) out.print("checked"); %> value="true" required> Activo
		    <br>-->
		    <input type="submit" name="btnGuardar" value="Guardar cambios"> 
		    <% } %>
        </form>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
	</body>
</html>