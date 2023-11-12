package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import daoImpl.PrestamoDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Prestamo;
import entidades.PrestamosXmovimientos;
import entidades.Tipo_Movimiento;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoImpl;
import negocioImpl.PrestamoNegocioImpl;
import negocioImpl.PrestamosXmovimientosNegocioImpl;
import negocioImpl.Tipo_MovimientoNegocioImpl;
import negocioImpl.Tipo_cuentaNegocioImpl;

@WebServlet("/ServletCliente") // SERVLET DE PRÉSTAMOS!!!

public class ServletCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	PrestamoDaoImpl prestamoD = new PrestamoDaoImpl();
	PrestamoNegocioImpl prestamoN = new PrestamoNegocioImpl();
	ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
	PrestamosXmovimientosNegocioImpl pxmN = new PrestamosXmovimientosNegocioImpl();
	Usuario usuario = new Usuario();
	Prestamo prestamo = new Prestamo();
	MovimientoImpl movimientoN = new MovimientoImpl();
	Tipo_MovimientoNegocioImpl tmN = new Tipo_MovimientoNegocioImpl();

	Cuenta cuenta = new Cuenta();

	public ServletCliente() {
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

	private void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {

			usuario = (Usuario) request.getSession().getAttribute("usuario");
			cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			request.getSession().setAttribute("cliente_actual", cliente);
			cuentas_cliente_actual = cuentaN.getCuentasxDNI(usuario.getDni().getDNI());
			request.getSession().setAttribute("cuentas_cliente_actual", cuentas_cliente_actual);

			ArrayList<Prestamo> prestamosClienteAux = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			ArrayList<Prestamo> prestamosCliente = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			request.setAttribute("prestamosCliente", prestamosCliente);
			request.setAttribute("prestamosClienteAux", prestamosClienteAux);
		}

		if (request.getParameter("btnSolicitarPrestamo") != null) {

			Prestamo prestamo = new Prestamo();
			int ultimoID = prestamoN.getUltimoID();
			prestamo.setId_prestamo(ultimoID + 1);
			prestamo.setImporte_pedido(Float.parseFloat(request.getParameter("importe_pedido")));
			// calculo los intereses
			float importe_con_intereses = prestamoN.calcularImporteConIntereses(
					Float.parseFloat(request.getParameter("importe_pedido")),
					Integer.parseInt(request.getParameter("cant_cuotas")));
			prestamo.setImporte_con_intereses(importe_con_intereses);
			prestamo.setCant_cuotas(Integer.parseInt(request.getParameter("cant_cuotas")));
			prestamo.setMonto_x_mes(prestamoN.calcularMontoxMes(Integer.parseInt(request.getParameter("cant_cuotas")),
					importe_con_intereses));
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuentas-cliente"));
			prestamo.setCBU(cuenta);
			prestamo.setEstado("Aprobado");
			boolean inserto = prestamoN.insert(prestamo);
			request.setAttribute("inserto", inserto);
			ArrayList<Prestamo> prestamosClienteAux = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			request.setAttribute("prestamosClienteAux", prestamosClienteAux);
		}

		if (request.getParameter("btnBuscarXCbu") != null) {

			String cbu = request.getParameter("filtro-cuentas-cliente");
			ArrayList<Prestamo> prestamosxCBU = prestamoN.getPrestamosxCBU(cbu, cuentas_cliente_actual);
			ArrayList<Prestamo> prestamosClienteAux = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			ArrayList<Prestamo> prestamosCliente = null;

			request.setAttribute("filtro", prestamosxCBU);
			request.setAttribute("hayFiltro", true);

			request.setAttribute("prestamosCliente", prestamosCliente);
			request.setAttribute("prestamosClienteAux", prestamosClienteAux);

		}

		if (request.getParameter("btnLimpiarFiltro") != null) {

			request.setAttribute("hayFiltro", false);
			ArrayList<Prestamo> prestamosxCBU = null;
			ArrayList<Prestamo> prestamosCliente = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			request.setAttribute("prestamosCliente", prestamosCliente);
		}

		if (request.getParameter("btnConsultarPagos") != null) {

			if (!(request.getParameter("prestamo-cliente").compareTo("NO TIENE PRÉSTAMOS APROBADOS") == 0)) {

				int idPrestamo = Integer.parseInt(request.getParameter("prestamo-cliente"));
				ArrayList<PrestamosXmovimientos> pagosPrestamos = pxmN.getPrestamosXmovimientosByID(idPrestamo);
				// acá tengo el ID del préstamo a PAGAR y un array con los pagos de ese
				// prestamo.
				Boolean debePagar = false;
				Prestamo prestamo = prestamoN.getPrestamoByID(idPrestamo);
				int cant_cuotas = prestamo.getCant_cuotas();
				float monto_x_mes = prestamo.getMonto_x_mes();

				if (pagosPrestamos.size() == cant_cuotas) {

					request.setAttribute("debePagar", false);
				} else {
					int cuotas_faltantes = cant_cuotas - pagosPrestamos.size();
					int nro_cuota = pagosPrestamos.size() + 1;
					request.setAttribute("debePagar", true);
					request.setAttribute("prestamo_consultado", prestamo);
					request.setAttribute("nro_cuota", nro_cuota);
				}

				ArrayList<Prestamo> prestamosClienteAux = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
				request.setAttribute("prestamosClienteAux", prestamosClienteAux);
				request.setAttribute("pagosPrestamos", pagosPrestamos);

			}
		}

		if (request.getParameter("btnRealizarpago") != null) {

			Cuenta cuentaOrigen = new Cuenta();
			Cuenta cuentaDestino = new Cuenta();
			cuentaDestino.setCBU("000000001");
			Tipo_Movimiento tm = new Tipo_Movimiento();
			Movimiento movimiento = new Movimiento();
			int idPrestamo = Integer.parseInt(request.getParameter("prestamo"));
			Prestamo prestamo_actual = prestamoN.getPrestamoByID(idPrestamo);
			PrestamosXmovimientos pxm = new PrestamosXmovimientos();
			String cbu = request.getParameter("cbu_origen");
			cuentaOrigen = cuentaN.getCuentaxCBU(cbu);
			tm = tmN.getTipo_MovimientoByID("pago_prestamo");
			float importe_cuota = prestamo_actual.getMonto_x_mes();

			movimiento.setCBU(cuentaOrigen);
			movimiento.setCBU_Destino(cuentaDestino);
			movimiento.setTipoMovimiento(tm);
			movimiento.setDetalle("pago_prestamo");
			movimiento.setImporte(importe_cuota);
			movimiento.setEstado(true);
			
			Boolean inserto = movimientoN.insert(movimiento);
			
			movimiento.setId_movimiento(movimientoN.getUltimoID());

			pxm.setCBU(cuentaOrigen);
			pxm.setId_movimiento(movimiento);
			pxm.setId_prestamo(prestamo_actual);

			Boolean inserto2 = pxmN.insert(pxm);

			if (inserto && inserto2)
				request.setAttribute("pagoCorrectamente", inserto);

		}

		String url = "/prestamosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}