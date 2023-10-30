package negocioImpl;

import java.util.ArrayList;
import dao.GeneroDao;
import daoImpl.GeneroDaoImpl;
import entidades.Genero;
import negocio.GeneroNegocio;

public class GeneroNegocioImpl implements GeneroNegocio {
	
	GeneroDao gdao = new GeneroDaoImpl();
	Genero genero = new Genero();
	
	@Override
	public ArrayList<Genero> readAll() {
		return gdao.readAll();
	}

	@Override
	public Genero getGeneroByID(String id_genero) {
		genero = gdao.getGeneroByID(id_genero);
		return genero;
	}

}
