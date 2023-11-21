package dao;

import entidades.Usuario;

public interface UsuarioDao {
	
	public Usuario getUsuarioxUser (String usuario);
	public Usuario getUsuarioxDNI(String dni);
	public boolean updatePassword(Usuario usuario);
	
}
