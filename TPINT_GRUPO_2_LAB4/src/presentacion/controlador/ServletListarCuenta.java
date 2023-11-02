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
import entidades.Cliente;
import entidades.Cuenta;
import negocioImpl.ClienteNegocioImpl;

@WebServlet("/ServletListarCuenta")
public class ServletListarCuenta extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	CuentaDaoImpl cneg = new CuentaDaoImpl();
	
    public ServletListarCuenta() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cuenta> listaCuentas = cneg.readAll();
		request.setAttribute("listaCuentas", listaCuentas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadocuenta.jsp");   
	    rd.forward(request, response);
	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cuenta> listaCuentas = cneg.readAll();
		request.setAttribute("listaCuentas", listaCuentas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCliente.jsp");   
	    rd.forward(request, response);
	}
}
