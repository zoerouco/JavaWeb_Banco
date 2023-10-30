package presentacion.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import negocio.UsuarioNegocio;
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
    	
    	if(request.getParameter("buttonSubmit") != null) {
    		
    		 String errorMessage = "";
        	 String userName = request.getParameter("userName");
             String password = request.getParameter("password");
             
             
             UsuarioNegocio usuarioNeg = new UsuarioNegocioImpl();
             Usuario usuario = usuarioNeg.getUsuarioxUser(userName);

             if (usuario != null) {

                 if (password.compareTo(usuario.getContraseña()) == 0) {
                	 
                     request.getSession().setAttribute("usuario", usuario);
                  	
                     if(usuario.isEsAdmin()) {
                    RequestDispatcher rd = request.getRequestDispatcher("/menuAdmins.jsp");   
         	        rd.forward(request, response);}
                     else{
                    	 RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");   
              	        rd.forward(request, response);}
                     

                 } else {
                     // Contraseña incorrecta, redirigir al formulario de inicio de sesión con un mensaje de error
                	 errorMessage = "Contraseña incorrecta. Intente nuevamente.";
                	 request.setAttribute("errorMessage", errorMessage);
                	 RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
                	 rd.forward(request, response);
                 }
             } else {
                 // Usuario no encontrado, redirigir al formulario de inicio de sesión con un mensaje de error
            	 errorMessage = "Usuario no encontrado. Intente nuevamente.";
            	 request.setAttribute("errorMessage", errorMessage);
            	 RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
            	 rd.forward(request, response);
         }
        }
    }
    
}