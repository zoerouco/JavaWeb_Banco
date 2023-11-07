package negocio;

import java.util.ArrayList;

import entidades.Localidad;

public interface LocalidadNegocio {
	
	public ArrayList<Localidad> readAll();
	public Localidad getLocalidadByID(int id);
	public ArrayList<Localidad> readLocalidadByProvince(int id_provincia);
}
