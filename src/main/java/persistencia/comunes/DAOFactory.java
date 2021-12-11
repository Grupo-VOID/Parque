package persistencia.comunes;


import persistencia.AtraccionDAO;
import persistencia.ItinerarioDAO;
import persistencia.PromocionDAO;
import persistencia.TipoAtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.impl.AtraccionDAOImpl;
import persistencia.impl.ItinerarioDAOImpl;
import persistencia.impl.PromocionDAOImpl;
import persistencia.impl.TipoAtraccionDAOImpl;
import persistencia.impl.UsuarioDAOImpl;
import servicios.ServiciosDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}

	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}

	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	}

	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
	
	public static ServiciosDAO getServiciosDAO() {
		return new ServiciosDAO();
	}
	
	public static TipoAtraccionDAO getTipoAtraccionDAO() {
		return new TipoAtraccionDAOImpl();
	}

}