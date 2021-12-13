package persistencia;

import java.util.List;

import modelo.Adquirible;
import modelo.Atraccion;
import modelo.Itinerario;
import modelo.Usuario;
import persistencia.comunes.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {
	public int insertPromocion(Usuario usuario, Adquirible nuevaAtraccion);

	public int insertAtraccion(Usuario usuario, Adquirible atraccion);

	public List<Atraccion> atraccionesUsuario(int id);
	
	public List<Adquirible> obtenerAdquiribles(int idUsuario);
}