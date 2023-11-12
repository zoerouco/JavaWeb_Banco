<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
		<link rel="stylesheet" type="text/css" href="Recursos/css/logIn.css">
		<title>Globank | Log In</title>
	</head>
	<body>
        <form class="custom-form" action="ServletUsuario" method="post">
                <p id="welcome">Bienvenid@!</p>
                <p>Ingrese a tu cuenta de Globank:</p>
                <br>
                <div class="text-layout">
                    <input type="text" name="userName" id="userName" placeholder=" " required>
                    <label for="userName">Nombre de usuario</label>
                </div>
                <p id="examples">Ej: RamonaMartinez01</p>
                <br>
                <div class="text-layout">
                    <input type="password" name="password" id="password" placeholder=" " required>
                    <label for="password">Contraseña</label>
                </div>
                <button type="submit" name=buttonSubmit value="Ingresar" id="buttonSubmit">Ingresar</button>
                <div class="error-message">
    				<%= (request.getAttribute("errorMessage") != null) ? request.getAttribute("errorMessage") : "" %>
				</div>             
         </form>
         <br>
         <footer class="footer">
                <a class="links" href="#">Terms of use</a>
                <a class="links" href="#">Privacy Policy</a>
                <p> © Globank 2023 - All rights reserved. </p>
        </footer>
    </body>
</html>