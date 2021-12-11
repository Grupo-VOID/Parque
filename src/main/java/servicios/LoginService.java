package servicios;

import modelo.Usuario;
import modelo.ObjetosNulos.UsuarioNulo;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class LoginService {

	public Usuario login(String nombreUsuario, String contraseña) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
    	Usuario usuario = usuarioDao.buscarPorId(0);
    	
    	if (usuario.isNull() || !usuario.chequearContraseña(contraseña)) {
    		usuario = UsuarioNulo.constructor();
    	}
    	return usuario;
	}
	
}
