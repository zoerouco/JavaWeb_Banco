package presentacion.controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Cuenta;
import entidades.Usuario;
import negocio.CuentaNegocio;
import negocio.UsuarioNegocio;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public ServletUsuario() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	}
		
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("buttonSubmit") != null) {
            String errorMessage = "";
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            UsuarioNegocio usuarioNeg = new UsuarioNegocioImpl();
            Usuario usuario = usuarioNeg.getUsuarioxUser(userName);

            if (usuario != null) {
                CuentaNegocio cuentaNeg = new CuentaNegocioImpl();
                ArrayList<Cuenta> cuentas = cuentaNeg.getCuentasxDNI(usuario.getDni().getDNI().toString());

                if (cuentas != null && !cuentas.isEmpty()) {
                    if (password.equals(usuario.getContrase�a()) && usuario.isEstado()) {
                        request.getSession().setAttribute("usuario", usuario);
                        if (usuario.isEsAdmin()) {
                            RequestDispatcher rd = request.getRequestDispatcher("ServletMenuAdmin");
                            rd.forward(request, response);
                        } else {
                            RequestDispatcher rd = request.getRequestDispatcher("ServletMenuCliente");
                            rd.forward(request, response);
                        }
                        return; // Detiene el flujo para evitar el env�o del mensaje de error
                    } else {
                        errorMessage = "Contrase�a incorrecta. Intente nuevamente.";
                    }
                } else {
                    errorMessage = "El usuario no tiene cuentas asociadas.";
                }
            } else {
                errorMessage = "Usuario no encontrado. Intente nuevamente.";
            }

            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
            rd.forward(request, response);
        }
    }   
}