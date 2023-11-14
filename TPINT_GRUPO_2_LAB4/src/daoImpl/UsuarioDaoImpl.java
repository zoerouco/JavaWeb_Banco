package daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	private static final String readall = "SELECT * FROM usuarios";	
	private static final String update = "UPDATE usuarios SET usuarios.contraseña = ? WHERE usuarios.id_usuario = ?";
	
	@Override
	public Usuario getUsuarioxUser(String usuario) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Usuario u = null;
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				
				if (resultSet.getString("nombre_usuario").compareTo(usuario) == 0) {
					
					Cliente cliente = new Cliente();
					u = new Usuario();
					
					u.setId(resultSet.getString("id_usuario"));
					cliente.setDNI(resultSet.getString("DNI"));
					u.setDni(cliente);
					u.setEsAdmin(resultSet.getBoolean("esAdmin"));
					u.setIdRef(resultSet.getInt("id_ref"));
					u.setContraseña(resultSet.getString("contraseña"));
					u.setNombreUsuario(resultSet.getString("nombre_usuario"));
					u.setEstado(resultSet.getBoolean("estado"));

				
					conexion.cerrarConexion();
					return u;
					
				}
				
			}

		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return u;
	}
	
	public Usuario getUsuarioxDNI(String dni) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Usuario u = null;
		Conexion conexion = Conexion.getConexion();
		String query =  "SELECT * FROM usuarios WHERE DNI = " + dni;
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				u = new Usuario();
				
				u.setId(resultSet.getString("id_usuario"));
				cliente.setDNI(resultSet.getString("DNI"));
				u.setDni(cliente);
				u.setEsAdmin(resultSet.getBoolean("esAdmin"));
				u.setIdRef(resultSet.getInt("id_ref"));
				u.setContraseña(resultSet.getString("contraseña"));
				u.setNombreUsuario(resultSet.getString("nombre_usuario"));
				u.setEstado(resultSet.getBoolean("estado"));
				
			}

		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return u;
	}
	
	public boolean updatePassword(Usuario usuario) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, usuario.getContraseña());
			statement.setInt(2, Integer.parseInt(usuario.getId()));
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdateExitoso;
	}
}
