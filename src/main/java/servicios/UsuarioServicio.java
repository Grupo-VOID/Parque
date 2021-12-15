package servicios;

import java.util.List;

import modelo.TipoAtraccion;
import modelo.Usuario;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class UsuarioServicio {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario crear(String username, String password, String nombre, TipoAtraccion tematica, double monedas, double tiempo, boolean admin) {
		Usuario usuario = new Usuario(0, username, password, nombre, tematica, monedas, tiempo, false);
		usuario.setPassword(password);

		if (usuario.esValido()) {
			UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
			usuarioDAO.agregarUsuario(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}
	
	public Usuario update(int id, String username, String password, String nombre, TipoAtraccion tematica, double monedas, double tiempo, boolean admin) {

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(id);

		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setTematicaFavorita(tematica);
		usuario.setMonedasDisponibles(monedas);
		usuario.setTiempoDisponible(tiempo);
		usuario.setAdmin(admin);
	
		if (usuario.esValido()) {
			usuarioDAO.updateUsuario(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}

	public void borrar(int id) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.eliminarUsuario(usuarioDAO.buscarPorId(id));
	}

	public Usuario buscar(int id) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		return usuarioDAO.buscarPorId(id);
	}
}
