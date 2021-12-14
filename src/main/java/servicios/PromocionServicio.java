package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import modelo.Atraccion;
import modelo.Promocion;
import modelo.PromocionAbsoluta;
import modelo.PromocionAxB;
import modelo.PromocionPorcentual;
import modelo.TipoAtraccion;
import persistencia.AtraccionDAO;
import persistencia.PromocionDAO;
import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.DAOFactory;
import persistencia.comunes.MissingDataException;

public class PromocionServicio {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Promocion crear(String tipoPromocion, TipoAtraccion tematica, Atraccion atraccion1, Atraccion atraccion2,
			double parametro, String descripcion, String imagen) {

		Promocion promocion;

		if (tipoPromocion == "ABSOLUTA") {
			promocion = new PromocionAbsoluta(this.obtenerUltimoIDPromocion() + 1, tematica, atraccion1, atraccion2,
					parametro, descripcion, imagen);
		}
		if (tipoPromocion == "PORCENTUAL") {
			promocion = new PromocionPorcentual(this.obtenerUltimoIDPromocion() + 1, tematica, atraccion1, atraccion2,
					parametro, descripcion, imagen);
		} else {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			int id = (int) parametro;
			Atraccion atraccion3 = atraccionDAO.buscarPorId(id);
			promocion = new PromocionAxB(this.obtenerUltimoIDPromocion() + 1, tematica, atraccion2, atraccion2,
					atraccion3, descripcion, imagen);
		}

		if (promocion.esValida()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.agregarPromocion(promocion, tipoPromocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public Promocion update(int id, String tipoPromocion, TipoAtraccion tematica, Atraccion atraccion1,
			Atraccion atraccion2, double parametro, String descripcion, String imagen) {

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promocion = promocionDAO.buscarPorId(id);

		if (tipoPromocion == "ABSOLUTA") {
			PromocionAbsoluta promocionAbsoluta = (PromocionAbsoluta) promocion;
			promocionAbsoluta.setAtraccionesIncluidas(atraccion1, atraccion2);
			promocionAbsoluta.setTematica(tematica);
			promocionAbsoluta.setDescuento(parametro);
			promocionAbsoluta.setDescripcion(descripcion);
			promocionAbsoluta.setImagen(imagen);
		}
		if (tipoPromocion == "PORCENTUAL") {
			PromocionPorcentual promocionPorcentual = (PromocionPorcentual) promocion;
			promocionPorcentual.setAtraccionesIncluidas(atraccion1, atraccion2);
			promocionPorcentual.setTematica(tematica);
			promocionPorcentual.setPorcentajeDescuento(parametro);
			promocionPorcentual.setDescripcion(descripcion);
			promocionPorcentual.setImagen(imagen);
		} else {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			int idAtraccion = (int) parametro;
			Atraccion atraccion3 = atraccionDAO.buscarPorId(idAtraccion);
			
			PromocionAxB promocionAxB = (PromocionAxB) promocion;
			promocionAxB.setAtraccionIncluidas(atraccion1, atraccion2,atraccion3);
			promocionAxB.setTematica(tematica);
		}
		if (promocion.esValida()) {
			promocionDAO.updatePromocion(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public void borrar(Promocion promocion) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.eliminarPromocion(promocion);
	}

	public Promocion buscar(Integer id) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		return promocionDAO.buscarPorId(id);
	}

	public int obtenerUltimoIDPromocion() {
		try {
			String sql = "SELECT max(id_promocion) AS 'id'\r\n" + "FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			int id = 0;

			if (resultados.next()) {
				id = resultados.getInt("id");
			}
			return id;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
