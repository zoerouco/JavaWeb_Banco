package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Prestamo;

public class MovimientoDao {
	
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "root";
	private String DBname = "bdglobank?useSSL=false";
	private static final String readall = "SELECT * FROM prestamos";

		
	
	public ArrayList<Movimiento> getAllMovimientos() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		
		Connection connection = null;
		try{
			
			connection = (Connection) DriverManager.getConnection(host + DBname, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(readall);
			
			while(resultSet.next()){
				
				//clases necesarias para crear un obj Movimiento
				Movimiento movimiento = new Movimiento();
				Cuenta cuenta = new Cuenta();	
				Cuenta cuentaDest = new Cuenta();	
				// Cargar los atributos
				Cuenta cbu = movimiento.getCBU();
				Cuenta cbuDestino = movimiento.getCBU_Destino();
				Date fechaTransaccion = movimiento.getFecha_Transaccion();
				int importe = movimiento.getImporte();
				String detalle = movimiento.getDetalle();
				String tipoMovimiento = movimiento.getTipoMovimiento();
				boolean estado = movimiento.isEstado();
				
				
	
														
				lista.add(movimiento);
						
			}
			
		connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}


}
