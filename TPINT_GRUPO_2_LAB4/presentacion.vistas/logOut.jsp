<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.ServletException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
    // Invalidar la sesión actual al hacer logout
    HttpSession currentSession = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }

    // Redirigir a la página de login después del logout
    response.sendRedirect("logIn.jsp");
%>

</body>
</html>