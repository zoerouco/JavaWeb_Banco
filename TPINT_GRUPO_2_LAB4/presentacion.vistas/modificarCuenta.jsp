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
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
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
  <form action="ServletModificarCuenta" method="post">
         <label for="CBU"> Buscar cuenta por CBU:<span class="required-fields"></span></label>
        	<input type="text" name="CBU" id="CBU" placeholder=" " >
        	<input type="submit" name="btnBuscarCBU" value="Aceptar" style="margin-top: 200px">       	
	  <%
	  Cuenta cuenta = (Cuenta) request.getAttribute("cuentaCBU");
	  
		if (cuenta != null) { %>
        	<br>
        	<br>
		    <label>CBU:</label>
		    <label name="cbu-cliente"> <%= cuenta.getCBU() %></label>
		    <br>
		    <label>Nro de cuenta:</label>
		    <label><%= cuenta.getNro_cuenta() %></label>
		    <br>
		    <label>DNI:</label>
			<label><%= cuenta.getDNI().getDNI() %></label>
		     <br>		   
		    <label>Saldo:</label>
		    <label><%= cuenta.getSaldo() %></label>
		   <input type="number"  required name="Saldo" min="1000"
					max="100000000" step="1000"></input>
		     <br>		   
		    <label for="IdTipo">IdTipo:</label>
		    <label> <%= cuenta.getId_tipo().getId_tipo() %></label>
		    <br>
		    <br>		   
		    <label>Estado:</label>
		    <% if(cuenta.getEstado()){
		    	%>
		    	  <label> ACTIVA </label>
		   <%}else{ %> 
		 		 <label> INACTIVA </label>
		 		 <%} %>
		    <br>
		    <input type="submit" name="btnGuardar" value="Guardar cambios"> 
		    
        SE MODIFICO CORRECTAMENTE
      
		<%} %>
        </form>
     
</body>
</html>