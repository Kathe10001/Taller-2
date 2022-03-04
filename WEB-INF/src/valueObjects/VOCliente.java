package valueObjects;

import java.io.Serializable;

public class VOCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cedula;

	private String nombre;

	private String apellido;

	private String telefono;

	public VOCliente() {
	}

	public VOCliente(String cedula, String nombre, String apellido, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
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


}
