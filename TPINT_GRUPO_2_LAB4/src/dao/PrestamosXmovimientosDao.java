package dao;

import java.util.ArrayList;

import entidades.PrestamosXmovimientos;

public interface PrestamosXmovimientosDao {
	
	
	public ArrayList<PrestamosXmovimientos> readAll();
	public ArrayList<PrestamosXmovimientos> getPrestamosXmovimientosByID(int id_prestamo);
	
}
