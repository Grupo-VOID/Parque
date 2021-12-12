package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import persistencia.TipoAtraccionDAO;
import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.MissingDataException;

public class TipoAtraccionDAOImpl implements TipoAtraccionDAO {

	public List<String> findAll() {
		try {
			String sql = "SELECT *\r\n" + "FROM tematicas_atracciones\r\n" + "WHERE tematica_activa = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<String> listaTipoAtraccion = new List<String>();
			while (resultados.next()) {
				listaTipoAtraccion.add(resultados.getString("nombre_tematica"));
			}
			return listaTipoAtraccion;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int agregarTipoAtraccion(String nombre) {
		try {
			String sql = "INSERT INTO tematicas_atracciones (nombre_tematica, tematica_activa) \r\n" + "VALUES (?, 1)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int eliminarTipoAtraccion(String nombre) {
		try {
			String sql = "UPDATE tematicas_atracciones SET tematica_activa = 0 WHERE nombre_tematica = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int encontrarId(String nombre) {
		try {
			String sql = "SELECT *\r\n" + "FROM tematicas_atracciones\r\n" + "WHERE nombre_tematica = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			int id = 0;

			if (resultados.next()) {
				id = resultados.getInt("id_tematica");
			}
			return id;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}