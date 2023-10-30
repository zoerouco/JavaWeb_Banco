package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.NacionalidadDao;
import entidades.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao{
	
	private static final String readall = "SELECT * FROM nacionalidades";
	
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
		
		String getByID = "SELECT * FROM nacionalidades WHERE id = " + id;
		Nacionalidad nacionalidad = new Nacionalidad();
		
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
				nacionalidad.setId(resultSet.getInt("id"));
				nacionalidad.setCode(resultSet.getShort("code"));
				nacionalidad.setIso3166a1(resultSet.getString("iso3166a1"));
				nacionalidad.setIso3166a2(resultSet.getString("iso3166a2"));
				nacionalidad.setNombre_pais(resultSet.getString("nombre_pais"));
			}
			
		conexion.cerrarConexion();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return nacionalidad;
	}
}
