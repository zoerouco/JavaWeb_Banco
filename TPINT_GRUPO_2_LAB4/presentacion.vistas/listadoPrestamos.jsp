<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cliente" %>
<%@ page import="entidades.Usuario"%>
<%@ page import="entidades.Prestamo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/eliminarCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Listado Clientes</title>
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
                            <a class="dropdown-item" href="#">Gestionar prestamos</a>
                        </div>
                    </li>
                    <li class="mensaje-bienvenida">
                        <h1> Bienvenid@, <%=admin.getNombreUsuario() %></h1> 
                    </li>
                </ul>
            </div> 
        </header>
        <% ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>)request.getAttribute("listaPrestamos");%>
        <div class="container-table"  id="table-usuarios" style="margin-top: 150px">
	    	<h2> Prestamos: </h2>
	    	<form action="ServletListarPrestamos" method="post">
		    	<div class="d-flex justify-content-center mb-3">
			    	<div class="btn-group" role="group" aria-label="Basic mixed styles example">
			    		<button type="submit" class="btn btn-success" name="aceptado">Aceptados</button>
					  	<button type="submit" class="btn btn-warning" name="solicitado">Solicitados</button>
					  	<button type="submit" class="btn btn-danger" name="rechazado">Rechazados</button>
					</div>
				</div>
		        <table class="table">
		        <thead>
		            <tr>
		            	<th scope="col" class="table-header">ID</th>
			        	<th scope="col" class="table-header">CBU</th>
			        	<th scope="col" class="table-header">Fecha de realización</th>
			        	<th scope="col" class="table-header">Importe pedido</th>
			        	<th scope="col" class="table-header">Importe con intereses</th>
			        	<th scope="col" class="table-header">Monto por mes</th>
			        	<th scope="col" class="table-header">Cantidad de cuotas</th>
			        	<th scope="col" class="table-header">Estado</th>
		            </tr>
		        </thead>
		        <tbody>
		         <% if(prestamos != null) {
		        	 int cont = 0;
			        	for(Prestamo prestamo: prestamos) { 
			        		cont++;
			        		String rowClass = (cont % 2 == 0) ? "table-row-even" : "table-row-odd"; %>
					        	<tr class="<%=rowClass%>">
					        		<th scope="row"><%=prestamo.getId_prestamo()%></th>
					        		<td><%=prestamo.getCBU().getCBU()%></td>
					        		<td><%=prestamo.getFecha_realizacion()%></td>
					        		<td><%=prestamo.getImporte_pedido()%></td>
					        		<td><%=prestamo.getImporte_con_intereses()%></td>
					        		<td><%=prestamo.getMonto_x_mes()%></td>
					        		<td><%=prestamo.getCant_cuotas()%></td>
					        		<td><%=prestamo.getEstado()%></td>
							 	</tr>
			        	 <%}
			        }%>
		        </tbody>
		    </table>
		</form>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
	</body>
</html>