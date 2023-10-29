package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "root";
	private String DBname = "bdglobank?useSSL=false";
	public static Conexion instancia;
	private Connection connection;
			
	private Conexion(){
		try { 
			this.connection = DriverManager.getConnection(host+DBname,user,password);
			this.connection.setAutoCommit(false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
				
	public static Conexion getConexion()   
	{								
		if(instancia == null) instancia = new Conexion();
		return instancia;
	}

	public Connection getSQLConexion() {return this.connection;}
			
	public void cerrarConexion()
	{
		try {
			this.connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		instancia = null;
	}
}
