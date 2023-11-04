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


@WebServlet("/ServletEliminarCliente")
public class ServletEliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ClienteNegocioImpl cneg = new ClienteNegocioImpl();
    Usuario usuario = new Usuario();
    
    public ServletEliminarCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		 
		ArrayList<Cliente> listaClientes = cneg.readAllActivos();
		request.setAttribute("listaClientes", listaClientes);
		
		if(request.getParameter("buttonEliminar") != null) {
			String DNI = request.getParameter("DNI");
			Cliente cliente = cneg.getClientexDNI(DNI);
			String confirm = "Esta seguro de que quiere eliminar a " + cliente.getNombre() + ", " + cliente.getApellido() + "?";
       	 	request.setAttribute("confirm" + DNI, confirm);
		}
		if(request.getParameter("confirmEliminar") != null) {
			String DNI = request.getParameter("DNI");
			Cliente cliente = cneg.getClientexDNI(DNI);
			boolean delete = cneg.delete(cliente);
			request.setAttribute("delete", delete);
			
			listaClientes = cneg.readAllActivos();
			request.setAttribute("listaClientes", listaClientes);
		}
		String url = "/eliminarCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		 
		ArrayList<Cliente> listaClientes = cneg.readAllActivos();
		request.setAttribute("listaClientes", listaClientes);
		
		if(request.getParameter("buttonEliminar") != null) {
			String DNI = request.getParameter("DNI");
			Cliente cliente = cneg.getClientexDNI(DNI);
			String confirm = "Esta seguro de que quiere eliminar a " + cliente.getNombre() + ", " + cliente.getApellido() + "?";
       	 	request.setAttribute("confirm" + DNI, confirm);
		}
		if(request.getParameter("confirmEliminar") != null) {
			String DNI = request.getParameter("DNI");
			Cliente cliente = cneg.getClientexDNI(DNI);
			boolean delete = cneg.delete(cliente);
			request.setAttribute("delete", delete);
			
			listaClientes = cneg.readAllActivos();
			request.setAttribute("listaClientes", listaClientes);
		}
		String url = "/eliminarCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
