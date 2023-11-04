package presentacion.controlador;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.GeneroNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

/**
 * Servlet implementation class ServletModificarCliente
 */
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
	
    public ServletModificarCliente() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/modificarCliente.jsp");   
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("btnBuscarXDNI") != null) {
			String dni = request.getParameter("DNI"); 
			Cliente cliente = cneg.getClientexDNI(dni);
			if (cliente != null) {
			    request.setAttribute("clienteDNI", cliente);
			    System.out.println("ID genero: " + cliente.getId_genero().getDescripcion());
			    System.out.println("ID nacionalidad: " + cliente.getId_nacionalidad().getNombre_pais());
			    System.out.println("ID provincia: " + cliente.getId_provincia().getNombre_provincia());
			    System.out.println("ID localidad: " + cliente.getId_localidades().getNombre_localidad());

		}
		/*RequestDispatcher rd = request.getRequestDispatcher("/modificarCliente.jsp");   
	    rd.forward(request, response);*/
	}
		
		if (request.getParameter("btnGuardar") != null) {
			
			Cliente cliente = new Cliente();
			
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setDNI(request.getParameter("dni1"));
			genero = gneg.getGeneroByID(request.getParameter("idGenero"));
			cliente.setId_genero(genero);
			nacionalidad = nneg.getNacionalidadByID(Integer.parseInt(request.getParameter("idNacionalidad")));
			cliente.setId_nacionalidad(nacionalidad);
			cliente.setCUIL(request.getParameter("idCUIL"));
			cliente.setDireccion(request.getParameter("direc"));	
			cliente.setCorreo_electronico(request.getParameter("correo"));
			provincia = pneg.getProvinciaByID(Integer.parseInt(request.getParameter("idProvincia")));
			cliente.setId_provincia(provincia);
			localidad = lneg.getLocalidadByID(Integer.parseInt(request.getParameter("idLocalidad")));
			cliente.setId_localidades(localidad);
			cliente.setTelefono_primario(request.getParameter("telPrimario"));
			cliente.setTelefono_secundario(request.getParameter("telSec"));
			String estadoParam = request.getParameter("estado");
			boolean estado = "on".equalsIgnoreCase(estadoParam);
			cliente.setEstado(estado);;
	

			
			boolean update = cneg.modificar(cliente);
			request.setAttribute("update", update);
			if(update) {
				System.out.println("se modifico correctamente");
			} else {
				System.out.println("no se pudo modificar");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/modificarCliente.jsp");   
	    rd.forward(request, response);
}
}
