package negocioImpl;

import java.util.ArrayList;

import daoImpl.PrestamosXmovimientosDaoImpl;
import entidades.PrestamosXmovimientos;
import negocio.PrestamosXmovimientosNegocio;

public class PrestamosXmovimientosNegocioImpl implements PrestamosXmovimientosNegocio {


	PrestamosXmovimientosDaoImpl pxmD = new PrestamosXmovimientosDaoImpl();
	
	@Override
	public ArrayList<PrestamosXmovimientos> readAll() {
			
		return null;
	}

	@Override
	public ArrayList<PrestamosXmovimientos> getPrestamosXmovimientosByID(int id_prestamo) {
		
		return pxmD.getPrestamosXmovimientosByID(id_prestamo);
	}

}
