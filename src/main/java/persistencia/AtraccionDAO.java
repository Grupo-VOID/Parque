package persistencia;

import java.util.List;

import modelo.Adquirible;
import modelo.Atraccion;
import persistencia.comunes.GenericDAO;


public interface AtraccionDAO extends GenericDAO<Atraccion> {

	public List<Atraccion> findAll();
	
	public int agregarAtraccion(Atraccion atraccion);
	
	public int updateAtraccion(Atraccion atraccion);
	
	public int eliminarAtraccion(Atraccion atraccion);

	public Atraccion buscarPorId(int id);

	public int encontrarIdAtraccion(Adquirible atraccion);
	
	public Atraccion buscarPorNombre(String nombre);
	
	public int obtenerUltimoIDAtraccion();
}