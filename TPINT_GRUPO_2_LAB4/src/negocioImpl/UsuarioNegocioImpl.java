package negocioImpl;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	Usuario u = new Usuario();
	UsuarioDao uDao = new UsuarioDaoImpl();
	@Override
	public Usuario getUsuarioxUser(String usuario) {
		
		u = uDao.getUsuarioxUser(usuario);
		return u;
	}

}
