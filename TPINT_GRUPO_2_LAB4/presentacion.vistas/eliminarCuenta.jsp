
<%@page import="java.util.ArrayList"%>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<%@ page import="entidades.Cuenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/mainAdmin.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/eliminarCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Eliminar Cuenta</title>
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
              		<li>
               		<a class="btn btn-danger" href="logOut.jsp" role="button" >LogOut</a>
            		</li>                    
                    <li class="mensaje-bienvenida">
                        <h1> Bienvenid@, <%=admin.getNombreUsuario() %></h1>
                    </li>
                </ul>
            </div> 
        </header>
        <% ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas");%>
        <div class="container-table"  id="table-usuarios" style="margin-top: 150px">
	    	<h2> Cuentas: </h2>
	        <table class="table">
	        <thead>
	            <tr>
	            	<th scope="col" class="table-header">CBU</th>
	            	<th scope="col" class="table-header">Nro Cuenta</th>
	            	<th scope="col" class="table-header">Tipo Cuenta</th>
	            	<th scope="col" class="table-header">DNI</th>
	            	<th scope="col" class="table-header">Saldo Cuenta</th>
	            	<th scope="col" class="table-header"></th>
	            </tr>
	        </thead>
	        <tbody>
	         <% if(cuentas != null) {
	        	 	int cont = 0;
		        	for(Cuenta cuenta: cuentas) { 
		        		cont++;
		        		String rowClass = (cont % 2 == 0) ? "table-row-even" : "table-row-odd"; %>
				        <tr class="<%=rowClass%>">
				        	<form action="ServletEliminarCuenta" method="get">
				        		
				        		<th scope="row"><%=cuenta.getCBU()%> <input type="hidden" name="CBU" value="<%=cuenta.getCBU()%>"></th>
				        		<td><%=cuenta.getNro_cuenta()%></td>
				        		<td><%=cuenta.getId_tipo().getDescripcion()%></td>
				        		<td><%=cuenta.getDNI().getDNI()%></td>				        		
				        		<td><%=cuenta.getSaldo()%></td>
				        		<td><input type="submit" name="buttonEliminar" value="Eliminar" id="button"></td>
				        		<div>
			                        <% if (request.getAttribute("confirm" + cuenta.getCBU()) != null) { %>
			                            <p class="confirm-message"><%= request.getAttribute("confirm" + cuenta.getCBU()) %>
				                            <form action="ServletEliminarCuenta" method="get">
				                                <input type="hidden" name="CBU" value="<%=cuenta.getCBU()%>">
				                                <input type="submit" name="confirmEliminar" id="buttonSubmit" value="Eliminar">
				                                <input type="submit" name="buttonCancelar" id="button" value="Cancelar">
				                            </form>
			                            </p>
			                        <% } %>
			                    </div>
				       		</form>
				   		</tr>
				  <%}
		    }%>
	        </tbody>
	    </table>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	<script>
	    document.addEventListener("DOMContentLoaded", function () {
	    	var cancelButton = row.querySelector(".buttonCancelar");
	
	        if (cancelButton) {
	        	cancelButton.addEventListener("click", function () {
	            	buttonsInRow.forEach(function (btn) {
	            		btn.disabled = false;
	            	});
	        	});
	        }
	    });
	</script>
	
	</body>
</html>