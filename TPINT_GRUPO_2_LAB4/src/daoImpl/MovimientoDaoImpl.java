package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import dao.MovimientoDao;
import entidades.Cuenta;
import entidades.Movimiento;

public class MovimientoDaoImpl implements MovimientoDao {
	
	private static final String readall = "SELECT * FROM prestamos"; //modificar query con inner joins 
	
	@Override
	public boolean insert(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
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
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
	        ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				
				//habria que cargar cada objeto como en cuenta'
				/*Cuenta cuenta = new Cuenta();
				Tipo_cuenta tipoCuenta = new Tipo_cuenta();
				Genero genero = new Genero();
				Nacionalidad nacionalidad = new Nacionalidad();
				Provincia provincia = new Provincia();
				Localidad localidad = new Localidad();
				Cliente cliente = new Cliente();
				
				cuenta.setCBU(resultSet.getString("CBU"));
				tipoCuenta.setId_tipo(resultSet.getString(8));
				tipoCuenta.setDescripcion(resultSet.getString(9));
				cuenta.setId_tipo(tipoCuenta);
				cliente.setDNI(resultSet.getString("DNI"));
				genero.setId_genero(resultSet.getString(24));
				genero.setDescripcion(resultSet.getString(25));
				cliente.setId_genero(genero);
				nacionalidad.setId(resultSet.getInt(29));
				nacionalidad.setCode(resultSet.getShort(30));
				nacionalidad.setIso3166a1(resultSet.getString(31));
				nacionalidad.setIso3166a2(resultSet.getString(32));
				nacionalidad.setNombre_pais(resultSet.getString(33));
				cliente.setId_nacionalidad(nacionalidad);
				provincia.setId(resultSet.getInt("id_provincia"));
				provincia.setNombre_provincia(resultSet.getString(35));
				cliente.setId_provincia(provincia);
				localidad.setId(resultSet.getInt("id_localidades"));
				localidad.setId_provincia(provincia);
				localidad.setNombre_localidad(resultSet.getString("nombre_localidad"));
				cliente.setCUIL(resultSet.getString("CUIL"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCorreo_electronico(resultSet.getString("correo_electronico"));
				cliente.setTelefono_primario(resultSet.getString("telefono_primario"));
				cliente.setTelefono_secundario(resultSet.getString("telefono_secundario"));
				cuenta.setDNI(cliente);
				cuenta.setFecha_creacion(resultSet.getDate("fecha_creacion"));
				cuenta.setNro_cuenta(resultSet.getString("nro_cuenta"));
				cuenta.setSaldo(resultSet.getFloat("saldo"));
				cuenta.setEstado(resultSet.getBoolean("estado"));*/
				
				
				

				//clases necesarias para crear un obj Movimiento
				Movimiento movimiento = new Movimiento();
				Cuenta cuenta = new Cuenta();	
				Cuenta cuentaDest = new Cuenta();	
				// Cargar los atributos
				Cuenta cbu = movimiento.getCBU();
				Cuenta cbuDestino = movimiento.getCBU_Destino();
				Date fechaTransaccion = movimiento.getFecha_Transaccion();
				int importe = movimiento.getImporte();
				String detalle = movimiento.getDetalle();
				String tipoMovimiento = movimiento.getTipoMovimiento();
				boolean estado = movimiento.isEstado();
														
				lista.add(movimiento);
			}
			
		conexion.cerrarConexion();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
}
