<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Modificar Cuentas</title>
	</head>
	<body>
	<%
	Cliente admin = new Cliente ();
	admin = (Cliente) request.getSession().getAttribute("admin_actual");
	%>
		<header class="encabezado">
            <div class="contenedor-menu">
                <img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" />
                <h1 style="color:#ffefd5;"> GLOBANK </h1>
                <ul class="contenedor-links-menu">  
                    <li class="nav-item dropdown">
                        <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           Cuentas
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="ServletAltaCuenta">Alta de cuentas</a>
                            <a class="dropdown-item" href="#">Modificar Cuentas</a>
                            <a class="dropdown-item" href="#">Listar Cuentas</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Baja de cuentas</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           Clientes
                        </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="ServletAltaCliente">Alta de clientes</a>
                        <a class="dropdown-item" href="modificarCliente.jsp">Modificar clientes</a>
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
                            <a class="dropdown-item" href="#">Ver todos los prestamos</a>
                            <a class="dropdown-item" href="#">Modificar prestamos</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Eliminar Prestamos</a>
                        </div>
                    </li>
                    <li class="mensaje-bienvenida">
                        <h1> Bienvenid@, <%=admin.getNombre() %></h1> 
                    </li>
                </ul>
            </div> 
        </header>
        <form action="ServletModificarCliente" method="post">
         <label for="DNI">Buscar cliente por DNI:<span class="required-fields"></span></label>
        	<input type="text" name="DNI" id="DNI" placeholder=" " >
        	<input type="submit" name="btnBuscarXDNI" value="Aceptar" style="margin-top: 200px">
        	<%  Cliente cliente = (Cliente) request.getAttribute("clienteDNI");
        		if (cliente != null) {
        	%>
        	<br>
        	<br>
		    <label for="nombre">Nombre:</label>
		    <input type="text" name="nombre" value="<%= cliente.getNombre() %>">
		    <br>
		    <label for="apellido">Apellido:</label>
		    <input type="text" name="apellido" value="<%= cliente.getApellido() %>">
		    <br>
		    <label for="dni1">DNI:</label>
			<label><%= cliente.getDNI() %></label>
			<input type="hidden" name="dni1" value="<%= cliente.getDNI() %>" >
		    <br>
		    <label for="idGenero">ID genero:</label>
		    <input type="text" name="idGenero" value="<%= cliente.getId_genero().getId_genero() %>">
		    <br>
		    <label for="idNacionalidad">ID nacionalidad:</label>
		    <input type="text" name="idNacionalidad" value="<%= cliente.getId_nacionalidad().getId() %>">
		    <br>
		    <label for="idProvincia">ID provincia:</label>
		    <input type="text" name="idProvincia" value="<%= cliente.getId_provincia().getId() %>">
		    <br>
		    <label for="idLocalidad">ID localidad:</label>
		    <input type="text" name="idLocalidad" value="<%= cliente.getId_localidades().getId() %>">
		    <br>
		    <label for="idCUIL">CUIL:</label>
		    <input type="text" name="idCUIL" value="<%= cliente.getCUIL() %>">
		    <br>
		    <label for="fechaNac">Fecha de nacimiento:</label>
			<label id="fechaNac"><%= cliente.getFecha_nacimiento() %></label>
		    <br>
			<label for="direc">Dirección:</label>
		    <input type="text" name="direc" value="<%= cliente.getDireccion() %>">
		    <br>
		    <label for="correo">Correo electrónico:</label>
		    <input type="text" name="correo" value="<%= cliente.getCorreo_electronico() %>">
		    <br>
		    <label for="telPrimario">Teléfono primario:</label>
		    <input type="text" name="telPrimario" value="<%= cliente.getTelefono_primario() %>">
		    <br>
		    <label for="telSec">Teléfono secundario:</label>
		    <input type="text" name="telSec" value="<%= cliente.getTelefono_secundario() %>">
		    <br>
		    <label for="estado">Estado:</label>
		    <input type="checkbox" name="estado" <% if (cliente.isEstado()) out.print("checked"); %> value="true"> Activo
		    <br>
		    <input type="submit" name="btnGuardar" value="Guardar cambios"> 
		    <% } %>
        </form>
        
        
	</body>
</html>