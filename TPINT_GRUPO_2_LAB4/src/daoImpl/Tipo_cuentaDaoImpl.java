package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.Tipo_cuentaDao;
import entidades.Tipo_cuenta;

public class Tipo_cuentaDaoImpl implements Tipo_cuentaDao {

	private static final String readall = "SELECT * FROM tipo_cuenta";

	@Override
	public ArrayList<Tipo_cuenta> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Tipo_cuenta> lista = new ArrayList<Tipo_cuenta>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				Tipo_cuenta tipo_cuenta = new Tipo_cuenta();
				
				tipo_cuenta.setId_tipo(resultSet.getString("id_tipo"));
				tipo_cuenta.setDescripcion(resultSet.getString("descripcion"));
				
				lista.add(tipo_cuenta);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lista;
	}

	@Override
	public Tipo_cuenta getTipo_cuentaByID(String id_tipo) {
		
		String getByID = "SELECT * FROM tipo_cuenta WHERE id_tipo = '" + id_tipo + "'";
		Tipo_cuenta tipo_cuenta = new Tipo_cuenta();
		
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
				tipo_cuenta.setId_tipo(resultSet.getString("id_tipo"));
				tipo_cuenta.setDescripcion(resultSet.getString("descripcion"));
			}
			
		conexion.cerrarConexion();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tipo_cuenta;
	}
}
