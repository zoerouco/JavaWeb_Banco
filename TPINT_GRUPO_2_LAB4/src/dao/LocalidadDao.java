package dao;

import java.util.ArrayList;

import entidades.Localidad;

public interface LocalidadDao {
	
	public ArrayList<Localidad> readAll();
	public Localidad getLocalidadByID(int id);
}
