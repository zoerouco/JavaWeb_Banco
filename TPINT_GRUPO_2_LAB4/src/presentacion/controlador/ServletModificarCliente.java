package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.Usuario;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.GeneroNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;


@WebServlet("/ServletModificarCliente")
public class ServletModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	ClienteNegocioImpl cneg = new ClienteNegocioImpl();
	Genero genero = new Genero();
	GeneroNegocioImpl gneg = new GeneroNegocioImpl();
	NacionalidadNegocioImpl nneg = new NacionalidadNegocioImpl();
	Nacionalidad nacionalidad = new Nacionalidad();
	LocalidadNegocioImpl lneg = new LocalidadNegocioImpl(); 
	Localidad localidad = new Localidad();
	ProvinciaNegocioImpl pneg = new ProvinciaNegocioImpl();
	Provincia provincia = new Provincia();
	Usuario usuario = new Usuario();
	
    public ServletModificarCliente() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.setAttribute("admin_actual", usuario);
		 String errorMessage= "";
		 ArrayList<Genero> generos = gneg.readAll();
		 request.setAttribute("listaGeneros", generos);
		 ArrayList<Localidad> localidades = lneg.readAll();
		 request.setAttribute("listaLocalidades", localidades);
		 ArrayList<Nacionalidad> nacionalidades = nneg.readAll();
		 request.setAttribute("listaNacionalidades", nacionalidades);
		 ArrayList<Provincia> provincias = pneg.readAll();
		 request.setAttribute("listaProvincias", provincias);

		 if (request.getParameter("btnBuscarXDNI") != null) {
			String dni = request.getParameter("DNI"); 
			Cliente cliente = cneg.getClientexDNI(dni);
			if (cliente != null) {
			    request.setAttribute("clienteDNI", cliente);
			    
			} else {
				errorMessage="El DNI ingresado no existe";
				request.setAttribute("errorMessage", errorMessage);
	
			}
		
		} 
		
		if (request.getParameter("btnGuardar") != null) {
			
			String mensaje= "";
			Cliente cliente = new Cliente();
			
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setDNI(request.getParameter("dni1"));
			genero = gneg.getGeneroByID(request.getParameter("gender"));
			cliente.setId_genero(genero);
			nacionalidad = nneg.getNacionalidadByID(Integer.parseInt(request.getParameter("nationality")));
			cliente.setId_nacionalidad(nacionalidad);
			cliente.setCUIL(request.getParameter("idCUIL"));
			cliente.setDireccion(request.getParameter("direc"));	
			cliente.setCorreo_electronico(request.getParameter("correo"));
			provincia = pneg.getProvinciaByID(Integer.parseInt(request.getParameter("province")));
			cliente.setId_provincia(provincia);
			localidad = lneg.getLocalidadByID(Integer.parseInt(request.getParameter("locality")));
			cliente.setId_localidades(localidad);
			cliente.setTelefono_primario(request.getParameter("telPrimario"));
			cliente.setTelefono_secundario(request.getParameter("telSec"));
			String estadoParam = request.getParameter("estado");
			boolean estado = "on".equalsIgnoreCase(estadoParam);
			cliente.setEstado(estado);;
	

			
			boolean update = cneg.modificar(cliente);
			request.setAttribute("update", update);
			if(update) {
				mensaje= "Se modific� correctamente";
				request.setAttribute("mensaje", mensaje);
	           	
			} else {
				mensaje= "No se pudo modificar";
				request.setAttribute("mensaje", mensaje);
	          
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/modificarCliente.jsp");   
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 usuario = (Usuario) request.getSession().getAttribute("usuario");  
		 request.setAttribute("admin_actual", usuario);
		 String errorMessage= "";
		 ArrayList<Genero> generos = gneg.readAll();
		 request.setAttribute("listaGeneros", generos);
		 ArrayList<Localidad> localidades = lneg.readAll();
		 request.setAttribute("listaLocalidades", localidades);
		 ArrayList<Nacionalidad> nacionalidades = nneg.readAll();
		 request.setAttribute("listaNacionalidades", nacionalidades);
		 ArrayList<Provincia> provincias = pneg.readAll();
		 request.setAttribute("listaProvincias", provincias);

		 if (request.getParameter("btnBuscarXDNI") != null) {
			String dni = request.getParameter("DNI"); 
			Cliente cliente = cneg.getClientexDNI(dni);
			if (cliente != null) {
			    request.setAttribute("clienteDNI", cliente);
			    
			} else {
				errorMessage="El DNI ingresado no existe";
				request.setAttribute("errorMessage", errorMessage);
	
			}
		
		} 
		
		if (request.getParameter("btnGuardar") != null) {
			
			String mensaje= "";
			Cliente cliente = new Cliente();
			
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setDNI(request.getParameter("dni1"));
			genero = gneg.getGeneroByID(request.getParameter("gender"));
			cliente.setId_genero(genero);
			nacionalidad = nneg.getNacionalidadByID(Integer.parseInt(request.getParameter("nationality")));
			cliente.setId_nacionalidad(nacionalidad);
			cliente.setCUIL(request.getParameter("idCUIL"));
			cliente.setDireccion(request.getParameter("direc"));	
			cliente.setCorreo_electronico(request.getParameter("correo"));
			provincia = pneg.getProvinciaByID(Integer.parseInt(request.getParameter("province")));
			cliente.setId_provincia(provincia);
			localidad = lneg.getLocalidadByID(Integer.parseInt(request.getParameter("locality")));
			cliente.setId_localidades(localidad);
			cliente.setTelefono_primario(request.getParameter("telPrimario"));
			cliente.setTelefono_secundario(request.getParameter("telSec"));
			String estadoParam = request.getParameter("estado");
			boolean estado = "on".equalsIgnoreCase(estadoParam);
			cliente.setEstado(estado);;
	

			
			boolean update = cneg.modificar(cliente);
			request.setAttribute("update", update);
			if(update) {
				mensaje= "Se modific� correctamente";
				request.setAttribute("mensaje", mensaje);
	           	
			} else {
				mensaje= "No se pudo modificar";
				request.setAttribute("mensaje", mensaje);
	          
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/modificarCliente.jsp");   
	    rd.forward(request, response);
	}
}
