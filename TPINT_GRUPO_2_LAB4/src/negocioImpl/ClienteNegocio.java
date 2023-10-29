package negocioImpl;

import daoImpl.ClienteDaoImpl;
import entidades.Cliente;

public class ClienteNegocio {
	
	ClienteDaoImpl cdao = new ClienteDaoImpl(); //deberia ser clienteDaoImpl
	
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

}
