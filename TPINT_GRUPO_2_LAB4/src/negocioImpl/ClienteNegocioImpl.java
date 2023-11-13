package negocioImpl;

import java.util.ArrayList;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import excepciones.DniRepetido;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio {
	
	ClienteDao cdao = new ClienteDaoImpl();
	
	public boolean insert(Cliente cliente) {
		boolean insert = false;
		insert = cdao.insert(cliente);
		return insert;
	}

	@Override
	public boolean delete(Cliente cliente) {
		boolean estado=false;
		estado=cdao.delete(cliente);
		return estado;
	}

	@Override
	public boolean update(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> readAll() {
		return cdao.readAll();
	}

	public Cliente getClientexDNI(String dNIClienteActual) {
		return cdao.getClientexDNI(dNIClienteActual);
	}

	@Override
	public ArrayList<Cliente> readAllActivos() {
		return cdao.readAllActivos();
	}
	

	@Override
	public boolean modificar(Cliente cliente) {
		boolean update = false;
		update = cdao.modificar(cliente);
		return update;
	}

	@Override
	public ArrayList<Cliente> readAllInactivos() {
		return cdao.readAllInactivos();
	}
	
	public boolean verificarDniRepetido(String dni) throws DniRepetido {
		return cdao.verificarDniRepetido(dni);
	}
}
