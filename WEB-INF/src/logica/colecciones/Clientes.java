package logica.colecciones;

import java.io.Serializable;
import java.util.TreeMap;

import valueObjects.VOCliente;

public class Clientes implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private TreeMap <Integer,VOCliente> clientes;
	
	
	public Clientes() {
		this.clientes = new TreeMap <Integer,VOCliente>();
	}
	
	public boolean esVacia() {
		return this.clientes.isEmpty();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean member(String cedula) {
		return this.clientes.containsKey(cedula);
	}
	
	public void insert(VOCliente  cliente) {
		this.clientes.put(cliente.getCedula(), cliente);
	}
	
	public VOCliente find(int  cedula) {
		return this.clientes.get(cedula);
	}
	
	public TreeMap <Integer,VOCliente> listarClientes() {
		return this.clientes;
		
	}
}
