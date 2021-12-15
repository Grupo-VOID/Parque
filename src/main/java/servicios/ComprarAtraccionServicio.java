package servicios;

import java.util.HashMap;
import java.util.Map;
import modelo.Atraccion;
import modelo.Usuario;
import persistencia.AtraccionDAO;
import persistencia.ItinerarioDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class ComprarAtraccionServicio {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer atraccionId) {
		Map<String, String> errores = new HashMap<String, String>();

		Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
		Atraccion atraccion = atraccionDAO.buscarPorId(atraccionId);

		if (!atraccion.tieneCupo(1)) {
			errores.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.chequearDinero(atraccion)) {
			errores.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.chequearTiempo(atraccion)) {
			errores.put("usuario", "No tienes tiempo suficiente");
		}

		if (errores.isEmpty()) {
			usuario.aceptarCompra(atraccion);

			atraccionDAO.updateAtraccion(atraccion);
			usuarioDAO.updateUsuario(usuario);
		}

		return errores;

	}

}
