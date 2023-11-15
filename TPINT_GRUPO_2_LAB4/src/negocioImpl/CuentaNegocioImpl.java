package negocioImpl;

import java.util.ArrayList;
import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import excepciones.CbuRepetidoException;
import excepciones.SaldoInsuficienteException;
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
	public ArrayList<Cuenta> readAllActivos() {
		return cdao.readAllActivos();
	}
	@Override
	public ArrayList<Cuenta> readAllInactivos() {
		return cdao.readAllInactivos();
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
	public ArrayList<Cuenta> getCuentasxDNI (String DNI) {
		return  cuentas_cliente = cdao.getCuentasxDNI(DNI);
	}
	
	@Override
	public void validarSaldo(Cuenta cuenta, float importeMovimiento) throws SaldoInsuficienteException {
		if (cuenta.getSaldo() - importeMovimiento < 0)
			throw new SaldoInsuficienteException();
	}
	public boolean verificarCbuRepetido(String cbu) throws CbuRepetidoException {
		return cdao.verificarCbuRepetido(cbu);
	}
	
public Cuenta getCuentaxDNI (String CBU) {
		
		cuenta = cdao.getCuentaxCBU(CBU);
		
		return cuenta;
	}

	public boolean modificar(Cuenta cuenta) {
		boolean update = false;
		update = cdao.modificar(cuenta);
		return update;
	}


}
