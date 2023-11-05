package presentacion.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.Tipo_cuentaNegocioImpl;

/**
 * Servlet implementation class ServletModificarCuenta
 */
@WebServlet("/ServletModificarCuenta")
public class ServletModificarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CuentaNegocioImpl cneg = new CuentaNegocioImpl();
	ClienteNegocioImpl clineg = new ClienteNegocioImpl();
	Tipo_cuentaNegocioImpl TipNeg = new Tipo_cuentaNegocioImpl();
	Cuenta cuenta = new Cuenta();
	Cliente cliente = new Cliente();
	Usuario usuario = new Usuario();
	Tipo_cuenta tipoCuenta = new Tipo_cuenta();
	
	 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarCuenta() {
        super();       
    }	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.setAttribute("admin_actual", usuario);
		
		if (request.getParameter("btnBuscarCBU") != null) {
			
			String cbu = request.getParameter("CBU"); 
			 cuenta = cneg.getCuentaxCBU(cbu);
			 
			if (cuenta != null) {
				
			    request.setAttribute("cuentaCBU", cuenta);
			    
			}
			
		}
		
		
			    if (request.getParameter("btnGuardar") != null) {
					
			    	Cuenta newCuenta = new Cuenta();
			        String cbu = (String) request.getParameter("cbuActual"); 
					cuenta = cneg.getCuentaxCBU(cbu);
					float saldo = Float.parseFloat(request.getParameter("Saldo"));
					
			    	  
					newCuenta.setCBU(cbu);
					newCuenta.setSaldo(saldo);		
					
					boolean update = cneg.modificar(newCuenta);
					request.setAttribute("update", update);
		}
			  
	
		  RequestDispatcher rd = request.getRequestDispatcher("/modificarCuenta.jsp");   
		    rd.forward(request, response);
	}
	
			
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.setAttribute("admin_actual", usuario);
		
		if (request.getParameter("btnBuscarCBU") != null) {
			
			String cbu = request.getParameter("CBU"); 
			 cuenta = cneg.getCuentaxCBU(cbu);
			 
			if (cuenta != null) {
				
			    request.setAttribute("cuentaCBU", cuenta);
			    
			}
			
		}
		
		
			    if (request.getParameter("btnGuardar") != null) {
					
			    	Cuenta newCuenta = new Cuenta();
			        String cbu = (String) request.getParameter("cbuActual"); 
					cuenta = cneg.getCuentaxCBU(cbu);
					float saldo = Float.parseFloat(request.getParameter("Saldo"));
					
			    	  
					newCuenta.setCBU(cbu);
					newCuenta.setSaldo(saldo);		
					
					boolean update = cneg.modificar(newCuenta);
					request.setAttribute("update", update);
		}
			  
	
		  RequestDispatcher rd = request.getRequestDispatcher("/modificarCuenta.jsp");   
		    rd.forward(request, response);
	}	
			
			
}
	


	
