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
	    <link rel="stylesheet" type="text/css" href="Recursos/css/mainAdmin.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/altaCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
  			<symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
    			<path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  			</symbol>
			<symbol id="check-circle-fill" viewBox="0 0 16 16">
			    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
			</symbol>
		</svg>
	    <title>Globank | Agregar Cliente</title>
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
            <form action="ServletAltaCliente" method="post">
                <p class="details"> Ingrese un nuevo cliente al sistema:</p>
                <%	Boolean insert = (Boolean)request.getAttribute("insert");
	            String formSubmitted = request.getParameter("buttonSubmit");
					
				if (formSubmitted != null) {
					if (insert != null && insert) {%>
						<div class="alert alert-success d-flex align-items-center" role="alert">
					    	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			      				<span aria-hidden="true">&times;</span>
			    			</button>
			    			<div class="d-flex align-items-center">
			      				<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Success:" width="24" height="24" viewBox="0 0 16 16">
			      					<use xlink:href="#check-circle-fill"/>
			      				</svg>
								Se agregó correctamente!
							</div>
						</div>
					<%} else if (request.getAttribute("dniRepetido") != null) { %>
							<div class="alert alert-danger d-flex align-items-center" role="alert">
				    			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				    			</button>
				    			<div class="d-flex align-items-center">
				      				<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Warning:" width="24" height="24" viewBox="0 0 16 16">
				      					<use xlink:href="#exclamation-triangle-fill"/>
				      				</svg>
				    				<%=request.getAttribute("dniRepetido")%>
				   				</div>
				  			</div>
				  	<%}else if(request.getAttribute("edad") != null) { %>
				  			<div class="alert alert-danger d-flex align-items-center" role="alert">
				    			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				    			</button>
				    			<div class="d-flex align-items-center">
				      				<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Warning:" width="24" height="24" viewBox="0 0 16 16">
				      					<use xlink:href="#exclamation-triangle-fill"/>
				      				</svg>
				    				<%= request.getAttribute("edad") %>
				   				</div>
				  			</div>
					<% } else {%>
				  			<div class="alert alert-danger d-flex align-items-center" role="alert">
			    				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			      					<span aria-hidden="true">&times;</span>
			    				</button>
			    				<div class="d-flex align-items-center">
			      					<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Warning:" width="24" height="24" viewBox="0 0 16 16">
	      								<use xlink:href="#exclamation-triangle-fill"/>
	      							</svg>
	      							Se produjo un error en la carga del cliente, corrobore los datos.
			    				</div>
			  				</div>
						<%}
				}%>
                <div class="inputs">
                    <div class="text-layout">
                        <label for="name">Nombre<span class="required-fields">*</span></label>
                        <input type="text" name="name" maxlength="40" required>
                    </div>
                    <div class="text-layout">
                        <label for="lastName">Apellido<span class="required-fields">*</span></label>
                        <input type="text" name="lastName" maxlength="40" required>
                    </div>
                    <div class="text-layout">
                        <label for="DNI">DNI<span class="required-fields">*</span></label>
                        <input type="number" name="DNI" minlength="8" maxlength="9" placeholder=" XX-XXX-XXX" required>
                    </div>
                    <div class="text-layout">
                        <label for="CUIL">CUIL<span class="required-fields">*</span></label>
                        <input type="number" name="CUIL" minlength="11" maxlength="11" placeholder=" XX-XXXXXXXX-X" required>
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
                        <input type="text" name="adress" maxlength="40" placeholder=" Caballito 123" required>
                    </div>
                    <div class="text-layout">
                        <label for="email">Correo electronico<span class="required-fields">*</span></label>
                        <input type="email" name="email" maxlength="100" placeholder=" example@example.com" required>
                    </div>
                    <div class="text-layout">
                        <label for="number1">Numero de telefono<span class="required-fields">*</span></label>
                        <input type="number" minlength="10" maxlength="10" name="number1" placeholder=" (11)XXXXXXXX" required>
                    </div>
                    <div class="text-layout">
                        <label for="number2">Numero de telefono secundario</label>
                        <input type="number" minlength="10" maxlength="10" name="number2">
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