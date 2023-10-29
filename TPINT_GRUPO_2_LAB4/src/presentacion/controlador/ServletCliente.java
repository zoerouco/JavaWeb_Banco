package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Cuenta;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.PrestamoDao;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	
private static final long serialVersionUID = 1L;
ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
PrestamoDao prestamoD = new PrestamoDao();
CuentaDao cuentaD = new CuentaDao();
ClienteDao clienteD = new ClienteDao();
Cliente cliente = new Cliente();

    public ServletCliente() {
        super();
	
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
			request.setAttribute("confirmacion", 0);
		
		
			if(request.getParameter("btnSolicitarPositivo") != null) {
				
				String DNIClienteActual = request.getParameter("clienteActual");
				cliente = clienteD.getClientexDNI(DNIClienteActual);
				cuentas = cuentaD.getCuentasXDNI(cliente);
				request.setAttribute("confirmacion", 1);
			}
			
		
		

	    RequestDispatcher rd = request.getRequestDispatcher("/prestamosCliente.jsp");
        rd.forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
	
			
			String DNIClienteActual = request.getParameter("clienteActual");
			cliente = clienteD.getClientexDNI(DNIClienteActual);
			cuentas = cuentaD.getCuentasXDNI(cliente);
			request.setAttribute("listaCuentas", cuentas);
		
	
	    RequestDispatcher rd = request.getRequestDispatcher("/prestamosCliente.jsp");
        rd.forward(request, response);
       
		

}
	}

