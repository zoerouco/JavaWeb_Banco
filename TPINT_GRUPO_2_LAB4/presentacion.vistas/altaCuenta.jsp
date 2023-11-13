<%@page import="negocioImpl.CuentaNegocioImpl"%>
<%@page import="entidades.Tipo_cuenta"%>
<%@page import="daoImpl.Tipo_cuentaDaoImpl"%>
<%@page import="negocioImpl.ClienteNegocioImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<%@ page import="entidades.Cuenta"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/mainAdmin.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/altaCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Agregar Cuenta</title>
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
                        <h1> Bienvenid@, <%= admin.getNombreUsuario() %></h1> 
                    </li>
                </ul>
            </div> 
        </header>
        
        <div class="form-alta-cuentas">
        
            <form action="ServletAltaCuenta" method="get">
            
                <p class="details">Asignar cuenta a un cliente:</p>
                <div class="inputs">
                    <div class="text-layout">
                        <label for="CBUe">CBU<span class="required-fields">*</span></label>
                        <input type="text" name="txtCbu" minlength="22" maxlength="22" id="CBU" required>
                    </div>
                    
                    <div class="text-layout">
                        <label for="DNI">DNI<span class="required-fields">*</span></label>
                        <input type="number" minlength="7" maxlength="9" id="DNI" placeholder=" XX-XXX-XXX" name="txtDni" required>
                    </div>
                    
                    <div class="text-layout">
                        <label for="T-Cuenta">Tipo de Cuenta<span class="required-fields">*</span></label>
                        <select name="txtTipo" id="T-Cuenta">
						<% ArrayList <Tipo_cuenta> tCuentas = (ArrayList <Tipo_cuenta>)request.getAttribute("listatCuentas");
                           	   if (tCuentas != null){
                        			for(Tipo_cuenta tcuenta : tCuentas) { %>
                        				<option value="<%= tcuenta.getId_tipo()%>"><%=tcuenta.getDescripcion()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
                    </div>

                    <div class="text-layout">
                        <label for="adress">Numero de Cuenta<span class="required-fields">*</span></label>
                        <input type="text" name="txtNroCuenta" id="adress" placeholder=" 123454" required>
                    </div>

                </div>
                <h6 class="required-fields">* - Campos obligatorios.</h6>
                <input type="submit" name="btnAceptar" value="Agregar" id="buttonSubmit"></input>
                <button type="button" id="buttonCancel" onclick="window.location.href='ServletMenuAdmin';">Cancelar</button>
                
                
            </form>
            <%
			Boolean insert = (Boolean) request.getAttribute("insert");
			String formSubmitted = request.getParameter("btnAceptar");
				
				if (formSubmitted != null) {
				    	if (insert != null && insert) {
					%>
			    <div class="alta-cuentas-succes">
				          Se agregó correctamente.
			    </div>
				<%} else {%>
				<div class="alta-cuentas-error">
				   Se produjo un error en la carga de la cuenta, corrobore los datos.
				</div>
				<%}}%>
			
			
        </div>
	</body>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>