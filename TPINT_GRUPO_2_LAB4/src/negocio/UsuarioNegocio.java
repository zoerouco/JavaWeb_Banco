package negocio;

import entidades.Usuario;

public interface UsuarioNegocio {
	
	public Usuario getUsuarioxUser (String usuario);
	public Usuario getUsuarioxDNI(String dni);
	public boolean updatePassword(Usuario usuario);
}
