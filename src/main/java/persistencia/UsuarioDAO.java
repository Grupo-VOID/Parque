package persistencia;

import java.util.List;

import modelo.Usuario;
import persistencia.comunes.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public List<Usuario> findAll();
	
	public int updateUsuario(Usuario usuario);
	
	public int agregarUsuario(Usuario usuario);
	
	public int eliminarUsuario(Usuario usuario);

	public Usuario buscarPorId(int id);
	
	public Usuario buscarPorNombre(String nombre);
	
	public Usuario findByUsername(String username);

}