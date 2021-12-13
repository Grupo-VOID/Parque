package modelo;

import persistencia.comunes.DAOFactory;
import persistencia.AtraccionDAO;

public class PromocionPorcentual extends Promocion {

	private int id;
	private double porcentajeDescuento = 0;
	private Atraccion atraccionUno, atraccionDos;
	private String descripcion;
	private String imagen;

	public PromocionPorcentual(int id, TipoAtraccion tematica, Atraccion atraccion1, Atraccion atraccion2,
			double porcentajeDescuento, String descripcion, String imagen) {
		super(tematica);
		this.id = id;
		this.atraccionUno = atraccion1;
		this.atraccionDos = atraccion2;
		this.porcentajeDescuento = porcentajeDescuento;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	@Override
	public double getCosto() {
		double costoAtracciones = this.atraccionUno.getCosto() + this.atraccionDos.getCosto();
		this.costoTotal = costoAtracciones * (1 - porcentajeDescuento / 100);
		this.costoTotal = this.costoTotal * 100;
		return (Math.floor(this.costoTotal)) / 100;
	}

	@Override
	public double getTiempo() {
		this.duracionTotal = atraccionUno.getTiempo() + atraccionDos.getTiempo();
		return duracionTotal;
	}

	@Override
	public String toString() {
		return (this.getNombre()+": Si compra la atraccion " + this.atraccionUno.getNombre() 
				+ " y la atraccion " + this.atraccionDos.getNombre()
				+ ", se ofrece un descuento del " + this.porcentajeDescuento
				+ "% sobre el costo total."
				+ "\n Tematica: " + this.getTematica()
				+ "\n Costo Total con descuento= $" + this.getCosto()
				+ "\n Duracion Total= " + this.getTiempo() + " horas");
	}

	public void comprar() {
		this.atraccionUno.comprar();
		this.atraccionDos.comprar();
		
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.updateAtraccion(atraccionUno);
		atraccionDAO.updateAtraccion(atraccionDos);
	}

	@Override
	public boolean estaDisponible() {
		return (this.atraccionUno.estaDisponible() && this.atraccionDos.estaDisponible());
	}

	@Override
	public Atraccion[] atraccionesIncluidas() {
		Atraccion[] atracciones = { this.atraccionUno, this.atraccionDos };
		return atracciones;
	}
	
	public String getTipoPromocion() {
		return "PORCENTUAL";
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public int getId() {
		return id;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public void setAtraccionesIncluidas(Atraccion atraccionUno, Atraccion atraccionDos) {
		this.atraccionUno = atraccionUno;
		this.atraccionDos = atraccionDos;
	}	
	
	public boolean esValida() {
		return( this.atraccionUno.esValida() && this.atraccionDos.esValida() );
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
}