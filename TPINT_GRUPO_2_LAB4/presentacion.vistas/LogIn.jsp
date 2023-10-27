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
        <form class="custom-form" action="">
                <p id="welcome">Bienvenido!</p>
                <p>Ingrese a tu cuenta de Globank:</p>
                <br>
                <div class="text-layout">
                    <input type="text" id="userName" placeholder=" ">
                    <label for="userName">Nombre de usuario</label>
                </div>
                <p id="examples">Ej: RamonaMartinez01</p>
                <br>
                <div class="text-layout">
                    <input type="password" id="password" placeholder=" ">
                    <label for="password">Contraseña</label>
                </div>
                <br>
                <br>
                <button type="submit" id="buttonSubmit">Ingresar</button>
         </form>
         <br>
         <footer class="footer">
                <a class="links" href="#">Terms of use</a>
                <a class="links" href="#">Privacy Policy</a>
                <p> © Globank 2023 - All rights reserved. </p>
        </footer>
    </body>
</html>