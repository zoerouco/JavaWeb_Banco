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
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/altaCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Agregar Cuenta</title>
	</head>
<body>
<%
	
	Usuario admin = new Usuario ();
	admin = (Usuario) request.getSession().getAttribute("admin_actual"); 
	
	%>
    <header class="encabezado">
            <div class="contenedor-menu">
	        <a href="menuAdmins.jsp">
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
                            <a class="dropdown-item" href="#">Modificar Cuentas</a>
                            <a class="dropdown-item" href="ServletListarCuenta">Listar Cuentas</a>
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
                        <h1> Bienvenid@, <%= admin.getNombreUsuario() %></h1> 
                    </li>
                </ul>
            </div> 
        </header> 
        <% ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas"); %>
          <div class="container-table"  id="table-cuentas" style="margin-top: 150px">
	    	<h1> CUENTAS </h1>
	        <table class="table">
	        <thead>
	            <tr>
	            	<th scope="col">CBU</th>
		        	<th scope="col">ID TIPO</th>
		        	<th scope="col">DNI</th>
		        	<th scope="col">FECHA DE CREACION</th>
		        	<th scope="col">NRO. DE CUENTA</th>
		        	<th scope="col">SALDO</th>
		        	<th scope="col">ESTADO</th>		       
	            </tr>
	        </thead>
	        <tbody>
	         <% if(cuentas != null) {
		        		for(Cuenta cuenta: cuentas) { %>
				        	<tr>
				        		<th scope="row"><%=cuenta.getCBU()%></th>
				        		<td><%=cuenta.getId_tipo()%></td>
				        		<td><%=cuenta.getDNI()%></td>
				        		<td><%=cuenta.getFecha_creacion()%></td>
				        		<td><%=cuenta.getNro_cuenta()%></td>
				        		<td><%=cuenta.getSaldo()%></td>
				        		<td><%=cuenta.getEstado()%></td>				        		
				        	</tr>
		        	 <%}
		        }%>
	        </tbody>
	    </table>
        
        
        
</body>
</html>