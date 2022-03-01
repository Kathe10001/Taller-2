package logica.colecciones;

import java.io.Serializable;
import java.util.HashMap;

import valueObjects.VOServicio;


public class Servicios implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap <String,VOServicio> servicios;
	
	
	public Servicios() {
		this.servicios = new HashMap <String,VOServicio>();
	}
	
	
	public boolean member(String codigo) {
		return this.servicios.containsKey(codigo);
	}
	
	public void insert(VOServicio  servicio) {
		this.servicios.put(servicio.getCodigo(), servicio);
	}
	
	public VOServicio find(String  codigo) {
		return this.servicios.get(codigo);
	}
	
	public HashMap <String,VOServicio> listarServicios() {
		return this.servicios;
		
	}
	
	
}
