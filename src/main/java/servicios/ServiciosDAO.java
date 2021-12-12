package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import persistencia.comunes.ConnectionProvider;
import persistencia.comunes.MissingDataException;

public class ServiciosDAO {

	public int obtenerIdTematica(String tematica) {
		try {
			String sql = "SELECT id_tematica FROM tematicas_atracciones WHERE nombre_tematica = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tematica);
			ResultSet resultados = statement.executeQuery();
			return resultados.getInt("id_tematica");
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public String obtenerNombreTematica(int idTematica) {
		try {
			String sql = "SELECT nombre_tematica FROM tematicas_atracciones WHERE id_tematica  ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idTematica);
			ResultSet resultados = statement.executeQuery();
			return resultados.getString("nombre_tematica");
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
