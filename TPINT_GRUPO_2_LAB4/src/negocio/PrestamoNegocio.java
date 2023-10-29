package negocio;

import java.util.ArrayList;
import entidades.Prestamo;

public interface PrestamoNegocio {
	
	public boolean insert (Prestamo prestamo);
	public boolean delete (Prestamo prestamo);
	public ArrayList<Prestamo> readAll();
	public boolean update (Prestamo prestamo);
	
}
