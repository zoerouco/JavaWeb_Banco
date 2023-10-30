package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.LocalidadDao;
import entidades.Localidad;

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
				//ProvinciaNegocioImpl pNeg = new ProvinciaNegocioImpl();
				//pNeg.getObjectbyID();
				
				localidad.setId(resultSet.getInt("id_localidades"));
				//localidad.setId_provincia(pNeg);
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
		// TODO Auto-generated method stub
		return null;
	}
}
