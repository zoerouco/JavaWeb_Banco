package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Genero;
import negocioImpl.CuentaNegocioImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ClienteDaoImpl;
import daoImpl.CuentaDaoImpl;
import daoImpl.PrestamoDaoImpl;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	
	//solo deberian haber llamados al negocio (y en negocio al dao)
	PrestamoDaoImpl prestamoD = new PrestamoDaoImpl();
	CuentaDaoImpl cuentaD = new CuentaDaoImpl();
	ClienteDaoImpl clienteD = new ClienteDaoImpl();

    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnMenuPrestamo") != null) {
					
			String DNIClienteActual = request.getParameter("clienteActual");
			cliente = clienteD.getClientexDNI(DNIClienteActual); //con el obj bien cargado en el dao se puede hacer el readAll()
																 //como cambie abajo con cuentas
			cuentas = cuentaN.readAll(); //usando negocio
			
			request.setAttribute("listaCuentas", cuentas);
			
			String url = "/prestamosCliente.jsp";
			request.setAttribute("miUrl", url);
			request.getRequestDispatcher(url).forward(request, response);
					
		}
		
	    RequestDispatcher rd = request.getRequestDispatcher("/prestamosCliente.jsp");
	    
        rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnMenuPrestamo") != null) {
			String DNIClienteActual = request.getParameter("clienteActual");
			cliente = clienteD.getClientexDNI(DNIClienteActual);//con el obj bien cargado en el dao se puede hacer el readAll()
			 													//como cambie abajo con cuentas
			cuentas = cuentaN.readAll(); //usando negocio
			request.setAttribute("listaCuentas", cuentas);
		}
	
	    RequestDispatcher rd = request.getRequestDispatcher("/prestamosCliente.jsp");
        rd.forward(request, response);
	}
}