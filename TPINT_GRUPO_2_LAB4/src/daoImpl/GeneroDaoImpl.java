package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.GeneroDao;
import entidades.Genero;

public class GeneroDaoImpl implements GeneroDao {
	
	private static final String readall = "SELECT * FROM generos";

	@Override
	public ArrayList<Genero> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Genero> lista = new ArrayList<Genero>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				Genero genero = new Genero();
				
				genero.setId_genero(resultSet.getString("id_genero"));
				genero.setDescripcion(resultSet.getString("descripcion"));
				
				lista.add(genero);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lista;
	}

	@Override
	public Genero getGeneroByID(String id_genero) {
		
		String getByID = "SELECT * FROM generos WHERE id_genero = '" + id_genero + "'";
		Genero genero = new Genero();
		
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
				
				genero.setId_genero(resultSet.getString("id_genero"));
				genero.setDescripcion(resultSet.getString("descripcion"));
			}
		
		conexion.cerrarConexion();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return genero;
	}

}
