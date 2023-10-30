package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.LocalidadDao;
import entidades.Localidad;
import entidades.Provincia;

public class LocalidadDaoImpl implements LocalidadDao{
	
	private static final String readall = "SELECT * FROM localidades";

	@Override
	public ArrayList<Localidad> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Localidad> lista = new ArrayList<Localidad>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				Localidad localidad = new Localidad();
				ProvinciaDaoImpl pDao = new ProvinciaDaoImpl();
				Provincia provincia = pDao.getProvinciaByID(resultSet.getInt("id_provincia"));
				
				localidad.setId(resultSet.getInt("id"));
				localidad.setId_provincia(provincia);
				localidad.setNombre_localidad(resultSet.getString("nombre_localidad"));
				
				lista.add(localidad);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lista;
	}

	@Override
	public Localidad getLocalidadByID(int id) {
		
		String getByID = "SELECT * FROM localidades WHERE id = " + id;
		Localidad localidad = new Localidad();
		
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
				ProvinciaDaoImpl pDao = new ProvinciaDaoImpl();
				Provincia provincia = pDao.getProvinciaByID(resultSet.getInt("id_provincia"));
				
				localidad.setId(resultSet.getInt("id"));
				localidad.setId_provincia(provincia);
				localidad.setNombre_localidad(resultSet.getString("nombre_localidad"));
			}
			
		conexion.cerrarConexion();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return localidad;
	}
}
