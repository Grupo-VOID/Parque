package persistencia;

import modelo.Adquirible;
import modelo.Promocion;
import persistencia.comunes.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {

	public int agregarPromocion(Promocion promocion, String tipoPromocion);

	public int eliminarPromocion(Promocion promocion);

	public int updatePromocion(Promocion promocion);

	public int obtenerUltimoIDPromocion();

	public Promocion buscarPorId(int id);
	
	public Promocion buscarPorNombre(String nombre);

	public int encontrarIdPromocion(Adquirible promocion);
}