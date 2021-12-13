package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import persistencia.comunes.DAOFactory;
import persistencia.AtraccionDAO;

public class Atraccion implements Adquirible {

	private final int ID;
	private String nombre;
	private TipoAtraccion tematica;
	private double costo;
	private double duracion;
	private int cupo;
	private int lugaresOcupados = 0;
	private String descripcion;
	private String imagen;
	
	private Map<String, String> errores;

	public Atraccion(int id, String nombre, TipoAtraccion tematica, double costo, double duracion, int cupo, String descripcion, String imagen) {
		this.ID = id;
		this.nombre = nombre;
		this.tematica = tematica;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	
	public boolean esValida() {
		validate();
		return errores.isEmpty();
	}
	
	public void validate() {
		errores = new HashMap<String, String>();

		if (costo <= 0) {
			errores.put("costo", "Debe ser positivo");
		}
		if (duracion<= 0) {
			errores.put("duracion", "Debe ser positivo");
		}
		if (cupo <= 0) {
			errores.put("cupo", "Debe ser positivo");
		}
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return duracion;
	}
	
	public int getID() {
		return ID;
	}
	
	public TipoAtraccion getTematica() {
		return tematica;
	}

	public int getCupoActual() {
		return lugaresOcupados;
	}

	public int getCupoMaximo() {
		return cupo;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean estaDisponible() {
		return lugaresOcupados < cupo;
	}

	public void comprar() {
		lugaresOcupados++;
		
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.updateAtraccion(this);
	}

	public Atraccion[] atraccionesIncluidas() {
		Atraccion[] nombre = { this };
		return nombre;
	}

	public boolean esPromocion() {
		return false;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTematica(TipoAtraccion tematica) {
		this.tematica = tematica;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupo = cupoMaximo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return String.format("Atraccion: " + this.nombre 
				+ ". Tematica: " + this.getTematica()
				+ "\n Costo Total= $" + this.getCosto()
				+ "\n Duracion Total= " + this.getTiempo() + " horas");
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, duracion, nombre, tematica, lugaresOcupados);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& cupo == other.cupo
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tematica, other.tematica)
				&& lugaresOcupados == other.lugaresOcupados;
	}
	
	
}