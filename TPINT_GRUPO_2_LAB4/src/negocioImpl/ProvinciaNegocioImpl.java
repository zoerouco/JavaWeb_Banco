package negocioImpl;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daoImpl.ProvinciaDaoImpl;
import entidades.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio {

	ProvinciaDao pdao = new ProvinciaDaoImpl();
	Provincia provincia = new Provincia();
	
	@Override
	public ArrayList<Provincia> readAll() {
		return pdao.readAll();
	}

	@Override
	public Provincia getProvinciaByID(int id) {
		provincia = pdao.getProvinciaByID(id);
		return provincia;
	}
}
