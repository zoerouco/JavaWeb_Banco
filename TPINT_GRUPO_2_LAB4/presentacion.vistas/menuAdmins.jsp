
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
    <header class="encabezado">
        <div class="contenedor-menu">
           <a href="menuAdmins.jsp">
           <img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" /> 
           </a> 
            <h1 style="color:#ffefd5;"> GLOBANK </h1>
            <ul class="contenedor-links-menu">  

                <li class="nav-item dropdown">
                    <a class= "nav-link dropdown-toggle links-menu" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Cuentas ABML
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="altaCuenta.jsp">Alta de cuentas</a>
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
    <div class="container-table"  id="table-usuarios">
    <h1> CLIENTES </h1>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Nro Usuario</th>
                <th scope="col">CBU </th>
                <th scope="col">ID cuenta</th>
                <th scope="col">ID Usuario</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td>533332213234565</td>
                <td>1</td>
                <td>3</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>533332213234568</td>
                <td>2</td>
                <td>3</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>533332213234565</td>
                <td>3</td>
                <td>3</td>
            </tr>
        </tbody>
    </table>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
