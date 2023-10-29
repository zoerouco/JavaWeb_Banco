package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.PrestamoDao;
import entidades.Cuenta;
import entidades.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao{
	
	private static final String readall = "SELECT * FROM prestamos";
		
	@Override
	public boolean insert(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
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
				Prestamo prestamo = new Prestamo("x"); //pasa por el constructor que no incrementa prestamos.
				Cuenta cuenta = new Cuenta();
					
				prestamo.setId_prestamo(resultSet.getString("id_prestamo"));
				cuenta.setCBU(resultSet.getString("CBU")); //habria que llamar a lo demas en la query
				prestamo.setCBU(cuenta);
				prestamo.setFecha_realizacion(resultSet.getDate("fecha_realizacion"));
				prestamo.setImporte_con_intereses(resultSet.getFloat("importe_con_intereses"));
				prestamo.setImporte_pedido(resultSet.getFloat("importe_pedido"));
				prestamo.setMonto_x_mes(resultSet.getFloat("monto_x_mes"));
				prestamo.setCant_cuotas(resultSet.getInt("cantidad_cuotas"));
				prestamo.setEstado(resultSet.getBoolean("estado"));	
					
				lista.add(prestamo);		
			}
			
		conexion.cerrarConexion();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
}