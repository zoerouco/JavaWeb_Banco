package presentacion.controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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


@WebServlet("/ServletAltaCliente")
public class ServletAltaCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Usuario usuario = new Usuario();
	ClienteNegocioImpl cneg = new ClienteNegocioImpl();
	Genero genero = new Genero();
	GeneroNegocioImpl gneg = new GeneroNegocioImpl();
	NacionalidadNegocioImpl nneg = new NacionalidadNegocioImpl();
	Nacionalidad nacionalidad = new Nacionalidad();
	LocalidadNegocioImpl lneg = new LocalidadNegocioImpl(); 
	Localidad localidad = new Localidad();
	ProvinciaNegocioImpl pneg = new ProvinciaNegocioImpl();
	Provincia provincia = new Provincia();
	ArrayList<Genero> generos = new ArrayList<Genero>();
	ArrayList<Localidad> localidades = new ArrayList<Localidad>();
	ArrayList<Provincia> provincias = new ArrayList<Provincia>();
	ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
	
	
    public ServletAltaCliente() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		
		generos = gneg.readAll();
		request.setAttribute("listaGeneros", generos);
		nacionalidades = nneg.readAll();
		request.setAttribute("listaNacionalidades", nacionalidades);
		provincias = pneg.readAll();
		request.setAttribute("listaProvincias", provincias);
		localidades = lneg.readAll();
		request.setAttribute("listaLocalidades", localidades);
		
		if (request.getParameter("buttonSubmit") != null) {
			
			Cliente cliente = new Cliente();
			
			cliente.setApellido(request.getParameter("lastName"));
			cliente.setCorreo_electronico(request.getParameter("email"));
			cliente.setCUIL(request.getParameter("CUIL"));
			cliente.setDireccion(request.getParameter("adress"));
			cliente.setDNI(request.getParameter("DNI"));
			cliente.setFecha_nacimiento(Date.valueOf(request.getParameter("birthdate"))/*new Date(07/07/2003)*/);
			genero = gneg.getGeneroByID(request.getParameter("id_genero"));
			cliente.setId_genero(genero);
			localidad = lneg.getLocalidadByID(Integer.parseInt(request.getParameter("id_localidad")));
			cliente.setId_localidades(localidad);
			nacionalidad = nneg.getNacionalidadByID(Integer.parseInt(request.getParameter("id_nacionalidad")));
			cliente.setId_nacionalidad(nacionalidad);
			provincia = pneg.getProvinciaByID(Integer.parseInt(request.getParameter("id_provincia")));
			cliente.setId_provincia(provincia);
			cliente.setNombre(request.getParameter("name"));
			cliente.setTelefono_primario(request.getParameter("number1"));
			cliente.setTelefono_secundario(request.getParameter("number2"));
			cliente.setEstado(true);
			
			boolean insert = cneg.insert(cliente);
			request.setAttribute("insert", insert);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/altaCliente.jsp");   
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		
		generos = gneg.readAll();
		request.setAttribute("listaGeneros", generos);
		nacionalidades = nneg.readAll();
		request.setAttribute("listaNacionalidades", nacionalidades);
		provincias = pneg.readAll();
		request.setAttribute("listaProvincias", provincias);
		localidades = lneg.readAll();
		request.setAttribute("listaLocalidades", localidades);
		
		if (request.getParameter("buttonSubmit") != null) {
			
			Cliente cliente = new Cliente();
			
			cliente.setApellido(request.getParameter("lastName"));
			cliente.setCorreo_electronico(request.getParameter("email"));
			cliente.setCUIL(request.getParameter("CUIL"));
			cliente.setDireccion(request.getParameter("adress"));
			cliente.setDNI(request.getParameter("DNI"));
			cliente.setFecha_nacimiento(Date.valueOf(request.getParameter("birthdate"))/*new Date(07/07/2003)*/);
			genero = gneg.getGeneroByID(request.getParameter("gender"));
			cliente.setId_genero(genero);
			localidad = lneg.getLocalidadByID(Integer.parseInt(request.getParameter("locality")));
			cliente.setId_localidades(localidad);
			nacionalidad = nneg.getNacionalidadByID(Integer.parseInt(request.getParameter("nationality")));
			cliente.setId_nacionalidad(nacionalidad);
			provincia = pneg.getProvinciaByID(Integer.parseInt(request.getParameter("province")));
			cliente.setId_provincia(provincia);
			cliente.setNombre(request.getParameter("name"));
			cliente.setTelefono_primario(request.getParameter("number1"));
			cliente.setTelefono_secundario(request.getParameter("number2"));
			cliente.setEstado(true);
			
			boolean insert = cneg.insert(cliente);
			request.setAttribute("insert", insert);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/altaCliente.jsp");   
	    rd.forward(request, response);
	}
}
