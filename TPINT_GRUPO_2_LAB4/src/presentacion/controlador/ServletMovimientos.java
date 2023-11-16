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
import excepciones.SaldoInsuficienteException;
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
	Movimiento movimientomayor = new Movimiento();

	Cuenta cuenta = new Cuenta(); //CUENTA ACTUAL DEL CLIENTE SOLO SE MODIFICA SI EL CLIENTE LO HACE.
	Cuenta cuentaDestinoTransfe  = new Cuenta();

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
		String url = "/movimientosCliente.jsp";
		request.setAttribute("miUrl", url);
		ArrayList<Movimiento> movimientosCliente = new ArrayList<Movimiento>();
		
		if (request.getSession().getAttribute("usuario") != null) {

			usuario = (Usuario) request.getSession().getAttribute("usuario");
			cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			request.getSession().setAttribute("cliente_actual", cliente);
			cuenta = (Cuenta) request.getSession().getAttribute("cuenta_actual"); //CUENTA ACTUAL
		    movimientosCliente = movimientoN.getMovimientosXCuenta(cuenta);
			request.setAttribute("movimientosCliente", movimientosCliente);

			ArrayList<Cuenta> cuentas_cliente_actual = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
			request.setAttribute("cuentas_cliente_actual", cuentas_cliente_actual);
		}
	
		if (request.getParameter("btnMovimiento") != null) {
			
			float saldoAnterior = cuenta.getSaldo();
			float importeMovimiento = Float.parseFloat(request.getParameter("importe_transferir"));
			
			try {
				cuentaN.validarSaldo(cuenta, importeMovimiento);
			}
			catch(SaldoInsuficienteException ex) {
				request.setAttribute("saldo_insuficiente", ex.getMessage());
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
			
			Movimiento movimiento_emitido = new Movimiento();
			Movimiento movimiento_recibido = new Movimiento();
			int ultimoID = movimientoN.getUltimoID();
			//SE CARGA EL OBJETO MOVIMIENTO EMITIDO.
			movimiento_emitido.setId_movimiento(ultimoID + 1);
			cuenta = cuentaN.getCuentaxCBU(cuenta.getCBU()); // EL OBJETO CUENTA OJO CON LO QUE LO PISAS.
			movimiento_emitido.setCBU(cuenta);
			cuentaDestinoTransfe = cuentaN.getCuentaxCBU(request.getParameter("cbu_destino"));
			movimiento_emitido.setCBU_Destino(cuentaDestinoTransfe);
			movimiento_emitido.setDetalle("transferencia_enviada");
			movimiento_emitido.setImporte(importeMovimiento);
			tipoMovimiento = tipoMovimientoN.getTipo_MovimientoByID("transferencia_enviada");
			movimiento_emitido.setTipoMovimiento(tipoMovimiento);
			movimiento_emitido.setEstado(true);
			
			// se guarda el movimiento EMITIDO
			boolean insert = movimientoN.insert(movimiento_emitido);
						
			//SE CARGA EL OBJETO MOVIMIENTO RECIBIDO
			movimiento_recibido.setId_movimiento(ultimoID + 1);
			cuentaDestinoTransfe = cuentaN.getCuentaxCBU(request.getParameter("cbu_destino"));
			cuenta = cuentaN.getCuentaxCBU(cuenta.getCBU());
			movimiento_recibido.setCBU(cuentaDestinoTransfe);
			movimiento_recibido.setCBU_Destino(cuenta);
			movimiento_recibido.setDetalle("transferencia_recibida");
			movimiento_recibido.setImporte(importeMovimiento);
			tipoMovimiento = tipoMovimientoN.getTipo_MovimientoByID("transferencia_recibida");
			movimiento_recibido.setTipoMovimiento(tipoMovimiento);
			movimiento_recibido.setEstado(true);
			
			// se guarda el movimiento EMITIDO
			if (insert)
				insert = movimientoN.insert(movimiento_recibido);
			
				
			
				request.setAttribute("insert", insert);
			
			// si no insertó alguno de los dos movimientos (enviado y recibido) termina
			if (!insert) {
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
			
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
		//si presiona el boton del filtro cargo el array de movimientos Cliente con getMovimientos por importe.
		if (request.getParameter("estado") != null) {
			Float importeFiltro = Float.parseFloat(request.getParameter("importe_filtro"));
			if(importeFiltro !=null) {
			importeFiltro = Float.parseFloat(request.getParameter("importe_filtro"));
			
			movimientosCliente = movimientoN.getMovimientosXImporte(cuenta, importeFiltro);
			request.getSession().setAttribute("movimientosCliente", movimientosCliente);
			request.getSession().setAttribute("ultimo_movimiento", movimientomayor);
			request.getSession().setAttribute("cuenta_actual", cuenta);
			}
		}
		else {
		movimientosCliente = movimientoN.getMovimientosXCuenta(cuenta);
		request.getSession().setAttribute("movimientosCliente", movimientosCliente);
		movimientomayor = movimientoN.getUltimoMovimientoCuenta((Cuenta) request.getSession().getAttribute("cuenta_actual"));
		request.getSession().setAttribute("ultimo_movimiento", movimientomayor);
		request.getSession().setAttribute("cuenta_actual", cuenta);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	
}
