package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.Usuario;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.GeneroNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;


@WebServlet("/ServletMenuAdmin")
public class ServletMenuAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ClienteNegocioImpl cneg = new ClienteNegocioImpl();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuenegImpl = new CuentaNegocioImpl();
	
	Usuario usuario = new Usuario();

    public ServletMenuAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cliente> listaClientes = cneg.readAllActivos();
		request.setAttribute("listaClientes", listaClientes);
		
	    usuario = (Usuario) request.getSession().getAttribute("usuario");
		request.setAttribute("admin_actual", usuario);
		
		Cuenta cuentaAdmin = cuenegImpl.getCuentaxCBU("1000000000000000000001");
		request.getSession().setAttribute("cuentaAdmin", cuentaAdmin);
			 
		String url = "/menuAdmins.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cliente> listaClientes = cneg.readAllActivos();
		request.setAttribute("listaClientes", listaClientes);
		
	    usuario = (Usuario) request.getSession().getAttribute("usuario");
		request.setAttribute("admin_actual", usuario);
		
		Cuenta cuentaAdmin = cuenegImpl.getCuentaxCBU("1000000000000000000001");
		request.getSession().setAttribute("cuentaAdmin", cuentaAdmin);
			 
		String url = "/menuAdmins.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}