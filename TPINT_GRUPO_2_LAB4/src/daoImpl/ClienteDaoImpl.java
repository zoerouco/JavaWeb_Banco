package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.ClienteDao;



import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;

public class ClienteDaoImpl implements ClienteDao{
	
	private static final String readall = "SELECT * FROM clientes DNI INNER JOIN generos ON clientes.id_genero = "
			+ "generos.id_genero INNER JOIN localidades ON clientes.id_localidades = localidades.id INNER JOIN "
			+ "nacionalidades ON clientes.id_nacionalidad = nacionalidades.id INNER JOIN provincias ON "
			+ "clientes.id_provincia = provincias.id";
	
	private static final String insert = "INSERT INTO clientes(DNI, id_genero, id_nacionalidad, id_provincia, id_localidades, CUIL, nombre, apellido, fecha_nacimiento, direccion," + 
										"correo_electronico, telefono_primario, telefono_secundario, estado)" + 
										"SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?;";

	@Override
	public boolean insert(Cliente cliente) {
		return false;
		/*Conexion conexion = Conexion.getConexion();
		int filas=0;
		try {
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
			filas=statement.executeUpdate(insert);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return filas;*/
	}

	@Override
	public boolean delete(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
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
				Cliente cliente = new Cliente();
				Genero genero = new Genero();
				Nacionalidad nacionalidad = new Nacionalidad();
				Provincia provincia = new Provincia();
				Localidad localidad = new Localidad();
				
				//faltarian cargar los demas objetos
				cliente.setDNI(resultSet.getString("DNI"));
				genero.setId_genero(resultSet.getString("id_genero"));
				cliente.setId_genero(genero);
				nacionalidad.setId(resultSet.getInt("id_nacionalidad"));
				cliente.setId_nacionalidad(nacionalidad);
				provincia.setId(resultSet.getInt("id_provincia"));
				cliente.setId_provincia(provincia);
				localidad.setId(resultSet.getInt("id_localidades"));
				cliente.setCUIL(resultSet.getString("CUIL"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCorreo_electronico(resultSet.getString("correo_electronico"));
				cliente.setTelefono_primario(resultSet.getString("telefono_primario"));
				cliente.setTelefono_secundario(resultSet.getString("telefono_secundario"));
				cliente.setEstado(resultSet.getBoolean("estado"));	
				
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
