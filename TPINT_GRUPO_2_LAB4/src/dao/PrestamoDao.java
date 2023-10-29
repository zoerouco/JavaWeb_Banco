package dao;

import java.util.ArrayList;

import entidades.Prestamo;

public interface PrestamoDao {

	public boolean insert (Prestamo cuenta);
	public boolean delete (Prestamo cuenta);
	public ArrayList<Prestamo> readAll();
	public int getUltimoID();
}
