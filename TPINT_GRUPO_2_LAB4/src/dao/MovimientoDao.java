package dao;

import java.util.ArrayList;

import entidades.Cuenta;
import entidades.Movimiento;

public interface MovimientoDao {

	public boolean insert (Movimiento movimiento);
	public boolean delete (Movimiento movimiento);
	/*public ArrayList<Movimiento> readAll();*/
	public ArrayList<Movimiento> getMovimientosXCuenta(Cuenta cuenta);
	public int getUltimoID();
}
