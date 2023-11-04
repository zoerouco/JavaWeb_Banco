package dao;

import java.util.ArrayList;
import entidades.Cuenta;

public interface CuentaDao {

	public boolean insert (Cuenta cuenta);
	public boolean delete (Cuenta cuenta);
	public ArrayList<Cuenta> readAll();
	public ArrayList<Cuenta> getCuentasxDNI(String DNI);
	public Cuenta getCuentaxCBU (String CBU);
	public boolean modificar(Cuenta cuenta);
	
}
