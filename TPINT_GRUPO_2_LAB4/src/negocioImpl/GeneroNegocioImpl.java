package negocioImpl;

import java.util.ArrayList;
import dao.GeneroDao;
import daoImpl.GeneroDaoImpl;
import entidades.Genero;
import negocio.GeneroNegocio;

public class GeneroNegocioImpl implements GeneroNegocio {
	
	GeneroDao gdao = new GeneroDaoImpl();
	
	@Override
	public ArrayList<Genero> readAll() {
		return gdao.readAll();
	}

}
