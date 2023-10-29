package negocio;

import java.util.ArrayList;
import entidades.Prestamo;

public interface PrestamoNegocio {
	
	public boolean insert (Prestamo prestamo);
	public boolean delete (Prestamo prestamo);
	public ArrayList<Prestamo> readAll();
	public boolean update (Prestamo prestamo);
	public float calcularImporteConIntereses(float importe_pedido, int cant_cuotas);
	public float calcularMontoxMes(int cant_cuotas, float importe_con_intereses);
}
