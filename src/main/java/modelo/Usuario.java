package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import persistencia.ItinerarioDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;
import utilidades.Crypt;

public class Usuario {

	private int id;
	private String username;
	private String password;
	private String nombre;
	private TipoAtraccion tematicaFavorita;
	private double monedasDisponibles;
	private double tiempoDisponible;
	private boolean admin;
	protected Itinerario itinerarioUsuario;
	private ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
	private HashMap<String, String> errors;
	private ArrayList<Adquirible> listaAdquiribles;

	//Usuario nuevo
	public Usuario(String username, String password, String nombre, TipoAtraccion tematica, double monedas, double tiempo, boolean admin) {
		this.id = 0;
		this.username = username;
		this.password = Crypt.hash(password);
		this.nombre = nombre;
		this.tematicaFavorita = tematica;
		this.monedasDisponibles = monedas;
		this.tiempoDisponible = tiempo;
		this.admin = admin;
		this.itinerarioUsuario = new Itinerario();
	}
	
	//Usuario en la BdD
	public Usuario(int id, String username, String password, String nombre, TipoAtraccion tematica, double monedas, double tiempo, boolean admin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.tematicaFavorita = tematica;
		this.monedasDisponibles = monedas;
		this.tiempoDisponible = tiempo;
		this.admin = admin;
		this.itinerarioUsuario = new Itinerario(); 
	}
	
	public boolean chequearDinero(Adquirible adquirible) {
		return adquirible.getCosto() <= this.monedasDisponibles;
	}

	public boolean chequearTiempo(Adquirible adquirible) {
		return adquirible.getTiempo() <= this.tiempoDisponible;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}

	public TipoAtraccion getTematica() {
		return tematicaFavorita;
	}

	public double getMonedasDisponibles() {
		return monedasDisponibles;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public ArrayList<Atraccion> getListaAtracciones() {
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		listaAtracciones = (ArrayList<Atraccion>) itinerarioDAO.atraccionesUsuario(this.getId());

		return listaAtracciones;
	}
	
	public ArrayList<Adquirible> getListaAdquiribles() {
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		listaAdquiribles = (ArrayList<Adquirible>) itinerarioDAO.obtenerAdquiribles(this.id);
		return listaAdquiribles;
	}
	

	public void aceptarCompra(Adquirible sugerencia) {
		this.monedasDisponibles -= sugerencia.getCosto();
		this.tiempoDisponible -= sugerencia.getTiempo();
		this.itinerarioUsuario.agregarAdquirible(sugerencia, this);
		for (Atraccion i : sugerencia.atraccionesIncluidas()) {
			listaAtracciones.add(i);
		}
		sugerencia.comprar();

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.updateUsuario(this);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + "]";
	}

	public boolean esAdministrador() {
		return this.admin;
	}

	public boolean isNull() {
		return false;
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTematicaFavorita(TipoAtraccion tematicaFavorita) {
		this.tematicaFavorita = tematicaFavorita;
	}

	public void setMonedasDisponibles(double monedasDisponibles) {
		this.monedasDisponibles = monedasDisponibles;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}
	
	public void setId(int id) {
		if(this.id == 0) {
			this.id = id;
		}
	}
	
	public boolean esValido() {
		validar();
		return errors.isEmpty();
	}
	
	public void validar() {
		errors = new HashMap<String, String>();

		if (this.monedasDisponibles < 0) {
			errors.put("monedasDisponibles", "No debe ser negativo");
		}
		if (this.tiempoDisponible < 0) {
			errors.put("tiempoDisponible", "No debe ser negativo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	

}