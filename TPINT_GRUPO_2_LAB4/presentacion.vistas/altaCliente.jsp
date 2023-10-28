<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
	    <link rel="stylesheet" type="text/css" href="Recursos/css/altaCliente.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
	    <title>Globank | Agregar cuenta</title>
	</head>
	<body>
        <header class="encabezado">
            <div class="contenedor-menu">
                <img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" />
                <h1 style="color:#ffefd5;"> GLOBANK </h1>
                <ul class="contenedor-links-menu">  
                    <li class="nav-item dropdown">
                        <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           Cuentas ABML
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Alta de cuentas</a>
                            <a class="dropdown-item" href="#">Baja de cuentas</a>
                            <a class="dropdown-item" href="#">Modificar Cuentas</a>
                            <a class="dropdown-item" href="#">Listar Cuentas</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           Clientes ABML
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="altaCliente.jsp">Alta de clientes</a>
                            <a class="dropdown-item" href="#">Baja de clientes</a>
                            <a class="dropdown-item" href="#">Modificar clientes</a>
                            <a class="dropdown-item" href="#">Listar clientes</a>
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
                        <h1> Bienvenido, x</h1> 
                    </li>
                </ul>
            </div> 
        </header>
        <!--<h1 id="titulo">Alta de clientes</h1>-->
        <div class="form-alta-cuentas">
            <form action="ServletCliente" method="get">
                <p class="details"> Ingrese un nuevo cliente al sistema:</p>
                <div class="inputs">
                    <div class="text-layout">
                        <label for="name">Nombre<span class="required-fields">*</span></label>
                        <input type="text" id="name" required>
                    </div>
                    <div class="text-layout">
                        <label for="lastName">Apellido<span class="required-fields">*</span></label>
                        <input type="text" id="lastName" required>
                    </div>
                    <div class="text-layout">
                        <label for="DNI">DNI<span class="required-fields">*</span></label>
                        <input type="number" id="DNI" placeholder=" XX-XXX-XXX" required>
                    </div>
                    <div class="text-layout">
                        <label for="CUIL">CUIL<span class="required-fields">*</span></label>
                        <input type="number" id="CUIL" placeholder=" XX-XXXXXXXX-X" required>
                    </div>
                    <div class="text-layout">
                        <label for="birthdate">Fecha de nacimiento<span class="required-fields">*</span></label>
                        <input type="date" id="birthdate" required>
                    </div>
                    <div class="text-layout">
                        <label for="gender">Genero<span class="required-fields">*</span></label>
                        <select name="gender" id="gender">
                            <option value="M">Mujer</option>
                        </select>
                    </div>
                    <div class="text-layout">
                        <label for="nationality">Nacionalidad<span class="required-fields">*</span></label>
                        <select name="nationality" id="nationality">
                            <option value="ARG">Argentina</option>
                        </select>
                    </div>
                    <div class="text-layout">
                        <label for="adress">Direccion<span class="required-fields">*</span></label>
                        <input type="text" id="adress" placeholder=" Caballito 123" required>
                    </div>
                    <div class="text-layout">
                        <label for="email">Correo electronico<span class="required-fields">*</span></label>
                        <input type="email" id="email" placeholder=" example@example.com" required>
                    </div>
                    <div class="text-layout">
                        <label for="number1">Numero de telefono<span class="required-fields">*</span></label>
                        <input type="number" id="number1" required>
                    </div>
                    <div class="text-layout">
                        <label for="number2">Numero de telefono secundario</label>
                        <input type="number" id="number2">
                    </div>
                    <div class="text-layout">
                        <label for="province">Provincia<span class="required-fields">*</span></label>
                        <select name="province" id="province">
                            <option value="1">Buenos Aires</option>
                        </select>
                    </div>
                    <div class="text-layout">
                        <label for="locality">Localidad<span class="required-fields">*</span></label>
                        <select name="locality" id="locality">
                            <option value="2">Tigre</option>
                        </select>
                    </div>
                </div>
                <h6 class="required-fields">* - Campos obligatorios.</h6>
                <button type="submit" id="buttonSubmit">Agregar</button>
                <button type="reset" id="buttonCancel">Cancelar</button>
            </form>
        </div>
	</body>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>