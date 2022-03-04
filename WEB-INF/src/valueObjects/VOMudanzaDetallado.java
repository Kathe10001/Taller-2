package valueObjects;

import java.util.Date;

public class VOMudanzaDetallado extends VOMudanzaIngreso {

	private int cedula;

	private String nombre;

	private String apellido;

	private String telefono;

	private String codigoServicio;
	
	public VOMudanzaDetallado() {
	
	}
	
	public VOMudanzaDetallado(int numContratacion, int horaInicio, Date fechaMudanza, String domicilioOrigen,
			String domicilioDestino, int cedula, String nombre, String apellido, String telefono, String codigoServicio) {
		super(numContratacion, horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino);
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.codigoServicio = codigoServicio;
	}
	
	public VOMudanzaDetallado(int numContratacion, int horaInicio, Date fechaMudanza, String domicilioOrigen,
			String domicilioDestino, float duracionTotal, int cedula, String nombre, String apellido, String telefono, String codigoServicio) {
		super(numContratacion, horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino, duracionTotal);
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.codigoServicio = codigoServicio;
	}
	

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	
	



	}

	
	