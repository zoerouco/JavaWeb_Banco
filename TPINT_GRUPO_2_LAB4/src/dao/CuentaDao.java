package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;


public class CuentaDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "root";
	private String DBname = "bdglobank?useSSL=false";
	private static final String readall = "SELECT * FROM cuentas";
	
	public int agregarCuenta(Cuenta cuenta) {
		
		String query = "INSERT INTO cuentas(CBU,id_tipo,DNI,nro_cuenta,saldo) values ('" + cuenta.getCBU() + "','" + cuenta.getId_tipo() + "'," + cuenta.getDNI() + ",  " + cuenta.getNro_cuenta() + ", "+ cuenta.getSaldo() +")";
		
		 
		Connection conn = null;
		int filas=0;
		try {
			conn = DriverManager.getConnection(host + DBname, user, password);
			Statement st = conn.createStatement();
			filas=st.executeUpdate(query);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return filas;
		
	}
	
	
	public ArrayList<Cuenta> getAllCuentas() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		Connection connection = null;
		try{
			
			connection = DriverManager.getConnection(host + DBname, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(readall);
			
			while(resultSet.next()){
				
				//clases necesarias para crear un obj cliente
				Cuenta cuenta = new Cuenta();
				Cliente cliente = new Cliente();
				Tipo_cuenta tipoCuenta = new Tipo_cuenta();
				
				cuenta.setCBU(resultSet.getString("CBU"));
				tipoCuenta.setId_tipo(resultSet.getString("id_tipo"));
				cuenta.setId_tipo(tipoCuenta);
				cliente.setDNI(resultSet.getString("DNI"));
				cuenta.setDNI(cliente);
				cuenta.setFecha_creacion(resultSet.getDate("fecha_creacion"));
				cuenta.setNro_cuenta(resultSet.getString("nro_cuenta"));
				cuenta.setSaldo(resultSet.getFloat("saldo"));
				cuenta.setEstado(resultSet.getBoolean("estado"));
				
				lista.add(cuenta);
			}
			
		connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	public ArrayList <Cuenta> getCuentasXDNI(Cliente cliente){
		
		String DNI = cliente.getDNI();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		Connection connection = null;
		
		try{
			
			connection =  DriverManager.getConnection(host + DBname, user, password);
			Statement st = connection.createStatement();
	        ResultSet resultSet = st.executeQuery(readall);
		
			
			while(resultSet.next()){
				
				if(resultSet.getString("DNI").compareTo(cliente.getDNI()) == 0) {
					
				//clases necesarias para crear un obj Cuenta
				Cuenta cuenta = new Cuenta();
				Tipo_cuenta tipoCuenta = new Tipo_cuenta();
				
				cuenta.setCBU(resultSet.getString("CBU"));
				tipoCuenta.setId_tipo(resultSet.getString("id_tipo"));
				cuenta.setId_tipo(tipoCuenta);
				cliente.setDNI(resultSet.getString("DNI"));
				cuenta.setDNI(cliente);
				cuenta.setFecha_creacion(resultSet.getDate("fecha_creacion"));
				cuenta.setNro_cuenta(resultSet.getString("nro_cuenta"));
				cuenta.setSaldo(resultSet.getFloat("saldo"));
				cuenta.setEstado(resultSet.getBoolean("estado"));
				
				lista.add(cuenta);
			}
				
			}
			
		connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
		
		
		
		
	}
	
	

}
