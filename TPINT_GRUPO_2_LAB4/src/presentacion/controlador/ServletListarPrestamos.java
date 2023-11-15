package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Prestamo;
import entidades.Usuario;
import negocioImpl.PrestamoNegocioImpl;


@WebServlet("/ServletListarPrestamos")
public class ServletListarPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	PrestamoNegocioImpl pneg = new PrestamoNegocioImpl();
    
    public ServletListarPrestamos() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		String estado = request.getParameter("estado");
		ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
		
		if (estado != null && !estado.isEmpty()) {
			if(estado.equalsIgnoreCase("mostrarTodos")) {
				listaPrestamos = pneg.readAll();
			} else if(estado.equalsIgnoreCase("Aprobado") || estado.equalsIgnoreCase("Solicitado") || estado.equalsIgnoreCase("Rechazado")){
				listaPrestamos = pneg.readAllByEstado(estado);
			} else {
				listaPrestamos = pneg.readAll();
			}
	    } else {
	        listaPrestamos = pneg.readAll();
	    }
		request.setAttribute("listaPrestamos", listaPrestamos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoPrestamos.jsp");   
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		String estado = request.getParameter("estado");
		ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
		
		if (estado != null && !estado.isEmpty()) {
			if(estado.equalsIgnoreCase("mostrarTodos")) {
				listaPrestamos = pneg.readAll();
			} else if(estado.equalsIgnoreCase("Aprobado") || estado.equalsIgnoreCase("Solicitado") || estado.equalsIgnoreCase("Rechazado")){
				listaPrestamos = pneg.readAllByEstado(estado);
			} else {
				listaPrestamos = pneg.readAll();
			}
	    } else {
	        listaPrestamos = pneg.readAll();
	    }
		request.setAttribute("listaPrestamos", listaPrestamos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoPrestamos.jsp");   
	    rd.forward(request, response);
	}
}
