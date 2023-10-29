package dao;

import java.util.ArrayList;

import entidades.Cliente;
import entidades.Cuenta;

public interface CuentaDao {

	public boolean insert (Cuenta cuenta);
	public boolean delete (Cuenta cuenta);
	public ArrayList<Cuenta> readAll();
	
}
