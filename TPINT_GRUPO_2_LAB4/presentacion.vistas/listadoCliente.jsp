<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Listado Clientes</title>
	</head>
	<body>
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
                            <a class="dropdown-item" href="altaCuenta.jsp">Alta de cuentas</a>
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
                        <h1> Bienvenido, x</h1> 
                    </li>
                </ul>
            </div> 
        </header>
        <% ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("listaClientes");%>
        <div class="container-table"  id="table-usuarios" style="margin-top: 150px">
	    	<h1> CLIENTES </h1>
	        <table class="table">
	        <thead>
	            <tr>
	            	<th scope="col">DNI</th>
		        	<th scope="col">Nombre</th>
		        	<th scope="col">Apellido</th>
		        	<th scope="col">Genero</th>
		        	<th scope="col">Nacionalidad</th>
		        	<th scope="col">CUIL</th>
		        	<th scope="col">Fecha de nacimiento</th>
		        	<th scope="col">Direccion</th>
		        	<th scope="col">Correo electronico</th>
		        	<th scope="col">Provincia</th>
		        	<th scope="col">Localidad</th> 
		        	<th scope="col">Telefono primario</th>
		        	<th scope="col">Telefono secundario</th>
	            </tr>
	        </thead>
	        <tbody>
	         <% if(clientes != null) {
		        		for(Cliente cliente: clientes) { %>
				        	<tr>
				        		<th scope="row"><%=cliente.getDNI()%></th>
				        		<td><%=cliente.getNombre()%></td>
				        		<td><%=cliente.getApellido()%></td>
				        		<td><%=cliente.getId_genero().getDescripcion()%></td>
				        		<td><%=cliente.getId_nacionalidad().getNombre_pais()%></td>
				        		<td><%=cliente.getCUIL()%></td>
				        		<td><%=cliente.getFecha_nacimiento()%></td>
				        		<td><%=cliente.getDireccion()%></td>
				        		<td><%=cliente.getCorreo_electronico()%></td>
				        		<td><%=cliente.getId_provincia().getNombre_provincia()%></td>
				        		<td><%=cliente.getId_localidades().getNombre_localidad()%></td>
				        		<td><%=cliente.getTelefono_primario()%></td>
				        		<td><%=cliente.getTelefono_secundario()%></td>
				        	</tr>
		        	 <%}
		        }%>
	        </tbody>
	    </table>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
	</body>
</html>