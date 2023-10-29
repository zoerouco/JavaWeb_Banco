package negocioImpl;

import java.util.ArrayList;

import dao.MovimientoDao;
import daoImpl.MovimientoDaoImpl;
import entidades.Movimiento;
import negocio.MovimientoNegocio;
import negocio.PrestamoNegocio;


public class MovimientoImpl implements MovimientoNegocio {
	
MovimientoDao mdao = new MovimientoDaoImpl();
	
	@Override
	public int insert(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Movimiento> readAll() {
		return mdao.readAll();
	}

	@Override
	public boolean update(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}
}
