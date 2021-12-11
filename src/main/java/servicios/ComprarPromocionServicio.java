package servicios;

import java.util.HashMap;
import java.util.Map;

import modelo.Promocion;
import modelo.Usuario;
import persistencia.ItinerarioDAO;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class ComprarPromocionServicio {

	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer promocionId) {
		Map<String, String> errores = new HashMap<String, String>();

		Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
		Promocion promocion = promocionDAO.buscarPorId(promocionId);

		if (!promocion.estaDisponible()) {
			errores.put("promocion", "No hay cupo disponible");
		}
		if (usuario.getMonedasDisponibles() < promocion.getCosto()) {
			errores.put("usuario", "No tienes dinero suficiente");
		}
		if (usuario.getTiempoDisponible() < promocion.getTiempo()) {
			errores.put("usuario", "No tienes tiempo suficiente");
		}

		if (errores.isEmpty()) {
			itinerarioDAO.insertAtraccion(usuario, promocion);
			promocion.comprar();
			usuario.aceptarCompra(promocion);

			// no grabamos para no afectar la base de pruebas
			promocionDAO.updatePromocion(promocion);
			usuarioDAO.updateUsuario(usuario);
		}

		return errores;

	}

}
