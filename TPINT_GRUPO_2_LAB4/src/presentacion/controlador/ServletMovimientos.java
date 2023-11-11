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
import entidades.Tipo_Movimiento;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoImpl;
import negocioImpl.Tipo_MovimientoNegocioImpl;

@WebServlet("/ServletMovimientos")

public class ServletMovimientos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	MovimientoImpl movimientoN = new MovimientoImpl();
    ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
    Usuario usuario = new Usuario();
    Tipo_MovimientoNegocioImpl tipoMovimientoN = new Tipo_MovimientoNegocioImpl();
    Tipo_Movimiento tipoMovimiento = new Tipo_Movimiento();
    
	Cuenta cuenta = new Cuenta();

    public ServletMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") != null) {
			  
			 usuario = (Usuario) request.getSession().getAttribute("usuario");  
			 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cliente_actual", cliente);
			 cuenta = (Cuenta)request.getSession().getAttribute("cuenta_actual");
			 ArrayList<Movimiento> movimientosCliente = movimientoN.getMovimientosXCuenta(cuenta);
			 request.setAttribute("movimientosCliente", movimientosCliente);
			 
			 ArrayList<Cuenta> cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
			 request.setAttribute("cuentas_cliente_actual",cuentas_cliente_actual);
		  }
		if (request.getParameter("btnMovimiento") != null) {
			
			Movimiento movimiento = new Movimiento();
			int ultimoID = movimientoN.getUltimoID();
			movimiento.setId_movimiento(ultimoID+1);
			cuenta = cuentaN.getCuentaxCBU(cuenta.getCBU()); //EL OBJETO CUENTA OJO CON LO QUE LO PISAS.
			movimiento.setCBU(cuenta);
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cbu_destino"));
			movimiento.setCBU_Destino(cuenta);
			movimiento.setDetalle("transferencia_enviada");
			movimiento.setImporte((int) Float.parseFloat(request.getParameter("importe_transferir")));
			tipoMovimiento = tipoMovimientoN.getTipo_MovimientoByID("transferencia_enviada");		
			movimiento.setTipoMovimiento(tipoMovimiento);
			movimiento.setEstado(true);
			
			 cuenta = (Cuenta)request.getSession().getAttribute("cuenta_actual"); // restablecemos a la cuenta del cliente

			boolean inserto = movimientoN.insert(movimiento);
			request.setAttribute("inserto", inserto);
			
			
		}
		String url = "/movimientosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("usuario") != null) {
			  
			 usuario = (Usuario) request.getSession().getAttribute("usuario");  
			 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cliente_actual", cliente);
			 cuenta = (Cuenta)request.getSession().getAttribute("cuenta_actual");
			 ArrayList<Movimiento> movimientosCliente = movimientoN.getMovimientosXCuenta(cuenta);
			 request.setAttribute("movimientosCliente", movimientosCliente);
			 
			 ArrayList<Cuenta> cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
			 request.setAttribute("cuentas_cliente_actual",cuentas_cliente_actual);
		  }
		if (request.getParameter("btnMovimiento") != null) {
			//int validacion;
			//guardar el SALDO "anterior" del cliente cuenta.getsaldo();
			// validar si lo que se quiere transferir es menor o igual al monto del saldo actual.
			//si no pasa la validacion se retorna un int -2 => error de que esta queriendo transferir monto que no tiene.
			
			
			//if(validarMovimiento()){ => si devuelve true 
			Movimiento movimiento = new Movimiento();
			int ultimoID = movimientoN.getUltimoID();
			float importeMovimiento = Float.parseFloat(request.getParameter("importe_transferir"));

			movimiento.setId_movimiento(ultimoID+1);
			cuenta = cuentaN.getCuentaxCBU(cuenta.getCBU()); //EL OBJETO CUENTA OJO CON LO QUE LO PISAS.
			movimiento.setCBU(cuenta);
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cbu_destino"));
			movimiento.setCBU_Destino(cuenta);
			movimiento.setDetalle("transferencia_enviada");
			movimiento.setImporte(importeMovimiento);
			tipoMovimiento = tipoMovimientoN.getTipo_MovimientoByID("transferencia_enviada");		
			movimiento.setTipoMovimiento(tipoMovimiento);
			movimiento.setEstado(true);
			
		 cuenta = (Cuenta)request.getSession().getAttribute("cuenta_actual"); // restablecemos a la cuenta del cliente
		 	//validacion = 1;
			boolean inserto = movimientoN.insert(movimiento);
			request.setAttribute("inserto", inserto);
			//UPDATE CLIENTE ACTUAL:
			//cuenta.setSaldo(importeMovimiento - saldo);
			//boolean update = cuentaN.modificar(cuenta); => modificar saldo.
			//request.setAttribute("update", update);
			//}
			
			
			//validacion = -2
			//request.setAttribute("validacion", validacion); => si validacion es -2 se debe mostrar el mensaje aclaratorio.
			
		}
		String url = "/movimientosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
