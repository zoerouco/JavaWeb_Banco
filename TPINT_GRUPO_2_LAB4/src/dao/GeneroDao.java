package dao;

import java.util.ArrayList;
import entidades.Genero;

public interface GeneroDao {
	
	public ArrayList<Genero> readAll();
	public Genero getGeneroByID(String id_genero);
	
}
