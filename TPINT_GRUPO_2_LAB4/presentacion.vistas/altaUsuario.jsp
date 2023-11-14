<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> 
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/mainAdmin.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/altaCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
  			<symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
    			<path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  			</symbol>
		</svg>
	    <title>Globank | Agregar Usuario</title>
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
        <div class="form-alta-cuentas">
            <form action="ServletAltaUsuario" method="post">
                <p class="details"> Asignacion de un cliente a un usuario:</p>
                <%Usuario nuevoUsuario = (Usuario) request.getAttribute("nuevoUsuario");
                	if(request.getAttribute("passError") != null) {%>
                		<div class="alert alert-danger d-flex align-items-center" role="alert">
				    		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    			<span aria-hidden="true">&times;</span>
				    		</button>
				    		<div class="d-flex align-items-center">
				      			<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Warning:" width="24" height="24" viewBox="0 0 16 16">
				      				<use xlink:href="#exclamation-triangle-fill"/>
				      			</svg>
				    			<%=request.getAttribute("passError")%>
				   			</div>
				  		</div>
                	<%}%>
                <div class="inputs">
                    <div class="text-layout">
                        <label for="name">Nombre de usuario:</label>
                        <label style="font-weight: bold;"><%= nuevoUsuario.getNombreUsuario() %></label>
                    </div>
                 	<div class="text-layout">
                 		<label for="password">Contraseña</label>
	                   <input type="password" name="password1" id="password1" maxlength="20" required>
                	</div>
                	<div class="text-layout">
                 		<label for="password">Confirmar contraseña</label>
	                   <input type="password" name="password2" id="password2" maxlength="20" required>
                	</div>
                </div>
                <input type="submit" name="buttonAgregar" value="Agregar" id="buttonSubmit"></input>
            </form>     
        </div>
	</body>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>