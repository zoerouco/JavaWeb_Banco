package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;


import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;

public class ClienteDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "root";
	private String DBname = "bdglobank?useSSL=false";
	private static final String readall = "SELECT * FROM clientes";

		
	
	public ArrayList<Cliente> getAllClientes() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		Connection connection = null;
		try{
			
			connection = (Connection) DriverManager.getConnection(host + DBname, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(readall);
			
			while(resultSet.next()){
				
				//clases necesarias para crear un obj cliente
				Cliente cliente = new Cliente();
				Genero genero = new Genero();
				Nacionalidad nacionalidad = new Nacionalidad();
				Provincia provincia = new Provincia();
				Localidad localidad = new Localidad();
				
				
				cliente.setDNI(resultSet.getString("DNI"));
				genero.setId_genero(resultSet.getString("id_genero"));
				cliente.setId_genero(genero);
				nacionalidad.setId(resultSet.getInt("id_nacionalidad"));
				cliente.setId_nacionalidad(nacionalidad);
				provincia.setId(resultSet.getInt("id_provincia"));
				cliente.setId_provincia(provincia);
				localidad.setId(resultSet.getInt("id_localidades"));
				cliente.setCUIL(resultSet.getString("CUIL"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCorreo_electronico(resultSet.getString("correo_electronico"));
				cliente.setTelefono_primario(resultSet.getString("telefono_primario"));
				cliente.setTelefono_secundario(resultSet.getString("telefono_secundario"));
				cliente.setEstado(resultSet.getBoolean("estado"));	
				
				lista.add(cliente);
			}
			
		connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	public Cliente getClientexDNI (String DNI) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Cliente cliente = new Cliente();
		Connection connection = null;
		try{			
			connection =  DriverManager.getConnection(host + DBname, user, password);
			Statement st = connection.createStatement();
	        ResultSet resultSet = st.executeQuery(readall);
		
			while(resultSet.next()){
				
				if(resultSet.getString("DNI").compareTo(DNI) == 0) {
					
				//clases necesarias para crear un obj cliente
				Genero genero = new Genero();
				Nacionalidad nacionalidad = new Nacionalidad();
			
				Provincia provincia = new Provincia();
				Localidad localidad = new Localidad();
				
				cliente.setDNI(resultSet.getString("DNI"));
				genero.setId_genero(resultSet.getString("id_genero"));
				cliente.setId_genero(genero);
				nacionalidad.setId(resultSet.getInt("id_nacionalidad"));
				cliente.setId_nacionalidad(nacionalidad);
				provincia.setId(resultSet.getInt("id_provincia"));
				cliente.setId_provincia(provincia);
				localidad.setId(resultSet.getInt("id_localidades"));
				cliente.setCUIL(resultSet.getString("CUIL"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCorreo_electronico(resultSet.getString("correo_electronico"));
				cliente.setTelefono_primario(resultSet.getString("telefono_primario"));
				cliente.setTelefono_secundario(resultSet.getString("telefono_secundario"));
				cliente.setEstado(resultSet.getBoolean("estado"));	
				
				connection.close();
				return cliente;
				
			}
				
			}
			
		connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cliente;
			
		
		
	}

}
