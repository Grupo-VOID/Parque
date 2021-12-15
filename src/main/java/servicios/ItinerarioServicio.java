package servicios;

import java.util.List;

import modelo.Adquirible;
import modelo.Usuario;
import persistencia.comunes.DAOFactory;

public class ItinerarioServicio {
	public List<Adquirible> list(Usuario usuario) {
		return DAOFactory.getItinerarioDAO().obtenerAdquiribles(usuario.getId());
	}
}
