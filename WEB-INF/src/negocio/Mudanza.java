package negocio;

import java.util.Date;

public class Mudanza {

	private Date fechaMudanza;

	private String domicilioOrigen;

	private String domiciloDestino;

	private float duracionTotal;
	
	 private int numContratacion;

	 private int horaInicio;

	 private boolean finalizacion;

	 
	 
	public Mudanza(Date fechaMudanza, String domicilioOrigen, String domiciloDestino, float duracionTotal, int numContratacion, int horaInicio, boolean finalizacion) {
		super();
		this.numContratacion = numContratacion;
		this.horaInicio = horaInicio;
		this.finalizacion = finalizacion;
		this.numContratacion = numContratacion;
		this.horaInicio = horaInicio;
		this.finalizacion = finalizacion;
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
}
