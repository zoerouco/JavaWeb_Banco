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
import entidades.Usuario;
import negocioImpl.CuentaNegocioImpl;


@WebServlet("/ServletEliminarCuenta")
public class ServletEliminarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CuentaNegocioImpl cnegImpl = new CuentaNegocioImpl();
	Usuario usuario = new Usuario();
	
    public ServletEliminarCuenta() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		ArrayList<Cuenta> listaCuentas = cnegImpl.readAll();
		request.setAttribute("listaCuentas", listaCuentas);
		
		
		if(request.getParameter("buttonEliminar") != null) {
			String CBU = request.getParameter("CBU");
			Cuenta cuenta = cnegImpl.getCuentaxCBU(CBU);
			String confirm = "Esta seguro de que quiere eliminar a la cuenta nro :" + cuenta.getNro_cuenta() + "," + "?";
       	 	request.setAttribute("confirm", confirm);
		}
		if(request.getParameter("confirmEliminar") != null) {
			String CBU = request.getParameter("CBU");
			Cuenta cuenta = cnegImpl.getCuentaxCBU(CBU);
			boolean delete = cnegImpl.delete(cuenta);
			request.setAttribute("delete", delete);
			
			request.setAttribute("listaCuentas", listaCuentas);
		}
		String url = "/eliminarCuenta.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		ArrayList<Cuenta> listaCuentas = cnegImpl.readAll();
		request.setAttribute("listaCuentas", listaCuentas);
		
		
		if(request.getParameter("buttonEliminar") != null) {
			String CBU = request.getParameter("CBU");
			Cuenta cuenta = cnegImpl.getCuentaxCBU(CBU);
			String confirm = "Esta seguro de que quiere eliminar a la cuenta nro :" + cuenta.getNro_cuenta() + "," + "?";
       	 	request.setAttribute("confirm", confirm);
		}
		if(request.getParameter("confirmEliminar") != null) {
			String CBU = request.getParameter("CBU");
			Cuenta cuenta = cnegImpl.getCuentaxCBU(CBU);
			boolean delete = cnegImpl.delete(cuenta);
			request.setAttribute("delete", delete);
			
			request.setAttribute("listaCuentas", listaCuentas);
		}
		String url = "/eliminarCuenta.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
