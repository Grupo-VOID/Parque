package servicios;

import java.util.Collections;
import java.util.LinkedList;

import modelo.Adquirible;
import modelo.Sugerencia;
import modelo.Usuario;

public class SugerenciaService {

	private LinkedList<Adquirible> catalogo = new LinkedList<Adquirible>();
	private AtraccionServicio atraccionServicio;
	private PromocionServicio promocionServicio;
	
	public LinkedList<Adquirible> ordenar(Usuario usuario) {
		atraccionServicio = new AtraccionServicio();
		promocionServicio = new PromocionServicio();
		
		catalogo.removeAll(catalogo);
		catalogo.addAll(atraccionServicio.list());
		catalogo.addAll(promocionServicio.list());
		
		Sugerencia s1 = new Sugerencia(usuario);
		
		Collections.sort(catalogo, s1);
		
		return catalogo;
	}
}
