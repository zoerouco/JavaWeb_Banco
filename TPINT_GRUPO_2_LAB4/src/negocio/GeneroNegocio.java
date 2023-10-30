package negocio;

import java.util.ArrayList;
import entidades.Genero;

public interface GeneroNegocio {
	
	public ArrayList<Genero> readAll();
	public Genero getGeneroByID(String id_genero);
}
