package valueObjects;

import java.io.Serializable;
import java.util.Date;

public class VOMudanza implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private int numContratacion;

	 private Date horaInicio;

	 private boolean finalizacion;


	 public VOMudanza() {

		}


	public VOMudanza(int numContratacion, Date horaInicio) {
		this.numContratacion = numContratacion;
		this.horaInicio = horaInicio;
		this.finalizacion = false;
	}

	public int getNumContratacion() {
		return numContratacion;
	}

	public void setNumContratacion(int numContratacion) {
		this.numContratacion = numContratacion;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public boolean isFinalizacion() {
		return finalizacion;
	}

	public void setFinalizacion(boolean finalizacion) {
		this.finalizacion = finalizacion;
	}


}
