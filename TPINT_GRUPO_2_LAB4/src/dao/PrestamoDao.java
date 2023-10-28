package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

import entidades.Cuenta;
import entidades.Prestamo;



public class PrestamoDao {
	
		
		private String host = "jdbc:mysql://localhost:3306/";
		private String user = "root";
		private String password = "root";
		private String DBname = "bdglobank?useSSL=false";
		private static final String readall = "SELECT * FROM prestamos";

			
		
		public ArrayList<Prestamo> getAllPrestamos() {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
			
			Connection connection = null;
			try{
				
				connection = (Connection) DriverManager.getConnection(host + DBname, user, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(readall);
				
				while(resultSet.next()){
					
					//clases necesarias para crear un obj prestamo
					Prestamo prestamo = new Prestamo("x"); //pasa por el constructor que no incrementa prestamos.
					Cuenta cuenta = new Cuenta();
					
					prestamo.setId_prestamo(resultSet.getString("id_prestamo"));
					cuenta.setCBU(resultSet.getString("CBU"));
					prestamo.setCBU(cuenta);
					prestamo.setFecha_realizacion(resultSet.getDate("fecha_realizacion"));
					prestamo.setImporte_con_intereses(resultSet.getFloat("importe_con_intereses"));
					prestamo.setImporte_pedido(resultSet.getFloat("importe_pedido"));
					prestamo.setMonto_x_mes(resultSet.getFloat("monto_x_mes"));
					prestamo.setCant_cuotas(resultSet.getInt("cantidad_cuotas"));
					prestamo.setEstado(resultSet.getBoolean("estado"));	
					
					lista.add(prestamo);
							
				}
				
			connection.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return lista;
		}

	}

	
	


