package negocioImpl;

import java.util.ArrayList;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
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
		// TODO Auto-generated method stub
		return false;
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
}
