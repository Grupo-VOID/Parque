package persistencia.comunes;

import java.util.List;

public interface GenericDAO<T> {

	public List<T> findAll();

}