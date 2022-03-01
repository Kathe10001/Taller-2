package valueObjects;

import logica.colecciones.Clientes;
import logica.colecciones.Mudanzas;
import logica.colecciones.Servicios;

public class VOPersistencia {
	
	private Clientes clientes;
	
	private Mudanzas mudanzas;
	
	private Servicios servicios;
	
	public VOPersistencia() {
		
	}
	
	public VOPersistencia(Clientes c, Mudanzas m, Servicios s) {
		this.clientes = c;
		this.servicios = s;
		this.mudanzas = m;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes c) {
		this.clientes = c;
	}

	public Mudanzas getMudanzas() {
		return mudanzas;
	}

	public void setMudanzas(Mudanzas m) {
		this.mudanzas = m;
	}

	public Servicios getServicios() {
		return servicios;
	}

	public void setServicios(Servicios s) {
		this.servicios = s;
	}
	

}


