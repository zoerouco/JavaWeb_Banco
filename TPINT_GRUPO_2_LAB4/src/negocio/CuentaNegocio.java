package negocio;

import java.util.ArrayList;
import entidades.Cuenta;

public interface CuentaNegocio {
	
	public int insert (Cuenta cuenta);
	public boolean delete (Cuenta cuenta);
	public ArrayList<Cuenta> readAll();
	public boolean update (Cuenta cuenta);
	public Cuenta getCuentaxCBU (String CBU);
	
}
