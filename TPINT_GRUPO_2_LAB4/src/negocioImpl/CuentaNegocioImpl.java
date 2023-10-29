package negocioImpl;

import java.util.ArrayList;
import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio{

	CuentaDao cdao = new CuentaDaoImpl();

	@Override
	public int insert(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cuenta> readAll() {
		return cdao.readAll();
	}

	@Override
	public boolean update(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
