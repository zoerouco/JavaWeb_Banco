<%@page import="java.util.ArrayList"%>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<%@ page import="entidades.Cuenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
    <link rel="stylesheet" type="text/css" href="Recursos/css/styleAdmin.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
    <title>Globank | Menu Administradores</title>
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
                <h1>Bienvenid@, <%= admin.getNombreUsuario() %></h1>
            	</li>
            </ul>
        </div> 
    </header>
   	<form action="ServletModificarCuenta" method="post">
	        <label for="CBU"> Buscar cuenta por CBU:<span class="required-fields"></span></label>
	        <input type="text" name="CBU" id="CBU" placeholder=" " required>
	       	<input type="submit" name="btnBuscarCBU" value="Aceptar" style="margin-top: 200px">  
      </form>  
      <form action="ServletModificarCuenta" method="post">   	
	  <%
	  Cuenta cuenta = (Cuenta) request.getAttribute("cuentaCBU");
	  
		if (cuenta != null) { %>
        	<br>
        	<br>
		    <label>CBU:</label>
		    <!--<label> <%=cuenta.getCBU() %></label>-->
		    <input name ="cbuActual" type="hidden" value="<%= cuenta.getCBU() %>"></input>
		    <label name="cbu-cliente"> <%= cuenta.getCBU() %></label>
		    <br>
		    <label>Nro de cuenta:</label>
		    <label> <%= cuenta.getNro_cuenta() %></label>
		    <br>
		    <label>DNI:</label>
			<label><%= cuenta.getDNI().getDNI() %></label>
		     <br>		   
		    <label>Saldo:</label>
		    <label><%= cuenta.getSaldo() %></label>
		   <input type="number"  required name="Saldo" min="1000"
					max="100000000" step="1000" required></input>
		     <br>		   
		    <label for="IdTipo">IdTipo:</label>
		    <label> <%= cuenta.getId_tipo().getDescripcion() %></label>
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
		    <button type="reset" name="buttonReset" id="buttonCancel">Cancelar</button> 		         
      
		<%} %>
        </form>
        <%if(request.getAttribute("update") != null) { %>
        	<p>La cuenta se ha modificado correctamente.</p>
        <%} %>
     
     
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
</body>
</html>