package negocioImpl;

import java.util.ArrayList;

import dao.MovimientoDao;
import daoImpl.MovimientoDaoImpl;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Prestamo;
import negocio.MovimientoNegocio;


public class MovimientoImpl implements MovimientoNegocio {
	
MovimientoDao mdao = new MovimientoDaoImpl();
	
	@Override
	public boolean insert(Movimiento movimiento) {
		boolean filas = false;
		filas = mdao.insert(movimiento);
		return filas;
	}

	@Override
	public boolean delete(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}


	/*public ArrayList<Movimiento> readAll() {
		return mdao.readAll();
	}*/

	public ArrayList<Movimiento> getMovimientosXCuenta (Cuenta cuenta) {
		
		
		return mdao.getMovimientosXCuenta(cuenta);
		
	}
	
	@Override
	public boolean update(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getUltimoID() {
		// TODO Auto-generated method stub
		return mdao.getUltimoID();
	}
	
	public Movimiento getUltimoMovimientoCuenta (Cuenta cuenta) {
		
	ArrayList<Movimiento> movimientosCliente = this.getMovimientosXCuenta(cuenta);
	Movimiento movimientoMayor = new Movimiento();
		
        if (movimientosCliente.size() > 0) {
           
            int mayorId = movimientosCliente.get(0).getId_movimiento();
            
            for (Movimiento movimiento : movimientosCliente) {
                if (movimiento.getId_movimiento() > mayorId) {
                    mayorId = movimiento.getId_movimiento();
                    movimientoMayor = movimiento;           
                }
            }
        }
		
		return movimientoMayor;
		
		
	}
	
	
	
}
