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
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;

@WebServlet("/ServletListadoCliente")
public class ServletListadoCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	
	ClienteNegocioImpl cneg = new ClienteNegocioImpl();
	
    public ServletListadoCliente() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		String estado = request.getParameter("estado");
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		listaClientes = cneg.readAll();
		
		if(request.getParameter("btnBuscarXDNI") != null && !request.getParameter("btnBuscarXDNI").isEmpty()) {
			String errorMessage= "";
			
			if (request.getParameter("btnBuscarXDNI") != null && !request.getParameter("btnBuscarXDNI").isEmpty()) {
				if(request.getParameter("DNI") != null && !request.getParameter("DNI").isEmpty()) {
					String dni = request.getParameter("DNI"); 
					listaClientes = cneg.getClientexDNILike(dni);
				} else {
					errorMessage="El DNI ingresado no existe";
					request.setAttribute("errorMessage", errorMessage);
				}
			}
		}
		
		if (estado != null && !estado.isEmpty()) {
			if(estado.equalsIgnoreCase("todos")) {
				listaClientes = cneg.readAll();
			} else if(estado.equalsIgnoreCase("activos")) {
				listaClientes = cneg.readAllActivos();
			} else if(estado.equalsIgnoreCase("inactivos")) {
				listaClientes = cneg.readAllInactivos();
			}
		}

		request.setAttribute("listaClientes", listaClientes);
			
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCliente.jsp");   
	    rd.forward(request, response);
	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		String estado = request.getParameter("estado");
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		listaClientes = cneg.readAll();
		
		if(request.getParameter("btnBuscarXDNI") != null && !request.getParameter("btnBuscarXDNI").isEmpty()) {
			String errorMessage= "";
			
			if (request.getParameter("btnBuscarXDNI") != null && !request.getParameter("btnBuscarXDNI").isEmpty()) {
				if(request.getParameter("DNI") != null && !request.getParameter("DNI").isEmpty()) {
					String dni = request.getParameter("DNI"); 
					listaClientes = cneg.getClientexDNILike(dni);
				} else {
					errorMessage="El DNI ingresado no existe";
					request.setAttribute("errorMessage", errorMessage);
				}
			}
		}
		
		if (estado != null && !estado.isEmpty()) {
			if(estado.equalsIgnoreCase("todos")) {
				listaClientes = cneg.readAll();
			} else if(estado.equalsIgnoreCase("activos")) {
				listaClientes = cneg.readAllActivos();
			} else if(estado.equalsIgnoreCase("inactivos")) {
				listaClientes = cneg.readAllInactivos();
			}
		}

		request.setAttribute("listaClientes", listaClientes);
			
		RequestDispatcher rd = request.getRequestDispatcher("/listadoCliente.jsp");   
	    rd.forward(request, response);
	}
}
