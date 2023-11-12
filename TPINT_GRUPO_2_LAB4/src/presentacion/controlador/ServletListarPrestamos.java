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
		
		ArrayList<Prestamo> listaPrestamos = pneg.readAll();
		request.setAttribute("listaPrestamos", listaPrestamos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoPrestamos.jsp");   
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario = (Usuario) request.getSession().getAttribute("usuario");  
		request.setAttribute("admin_actual", usuario);
		
		if(request.getParameter("aprobado") != null) {
			ArrayList<Prestamo> listaPrestamos = pneg.readAllByEstado("Aprobado");
			request.setAttribute("listaPrestamos", listaPrestamos);
		} else if (request.getParameter("solicitado") != null) {
			ArrayList<Prestamo> listaPrestamos = pneg.readAllByEstado("Solicitado");
			request.setAttribute("listaPrestamos", listaPrestamos);
		} else if (request.getParameter("rechazado") != null) {
			ArrayList<Prestamo> listaPrestamos = pneg.readAllByEstado("Rechazado");
			request.setAttribute("listaPrestamos", listaPrestamos);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/listadoPrestamos.jsp");   
	    rd.forward(request, response);
	}
}
