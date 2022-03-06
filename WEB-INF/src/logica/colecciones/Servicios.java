package logica.colecciones;

import java.io.Serializable;
import java.util.HashMap;

import negocio.Servicio;


public class Servicios implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap <String, Servicio> servicios = new HashMap<String, Servicio>();


	public Servicios() {
		this.servicios = new HashMap <>();
	}


	public boolean member(String codigo) {
		return this.servicios.containsKey(codigo);
	}

	public void insert(Servicio  servicio) {
		this.servicios.put(servicio.getCodigo(), servicio);
	}

	public Servicio find(String  codigo) {
		return this.servicios.get(codigo);
	}

	public boolean esVacio() {
		return this.servicios.isEmpty();
	}
	
	public HashMap <String, Servicio> getServicios() {
		return this.servicios;
	}

}
