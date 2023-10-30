package dao;

import java.util.ArrayList;
import entidades.Tipo_cuenta;

public interface Tipo_cuentaDao {
	
	public ArrayList<Tipo_cuenta> readAll();
	public Tipo_cuenta getTipo_cuentaByID(String id_tipo);
}
