package dao;

import java.util.ArrayList;

import entidades.Cliente;

public interface ClienteDao {

	public boolean insert (Cliente cliente);
	public boolean delete (Cliente cliente);
	public ArrayList<Cliente> readAll();
	public Cliente getClientexDNI (String DNI);
}
