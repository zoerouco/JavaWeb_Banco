package presentacion.controlador;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Usuario;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoImpl;


@WebServlet("/ServletMenuAdmin")
public class ServletMenuAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Movimiento movimiento = new Movimiento();
	MovimientoImpl mneg = new MovimientoImpl();
	CuentaNegocioImpl cuenegImpl = new CuentaNegocioImpl();
	
	Usuario usuario = new Usuario();

    public ServletMenuAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		request.setAttribute("admin_actual", usuario);
		
		Cuenta cuentaAdmin = cuenegImpl.getCuentaxCBU("1000000000000000000001");
		request.getSession().setAttribute("cuentaAdmin", cuentaAdmin);
		
		ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
		listaMovimientos = mneg.readAll();
		
		if (request.getParameter("btnFiltrar") != null) {
	        String fecha1Param = request.getParameter("fecha1");
	        String fecha2Param = request.getParameter("fecha2");

	        if (fecha1Param != null && fecha2Param != null && !fecha1Param.isEmpty() && !fecha2Param.isEmpty()) {
	            LocalDateTime desde = LocalDateTime.parse(fecha1Param, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	            LocalDateTime hasta = LocalDateTime.parse(fecha2Param, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	            listaMovimientos = mneg.getMovimientosXFechas(desde, hasta);
	        } else {
	            listaMovimientos = mneg.readAll();
	        }
	    }
		
		request.setAttribute("listaMovimientos", listaMovimientos);
			 
		String url = "/menuAdmins.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		request.setAttribute("admin_actual", usuario);
		
		Cuenta cuentaAdmin = cuenegImpl.getCuentaxCBU("1000000000000000000001");
		request.getSession().setAttribute("cuentaAdmin", cuentaAdmin);
		
		ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
		listaMovimientos = mneg.readAll();
		
		if (request.getParameter("btnFiltrar") != null) {
	        String fecha1Param = request.getParameter("fecha1");
	        String fecha2Param = request.getParameter("fecha2");

	        if (fecha1Param != null && fecha2Param != null && !fecha1Param.isEmpty() && !fecha2Param.isEmpty()) {
	            LocalDateTime desde = LocalDateTime.parse(fecha1Param, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	            LocalDateTime hasta = LocalDateTime.parse(fecha2Param, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	            listaMovimientos = mneg.getMovimientosXFechas(desde, hasta);
	        } else {
	            listaMovimientos = mneg.readAll();
	        }
	    }
		
		request.setAttribute("listaMovimientos", listaMovimientos);
			 
		String url = "/menuAdmins.jsp";
		request.setAttribute("miUrl", url);
		request.getRequestDispatcher(url).forward(request, response);
	}
}