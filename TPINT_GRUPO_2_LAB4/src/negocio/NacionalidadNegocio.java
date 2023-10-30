package negocio;

import java.util.ArrayList;
import entidades.Nacionalidad;

public interface NacionalidadNegocio {
	
	public ArrayList<Nacionalidad> readAll();
	public Nacionalidad getNacionalidadByID(int id);
}
