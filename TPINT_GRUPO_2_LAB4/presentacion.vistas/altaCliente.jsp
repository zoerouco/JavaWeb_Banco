<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Usuario"%>
<%@page import="entidades.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/altaCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Agregar Cliente</title>
	</head>
	<body>
	<%
	Cliente admin = new Cliente ();
	admin = (Cliente) request.getSession().getAttribute("admin_actual");
	%>
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
                            <a class="dropdown-item" href="ServletAltaCuenta">Alta de cuentas</a>
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
                        <h1> Bienvenid@, <%=admin.getNombre() %></h1> 
                    </li>
                </ul>
            </div> 
        </header>
        <div class="form-alta-cuentas">
            <form action="ServletAltaCliente" method="post">
                <p class="details"> Ingrese un nuevo cliente al sistema:</p>
                <div class="inputs">
                    <div class="text-layout">
                        <label for="name">Nombre<span class="required-fields">*</span></label>
                        <input type="text" name="name" required>
                    </div>
                    <div class="text-layout">
                        <label for="lastName">Apellido<span class="required-fields">*</span></label>
                        <input type="text" name="lastName" required>
                    </div>
                    <div class="text-layout">
                        <label for="DNI">DNI<span class="required-fields">*</span></label>
                        <input type="number" name="DNI" placeholder=" XX-XXX-XXX" required>
                    </div>
                    <div class="text-layout">
                        <label for="CUIL">CUIL<span class="required-fields">*</span></label>
                        <input type="number" name="CUIL" placeholder=" XX-XXXXXXXX-X" required>
                    </div>
                    <div class="text-layout">
                        <label for="birthdate">Fecha de nacimiento<span class="required-fields">*</span></label>
                        <input type="date" name="birthdate" required>
                    </div>
                    <div class="text-layout">
                        <label for="gender">Genero<span class="required-fields">*</span></label>
                         <select name="gender" name="gender">
                           	<% ArrayList <Genero> generos = (ArrayList <Genero>)request.getAttribute("listaGeneros");
                        		if (generos != null){
                        			for(Genero genero : generos) { %>
                        				<option value="<%=genero.getId_genero()%>"><%=genero.getDescripcion()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
                    </div>
                    <div class="text-layout">
                        <label for="nationality">Nacionalidad<span class="required-fields">*</span></label>
                        <select name="nationality" name="nationality">
                            <% ArrayList <Nacionalidad> nacionalidades = (ArrayList <Nacionalidad>)request.getAttribute("listaNacionalidades");
                           	   if (nacionalidades != null){
                        			for(Nacionalidad nacionalidad : nacionalidades) { %>
                        				<option value="<%=nacionalidad.getId()%>"><%=nacionalidad.getNombre_pais()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
                    </div>
                    <div class="text-layout">
                        <label for="adress">Direccion<span class="required-fields">*</span></label>
                        <input type="text" name="adress" placeholder=" Caballito 123" required>
                    </div>
                    <div class="text-layout">
                        <label for="email">Correo electronico<span class="required-fields">*</span></label>
                        <input type="email" name="email" placeholder=" example@example.com" required>
                    </div>
                    <div class="text-layout">
                        <label for="number1">Numero de telefono<span class="required-fields">*</span></label>
                        <input type="number" name="number1" required>
                    </div>
                    <div class="text-layout">
                        <label for="number2">Numero de telefono secundario</label>
                        <input type="number" name="number2">
                    </div>  
                    <div class="text-layout">
                        <label for="province">Provincia<span class="required-fields">*</span></label>
                        <select name="province" name="province"> <!--onchange="habilitarLocalidades()"-->
                            <% ArrayList <Provincia> provincias = (ArrayList <Provincia>)request.getAttribute("listaProvincias");
                        		if (provincias != null){
                        			for(Provincia provincia : provincias) { %>
                        				<option value="<%=provincia.getId()%>"><%=provincia.getNombre_provincia()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
                    </div>
                    <div class="text-layout">
                        <label for="locality">Localidad<span class="required-fields">*</span></label>
                        <select name="locality" name="locality"> <!--disabled-->
                            <% ArrayList <Localidad> localidades = (ArrayList <Localidad>)request.getAttribute("listaLocalidades");
                        		if (localidades != null){
                        			for(Localidad localidad : localidades) { %>
                        				<!--<option value="">Selecciona una provincia primero</option>-->
                        				<option value="<%=localidad.getId()%>"><%=localidad.getNombre_localidad()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
                    </div>
                </div>
                <h6 class="required-fields">* - Campos obligatorios.</h6>
                <input type="submit" name="buttonSubmit" value="Agregar" id="buttonSubmit"></input>
                <button type="reset" name="buttonReset" id="buttonCancel">Cancelar</button>
            </form>     
            <% Boolean insert = (Boolean)request.getAttribute("insert");
               if (insert != null && insert) {%>
            	   Se agrego correctamente!
            <%}%>
        </div>
        <!--<script type="text/javascript">
	        function habilitarLocalidades() {
	            var provinciaSelect = document.getElementById("province");
	            var localidadSelect = document.getElementById("locality");
	
	            if (provinciaSelect.value) {
	                localidadSelect.disabled = false;
	                localidadSelect.innerHTML = '';

	                var provinciaSelect = document.getElementById("province");

	                if (provinciaSelect.value) {
	                    var form = document.createElement("form");
	                    form.setAttribute("method", "post");
	                    form.setAttribute("action", "ServletAltaCliente");
	                    
	                    var methodField = document.createElement("input");
	                    methodField.setAttribute("type", "hidden");
	                    methodField.setAttribute("name", "method");
	                    methodField.setAttribute("value", "post");
	                    form.appendChild(methodField);

	                    document.body.appendChild(form);
	                    form.submit();
	                }     
	            } else {
	                localidadSelect.disabled = true;
	                localidadSelect.innerHTML = '<option value="">Selecciona una provincia primero</option>';
	            }
	        }
        </script>-->
	</body>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>