package servicios;

import java.util.List;

import modelo.Adquirible;
import modelo.Usuario;
import persistencia.comunes.DAOFactory;

public class ItinerarioServicio {
	public List<Adquirible> list(Usuario usuario) {
		List<Adquirible> catalogoTemp = null;
		
		catalogoTemp =	DAOFactory.getItinerarioDAO().obtenerAdquiribles(usuario.getId());
		
		if (catalogoTemp.isEmpty()) {
			return null;
		}
		
		return DAOFactory.getItinerarioDAO().obtenerAdquiribles(usuario.getId());
	}
}
