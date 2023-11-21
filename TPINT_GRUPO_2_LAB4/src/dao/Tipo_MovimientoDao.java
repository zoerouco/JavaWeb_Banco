package dao;

import java.util.ArrayList;
import entidades.Tipo_Movimiento;

public interface Tipo_MovimientoDao {
	
	public ArrayList<Tipo_Movimiento> readAll();
	public Tipo_Movimiento getTipo_MovimientoByID(String id_tipo);
	
}
