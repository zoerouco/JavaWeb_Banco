package negocioImpl;

import java.util.ArrayList;
import dao.PrestamoDao;
import daoImpl.PrestamoDaoImpl;
import entidades.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImpl implements PrestamoNegocio{

	PrestamoDao pdao = new PrestamoDaoImpl();
	
	@Override
	public boolean insert(Prestamo prestamo) {
		
		boolean filas = false;
		
		filas = pdao.insert(prestamo);
		
		return filas;
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
	
	public int getUltimoID() {
		
		return pdao.getUltimoID();
	
	}
	
	
}
