package logica.colecciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import negocio.Servicio;
import valueObjects.VOServicio;


public class Servicios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashMap <String, Servicio> servicios;
	
	
	public Servicios() {
		this.servicios = new HashMap <String, Servicio>();
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
	
	public ArrayList<VOServicio> listarServicios() {
		ArrayList<VOServicio> list = new ArrayList<VOServicio>();
		this.servicios.values().forEach(servicio -> list.add(servicio.toVO()));
		return list;
	}
	
	public boolean esVacio() {
		return this.servicios.isEmpty();
	}
	
}
