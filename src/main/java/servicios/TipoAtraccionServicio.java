package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import modelo.TipoAtraccion;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.DAOFactory;
import persistencia.comunes.MissingDataException;

public class TipoAtraccionServicio {
	public List<TipoAtraccion> list() {
		return DAOFactory.getTipoAtraccionDAO().findAll();
	}

	public TipoAtraccion crear(String tematica) {

		TipoAtraccion tipoAtraccion = new TipoAtraccion(this.obtenerUltimoIdTipoAtraccion() + 1, tematica);

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		
		if(!tipoAtraccionDAO.encontrarTipoAtraccion(tematica).getTematica().equals(tipoAtraccion.getTematica()))
			tipoAtraccionDAO.agregarTipoAtraccion(tipoAtraccion);

	return tipoAtraccion;

	}

	public TipoAtraccion update(int id, String tematica) {

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tipoAtraccion = tipoAtraccionDAO.encontrarTipoAtraccion(id);
		TipoAtraccion tipoAux = tipoAtraccionDAO.encontrarTipoAtraccion(tematica);
		if(tipoAux != null && !tipoAux.getTematica().equals(tipoAtraccion.getTematica())) {
			tipoAtraccion.setTematica(tematica);
			tipoAtraccionDAO.updateTipoAtraccion(tipoAtraccion);
		}
		return tipoAtraccion;
	}

	public void borrar(TipoAtraccion tipoAtraccion) {
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		tipoAtraccionDAO.eliminarTipoAtraccion(tipoAtraccion);
	}

	public TipoAtraccion buscar(Integer id) {
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		return tipoAtraccionDAO.encontrarTipoAtraccion(id);
	}

	public int obtenerUltimoIdTipoAtraccion() {
		try {
			String sql = "SELECT max(id_tematica) AS 'id'\r\n" + "FROM tematicas_atracciones";
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
