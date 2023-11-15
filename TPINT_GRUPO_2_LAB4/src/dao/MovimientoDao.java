package dao;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entidades.Cuenta;
import entidades.Movimiento;

public interface MovimientoDao {

	public boolean insert (Movimiento movimiento);
	public boolean delete (Movimiento movimiento);
	public ArrayList<Movimiento> readAll();
	public ArrayList<Movimiento> getMovimientosXCuenta(Cuenta cuenta);
	public int getUltimoID();
	public ArrayList<Movimiento> getMovimientosXFechas(LocalDateTime desde, LocalDateTime hasta);
}
