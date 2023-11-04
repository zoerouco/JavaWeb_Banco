package negocioImpl;

import java.util.ArrayList;
import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio{
	
    Cuenta cuenta = new Cuenta();
	CuentaDao cdao = new CuentaDaoImpl();
	ArrayList<Cuenta> cuentas_cliente = new ArrayList<Cuenta>();

	@Override
	public boolean insert(Cuenta cuenta) {
		boolean insert = false;
		insert = cdao.insert(cuenta);
		return insert;
	}

	@Override
	public boolean delete(Cuenta cuenta) {
		boolean estado=false;
		estado=cdao.delete(cuenta);
		return estado;
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
	
	

	@Override
	public Cuenta getCuentaxCBU(String CBU) {
		
		cuenta = cdao.getCuentaxCBU(CBU);
		
		return cuenta;
	}

	@Override
	public ArrayList<Cuenta> getCuentaxDNI(String DNI) {
		return  cuentas_cliente = cdao.getCuentasxDNI(DNI);
	}

	public boolean modificar(Cuenta cuenta) {
		boolean update = false;
		update = cdao.modificar(cuenta);
		return update;
	}
}
