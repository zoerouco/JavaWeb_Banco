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
import entidades.Cuenta;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;


@WebServlet("/ServletMenuCliente")
public class ServletMenuCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Cliente cliente = new Cliente();
	Usuario usuario = new Usuario();
	UsuarioNegocioImpl usuarioN = new UsuarioNegocioImpl();
	ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
	ArrayList<Cuenta> cuentas_cliente = new ArrayList<Cuenta>();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	
    public ServletMenuCliente() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
		
		
		  if(request.getSession().getAttribute("usuario") != null) {
			  
			 usuario = (Usuario) request.getSession().getAttribute("usuario");  
			 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cliente_actual", cliente);
			 cuentas_cliente = cuentaN.getCuentasxDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cuentas_cliente_actual", cuentas_cliente);
			 
			
		
			  
		  }
		
			String url = "/menuCliente.jsp";
			request.setAttribute("miUrl", url);
			request.getRequestDispatcher(url).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
		  if(request.getSession().getAttribute("usuario") != null) {
			  
				 usuario = (Usuario) request.getSession().getAttribute("usuario");  
				 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
				 request.getSession().setAttribute("cliente_actual", cliente);
				 cuentas_cliente = cuentaN.getCuentasxDNI(usuario.getDni().getDNI());
				 request.getSession().setAttribute("cuentas_cliente_actual", cuentas_cliente);
				 
		
				  
			  }
		  
			String url = "/menuCliente.jsp";
			request.setAttribute("miUrl", url);
			request.getRequestDispatcher(url).forward(request, response);
			
	}

}
