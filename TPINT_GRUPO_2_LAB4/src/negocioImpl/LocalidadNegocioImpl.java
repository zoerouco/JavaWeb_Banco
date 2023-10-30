package negocioImpl;

import java.util.ArrayList;

import dao.LocalidadDao;
import daoImpl.LocalidadDaoImpl;
import entidades.Localidad;
import negocio.LocalidadNegocio;

public class LocalidadNegocioImpl implements LocalidadNegocio {
	
	LocalidadDao ldao = new LocalidadDaoImpl();
	Localidad localidad = new Localidad();

	@Override
	public ArrayList<Localidad> readAll() {
		return ldao.readAll();
	}

	@Override
	public Localidad getLocalidadByID(int id) {
		localidad = ldao.getLocalidadByID(id);
		return localidad;
	}
}
