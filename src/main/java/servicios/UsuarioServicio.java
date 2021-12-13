package servicios;

import java.util.List;

import modelo.Usuario;
import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;

public class UsuarioServicio {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String username, String password, Integer coins, Double time) {
		Usuario user = new Usuario(-1, username, password, coins, time, false);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUsuarioDAO().agregarUsuario(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return user;
	}
}
