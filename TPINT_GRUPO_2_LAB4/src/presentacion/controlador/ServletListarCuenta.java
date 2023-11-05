package presentacion.controlador;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import entidades.Usuario;

@WebServlet("/ServletListarCuenta")
public class ServletListarCuenta extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	
	CuentaDaoImpl cneg = new CuentaDaoImpl();
	
    public ServletListarCuenta() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.setAttribute("admin_actual", usuario);
		
		ArrayList<Cuenta> listaCuentas = cneg.readAllActivos();
		request.setAttribute("listaCuentas", listaCuentas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCuentas.jsp");   
	    rd.forward(request, response);
	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.setAttribute("admin_actual", usuario);
		 
		ArrayList<Cuenta> listaCuentas = cneg.readAllActivos();
		request.setAttribute("listaCuentas", listaCuentas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCuentas.jsp");   
	    rd.forward(request, response);
	}
}
