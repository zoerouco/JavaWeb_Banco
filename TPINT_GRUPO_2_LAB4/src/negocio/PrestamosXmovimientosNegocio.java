package negocio;

import java.util.ArrayList;

import entidades.PrestamosXmovimientos;

public interface PrestamosXmovimientosNegocio {
	
	public ArrayList<PrestamosXmovimientos> readAll();
	public ArrayList<PrestamosXmovimientos> getPrestamosXmovimientosByID (int id_prestamo);
	

}
