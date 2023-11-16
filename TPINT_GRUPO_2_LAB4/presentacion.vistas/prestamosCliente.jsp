<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Prestamo"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="entidades.PrestamosXmovimientos"%>
<%@ page import="entidades.Usuario"%>
<%@ page import="entidades.Cuenta"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="util.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Recursos/css/stylesCliente.css">
    <link rel="stylesheet" type="text/css" href="Recursos/css/main.css">
    <link rel="stylesheet" type="text/css" href="Recursos/css/prestamos.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="Recursos/js/prestamos.js"></script>
    <link rel="icon" type="image/png" href="Recursos/img/BancoLogo.png" />
    <title>Globank | Mis préstamos</title>
</head>

<body>
    <%
        Nacionalidad nac = new Nacionalidad();
        Localidad loc = new Localidad();
        Provincia prov = new Provincia();
        Genero genero = new Genero();
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        PrestamosXmovimientos pxm = new PrestamosXmovimientos();
        cliente = (Cliente) request.getSession().getAttribute("cliente_actual");
        
        Cuenta cuentaActual = (Cuenta) request.getSession().getAttribute("cuenta_actual");
        ArrayList <Prestamo> prestamosCliente = (ArrayList <Prestamo>) request.getAttribute("prestamosCliente");
        ArrayList<Prestamo> prestamosClienteAux =  (ArrayList<Prestamo>) request.getAttribute("prestamosClienteAux");
    %>

    <header class="encabezado">
        <div class="contenedor-menu">
            <a href="ServletMenuCliente">
                <img class="imagen-menu" src="Recursos/img/BancoLogo.png" alt="nav" />
            </a>
            <h1 style="color: #ffefd5;">GLOBANK</h1>

            <ul class="contenedor-links-menu">
                <li class="links-menu"><a class="links-menu" href="ServletMenuCliente"> Home </a></li>
                <li class="links-menu"><a class="links-menu" href="ServletMovimientos"> Mis movimientos</a></li>
                <li class="links-menu"><a class="links-menu" href="ServletCliente" id="mis-prestamos"> Mis préstamos
                    </a></li>
                <li class="links-menu"><a class="links-menu" href="#mispagos">Mis pagos</a></li>

                <li class="mensaje-bienvenida">
                    <h1>Bienvenid@, <%= cliente.getNombre()%></h1><% if (cuentaActual != null) { %> <p style="color: floralwhite;margin: 0;font-weight: bold;">CBU seleccionado: <%=cuentaActual.getCBU()%></p><% } %>
                </li>
            </ul>
            <input type="hidden" name="clienteActual" value="<%= cliente.getDNI() %>">
        </div>
        <div class= "div-btn-logout"> 
		<a class="btn btn-danger" href="logOut.jsp" role="button">LogOut</a>
		</div>
    </header>
   
   
   <%

   
   if(prestamosCliente != null) { %>
    <div class="container-table" id="table-prestamos">
        <%
    		
            int itemsPerPage = 6;
            int totalPages = (int) Math.ceil((double) prestamosCliente.size() / itemsPerPage);
            int currentPage = 1;
            if (request.getParameter("page") != null) {
                currentPage = Integer.parseInt(request.getParameter("page"));
            }
            int startIndex = (currentPage - 1) * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, prestamosCliente.size());
        %>
        
        
       <form action="ServletCliente" method="Get" class="buscarXCbu">
      
        <p>Buscar préstamos por CBU:</p>
         <select required name="filtro-cuentas-cliente" id="cuentas-cliente">
                    <%
                       
                        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
                        if (cuentas != null) {
                            for (Cuenta cuentaCliente : cuentas) {
                    %>
                                <option><%=cuentaCliente.getCBU()%></option>
                    <%
                            }
                        } else {
                    %>
                            <option>NO TIENE CUENTAS ABIERTAS.</option>
                    <%
                        }
                    %>
                </select>
        <button class="buttons" type="submit" name="estado" value="Buscar" id="btnBuscarXCbu">Buscar</button>
		<button class="buttons" type="submit" name="estado" value="Quitar filtro" id="btnLimpiarFiltro">Quitar filtro</button>

          <h1 class="titulo">Mis préstamos</h1>
    
      
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID Préstamo</th>
                            <th scope="col">CBU Origen</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Importe pedido</th>
                            <th scope="col">Importe c/ intereses</th>
                            <th scope="col">Monto por mes</th>
                            <th scope="col">Cantidad de cuotas</th>
                            <th scope="col">Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = startIndex; i < endIndex; i++) {
                                Prestamo prestamo = prestamosCliente.get(i);
                        %>
                                <tr>
                                     <td><%= prestamo.getId_prestamo() %></td>
                                    <td><%= prestamo.getCBU().getCBU() %></td>
                                    <td><%= prestamo.getFecha_realizacion() %></td>
                                    <td><%= Utils.formatMoney(prestamo.getImporte_pedido())%></td>
                                     <td><%=Utils.formatMoney(prestamo.getImporte_con_intereses()) %></td>
                                    <td><%=Utils.formatMoney(prestamo.getMonto_x_mes()) %></td>
                                    <td><%= prestamo.getCant_cuotas() %></td>
                                    <%
                                        if (prestamo.getEstado().compareTo("Solicitado") == 0) {
                                    %>
                                            <td>SOLICITADO</td>
                                    <%
                                        } else if (prestamo.getEstado().compareTo("Aprobado") == 0) {
                                    %>
                                            <td><img class="icon-estado" src="Recursos/img/tick-verde.png"></td>
                                    <%
                                        } else {
                                    %>
                                            <td><img class="icon-estado" src="Recursos/img/rechazado.png"></td>
                                    </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
                <div class="paginado">
                <% 
                    for (int i = 1; i <= totalPages; i++) {
                %>
                
                	<li <%= i == currentPage ? "active" : "" %>">
		                 <a class="page-link" href="ServletCliente?page=<%= i %>&estado=<%= request.getParameter("estado") %>"><%= i %></a>
		             </li>

                <%
                    }
                %>
                   </div>

        </form>
            </div>
 <%}else if(prestamosCliente != null){ %>
    <div class="container-table" id="table-prestamos">
        <%
    		
            int itemsPerPage = 6;
            int totalPages = (int) Math.ceil((double) prestamosCliente.size() / itemsPerPage);
            int currentPage = 1;
            if (request.getParameter("page") != null) {
                currentPage = Integer.parseInt(request.getParameter("page"));
            }
            int startIndex = (currentPage - 1) * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, prestamosCliente.size());
        %>
        
        
       <form action="ServletCliente" method="Get" class="buscarXCbu">
      
        <p>Buscar préstamos por CBU:</p>
         <select required name="filtro-cuentas-cliente" id="cuentas-cliente">
                    <%
                        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
                        if (cuentas != null) {
                            for (Cuenta cuentaCliente : cuentas) {
                    %>
                                <option><%=cuentaCliente.getCBU()%></option>
                    <%
                            }
                        } else {
                    %>
                            <option>NO HAY</option>
                    <%
                        }
                    %>
                </select>
        <input class="buttons" type="submit" name="btnBuscarXCbu" value="Buscar" id="btnBuscarXCbu"></input>
		<input class="buttons" type="submit" name="btnLimpiarFiltro" value="Quitar filtro" id="btnLimpiarFiltro"></input>
         </form>

          <h1 class="titulo">Mis préstamos</h1>
    
      
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID Préstamo</th>
                            <th scope="col">CBU Origen</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Importe pedido</th>
                            <th scope="col">Importe c/ intereses</th>
                            <th scope="col">Monto por mes</th>
                            <th scope="col">Cantidad de cuotas</th>
                            <th scope="col">Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = startIndex; i < endIndex; i++) {
                                Prestamo prestamo = prestamosCliente.get(i);
                        %>
                                <tr>
                                    <td><%= prestamo.getId_prestamo() %></td>
                                    <td><%= prestamo.getCBU().getCBU() %></td>
                                    <td><%= prestamo.getFecha_realizacion() %></td>
                                    <td><%="$" +  Utils.formatMoney(prestamo.getImporte_pedido())%></td>
                                     <td><%="$" +  Utils.formatMoney(prestamo.getImporte_con_intereses()) %></td>
                                    <td><%="$" +  Utils.formatMoney(prestamo.getMonto_x_mes()) %></td>
                                    <td><%= prestamo.getCant_cuotas() %></td>
                                    <%
                                        if (prestamo.getEstado().compareTo("Solicitado") == 0) {
                                    %>
                                            <td>SOLICITADO</td>
                                    <%
                                        } else if (prestamo.getEstado().compareTo("Aprobado") == 0) {
                                    %>
                                            <td><img class="icon-estado" src="Recursos/img/tick-verde.png"></td>
                                    <%
                                        } else {
                                    %>
                                            <td><img class="icon-estado" src="Recursos/img/rechazado.png"></td>
                                    </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
                <div class="paginado">
                <% 
                    for (int i = 1; i <= totalPages; i++) {
                %>
                    <a href="?page=<%= i %>"><%= i %></a>

                <%
                    }
                %>
                   </div>
                   
                  
       
        
            </div>
 
 
 <%}%>
   
    <div class="form-prestamo" id="form-prestamo">
    
    <img src="Recursos/img/prestamo-icon.png" height="64px"> <h1>SOLICITAR PRÉSTAMO</h1> <img>

        <form action="ServletCliente" method="post">
            <input type="hidden" name="clienteActual" value="<%= cliente.getDNI() %>">
            <p class="importe_prestamo">
                Importe:<input type="number" required name="importe_pedido" min="1000" max="100000000" step="1000">
                </input>
            </p>
            <p>
                Cantidad de cuotas: <select name="cant_cuotas">
                    <option value="1">1 cuota - 3% interés</option>
                    <option value="3">3 cuotas - 5% interés</option>
                    <option value="6">6 cuotas - 10% interés</option>
                    <option value="12">12 cuotas - 20% interés</option>
                    <option value="18">18 cuotas - 25% interés</option>
                </select>
            </p>
            <p>
                Cuenta donde se depositará el préstamo:
                <select required name="cuentas-cliente" id="cuentas-cliente">
                    <%
                        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
                        if (cuentas != null) {
                            for (Cuenta cuentaCliente : cuentas) {
                    %>
                                <option><%=cuentaCliente.getCBU()%></option>
                    <%
                            }
                        } else {
                    %>
                            <option>NO HAY</option>
                    <%
                        }
                    %>
                </select>
                <input type="submit" name="btnSolicitarPrestamo" value="Solicitar" id="btnSolicitarPrestamo"></input>
        </form>
        <%
            Boolean inserto = (Boolean) request.getAttribute("inserto");
            if (inserto != null && inserto) {
        %>
                <p class="mensajeSucceed"> Se solicitó el préstamo correctamente.<br> Por favor revisa el estado de tu
                    solicitud en la pestaña "Mis préstamos". ¡Gracias!</p>
        <%
            }
        %>
    </div>

	<section id="mispagos">
	
	<div class="container-mispagos">
	
	   <img src="Recursos/img/salario.png" height="64px"> <h1>MIS PAGOS</h1> <img>
	   
                   
	<form action="ServletCliente" method="Post">
	
	<h2>Consultar pagos</h2>
	
	 <select required name="prestamo-cliente" id="prestamo-cliente">
                    <%
                    	int contAux = 0;
                    	if(prestamosClienteAux != null){
							 for (Prestamo prestamo : prestamosClienteAux) {
                            	if(prestamo.getEstado().compareTo("Aprobado") == 0){
                            		contAux++;
                    %>
                                <option> <%=prestamo.getId_prestamo()%> </option>
                            
                    <%
                         }}}if(contAux == 0) {
                    	%>
                    	<option>NO TIENE PRÉSTAMOS APROBADOS</option>
                   <% }%>
                </select>
                
               <input class="buttons" type="submit" name="btnConsultarPagos" value="Consultar" id="btnConsultarPagos"></input> 
	
	</form>
	
	<%
	ArrayList<PrestamosXmovimientos> pagosPrestamos = (ArrayList<PrestamosXmovimientos>) request.getAttribute("pagosPrestamos");
	if(pagosPrestamos != null){ %>
	 <h1 class="titulo">Mis Pagos</h1>
    
       <%
            int itemsPerPage = 18;
            int totalPages = (int) Math.ceil((double) pagosPrestamos.size() / itemsPerPage);
            int currentPage = 1;
            if (request.getParameter("page") != null) {
                currentPage = Integer.parseInt(request.getParameter("page"));
            }
            int startIndex = (currentPage - 1) * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, pagosPrestamos.size());
        %>
        <h4> Información sobre el préstamo ID: <%= pagosPrestamos.get(0).getId_prestamo().getId_prestamo() %></h4>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID Movimiento</th>
                            <th scope="col">CBU Origen</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Importe</th>
                            <th scope="col">N° de cuota</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = startIndex; i < endIndex; i++) {
                            	PrestamosXmovimientos PrestamosXmovimientos = pagosPrestamos.get(i);
                        %>
                                <tr>
                                    <td><%= PrestamosXmovimientos.getId_movimiento().getId_movimiento() %></td>
                                    <td><%= PrestamosXmovimientos.getCBU().getCBU()%></td>
                                    <td><%= PrestamosXmovimientos.getId_movimiento().getFecha_Transaccion() %></td>
                                    <td><%= Utils.formatMoney(PrestamosXmovimientos.getId_movimiento().getImporte()) %></td>
                                    <td><%= i + 1 %></td>
								     <td><img class="icon-estado" src="Recursos/img/tick-verde.png"></td>                
                                    </tr>
                        <%
                                }
                            
                        %>
                    </tbody>
                </table>
                <div class="paginado">
                <% 
                    for (int i = 1; i <= totalPages; i++) {
                %>
                    <a href="?page=<%= i %>"><%= i %></a>

                <%
                    }
                %>
                   </div>
                   
              <form class="pagar" action="ServletCliente" method=post>   
              <%
              if((Boolean)request.getAttribute("debePagar") == true ){
              Prestamo prestamo = (Prestamo) request.getAttribute("prestamo_consultado");
              int nro_cuota = (int) request.getAttribute("nro_cuota");%>
              
              
              <h4> CUOTA N°: <%= nro_cuota  %> de <%= prestamo.getCant_cuotas() %></h4>
              <label name="monto_x_mes" id="monto_x_mes" value=<%=prestamo.getMonto_x_mes() %>> Monto cuota: <%= Utils.formatMoney(prestamo.getMonto_x_mes()) %> </label>
              
           <select required name="cbu_origen" id="cbu_origen">
                    <%
                       
                        ArrayList<Cuenta> cbu_origen = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentas_cliente_actual");
                        if (cbu_origen != null) {
                            for (Cuenta cuentaCliente : cbu_origen) {
                    %>
                                <option><%=cuentaCliente.getCBU()%></option>
                    <%
                            }
                        } else if(request.getAttribute("pagosPrestamos") == null) {
                    %>
                            <option>NO HAY PAGOS PARA MOSTRAR.</option>
                    <%
                        }
                    %>
                </select>
                
         <input type="hidden" name="prestamo" value="<%= prestamo.getId_prestamo() %>" id="prestamo"></input>       
        <input class="buttons" type="submit" name="btnRealizarpago" value="Realizar Pago" id="btnRealizarPago"></input>
            </form> 	  
            	  
             <% }else{%>    
              <h4> ¡Su préstamo está al día!</h4>
<%}%>
	</div>
	<%}else if(request.getAttribute("bandera") != null) { %>
			<h3 class="no-hay-pagos"> NO HAY PAGOS PARA MOSTRAR</h3>
	<%} %>
	
	<%
	if(request.getAttribute("pagoCorrectamente")!= null){
		
	if((Boolean)request.getAttribute("pagoCorrectamente")){
		%>
		<h4> Tu pago fue realizado correctamente.</h4>
	<%	
	}else{
		%>
		<h4> Error al realizar el pago - intente nuevamente.</h4>
	<% }
	
	}else{
		 String saldo_insuficiente = (String) request.getAttribute("saldo_insuficiente");
		if(saldo_insuficiente != null && saldo_insuficiente.length() > 0){
		%>
		<div class="alta-movimiento-error">
		   <%=saldo_insuficiente %>
		</div> 
	
		<%} %>
	
	<%} %>
	

</section>


    <footer class="Z-footer">
        <p>Todos los derechos reservados &copy; Globank 2023</p>
        <ul class="container-social-media">
            <li class="social-media"><img src="Recursos/img/facebook.png" alt="Facebook"> <a class="social-media"
                    href="#"> Facebook </a></li>
            <li class="social-media"><img src="Recursos/img/twitter.png" alt="Twitter"> <a class="social-media"
                    href="#"> Twitter</a></li>
            <li class="social-media"><img src="Recursos/img/instagram.png" alt="Instagram"> <a class="social-media"
                    href="#"> Instagram </a></li>
            <li class="social-media"><img src="Recursos/img/whatsapp.png" alt="Soporte Whatsapp"> <a
                    class="social-media" href="#">Soporte Whatsapp</a></li>
        </ul>
    </footer>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>


