package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.ProvinciaDao;
import entidades.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao{
	
	private static final String readall = "SELECT * FROM provincias";

	@Override
	public ArrayList<Provincia> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Provincia> lista = new ArrayList<Provincia>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				Provincia provincia = new Provincia();
				
				provincia.setId(resultSet.getInt("id"));
				provincia.setNombre_provincia(resultSet.getString("nombre_provincia"));
				
				lista.add(provincia);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lista;
	}

	@Override
	public Provincia getProvinciaByID(int id) {
		
		String getByID = "SELECT * FROM provincias WHERE id = " + id;
		Provincia provincia = new Provincia();
		
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
				provincia.setId(resultSet.getInt("id"));
				provincia.setNombre_provincia(resultSet.getString("nombre_provincia"));
			}
		conexion.cerrarConexion();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return provincia;
	}
}
