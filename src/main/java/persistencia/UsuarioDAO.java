package persistencia;

import modelo.Usuario;
import persistencia.comunes.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public int updateUsuario(Usuario usuario);

	public Usuario buscarPorId(int id);
	
	public Usuario findByUsername(String username);

//	public int encontrarIdUsuario(Usuario usuario);

}