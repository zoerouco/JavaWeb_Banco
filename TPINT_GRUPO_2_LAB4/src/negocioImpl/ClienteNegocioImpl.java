package negocioImpl;

import java.util.ArrayList;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio {
	
	ClienteDao cdao = new ClienteDaoImpl();
	
	public int insert(Cliente cliente) {
		return 0;
	        /*boolean estado=false, repetido;
	        repetido = validarDNIRepetido(persona);
		
	        if(repetido) {
	        	JOptionPane.showMessageDialog(null, "ERROR - DNI REPETIDO.");
	        	return -1;
	        }
			if (cdao.insert(cliente))return 1;
			else return 0;*/
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
