package negocioImpl;

import java.util.ArrayList;
import dao.PrestamoDao;
import daoImpl.PrestamoDaoImpl;
import entidades.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImpl implements PrestamoNegocio{

	PrestamoDao pdao = new PrestamoDaoImpl();
	
	@Override
	public int insert(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Prestamo> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean update(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}
}
