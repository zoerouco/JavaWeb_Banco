package dao;

import java.util.ArrayList;
import entidades.Cuenta;
import excepciones.CbuRepetidoException;

public interface CuentaDao {

	public boolean insert (Cuenta cuenta);
	public boolean delete (Cuenta cuenta);
	public ArrayList<Cuenta> readAll();
	public ArrayList<Cuenta> readAllActivos();
	public ArrayList<Cuenta> readAllInactivos();
	public ArrayList<Cuenta> getCuentasxDNI(String DNI);
	public Cuenta getCuentaxCBU (String CBU);
	public boolean verificarCbuRepetido(String CBU) throws CbuRepetidoException;
	public boolean modificar(Cuenta cuenta);
	
}
