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
	Cuenta cuentaDestino  = new Cuenta();

	public ServletMovimientos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		accion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		accion(request, response);
	}

	private void accion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {

			usuario = (Usuario) request.getSession().getAttribute("usuario");
			cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			request.getSession().setAttribute("cliente_actual", cliente);
			cuenta = (Cuenta) request.getSession().getAttribute("cuenta_actual");
			ArrayList<Movimiento> movimientosCliente = movimientoN.getMovimientosXCuenta(cuenta);
			request.setAttribute("movimientosCliente", movimientosCliente);

			ArrayList<Cuenta> cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession()
					.getAttribute("cuentas_cliente_actual");
			request.setAttribute("cuentas_cliente_actual", cuentas_cliente_actual);
		}
		if (request.getParameter("btnMovimiento") != null) {
			
			float saldoAnterior = cuenta.getSaldo();
			float importeMovimiento = Float.parseFloat(request.getParameter("importe_transferir"));
			
			Movimiento movimiento_emitido = new Movimiento();
			Movimiento movimiento_recibido = new Movimiento();
			int ultimoID = movimientoN.getUltimoID();
			//SE CARGA EL OBJETO MOVIMIENTO EMITIDO.
			movimiento_emitido.setId_movimiento(ultimoID + 1);
			cuenta = cuentaN.getCuentaxCBU(cuenta.getCBU()); // EL OBJETO CUENTA OJO CON LO QUE LO PISAS.
			movimiento_emitido.setCBU(cuenta);
			cuentaDestino = cuentaN.getCuentaxCBU(request.getParameter("cbu_destino"));
			movimiento_emitido.setCBU_Destino(cuenta);
			movimiento_emitido.setDetalle("transferencia_enviada");
			movimiento_emitido.setImporte(importeMovimiento);
			tipoMovimiento = tipoMovimientoN.getTipo_MovimientoByID("transferencia_enviada");
			movimiento_emitido.setTipoMovimiento(tipoMovimiento);
			movimiento_emitido.setEstado(true);
			
			// se guarda el movimiento EMITIDO
						boolean insert = movimientoN.insert(movimiento_emitido);
						
			//SE CARGA EL OBJETO MOVIMIENTO RECIBIDO
			movimiento_recibido.setId_movimiento(ultimoID + 1);
			cuenta = cuentaN.getCuentaxCBU(cuentaDestino.getCBU()); // EL OBJETO CUENTA OJO CON LO QUE LO PISAS.
			movimiento_recibido.setCBU(cuenta);
			cuentaDestino = cuentaN.getCuentaxCBU(request.getParameter(cuenta.getCBU()));
			movimiento_recibido.setCBU_Destino(cuenta);
			movimiento_recibido.setDetalle("transferencia_recibida");
			movimiento_recibido.setImporte(importeMovimiento);
			tipoMovimiento = tipoMovimientoN.getTipo_MovimientoByID("transferencia_recibida");
			movimiento_recibido.setTipoMovimiento(tipoMovimiento);
			movimiento_recibido.setEstado(true);
			
			// se guarda el movimiento EMITIDO
				boolean insert2 = movimientoN.insert(movimiento_recibido);
			
				
			
				request.setAttribute("insert", insert);
				request.setAttribute("insert2", insert2);
			
			
			
			// UPDATE CLIENTE ACTUAL:
			float saldo = saldoAnterior - importeMovimiento;
			cuenta.setSaldo(saldo);

			// se actualiza la cuenta emisora
			boolean update = cuentaN.modificar(cuenta);

			// obtenemos la cuenta receptora por CBU para actualizar el saldo
			Cuenta cuentaDestino = cuentaN.getCuentaxCBU(request.getParameter("cbu_destino"));

			float nuevoSaldo = cuentaDestino.getSaldo() + importeMovimiento;
			cuentaDestino.setSaldo(nuevoSaldo);			

			// se actualiza la cuenta receptora
			cuentaN.modificar(cuentaDestino);

			request.setAttribute("update", update);
		}

		// request.setAttribute("validacion", validacion);

		// }

		String url = "/movimientosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
