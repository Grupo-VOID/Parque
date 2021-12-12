package servicios;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class LoginService {

	public Usuario login(String username, String password) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		Usuario usuario = userDao.findByUsername(username);
    	
    	if (usuario == null || !usuario.checkPassword(password)) {
    		return null;
    	}
    	return usuario;
	}
	
}
