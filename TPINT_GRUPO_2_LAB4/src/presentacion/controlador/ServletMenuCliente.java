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
import entidades.Movimiento;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletMenuCliente")
public class ServletMenuCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Cliente cliente = new Cliente();
	Usuario usuario = new Usuario();
	Cuenta cuenta = new Cuenta();
	UsuarioNegocioImpl usuarioN = new UsuarioNegocioImpl();
	ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
	ArrayList<Cuenta> cuentas_cliente = new ArrayList<Cuenta>();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	MovimientoImpl movimientoN = new MovimientoImpl();
	Movimiento movimiento = new Movimiento();

	public ServletMenuCliente() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		accion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		accion(request, response);
	}

	protected void accion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cbuCuentaCliente = (String) request.getParameter("cuenta-cliente");
		
		if (request.getSession().getAttribute("usuario") != null) {

			usuario = (Usuario) request.getSession().getAttribute("usuario");
			cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			request.getSession().setAttribute("cliente_actual", cliente);
			cuentas_cliente = cuentaN.getCuentasxDNI(cliente.getDNI());
			request.getSession().setAttribute("cuentas_cliente_actual", cuentas_cliente);
			
			// se obtiene la primer cuenta por defecto por si es la primera carga
			if (((Cuenta)request.getSession().getAttribute("cuenta_actual")) == null && (cbuCuentaCliente == null || cbuCuentaCliente.length() == 0) && cuentas_cliente.size() > 0)
			{				
				request.getSession().setAttribute("cuenta_actual", cuentas_cliente.get(0));
				Movimiento movimientomayor = movimientoN.getUltimoMovimientoCuenta((Cuenta) request.getSession().getAttribute("cuenta_actual"));
				request.getSession().setAttribute("ultimo_movimiento", movimientomayor);
			}
		}

		
		if (cbuCuentaCliente != null && cbuCuentaCliente.length() > 0) {
			cuenta = cuentaN.getCuentaxCBU(cbuCuentaCliente);
			request.getSession().setAttribute("cuenta_actual", cuenta);
			Movimiento movimientomayor = movimientoN.getUltimoMovimientoCuenta(cuenta);
			request.getSession().setAttribute("ultimo_movimiento", movimientomayor);
		}


		String url = "/menuCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}

