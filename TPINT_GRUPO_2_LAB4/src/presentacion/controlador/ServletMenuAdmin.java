package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

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
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.GeneroNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;


@WebServlet("/ServletMenuAdmin")
public class ServletMenuAdmin extends HttpServlet {
	
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
	ArrayList<Genero> generos = new ArrayList<Genero>();
	ArrayList<Localidad> localidades = new ArrayList<Localidad>();
	ArrayList<Provincia> provincias = new ArrayList<Provincia>();
	ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
	Cliente cliente = new Cliente();
	ClienteNegocioImpl clienteN = new ClienteNegocioImpl();
	
	Usuario usuario = new Usuario();

    public ServletMenuAdmin() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cliente> listaClientes = cneg.readAll();
		request.setAttribute("listaClientes", listaClientes);
		
		  usuario = (Usuario) request.getSession().getAttribute("usuario");
		//  cliente = (Cliente) request.getSession().getAttribute("cliente_actual");
		  

		  if(request.getSession().getAttribute("usuario") != null) {
			  
					generos = gneg.readAll();
					request.setAttribute("listaGeneros", generos);
					nacionalidades = nneg.readAll();
					request.setAttribute("listaNacionalidades", nacionalidades);
					provincias = pneg.readAll();
					request.setAttribute("listaProvincias", provincias);
					localidades = lneg.readAll();
					request.setAttribute("listaLocalidades", localidades);
					
				
				  
			  }
		  
		  
		  
			
				String url = "/menuAdmins.jsp";
				request.setAttribute("miUrl", url);
				request.getRequestDispatcher(url).forward(request, response);
		
	}


	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cliente> listaClientes = cneg.readAll();
		request.setAttribute("listaClientes", listaClientes);
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		 // cliente = (Cliente) request.getSession().getAttribute("cliente_actual");
		  

		  if(request.getSession().getAttribute("usuario") != null) {
			  
					generos = gneg.readAll();
					request.setAttribute("listaGeneros", generos);
					nacionalidades = nneg.readAll();
					request.setAttribute("listaNacionalidades", nacionalidades);
					provincias = pneg.readAll();
					request.setAttribute("listaProvincias", provincias);
					localidades = lneg.readAll();
					request.setAttribute("listaLocalidades", localidades);
					
				
				  
			  }
			
				String url = "/menuAdmins.jsp";
				request.setAttribute("miUrl", url);
				request.getRequestDispatcher(url).forward(request, response);
}
		
}
