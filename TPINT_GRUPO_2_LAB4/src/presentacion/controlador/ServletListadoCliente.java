package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocioImpl.ClienteNegocioImpl;

@WebServlet("/ServletListadoCliente")
public class ServletListadoCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ClienteNegocioImpl cneg = new ClienteNegocioImpl();
	
    public ServletListadoCliente() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cliente> listaClientes = cneg.readAll();
		request.setAttribute("listaClientes", listaClientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCliente.jsp");   
	    rd.forward(request, response);
	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cliente> listaClientes = cneg.readAll();
		request.setAttribute("listaClientes", listaClientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCliente.jsp");   
	    rd.forward(request, response);
	}
}
