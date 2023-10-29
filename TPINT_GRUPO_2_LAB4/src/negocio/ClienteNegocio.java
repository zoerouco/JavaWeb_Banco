package negocio;

import java.util.ArrayList;
import entidades.Cliente;

public interface ClienteNegocio {
	
	public int insert (Cliente cliente);
	public boolean delete (Cliente cliente);
	public ArrayList<Cliente> readAll();
	public boolean update (Cliente cliente);
	
}
