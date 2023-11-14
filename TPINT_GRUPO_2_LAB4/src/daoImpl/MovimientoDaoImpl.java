package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Collections;
import java.util.List;


import java.sql.CallableStatement;


import dao.MovimientoDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Genero;
import entidades.Localidad;
import entidades.Movimiento;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.Tipo_Movimiento;
import entidades.Tipo_cuenta;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import sun.util.resources.cldr.pt.TimeZoneNames_pt_PT;

public class MovimientoDaoImpl implements MovimientoDao {
	
	
	private static final String readall = "SELECT * FROM movimientos INNER JOIN tipo_movimiento ON movimientos.id_tipo = tipo_movimiento.id_tipo";	
	private static final String read = "SELECT * FROM movimientos INNER JOIN tipo_movimiento ON movimientos.id_tipo = tipo_movimiento.id_tipo";
	private static final String movimientosXcuenta = "SELECT * FROM movimientos" + 
			" INNER JOIN tipo_movimiento ON movimientos.id_tipo = tipo_movimiento.id_tipo" + 
			" WHERE CBU = ?" +
			" ORDER BY id_movimiento DESC";
	
	/*private static final String movimientosXcuentaEmisoras = "SELECT * FROM movimientos" + 
			" INNER JOIN tipo_movimiento ON movimientos.id_tipo = tipo_movimiento.id_tipo" + 
			" WHERE CBU = ? and detalle = 'transferencia_enviada'" +
			" ORDER BY id_movimiento DESC";
	
	private static final String movimientosXcuentaReceptoras = "SELECT * FROM movimientos" + 
			" INNER JOIN tipo_movimiento ON movimientos.id_tipo = tipo_movimiento.id_tipo" + 
			" WHERE CBU_destino = ? and detalle = 'transferencia_recibida' " +
			" ORDER BY id_movimiento DESC";*/
	
	CuentaDaoImpl cuentaDaoImpl = new CuentaDaoImpl();
	
	
	@Override
	public boolean insert(Movimiento movimiento) {
		String query =  "CALL AgregarMovimiento(?, ?, ?, ?, ?, ?)";
		
	
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try { 
			CallableStatement statement = conexion.prepareCall(query);
			
			statement.setString(1, movimiento.getTipoMovimiento().getId_tipo());
			statement.setString(2, movimiento.getCBU().getCBU());
			statement.setString(3, movimiento.getCBU_Destino().getCBU());
			statement.setFloat(4, movimiento.getImporte());
			statement.setString(5, movimiento.getDetalle());
			statement.setBoolean(6, movimiento.getEstado());

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
	public boolean delete(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Movimiento> readAll() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		
		Conexion conexion = Conexion.getConexion();
		try{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(read);
	        ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){

				Movimiento movimiento = new Movimiento();
				Cuenta cuenta = new Cuenta();
				Cuenta cuentaDestino = new Cuenta();
				Tipo_Movimiento tp = new Tipo_Movimiento();
				
				movimiento.setId_movimiento(resultSet.getInt("id_movimiento"));
				cuenta.setCBU(resultSet.getString("CBU"));
				movimiento.setCBU(cuenta);
				cuentaDestino.setCBU(resultSet.getString("CBU_destino"));
				movimiento.setCBU_Destino(cuentaDestino);
				movimiento.setFecha_Transaccion(resultSet.getDate("fecha"));
				movimiento.setImporte(resultSet.getFloat("importe"));
				movimiento.setDetalle(resultSet.getString("detalle"));
				tp.setId_tipo(resultSet.getString("id_tipo"));
				tp.setDescripcion((resultSet.getString("descripcion")));
				movimiento.setTipoMovimiento(tp);
														
				lista.add(movimiento);
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
	        PreparedStatement statement = conexion.getSQLConexion().prepareStatement("SELECT MAX(id_movimiento) AS maxId FROM movimientos");
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



	public ArrayList<Movimiento> getMovimientosXCuenta (Cuenta cuentaConsultante) {
	
	
		String cbu = cuentaConsultante.getCBU();
		Tipo_Movimiento tipoMovimiento =new Tipo_Movimiento();
		Cuenta cuentaDest =new Cuenta();
		ArrayList<Movimiento> movimientosCliente = new ArrayList<Movimiento>();	
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Conexion conexion = Conexion.getConexion();
		
		try{ //se ejecuta movimientos x cuentas receptoras
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(movimientosXcuenta);
			statement.setString(1, cbu);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
			
										
					Movimiento movimiento = new Movimiento();					
										
					tipoMovimiento.setId_tipo(resultSet.getString("id_tipo"));
					tipoMovimiento.setDescripcion((resultSet.getString("descripcion")));
					cuentaDest.setCBU(resultSet.getString(4));
					
					
					movimiento.setId_movimiento(resultSet.getInt("id_movimiento"));
					movimiento.setCBU(cuentaConsultante);
					movimiento.setCBU_Destino(cuentaDest);	
					movimiento.setDetalle(resultSet.getString("detalle"));					
					movimiento.setEstado(resultSet.getBoolean("estado"));					
					movimiento.setFecha_Transaccion(new java.sql.Date(resultSet.getTimestamp("fecha").getTime()));
					movimiento.setImporte(resultSet.getInt("importe"));
					movimiento.setTipoMovimiento(tipoMovimiento);	
					
					
					movimientosCliente.add(movimiento);
				
				}

		  conexion.cerrarConexion();
		  
	}catch(Exception e){
		e.printStackTrace();
	}
	
	/*Collections.sort(movimientosCliente, new Comparator<Movimiento>() {
        @Override
        public int compare(Movimiento m1, Movimiento m2) {
            return Integer.compare(m1.getId_movimiento(), m2.getId_movimiento());
        }
    });*/
	
	return movimientosCliente;
	}
}