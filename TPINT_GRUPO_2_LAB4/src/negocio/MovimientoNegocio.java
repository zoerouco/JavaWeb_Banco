package negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import entidades.Movimiento;

public interface MovimientoNegocio {
	
	public boolean insert (Movimiento movimiento);
	public boolean delete (Movimiento movimiento);
	public ArrayList<Movimiento> readAll();
	public boolean update (Movimiento movimiento);
	public ArrayList<Movimiento> getMovimientosXFechas(LocalDateTime desde, LocalDateTime hasta);
	
}
