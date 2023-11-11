package negocioImpl;

import java.util.ArrayList;
import dao.Tipo_MovimientoDao;
import daoImpl.Tipo_MovimientoDaoImpl;
import entidades.Tipo_Movimiento;
import negocio.Tipo_MovimientoNegocio;

public class Tipo_MovimientoNegocioImpl implements Tipo_MovimientoNegocio{

	Tipo_MovimientoDao tmdao= new Tipo_MovimientoDaoImpl();

	@Override
	public ArrayList<Tipo_Movimiento> readAll() {
		return tmdao.readAll();
	}
	
	
	public  Tipo_Movimiento getTipo_MovimientoByID(String id_tipo) {
		
		return tmdao.getTipo_MovimientoByID(id_tipo);

		
	}

}
