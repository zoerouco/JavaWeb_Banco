package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.NacionalidadDao;
import entidades.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao{
	
	private static final String readall = "SELECT * FROM nacionalidades";
	private static final String getByID = "SELECT * FROM nacionalidades WHERE id = ?";
	

	@Override
	public ArrayList<Nacionalidad> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Nacionalidad> lista = new ArrayList<Nacionalidad>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				Nacionalidad nacionalidad = new Nacionalidad();
				
				nacionalidad.setId(resultSet.getInt("id"));
				nacionalidad.setCode(resultSet.getShort("code"));
				nacionalidad.setIso3166a1(resultSet.getString("iso3166a1"));
				nacionalidad.setIso3166a2(resultSet.getString("iso3166a2"));
				nacionalidad.setNombre_pais(resultSet.getString("nombre_pais"));
				
				lista.add(nacionalidad);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Nacionalidad getNacionalidadByID(int id) {
		return null;
		/*
		Nacionalidad nacionalidad = new Nacionalidad();
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			statement = conexion.prepareStatement(getByID);
			statement.setInt(1, id);
			if(statement.executeUpdate() > 0) {
				conexion.commit();
			}
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return nacionalidad;*/
	}
}
