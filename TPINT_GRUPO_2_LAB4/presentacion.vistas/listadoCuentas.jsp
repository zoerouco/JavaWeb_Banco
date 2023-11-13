<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<%@ page import="entidades.Cuenta"%>
<%@page import="entidades.Tipo_cuenta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="Recursos/css/mainAdmin.css">
	<link rel="stylesheet" type="text/css" href="Recursos/css/eliminarCliente.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	<title>Globank | Listado Cuentas</title>
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
        <% ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas"); %>
		<%
		    int itemsPerPage = 3; 
		    int totalPages = (int) Math.ceil((double) cuentas.size() / itemsPerPage);
		    int currentPage = 1;
		
		    if (request.getParameter("page") != null) {
		        currentPage = Integer.parseInt(request.getParameter("page"));
		    }
		
		    int startIndex = (currentPage - 1) * itemsPerPage;
		    int endIndex = Math.min(startIndex + itemsPerPage, cuentas.size());
		%>
		
        <div class="container-table"  id="table-usuarios" style="margin-top: 150px">
	    	<h2> Cuentas: </h2>
	    	<form action="ServletListarCuenta" method="post">
	    	<div class="d-flex justify-content-center mb-3">
			    	<div class="btn-group" role="group" aria-label="Basic mixed styles example">
			    		<button type="submit" class="btn btn-success" name="activos">Solo activos</button>
					  	<button type="submit" class="btn btn-warning" name="todos">Todos los clientes</button>
					  	<button type="submit" class="btn btn-danger" name="inactivos">Solo inactivos</button>
					</div>
				</div>
	        <table class="table">
	        <thead>
	            <tr>
	            	<th scope="col" class="table-header">CBU</th>
		        	<th scope="col" class="table-header">ID TIPO</th>
		        	<th scope="col" class="table-header">DNI</th>
		        	<th scope="col" class="table-header">FECHA DE CREACION</th>
		        	<th scope="col" class="table-header">NRO. DE CUENTA</th>
		        	<th scope="col" class="table-header">SALDO</th>
		        	<th scope="col" class="table-header">ESTADO</th>		       
	            </tr>
	        </thead>
	        <tbody>
               <%
                   for (int i = startIndex; i < endIndex; i++) {
                     Cuenta cuenta= cuentas.get(i);
                 %>
                  <tr>
                  		<th scope="row"><%=cuenta.getCBU()%></th>
				        <td><%=cuenta.getId_tipo().getDescripcion()%></td>
				        <td><%=cuenta.getDNI().getDNI()%></td>
				        <td><%=cuenta.getFecha_creacion()%></td>
				        <td><%=cuenta.getNro_cuenta()%></td>
				        <td><%=cuenta.getSaldo()%></td>
				        <td><%=cuenta.getEstado()%></td>	
					                
                 </tr>
               <%
                                }
                            
                %>
	        </tbody>
	    </table>
		<nav aria-label="...">
		  <ul class="pagination pagination-lg">
		    <%
		      for (int i = 1; i <= totalPages; i++) {
		        if (i == currentPage) {
		    %>
		          <li class="page-item active"><a class="page-link" href="#"><%= i %></a></li>
		    <%
		        } else {
		    %>
		          <li class="page-item"><a class="page-link" href="ServletListarCuenta?page=<%= i %>"><%= i %></a></li>
		    <%
		        }
		      }
		    %>
		  </ul>
		</nav>
	</form>
</div>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
	
</body>
</html>