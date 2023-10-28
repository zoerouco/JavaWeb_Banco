package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import entidades.Cuenta;


public class CuentaDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "root";
	private String DBname = "bdglobank";
	
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

}
