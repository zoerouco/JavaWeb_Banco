package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.PrestamoDao;
import entidades.Cuenta;
import entidades.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao{
	
	private static final String readall = "SELECT * FROM prestamos";
	private static final String getPrestamosxCBU = "SELECT * FROM prestamos where CBU = ?";
		
	@Override
	public boolean insert(Prestamo prestamo) {
		
	String query =  "CALL AgregarPrestamo(?, ?, ?, ?, ?, ?, ?)";
	
	PreparedStatement statement;
	Connection conexion = Conexion.getConexion().getSQLConexion();
	boolean isInsertExitoso = false;
	
	try {
		statement = conexion.prepareStatement(query);
		statement.setInt(1, prestamo.getId_prestamo());
		statement.setString(2, prestamo.getCBU().getCBU());
		statement.setFloat(3, prestamo.getImporte_con_intereses());
		statement.setFloat(4, prestamo.getImporte_pedido());
		statement.setFloat(5, prestamo.getMonto_x_mes());
		statement.setInt(6, prestamo.getCant_cuotas());
		statement.setString(7, prestamo.getEstado());

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
	public boolean delete(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Prestamo> readAll() {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try{
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
					
				//clases necesarias para crear un obj prestamo
				Prestamo prestamo = new Prestamo(); //pasa por el constructor que no incrementa prestamos.
				Cuenta cuenta = new Cuenta();
					
				prestamo.setId_prestamo(resultSet.getInt("id_prestamo"));
				cuenta.setCBU(resultSet.getString("CBU")); //habria que llamar a lo demas en la query
				prestamo.setCBU(cuenta);
				prestamo.setFecha_realizacion(resultSet.getDate("fecha_realizacion"));
				prestamo.setImporte_con_intereses(resultSet.getFloat("importe_con_intereses"));
				prestamo.setImporte_pedido(resultSet.getFloat("importe_pedido"));
				prestamo.setMonto_x_mes(resultSet.getFloat("monto_x_mes"));
				prestamo.setCant_cuotas(resultSet.getInt("cantidad_cuotas"));
				prestamo.setEstado(resultSet.getString("estado"));	
					
				lista.add(prestamo);		
			}
			
		conexion.cerrarConexion();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public int getUltimoID() {
		
	    int UltimoId = 0;

	    Conexion conexion = Conexion.getConexion();

	    try {
	        PreparedStatement statement = conexion.getSQLConexion().prepareStatement("SELECT MAX(id_prestamo) AS maxId FROM prestamos");
	        ResultSet resultSet = statement.executeQuery();
	        
	
	        if (resultSet.next()) {
	            UltimoId = resultSet.getInt("maxId");
	        }

	  
	        conexion.cerrarConexion();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return UltimoId;
	}
	
	public ArrayList<Prestamo> getPrestamoxCuentas (ArrayList<Cuenta> cuentasCliente) {
		
		ArrayList<Prestamo> prestamosCliente = new ArrayList<Prestamo>();
		Cuenta cuentaAux = new Cuenta();
		Boolean bandera = false;
		
		int length = cuentasCliente.size();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Conexion conexion = Conexion.getConexion();
		
		try{
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				for(int i= 0; i<length; i++) {
					
					cuentaAux = cuentasCliente.get(i);
					
					if(resultSet.getString("CBU").compareTo(cuentaAux.getCBU()) == 0) bandera = true;
					else bandera = false;
					
					
					if(bandera)
					{
						
						Cuenta cuenta = new Cuenta();
						//clases necesarias para crear un obj prestamo
						Prestamo prestamo = new Prestamo();
						prestamo.setId_prestamo(resultSet.getInt("id_prestamo"));
						cuenta.setCBU(resultSet.getString("CBU")); //habria que llamar a lo demas en la query
						cuenta.setDNI(cuentaAux.getDNI());
						cuenta.setEstado(cuentaAux.getEstado());
						cuenta.setFecha_creacion(cuentaAux.getFecha_creacion());
						cuenta.setSaldo(cuentaAux.getSaldo());
						cuenta.setNro_cuenta(cuentaAux.getNro_cuenta());
						cuenta.setId_tipo(cuentaAux.getId_tipo());
						prestamo.setCBU(cuenta);
						prestamo.setFecha_realizacion(resultSet.getDate("fecha_realizacion"));
						prestamo.setImporte_con_intereses(resultSet.getFloat("importe_con_intereses"));
						prestamo.setImporte_pedido(resultSet.getFloat("importe_pedido"));
						prestamo.setMonto_x_mes(resultSet.getFloat("monto_x_mes"));
						prestamo.setCant_cuotas(resultSet.getInt("cantidad_cuotas"));
						prestamo.setEstado(resultSet.getString("estado"));	
							
						prestamosCliente.add(prestamo);
					}
	
				}
	
			}
			
		conexion.cerrarConexion();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return prestamosCliente;

		
	}
	
	
	
	public ArrayList<Prestamo> getPrestamosxCBU (String CBU){
		
		ArrayList<Prestamo> prestamosxCBU = new ArrayList<Prestamo>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		
		try{
		    statement = conexion.getSQLConexion().prepareStatement(getPrestamosxCBU);
		    statement.setString(1, CBU);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
						Cuenta cuenta = new Cuenta();
						Prestamo prestamo = new Prestamo();
						prestamo.setId_prestamo(resultSet.getInt("id_prestamo"));
						cuenta.setCBU(resultSet.getString("CBU")); 
						prestamo.setCBU(cuenta);
						prestamo.setFecha_realizacion(resultSet.getDate("fecha_realizacion"));
						prestamo.setImporte_con_intereses(resultSet.getFloat("importe_con_intereses"));
						prestamo.setImporte_pedido(resultSet.getFloat("importe_pedido"));
						prestamo.setMonto_x_mes(resultSet.getFloat("monto_x_mes"));
						prestamo.setCant_cuotas(resultSet.getInt("cantidad_cuotas"));
						prestamo.setEstado(resultSet.getString("estado"));	
							
						prestamosxCBU.add(prestamo);
					}
	
	
		conexion.cerrarConexion();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return prestamosxCBU;

	}
}
