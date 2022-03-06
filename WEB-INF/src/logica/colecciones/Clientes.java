package logica.colecciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import negocio.Cliente;
import valueObjects.VOCliente;

public class Clientes implements Serializable {


	private static final long serialVersionUID = 1L;
	private TreeMap <String, Cliente> clientes = new TreeMap<String, Cliente>();


	public Clientes() {
		this.clientes = new TreeMap <>();
	}

	public boolean esVacia() {
		return this.clientes.isEmpty();
	}

	public boolean member(String cedula) {
		return this.clientes.containsKey(cedula);
	}

	public void insert(Cliente cliente) {
		this.clientes.put(cliente.getCedula(), cliente);
	}

	public Cliente find(String  cedula) {
		return this.clientes.get(cedula);
	}

	public ArrayList<VOCliente> listarClientes() {
		ArrayList<VOCliente> list = new ArrayList<>();
		this.clientes.values().forEach(cliente -> list.add(cliente.toVO()));
		return list;
	}
}
