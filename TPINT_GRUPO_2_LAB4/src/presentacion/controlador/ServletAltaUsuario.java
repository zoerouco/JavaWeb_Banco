package presentacion.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Usuario;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletAltaUsuario")
public class ServletAltaUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	UsuarioNegocioImpl uneg = new UsuarioNegocioImpl();
	Cliente clienteIngresado = new Cliente();
       
    public ServletAltaUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		clienteIngresado = (Cliente) request.getSession().getAttribute("clienteIngresado");
		Usuario nuevoUsuario = uneg.getUsuarioxDNI(clienteIngresado.getDNI());
		request.setAttribute("nuevoUsuario", nuevoUsuario);
		
		RequestDispatcher rd = request.getRequestDispatcher("/altaUsuario.jsp");   
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		clienteIngresado = (Cliente) request.getSession().getAttribute("clienteIngresado");
		Usuario nuevoUsuario = uneg.getUsuarioxDNI(clienteIngresado.getDNI());
		request.setAttribute("nuevoUsuario", nuevoUsuario);
		
		boolean update = false;
		if(request.getParameter("buttonAgregar") != null) {
			
			String pass = request.getParameter("password1");
			String pass2 = request.getParameter("password2");
			if(pass.equals(pass2)) {
				nuevoUsuario.setContraseña(pass);
				update = uneg.updatePassword(nuevoUsuario);
			} else {
				request.setAttribute("passError", "Las contraseñas deben ser identicas.");
			}
		}
		
		if(update) {
			RequestDispatcher rd = request.getRequestDispatcher("/ServletAltaCuenta");   
		    rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/altaUsuario.jsp");   
		    rd.forward(request, response);
		}
	}

}
