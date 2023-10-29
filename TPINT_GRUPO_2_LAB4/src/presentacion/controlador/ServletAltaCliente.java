package presentacion.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;


@WebServlet("/ServletAltaCliente")
public class ServletAltaCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Cliente cliente = new Cliente();
	
    public ServletAltaCliente() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		if (request.getParameter("buttonSubmit") != null) {
			cliente.setApellido(request.getParameter("lastName"));
			cliente.setCorreo_electronico(request.getParameter("email"));
			cliente.setCUIL(request.getParameter("CUIL"));
			cliente.setDireccion(request.getParameter("adress"));
			cliente.setDNI(request.getParameter("DNI"));
			try {
				cliente.setFecha_nacimiento(dateFormat.parse(request.getParameter("birthdate")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//cliente.setId_genero();
			//cliente.setId_localidades();
			//cliente.setId_nacionalidad();
			//cliente.setId_provincia();
			cliente.setNombre(request.getParameter("name"));
			cliente.setTelefono_primario(request.getParameter("number1"));
			cliente.setTelefono_secundario(request.getParameter("number2"));
			cliente.setEstado(true);
		        	
		    //filas=segDao.AgregarSeguro(seg);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
