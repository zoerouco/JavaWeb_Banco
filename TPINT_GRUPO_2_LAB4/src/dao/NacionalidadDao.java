package dao;

import java.util.ArrayList;
import entidades.Nacionalidad;

public interface NacionalidadDao {
	
	public ArrayList<Nacionalidad> readAll();
	public Nacionalidad getNacionalidadByID(int id);
	
}
