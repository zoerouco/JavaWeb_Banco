package negocio;

import java.util.ArrayList;
import entidades.Provincia;

public interface ProvinciaNegocio {
	
	public ArrayList<Provincia> readAll();
	public Provincia getProvinciaByID(int id);
	
}
