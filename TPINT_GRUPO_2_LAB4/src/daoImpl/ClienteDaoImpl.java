package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import dao.ClienteDao;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;

public class ClienteDaoImpl implements ClienteDao{
	
	private static final String insert = "CALL AgregarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE clientes SET estado = 0 WHERE DNI = ?";
	private static final String readall = "SELECT * FROM clientes " 
		    + "INNER JOIN generos ON clientes.id_genero = generos.id_genero "
		    + "INNER JOIN localidades ON clientes.id_localidades = localidades.id "
		    + "INNER JOIN nacionalidades ON clientes.id_nacionalidad = nacionalidades.id "
		    + "INNER JOIN provincias ON clientes.id_provincia = provincias.id";

	@Override
	public boolean insert(Cliente cliente) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		
		try {
			CallableStatement statement = conexion.prepareCall(insert);
			statement.setString(1, cliente.getDNI());
			statement.setString(2, cliente.getId_genero().getId_genero());
			statement.setInt(3, cliente.getId_nacionalidad().getId());
			statement.setInt(4, cliente.getId_provincia().getId());
			statement.setInt(5, cliente.getId_localidades().getId());
			statement.setString(6, cliente.getCUIL());
			statement.setString(7, cliente.getNombre());
			statement.setString(8, cliente.getApellido());
			statement.setDate(9, cliente.getFecha_nacimiento());
			statement.setString(10, cliente.getDireccion());
			statement.setString(11, cliente.getCorreo_electronico());
			statement.setString(12, cliente.getTelefono_primario());
			statement.setString(13, cliente.getTelefono_secundario());
			statement.setBoolean(14, true);
						
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
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
		
		return isInsertExitoso;
	}

	@Override
	public boolean delete(Cliente cliente) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, cliente.getDNI());
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	@Override
	public ArrayList<Cliente> readAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				//clases necesarias para crear un obj cliente
				Genero genero = new Genero();
				genero.setId_genero(resultSet.getString("id_genero"));
				genero.setDescripcion(resultSet.getString("descripcion"));
				
				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setId(resultSet.getInt("id_nacionalidad"));
				nacionalidad.setCode(resultSet.getShort("code"));
				nacionalidad.setIso3166a1(resultSet.getString("iso3166a1"));
				nacionalidad.setIso3166a2(resultSet.getString("iso3166a2"));
				nacionalidad.setNombre_pais(resultSet.getString("nombre_pais"));
				
				Provincia provincia = new Provincia();
				provincia.setId(resultSet.getInt("id_provincia"));
				provincia.setNombre_provincia(resultSet.getString("nombre_provincia"));
				
				Localidad localidad = new Localidad();
				localidad.setId(resultSet.getInt("id_localidades"));
				localidad.setId_provincia(provincia);
				localidad.setNombre_localidad(resultSet.getString("nombre_localidad"));
				
				Cliente cliente = new Cliente();
				cliente.setDNI(resultSet.getString("DNI"));
				cliente.setId_genero(genero);
				cliente.setId_nacionalidad(nacionalidad);
				cliente.setId_provincia(provincia);
				cliente.setId_localidades(localidad);
				cliente.setCUIL(resultSet.getString("CUIL"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCorreo_electronico(resultSet.getString("correo_electronico"));
				cliente.setTelefono_primario(resultSet.getString("telefono_primario"));
				cliente.setTelefono_secundario(resultSet.getString("telefono_secundario"));
			
				lista.add(cliente);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Cliente getClientexDNI (String DNI) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Cliente cliente = new Cliente();
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				
				if(resultSet.getString("DNI").compareTo(DNI) == 0) {
					
					//clases necesarias para crear un obj cliente
					Genero genero = new Genero();
					Nacionalidad nacionalidad = new Nacionalidad();
				
					Provincia provincia = new Provincia();
					Localidad localidad = new Localidad();
					
					cliente.setDNI(resultSet.getString("DNI"));
					genero.setId_genero(resultSet.getString("id_genero"));
					cliente.setId_genero(genero);
					nacionalidad.setId(resultSet.getInt("id_nacionalidad"));
					cliente.setId_nacionalidad(nacionalidad);
					provincia.setId(resultSet.getInt("id_provincia"));
					cliente.setId_provincia(provincia);
					localidad.setId(resultSet.getInt("id_localidades"));
					cliente.setId_localidades(localidad);
					cliente.setCUIL(resultSet.getString("CUIL"));
					cliente.setNombre(resultSet.getString("nombre"));
					cliente.setApellido(resultSet.getString("apellido"));
					cliente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
					cliente.setDireccion(resultSet.getString("direccion"));
					cliente.setCorreo_electronico(resultSet.getString("correo_electronico"));
					cliente.setTelefono_primario(resultSet.getString("telefono_primario"));
					cliente.setTelefono_secundario(resultSet.getString("telefono_secundario"));
					cliente.setEstado(resultSet.getBoolean("estado"));	
					
					return cliente;
					
				}
				
			}

		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cliente;
	}
}
