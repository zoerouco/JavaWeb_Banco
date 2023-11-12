package negocio;

import java.util.ArrayList;
import entidades.Cuenta;

public interface CuentaNegocio {
	
	public boolean insert (Cuenta cuenta);
	public boolean delete (Cuenta cuenta);
	public ArrayList<Cuenta> readAll();
	public boolean update (Cuenta cuenta);
	public Cuenta getCuentaxCBU (String CBU);
	public ArrayList<Cuenta> getCuentasxDNI (String DNI);
	ArrayList<Cuenta> readAllActivos();
	ArrayList<Cuenta> readAllInactivos();
	
}
