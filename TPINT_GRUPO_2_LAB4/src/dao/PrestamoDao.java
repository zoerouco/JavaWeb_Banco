package dao;

import java.util.ArrayList;

import entidades.Cuenta;
import entidades.Prestamo;

public interface PrestamoDao {

	public boolean insert (Prestamo cuenta);
	public boolean delete (Prestamo cuenta);
	public ArrayList<Prestamo> readAll();
	public int getUltimoID();
	public ArrayList<Prestamo> getPrestamoxCuentas(ArrayList<Cuenta> cuentasCliente);

	public ArrayList<Prestamo> getPrestamosxCBU (String CBU);
	public ArrayList<Prestamo> readAllByEstado(String estado);
	public Prestamo getPrestamoByID(int idPrestamo);

}
