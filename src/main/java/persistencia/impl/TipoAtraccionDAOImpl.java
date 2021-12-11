package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.TipoAtraccion;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.MissingDataException;

public class TipoAtraccionDAOImpl implements TipoAtraccionDAO {

	public List<TipoAtraccion> findAll() {
		try {
			String sql = "SELECT *\r\n" + "FROM tematicas_atracciones\r\n" + "WHERE tematica_activa = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<TipoAtraccion> listaTipoAtraccion = new ArrayList<TipoAtraccion>();
			while (resultados.next()) {
				listaTipoAtraccion.add(toTipoAtraccion(resultados));
			}
			return listaTipoAtraccion;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int agregarTipoAtraccion(String tematica) {
		try {
			TipoAtraccion tipoAtraccion = new TipoAtraccion(this.obtenerUltimoIdTipoAtraccion()+1, tematica);
			
			String sql = "INSERT INTO tematicas_atracciones (nombre_tematica, tematica_activa) \r\n" + "VALUES (?, 1)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipoAtraccion.getTematica());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int updateTipoAtraccion(TipoAtraccion tipoAtraccion) {
		try {
			String sql = "UPDATE tematicas_atracciones SET nombre_tematica = ? WHERE id_tematica = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipoAtraccion.getTematica());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int eliminarTipoAtraccion(TipoAtraccion tipoAtraccion) {
		try {
			String sql = "UPDATE tematicas_atracciones SET tematica_activa = 0 WHERE id_tematica = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tipoAtraccion.getId());
			int rows = statement.executeUpdate();
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public TipoAtraccion encontrarTipoAtraccion(String nombre) {
		try {
			String sql = "SELECT *\r\n" + "FROM tematicas_atracciones\r\n" + "WHERE nombre_tematica = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre.toUpperCase());
			ResultSet resultados = statement.executeQuery();

			TipoAtraccion tipoAtraccion = null;

			if (resultados.next()) {
				tipoAtraccion = toTipoAtraccion(resultados);
			}
			return tipoAtraccion;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int obtenerUltimoIdTipoAtraccion() {
		try {
			String sql = "SELECT max(id_tematica) AS 'id'\r\n"
					+ "FROM tematicas_atracciones";
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
	
	private TipoAtraccion toTipoAtraccion(ResultSet resultados) throws SQLException {

		int id = resultados.getInt("id_tematica");
		String nombre = resultados.getString("nombre_tematica");

		TipoAtraccion tipoAtraccion = new TipoAtraccion(id, nombre);

		return tipoAtraccion;
	}
}