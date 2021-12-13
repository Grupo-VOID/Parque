package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Adquirible;
import modelo.Atraccion;
import modelo.TipoAtraccion;
import persistencia.AtraccionDAO;
import persistencia.TipoAtraccionDAO;
import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.DAOFactory;
import persistencia.comunes.MissingDataException;


public class AtraccionDAOImpl implements AtraccionDAO {

	public List<Atraccion> findAll() {
		try {
			String sql = "SELECT * \r\n"
					+ "FROM atracciones\r\n"
					+ "JOIN tematicas_atracciones ta ON ta.id_tematica = atracciones.id_tematica\r\n"
					+ "WHERE atraccion_activa = 1\r\n" 
					+ "GROUP BY atracciones.id_atraccion";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> listaAtracciones = new LinkedList<Atraccion>();
			while (resultados.next()) {
				listaAtracciones.add(toAtraccion(resultados));
			}
			return listaAtracciones;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int agregarAtraccion(Atraccion atraccion) {
		try {
			
			String sql = "INSERT INTO atracciones (nombre_atraccion, cupo_actual, costo, duracion, id_tematica, atraccion_activa, descripcion_atraccion, imagen_atraccion) VALUES (?, ?, ?, ?, ?, 1, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
		
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCupoActual());
			statement.setDouble(3, atraccion.getCosto());
			statement.setDouble(4, atraccion.getTiempo());
			statement.setInt(5, atraccion.getTematica().getId());
			statement.setString(6, atraccion.getDescripcion());
			statement.setString(7, atraccion.getImagen());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	public int updateAtraccion(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET nombre_atraccion = ?, cupo_actual = ?, costo = ?, duracion = ?, id_tematica = ?, descripcion_atraccion = ?, imagen_atraccion = ? WHERE id_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCupoMaximo() - atraccion.getCupoActual());
			statement.setDouble(3, atraccion.getCosto());
			statement.setDouble(4, atraccion.getTiempo());
			statement.setInt(5, atraccion.getTematica().getId());
			statement.setString(6, atraccion.getDescripcion());
			statement.setString(7, atraccion.getImagen());
			statement.setInt(8, atraccion.getID());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int eliminarAtraccion(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET atraccion_activa = 0 WHERE id_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getID());
			int rows = statement.executeUpdate();
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Atraccion buscarPorId(int id) {
		try {
			String sql = "SELECT * \r\n"
					+ "FROM atracciones \r\n"
					+ "JOIN tematicas_atracciones ta ON ta.id_tematica = atracciones.id_tematica\r\n"
					+ "WHERE id_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Atraccion atraccion = null;

			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}
			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int encontrarIdAtraccion(Adquirible atraccion) {
		try {
			String sql = "SELECT * FROM atracciones WHERE nombre_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			ResultSet resultados = statement.executeQuery();

			int id = 0;

			if (resultados.next()) {
				id = resultados.getInt("id_atraccion");
			}
			return id;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int obtenerUltimoIDAtraccion() {
		try {
			String sql = "SELECT max(id_atraccion) AS 'id'\r\n"
					+ "FROM atracciones";
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
	
	private Atraccion toAtraccion(ResultSet resultados) throws SQLException {

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		
		int id = resultados.getInt("id_atraccion");
		String nombre = resultados.getString("nombre_atraccion");
		TipoAtraccion tematica = tipoAtraccionDAO.encontrarTipoAtraccion(resultados.getString("nombre_tematica"));
		double monedas = resultados.getInt("costo");
		double tiempo = resultados.getInt("duracion");
		int cupo = resultados.getInt("cupo_actual");
		String descripcion = resultados.getString("descripcion_atraccion");
		String imagen = resultados.getString("imagen_atraccion");

		Atraccion atraccion = new Atraccion(id, nombre, tematica, monedas, tiempo, cupo, descripcion, imagen);

		return atraccion;
	}
}