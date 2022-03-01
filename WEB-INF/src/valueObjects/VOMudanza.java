package valueObjects;

public class VOMudanza {
	
	 private int numContratacion;

	 private int horaInicio;

	 private boolean finalizacion;

	 
	public VOMudanza(int numContratacion, int horaInicio) {
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
