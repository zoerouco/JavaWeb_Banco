package negocioImpl;

import java.util.ArrayList;

import dao.NacionalidadDao;
import daoImpl.NacionalidadDaoImpl;
import entidades.Nacionalidad;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImpl implements NacionalidadNegocio {

	NacionalidadDao ndao = new NacionalidadDaoImpl();
	
	@Override
	public ArrayList<Nacionalidad> readAll() {
		return ndao.readAll();
	}
}
