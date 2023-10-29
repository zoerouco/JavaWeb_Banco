package daoImpl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	private static final String readall = "SELECT * FROM usuarios";
	
	
	@Override
	public Usuario getUsuarioxUser(String usuario) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		Usuario u = new Usuario();
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				
				if(resultSet.getString("id_usuario").compareTo(usuario) == 0) {
					
					
					//clases
					Cliente cliente = new Cliente();
				
					
					u.setId(resultSet.getString("id_usuario"));
					cliente.setDNI(resultSet.getString("DNI"));
					u.setDni(cliente);
					u.setEsAdmin(resultSet.getBoolean("esAdmin"));
					u.setIdRef(resultSet.getInt("id_ref"));
					u.setContrase�a(resultSet.getString("contrase�a"));
					u.setNombreUsuario(resultSet.getString("nombre_usuario"));
					u.setEstado(resultSet.getBoolean("estado"));

				
					
					return u;
					
				}
				
			}

		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return u;
	}
}