package dao;

import java.util.ArrayList;
import entidades.Provincia;

public interface ProvinciaDao {
	
	public ArrayList<Provincia> readAll();
	public Provincia getProvinciaByID(int id);
}
