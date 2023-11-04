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
<title>Insert title here</title>
</head>
<body>
<header class="encabezado">
<% 	Usuario admin = new Usuario ();
        	admin = (Usuario) request.getAttribute("admin_actual");
        	Cuenta cuenta = (Cuenta) request.getAttribute("cuentaDNI");
    		if (cuenta != null) {
        	%>
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
  <form action="ServletModificarCliente" method="post">
         <label for="DNI">Buscar cuenta por DNI:<span class="required-fields"></span></label>
        	<input type="text" name="DNI" id="DNI" placeholder=" " >
        	<input type="submit" name="btnBuscarXDNI" value="Aceptar" style="margin-top: 200px">       	
        	<br>
        	<br>
		    <label for="nombre">CBU:</label>
		    <input type="text" name="cbu" value="<%= cuenta.getCBU() %>">
		    <br>
		    <label for="apellido">Nro de cuenta:</label>
		    <input type="text" name="cbu" value="<%= cuenta.getNro_cuenta() %>">
		    <br>
		    <label for="dni1">DNI:</label>
			<label><%= cuenta.getDNI() %></label>
			<input type="text" name="dn1" value="<%= cuenta.getDNI() %>" >
		     <br>		   
		    <label for="Saldo">Saldo:</label>
		    <input type="hidden" name="Saldo" value="<%= cuenta.getSaldo() %>" >
		    <br>
		     <br>		   
		    <label for="IdTipo">IdTipo:</label>
		    <input type="hidden" name="IdTipo" value="<%= cuenta.getId_tipo() %>" >
		    <br>
		    <br>		   
		    <label for="estado">Estado:</label>
		    <input type="checkbox" name="estado" <% if (cuenta.getEstado()) out.print("checked"); %> value="true"> Activo
		    <br>
		    <input type="submit" name="btnGuardar" value="Guardar cambios"> 
		    <% } %>
        </form>
</body>
</html>