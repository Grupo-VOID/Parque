package modelo;

import java.util.ArrayList;

import persistencia.ItinerarioDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;
import utilidades.Crypt;

public class Usuario {

	private Integer id;
	private String nombreDeUsuario, contraseña;
	private String tematicaFavorita;
	private double monedasDisponibles;
	private double tiempoDisponible;
	protected Itinerario itinerarioUsuario;
	private ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
	private boolean administrador;

	//Usuario nuevo
	public Usuario(String nombre, String contraseña, String tematica, double monedas, double tiempo,
			boolean esAdmin) {
		this.id = null;
		this.nombreDeUsuario = nombre;
		this.contraseña = Crypt.hash(contraseña);
		this.tematicaFavorita = tematica;
		this.monedasDisponibles = monedas;
		this.tiempoDisponible = tiempo;
		this.itinerarioUsuario = new Itinerario();
		this.setAdministrador(esAdmin);
	}
	
	//Usuario en la BdD
	//Agregar temática al constructor
	public Usuario(int id, String nombre, String contraseña, double monedas, double tiempo,
			boolean esAdmin) {
		this.id = id;
		this.nombreDeUsuario = nombre;
		this.contraseña = contraseña;
		this.tematicaFavorita = null;
		this.monedasDisponibles = monedas;
		this.tiempoDisponible = tiempo;
		this.itinerarioUsuario = new Itinerario();
		this.setAdministrador(esAdmin);
	}

	public String getNombre() {
		return nombreDeUsuario;
	}

	public String getTematica() {
		return tematicaFavorita;
	}

	public double getMonedasDisponibles() {
		return monedasDisponibles;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public ArrayList<Atraccion> getListaAtracciones() {
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		listaAtracciones = (ArrayList<Atraccion>) itinerarioDAO.atraccionesUsuario(this.getId());

		return listaAtracciones;
	}

	public void aceptarCompra(Adquirible sugerencia) {
		this.monedasDisponibles -= sugerencia.getCosto();
		this.tiempoDisponible -= sugerencia.getTiempo();
		this.itinerarioUsuario.agregarAdquirible(sugerencia, this);
//		for (Atraccion i : sugerencia.atraccionesIncluidas()) {
//			listaAtracciones.add(i);
//		}
		sugerencia.comprar();

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.updateUsuario(this);
	}

	@Override
	public String toString() {
		return this.nombreDeUsuario + this.tiempoDisponible;
	}

	public boolean isNull() {
		return false;
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.contraseña);
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public int getId() {
		return id;
	}
}