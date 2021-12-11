package persistencia;

import java.util.List;

import modelo.TipoAtraccion;
import persistencia.comunes.GenericDAO;


public interface TipoAtraccionDAO extends GenericDAO<TipoAtraccion> {

	public List<TipoAtraccion> findAll();

	public int agregarTipoAtraccion(String tematica);

	public int updateTipoAtraccion(TipoAtraccion tipoAtraccion);
	
	public int eliminarTipoAtraccion(TipoAtraccion tipoAtraccion);

	public TipoAtraccion encontrarTipoAtraccion(String nombre);
}
