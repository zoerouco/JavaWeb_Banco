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
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;


@WebServlet("/ServletCliente") //SERVLET DE PRÉSTAMOS!!!



public class ServletCliente extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	ArrayList<Cuenta> cuentas_cliente_actual = new ArrayList<Cuenta>();
	Cliente cliente = new Cliente();
	CuentaNegocioImpl cuentaN = new CuentaNegocioImpl();
	PrestamoDaoImpl prestamoD = new PrestamoDaoImpl();
	PrestamoNegocioImpl prestamoN = new PrestamoNegocioImpl();
    ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
    Usuario usuario = new Usuario();

	
	Cuenta cuenta = new Cuenta();

    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("usuario") != null) {
			  
				 usuario = (Usuario) request.getSession().getAttribute("usuario");  
				 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
				 request.getSession().setAttribute("cliente_actual", cliente);
				 cuentas_cliente_actual = cuentaN.getCuentasxDNI(usuario.getDni().getDNI());
				 request.getSession().setAttribute("cuentas_cliente_actual", cuentas_cliente_actual);
				 
				ArrayList <Prestamo> prestamosCliente = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
				request.setAttribute("prestamosCliente", prestamosCliente);
				 }
				 
			  
			
			if(request.getParameter("btnSolicitarPrestamo") != null) {
				
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
			
			if(request.getParameter("btnBuscarXCbu") != null) {
				
				String cbu = request.getParameter("filtro-cuentas-cliente");
				ArrayList <Prestamo> prestamosxCBU = prestamoN.getPrestamosxCBU(cbu, cuentas_cliente_actual);	
			    ArrayList <Prestamo> prestamosCliente = null;
				
				request.setAttribute("filtro", prestamosxCBU);
			    request.setAttribute("hayFiltro", true);
			   
				request.setAttribute("prestamosCliente", prestamosCliente);
			    
			}
			
			if(request.getParameter("btnLimpiarFiltro") != null) {
				
				request.setAttribute("hayFiltro", false);
				ArrayList <Prestamo> prestamosxCBU = null;	
				ArrayList <Prestamo> prestamosCliente = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
				request.setAttribute("prestamosCliente", prestamosCliente);
			}
			
			if(request.getParameter("btnConsultarPagos") != null) {
				
			}
			
			String url = "/prestamosCliente.jsp";
			request.setAttribute("miUrl", url);
			request.getRequestDispatcher(url).forward(request, response);
					
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("usuario") != null) {
			  
			 usuario = (Usuario) request.getSession().getAttribute("usuario");  
			 cliente = clienteN.getClientexDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cliente_actual", cliente);
			 cuentas_cliente_actual = cuentaN.getCuentasxDNI(usuario.getDni().getDNI());
			 request.getSession().setAttribute("cuentas_cliente_actual", cuentas_cliente_actual);
			 
			ArrayList <Prestamo> prestamosCliente = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			request.setAttribute("prestamosCliente", prestamosCliente);
			 }
			 
		  
		
		if(request.getParameter("btnSolicitarPrestamo") != null) {
			
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
		
		if(request.getParameter("btnBuscarXCbu") != null) {
			
			String cbu = request.getParameter("filtro-cuentas-cliente");
			ArrayList <Prestamo> prestamosxCBU = prestamoN.getPrestamosxCBU(cbu, cuentas_cliente_actual);	
		    ArrayList <Prestamo> prestamosCliente = null;
			
			request.setAttribute("filtro", prestamosxCBU);
		    request.setAttribute("hayFiltro", true);
		   
			request.setAttribute("prestamosCliente", prestamosCliente);
		    
		}
		
		if(request.getParameter("btnLimpiarFiltro") != null) {
			
			request.setAttribute("hayFiltro", false);
			ArrayList <Prestamo> prestamosxCBU = null;	
			ArrayList <Prestamo> prestamosCliente = prestamoN.getPrestamoxCuentas(cuentas_cliente_actual);
			request.setAttribute("prestamosCliente", prestamosCliente);
		}
		
		String url = "/prestamosCliente.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}