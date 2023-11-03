package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.Tipo_cuentaDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Genero;
import entidades.Tipo_cuenta;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.Tipo_cuentaNegocioImpl;

/**
 * Servlet implementation class ServletAltaCuenta
 */
@WebServlet("/ServletAltaCuenta")
public class ServletAltaCuenta extends HttpServlet {
private static final long serialVersionUID = 1L;
Cliente admin_actual = new Cliente();
ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
Usuario usuario = new Usuario();
	Cuenta cuenta = new Cuenta();
	Cliente cli= new Cliente();
	Tipo_cuentaDaoImpl tipoCuentaDaoImpl= new Tipo_cuentaDaoImpl();
	Tipo_cuenta tcuenta= new Tipo_cuenta();
	ClienteNegocioImpl clineg=new ClienteNegocioImpl();
	CuentaNegocioImpl cuenegImpl=new CuentaNegocioImpl();
	Tipo_cuentaNegocioImpl tcuenegImpl= new Tipo_cuentaNegocioImpl();
	ArrayList<Tipo_cuenta> tCuentas = new ArrayList<Tipo_cuenta>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.getSession().setAttribute("admin_actual", usuario);
		 tCuentas = tcuenegImpl.readAll();
		 request.setAttribute("listatCuentas", tCuentas);
		
    	if(request.getParameter("btnAceptar") != null){
    		
    		cuenta.setCBU(request.getParameter("txtCbu"));
    		tcuenta= tipoCuentaDaoImpl.getTipo_cuentaByID(request.getParameter("txtTipo"));
    		cuenta.setId_tipo(tcuenta);
    		cuenta.setNro_cuenta(request.getParameter("txtNroCuenta"));
    		cli = clineg.getClientexDNI((request.getParameter("txtDni")));
    		cuenta.setDNI(cli);
    		cuenta.setSaldo(Float.parseFloat(request.getParameter("txtSaldo")));
            
        boolean guardo= cuenegImpl.insert(cuenta);
        
        request.setAttribute("insert", guardo);
        
    	}
    	
    	String url = "/altaCuenta.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 admin_actual = clienteN.getClientexDNI(usuario.getDni().getDNI());
		 request.getSession().setAttribute("cliente_actual", admin_actual);
		
		
   	if (request.getParameter("btnAceptar") != null){
   		 		
   		cuenta.setCBU(request.getParameter("txtCbu"));
   		tcuenta= tipoCuentaDaoImpl.getTipo_cuentaByID(request.getParameter("txtTipo"));
   		cuenta.setId_tipo(tcuenta);
   		cuenta.setNro_cuenta(request.getParameter("txtNroCuenta"));
   		cli = clineg.getClientexDNI((request.getParameter("txtDni")));
   		cuenta.setDNI(cli);
   		cuenta.setSaldo(Float.parseFloat(request.getParameter("txtSaldo")));
           
       boolean guardo= cuenegImpl.insert(cuenta);
       
       request.setAttribute("insert", guardo);
       
   	}
   	
   	String url = "/altaCuenta.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}

}