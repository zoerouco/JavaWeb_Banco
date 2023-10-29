package negocio;

import java.util.ArrayList;
import entidades.Movimiento;

public interface MovimientoNegocio {
	
	public int insert (Movimiento movimiento);
	public boolean delete (Movimiento movimiento);
	public ArrayList<Movimiento> readAll();
	public boolean update (Movimiento movimiento);
	
}