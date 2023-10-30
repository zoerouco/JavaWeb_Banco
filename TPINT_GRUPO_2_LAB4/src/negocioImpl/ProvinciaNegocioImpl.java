package negocioImpl;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daoImpl.ProvinciaDaoImpl;
import entidades.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio {

	ProvinciaDao pdao = new ProvinciaDaoImpl();
	
	@Override
	public ArrayList<Provincia> readAll() {
		return pdao.readAll();
	}
}
