package presentacion.controlador;

import java.io.IOException;
import java.sql.Date;
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
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.GeneroNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;


@WebServlet("/ServletAltaCliente")
public class ServletAltaCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Cliente cliente = new Cliente();
	ClienteNegocioImpl cneg = new ClienteNegocioImpl();
	Genero genero = new Genero();
	GeneroNegocioImpl gneg = new GeneroNegocioImpl();
	NacionalidadNegocioImpl nneg = new NacionalidadNegocioImpl();
	Nacionalidad nacionalidad = new Nacionalidad();
	LocalidadNegocioImpl lneg = new LocalidadNegocioImpl();
	Localidad localidad = new Localidad();
	ProvinciaNegocioImpl pneg = new ProvinciaNegocioImpl();
	Provincia provincia = new Provincia();
	
	
    public ServletAltaCliente() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("buttonSubmit") != null) {
			cliente.setApellido(request.getParameter("lastName"));
			cliente.setCorreo_electronico(request.getParameter("email"));
			cliente.setCUIL(request.getParameter("CUIL"));
			cliente.setDireccion(request.getParameter("adress"));
			cliente.setDNI(request.getParameter("DNI"));
			cliente.setFecha_nacimiento(Date.valueOf(request.getParameter("birthdate")));
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
	}
}
