package negocio;

import java.util.Date;

import valueObjects.VOMudanzaDetallado;

public class Mudanza {

	private Date fechaMudanza;

	private String domicilioOrigen;

	private String domiciloDestino;

	private float duracionTotal;

	private int numContratacion;

	private int horaInicio;

	private boolean finalizacion;

	private Cliente cliente;

	private Servicio servicio;

	public Mudanza(int numContratacion, int horaInicio, Date fechaMudanza, String domicilioOrigen, String domiciloDestino, Cliente cliente, Servicio servicio) {
		super();
		this.fechaMudanza = fechaMudanza;
		this.domicilioOrigen = domicilioOrigen;
		this.domiciloDestino = domiciloDestino;
		this.numContratacion = numContratacion;
		this.horaInicio = horaInicio;
		this.numContratacion = numContratacion;
		this.horaInicio = horaInicio;
		this.cliente = cliente;
		this.servicio = servicio;

	}


	public Date getFechaMudanza() {
		return fechaMudanza;
	}

	public void setFechaMudanza(Date fechaMudanza) {
		this.fechaMudanza = fechaMudanza;
	}

	public String getDomicilioOrigen() {
		return domicilioOrigen;
	}

	public void setDomicilioOrigen(String domicilioOrigen) {
		this.domicilioOrigen = domicilioOrigen;
	}

	public String getDomiciloDestino() {
		return domiciloDestino;
	}

	public void setDomiciloDestino(String domiciloDestino) {
		this.domiciloDestino = domiciloDestino;
	}

	public float getDuracionTotal() {
		return duracionTotal;
	}

	public void setDuracionTotal(float duracionTotal) {
		this.duracionTotal = duracionTotal;
	}

	public int getNumContratacion() {
		return numContratacion;
	}

	public void setNumContratacion(int numContratacion) {
		this.numContratacion = numContratacion;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public boolean isFinalizacion() {
		return finalizacion;
	}

	public void setFinalizacion(boolean finalizacion) {
		this.finalizacion = finalizacion;
	}

	public VOMudanzaDetallado toVO() {

		VOMudanzaDetallado mudanza = new VOMudanzaDetallado();
		mudanza.setFechaMudanza(this.fechaMudanza);
		mudanza.setDomicilioOrigen(this.domicilioOrigen);
		mudanza.setDomicilioDestino(this.domiciloDestino);
		mudanza.setDuracionTotal(this.duracionTotal);
		mudanza.setNumContratacion(this.numContratacion);
		mudanza.setHoraInicio(this.horaInicio);
		mudanza.setFinalizacion(this.finalizacion);
		return mudanza;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Servicio getServicio() {
		return servicio;
	}


	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}
