package negocioImpl;

import java.util.ArrayList;
import dao.Tipo_cuentaDao;
import daoImpl.Tipo_cuentaDaoImpl;
import entidades.Tipo_cuenta;
import negocio.Tipo_cuentaNegocio;

public class Tipo_cuentaNegocioImpl implements Tipo_cuentaNegocio {
	
	Tipo_cuentaDao tcdao = new Tipo_cuentaDaoImpl();
	
	@Override
	public ArrayList<Tipo_cuenta> readAll() {
		return tcdao.readAll();
	}
	
	
	public  Tipo_cuenta getTipo_cuentaByID(String id_tipo) {
		
		return tcdao.getTipo_cuentaByID(id_tipo);

		
	}

}
