package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.PrestamoDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Prestamo;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;


@WebServlet("/ServletCliente")



public class ServletCliente extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	
	//solo deberian haber llamados al negocio (y en negocio al dao)
	PrestamoDaoImpl prestamoD = new PrestamoDaoImpl();
	PrestamoNegocioImpl prestamoN = new PrestamoNegocioImpl();
    ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
	
	Cuenta cuenta = new Cuenta();

    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String DNIClienteActual = request.getParameter("clienteActual");
			cliente = clienteN.getClientexDNI(DNIClienteActual); //con el obj bien cargado en el dao se puede hacer el readAll()												 //como cambie abajo con cuentas
			cuentas = cuentaN.readAll(); //usando negocio
			request.setAttribute("listaCuentas", cuentas);
			
			if(request.getParameter("btnSolicitarPrestamo") != null) { //quiere un préstamo
				
				Prestamo prestamo = new Prestamo();
				int ultimoID = prestamoN.getUltimoID();
				prestamo.setId_prestamo(ultimoID + 1);
				prestamo.setImporte_pedido(Float.parseFloat(request.getParameter("importe_pedido")));
				//calculo los intereses
				float importe_con_intereses = prestamoN.calcularImporteConIntereses(Float.parseFloat(request.getParameter("importe_pedido")),Integer.parseInt(request.getParameter("cant_cuotas")));
				prestamo.setImporte_con_intereses(importe_con_intereses);
				prestamo.setCant_cuotas(Integer.parseInt(request.getParameter("cant_cuotas")));
				prestamo.setMonto_x_mes(prestamoN.calcularMontoxMes(Integer.parseInt(request.getParameter("cant_cuotas")), importe_con_intereses));
				cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuentas-cliente"));
				prestamo.setCBU(cuenta);
				prestamo.setEstado("Solicitado");
				boolean inserto = prestamoN.insert(prestamo);
				request.setAttribute("inserto", inserto);
			}
			
			String url = "/prestamosCliente.jsp";
			request.setAttribute("miUrl", url);
			request.getRequestDispatcher(url).forward(request, response);
					
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String DNIClienteActual = request.getParameter("clienteActual");
		cliente = clienteN.getClientexDNI(DNIClienteActual);
		cuentas = cuentaN.readAll(); 
		request.setAttribute("listaCuentas", cuentas);
		
		if(request.getParameter("btnSolicitarPrestamo") != null) { //quiere un préstamo
			
			Prestamo prestamo = new Prestamo();
			int ultimoID = prestamoN.getUltimoID();
			prestamo.setId_prestamo(ultimoID + 1);
			prestamo.setImporte_pedido(Float.parseFloat(request.getParameter("importe_pedido")));
			//calculo los intereses
			float importe_con_intereses = prestamoN.calcularImporteConIntereses(Float.parseFloat(request.getParameter("importe_pedido")),Integer.parseInt(request.getParameter("cant_cuotas")));
			prestamo.setImporte_con_intereses(importe_con_intereses);
			prestamo.setCant_cuotas(Integer.parseInt(request.getParameter("cant_cuotas")));
			prestamo.setMonto_x_mes(prestamoN.calcularMontoxMes(Integer.parseInt(request.getParameter("cant_cuotas")), importe_con_intereses));
			cuenta = cuentaN.getCuentaxCBU(request.getParameter("cuentas-cliente"));
			prestamo.setCBU(cuenta);
			prestamo.setEstado("Solicitado");
			boolean inserto = prestamoN.insert(prestamo);
			request.setAttribute("inserto", inserto);
		}
		
		
			
		
			String url = "/prestamosCliente.jsp";
			request.setAttribute("miUrl", url);
			request.getRequestDispatcher(url).forward(request, response);
	}
}