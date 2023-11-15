package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PrestamosXmovimientosDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Prestamo;
import entidades.PrestamosXmovimientos;
import entidades.Tipo_Movimiento;
import entidades.Tipo_cuenta;

public class PrestamosXmovimientosDaoImpl implements PrestamosXmovimientosDao {
	
	
	private static final String readall = "SELECT * FROM movimientosxprestamos inner join prestamos on movimientosxprestamos.id_prestamo = prestamos.id_prestamo " +
	"inner join movimientos on movimientosxprestamos.id_movimiento = movimientos.id_movimiento and movimientosxprestamos.CBU = movimientos.CBU inner join cuentas on movimientos.CBU = cuentas.CBU where movimientosxprestamos.id_prestamo = ?";
	
	private static final String insert = "CALL AgregarMovimientoxPrestamo(?, ?, ?)";
	
	
	public ArrayList<PrestamosXmovimientos> readAll(){

		return null;

	}
	
	public ArrayList<PrestamosXmovimientos> getPrestamosXmovimientosByID(int id_prestamo){
		
		ArrayList<PrestamosXmovimientos> pagosPrestamos = new ArrayList<PrestamosXmovimientos>();
		Prestamo prestamo = new Prestamo();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Conexion conexion = Conexion.getConexion();
		
		try{
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setInt(1, id_prestamo);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
					
				PrestamosXmovimientos pxm = new PrestamosXmovimientos();
				Movimiento movimiento = new Movimiento();
				Cuenta cuenta = new Cuenta();
				Cuenta cuenta_solicitante = new Cuenta();
				Cuenta cuenta_dest = new Cuenta();
				Cliente cliente = new Cliente();
				Tipo_Movimiento tm = new Tipo_Movimiento();
				Tipo_cuenta tp = new Tipo_cuenta();
				
				cliente.setDNI(resultSet.getString("DNI"));
				
				tp.setId_tipo(resultSet.getString(21));
				
				tm.setId_tipo(resultSet.getString(14));
				
				cuenta_solicitante.setCBU(resultSet.getString(5));
				
				cuenta_dest.setCBU(resultSet.getString("CBU_destino"));
				
				cuenta.setDNI(cliente);
				cuenta.setCBU(resultSet.getString("CBU"));
				cuenta.setFecha_creacion(resultSet.getDate("fecha_creacion"));
				cuenta.setId_tipo(tp);
				cuenta.setNro_cuenta(resultSet.getString("nro_cuenta"));
				cuenta.setSaldo(resultSet.getFloat("saldo"));
				cuenta.setEstado(resultSet.getBoolean(26));
				
				movimiento.setId_movimiento(resultSet.getInt("id_movimiento"));
				movimiento.setCBU(cuenta);
				movimiento.setCBU_Destino(cuenta_dest);
				movimiento.setDetalle(resultSet.getString("detalle"));
				movimiento.setImporte(resultSet.getFloat("importe"));
				movimiento.setTipoMovimiento(tm);
                movimiento.setFecha_Transaccion(resultSet.getDate("fecha"));
				
				prestamo.setId_prestamo(resultSet.getInt("id_prestamo"));
				prestamo.setCBU(cuenta_solicitante);
				prestamo.setFecha_realizacion(resultSet.getDate("fecha_realizacion"));
				prestamo.setImporte_pedido(resultSet.getFloat("importe_pedido"));
				prestamo.setCant_cuotas(resultSet.getInt("cantidad_cuotas"));
				prestamo.setMonto_x_mes(resultSet.getFloat("monto_x_mes"));
				prestamo.setImporte_con_intereses(resultSet.getFloat("importe_con_intereses"));
				prestamo.setEstado(resultSet.getString(11));
				
				
				pxm.setId_movimiento(movimiento);
				pxm.setCBU(cuenta);
				pxm.setId_prestamo(prestamo);
					
				pagosPrestamos.add(pxm);		
			}
			
		conexion.cerrarConexion();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return pagosPrestamos;
	}

	@Override
	public boolean insert(PrestamosXmovimientos pxm) {
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		
		try {
			CallableStatement statement = conexion.prepareCall(insert);
			
			statement.setInt(1, pxm.getId_movimiento().getId_movimiento());
			statement.setString(2, pxm.getCBU().getCBU());
			statement.setInt(3, pxm.getId_prestamo().getId_prestamo());
		
						
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
	
	
}
