package dao;

import java.util.ArrayList;

import entidades.Cuenta;
import entidades.Prestamo;

public interface PrestamoDao {

	public boolean insert (Prestamo prestamo);
	public boolean delete (Prestamo prestamo);
	public boolean update (int idPrestamo, String estado);
	public ArrayList<Prestamo> readAll();
	public int getUltimoID();
	public ArrayList<Prestamo> getPrestamoxCuentas(ArrayList<Cuenta> cuentasCliente);
<<<<<<< HEAD

=======
>>>>>>> 07b539d8948d554dbceea380d7061f5307f78c7c
	public ArrayList<Prestamo> getPrestamosxCBU (String CBU);
	public ArrayList<Prestamo> readAllByEstado(String estado);
	public Prestamo getPrestamoByID(int idPrestamo);

}
