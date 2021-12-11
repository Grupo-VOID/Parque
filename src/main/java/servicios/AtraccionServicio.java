package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import modelo.Atraccion;
import modelo.TipoAtraccion;
import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.DAOFactory;
import persistencia.comunes.MissingDataException;
import persistencia.AtraccionDAO;

public class AtraccionServicio {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion crear(String nombre, TipoAtraccion tematica, double costo, double duracion, int cupo) {

		Atraccion atraccion = new Atraccion(this.obtenerUltimoIDAtraccion() + 1, nombre, tematica, costo, duracion,
				cupo);

		if (atraccion.esValida()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
			attractionDAO.agregarAtraccion(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion update(Integer id, String nombre, TipoAtraccion tematica, double costo, double duracion,
			int cupo) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.buscarPorId(id);

		atraccion.setNombre(nombre);
		atraccion.setTematica(tematica);
		atraccion.setCosto(costo);
		atraccion.setDuracion(duracion);
		atraccion.setCupoMaximo(cupo);

		if (atraccion.esValida()) {
			atraccionDAO.updateAtraccion(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public void borrar(Atraccion atraccion) {
		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		attractionDAO.eliminarAtraccion(atraccion);
	}

	public Atraccion buscar(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.buscarPorId(id);
	}

	public int obtenerUltimoIDAtraccion() {
		try {
			String sql = "SELECT max(id_atraccion) AS 'id'\r\n" + "FROM atracciones";
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
