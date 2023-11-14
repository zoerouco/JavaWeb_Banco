package negocio;

import java.util.ArrayList;
import entidades.Cliente;
import excepciones.DniRepetidoException;

public interface ClienteNegocio {
	
	public boolean insert (Cliente cliente);
	public boolean delete (Cliente cliente);
	public ArrayList<Cliente> readAll();
	public boolean update (Cliente cliente);
	public ArrayList<Cliente> readAllActivos();
	public boolean modificar (Cliente cliente);
	public ArrayList<Cliente> readAllInactivos();
	boolean verificarDniRepetido(String dni) throws DniRepetidoException;
	
}
