package dao;

import java.util.ArrayList;

import entidades.Cliente;
import excepciones.CuilRepetidoException;
import excepciones.DniRepetidoException;

public interface ClienteDao {

	public boolean insert (Cliente cliente);
	public boolean delete (Cliente cliente);
	public ArrayList<Cliente> readAll();
	public Cliente getClientexDNI (String DNI);
	public ArrayList<Cliente> readAllActivos();
	public boolean modificar (Cliente cliente);
	public ArrayList<Cliente> readAllInactivos();
	public boolean verificarDniRepetido(String dni) throws DniRepetidoException;
	public boolean verificarCuilRepetido(String cuil) throws CuilRepetidoException;
	public ArrayList<Cliente> getClientexDNILike(String DNI);
}
