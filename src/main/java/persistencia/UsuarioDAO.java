package persistencia;

import modelo.Usuario;
import persistencia.comunes.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public int updateUsuario(Usuario usuario);

	public Usuario buscarPorId(int id);

//	public int encontrarIdUsuario(Usuario usuario);

}