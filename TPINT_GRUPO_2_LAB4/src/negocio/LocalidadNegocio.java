package negocio;

import java.util.ArrayList;

import entidades.Localidad;

public interface LocalidadNegocio {
	
	public ArrayList<Localidad> readAll();
	public Localidad getLocalidadByID(int id);
}
