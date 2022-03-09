package valueObjects;
import java.io.Serializable;
import java.util.Date;

public class VOMudanzaIngreso extends VOMudanza implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date fechaMudanza;

	private String domicilioOrigen;

	private String domicilioDestino;

	private float duracionTotal;


	public VOMudanzaIngreso() {
	}

	public VOMudanzaIngreso(int numContratacion, Date horaInicio, Date fechaMudanza, String domicilioOrigen, String domicilioDestino) {
		super(numContratacion, horaInicio);
		this.fechaMudanza = fechaMudanza;
		this.domicilioOrigen = domicilioOrigen;
		this.domicilioDestino = domicilioDestino;
	}

	public VOMudanzaIngreso(int numContratacion, Date horaInicio, Date fechaMudanza, String domicilioOrigen, String domicilioDestino, float duracionTotal) {
		super(numContratacion, horaInicio);
		this.fechaMudanza = fechaMudanza;
		this.domicilioOrigen = domicilioOrigen;
		this.domicilioDestino = domicilioDestino;
		this.duracionTotal = duracionTotal;

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

	public String getDomicilioDestino() {
		return domicilioDestino;
	}

	public void setDomicilioDestino(String domiciloDestino) {
		this.domicilioDestino = domiciloDestino;
	}

	public float getDuracionTotal() {
		return duracionTotal;
	}

	public void setDuracionTotal(float duracionTotal) {
		this.duracionTotal = duracionTotal;
	}


}
