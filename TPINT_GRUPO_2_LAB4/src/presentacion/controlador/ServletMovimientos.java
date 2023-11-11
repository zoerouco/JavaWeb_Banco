package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoImpl.MovimientoDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoImpl;

/**
 * Servlet implementation class ServletMovimientos
 */
@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	MovimientoDaoImpl movimientoDao = new MovimientoDaoImpl();
	MovimientoImpl movimientoN = new MovimientoImpl();
    ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
    Usuario usuario = new Usuario();
    
	Cuenta cuenta = new Cuenta();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") != null) {
			  
			 usuario = (Usuario) request.getSession().getAttribute("usuario");  
			 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cliente_actual", cliente);			 			 					 			 
			 ArrayList<Movimiento> movimientosCliente = movimientoN.getMovimientosXCuenta((Cuenta) request.getSession().getAttribute("cuenta_actual"));
			 request.setAttribute("movimientosCliente", movimientosCliente);
			 
			 ArrayList<Cuenta> cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
			 request.setAttribute("cuentas_cliente_actual",cuentas_cliente_actual);
		  }
		if (request.getParameter("btnMovimiento") != null) {
			Movimiento movimiento = new Movimiento();
			int ultimoID = movimientoN.getUltimoID();
			movimiento.setID_Movimiento(ultimoID + 1);
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuentas-cliente"));
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuenta-destino"));
			movimiento.setDetalle("transferencia_enviada");
			movimiento.setEstado(true);
			movimiento.setImporte((int) Float.parseFloat(request.getParameter("importe")));
			
			boolean inserto = movimientoN.insert(movimiento);
			request.setAttribute("inserto", inserto);
			
			
		}
		String url = "/movimientosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") != null) {
			  
			 usuario = (Usuario) request.getSession().getAttribute("usuario");  
			 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cliente_actual", cliente);			 			 					 			 
			 ArrayList<Movimiento> movimientosCliente = movimientoN.getMovimientosXCuenta((Cuenta) request.getSession().getAttribute("cuenta_actual"));
			 request.setAttribute("movimientosCliente", movimientosCliente);
			 
			 ArrayList<Cuenta> cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
			 request.setAttribute("cuentas_cliente_actual",cuentas_cliente_actual);
		  }
		if (request.getParameter("btnMovimiento") != null) {
			Movimiento movimiento = new Movimiento();
			int ultimoID = movimientoN.getUltimoID();
			movimiento.setID_Movimiento(ultimoID + 1);
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuentas-cliente"));
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuenta-destino"));
			movimiento.setDetalle("transferencia_enviada");
			movimiento.setEstado(true);
			movimiento.setImporte((int) Float.parseFloat(request.getParameter("importe")));
			
			boolean inserto = movimientoN.insert(movimiento);
			request.setAttribute("inserto", inserto);
			
			
		}
		String url = "/movimientosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}
