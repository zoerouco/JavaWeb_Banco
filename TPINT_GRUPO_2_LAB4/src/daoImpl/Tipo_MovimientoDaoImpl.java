package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.Tipo_MovimientoDao;
import entidades.Tipo_Movimiento;


public class Tipo_MovimientoDaoImpl implements Tipo_MovimientoDao{


	private static final String readall = "SELECT * FROM tipo_movimiento";
	
	
	@Override
	public ArrayList<Tipo_Movimiento> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Tipo_Movimiento> lista = new ArrayList<Tipo_Movimiento>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				Tipo_Movimiento Tipo_Movimiento = new Tipo_Movimiento();
				
				Tipo_Movimiento.setId_tipo(resultSet.getString("id_tipo"));
				Tipo_Movimiento.setDescripcion(resultSet.getString("descripcion"));
				
				lista.add(Tipo_Movimiento);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lista;
}


	@Override
	public Tipo_Movimiento getTipo_MovimientoByID(String id_tipo) {
		String getByID = "SELECT * FROM tipo_movimiento WHERE id_tipo = '" + id_tipo + "'";
		Tipo_Movimiento tipo_movimiento = new Tipo_Movimiento();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(getByID);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				tipo_movimiento.setId_tipo(resultSet.getString("id_tipo"));
				tipo_movimiento.setDescripcion(resultSet.getString("descripcion"));
			}
			
		conexion.cerrarConexion();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tipo_movimiento;
	}
	}
