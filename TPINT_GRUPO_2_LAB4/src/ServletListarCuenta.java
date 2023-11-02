


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

@WebServlet("/ServletListarCuenta")
public class ServletListarCuenta extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	CuentaDaoImpl cneg = new CuentaDaoImpl();
	
    public ServletListarCuenta() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cuenta> listaClientes = cneg.readAll();
		request.setAttribute("listaClientes", listaClientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadocuentas.jsp");   
	    rd.forward(request, response);
	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cuenta> listaClientes = cneg.readAll();
		request.setAttribute("listaClientes", listaClientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadocuentas.jsp");   
	    rd.forward(request, response);
	}
}
