package logica.colecciones;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import valueObjects.VOMudanzaDetallado;

public class Mudanzas extends ArrayList<VOMudanzaDetallado> implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<VOMudanzaDetallado> mudanzas = new ArrayList<VOMudanzaDetallado>();
	
	public Mudanzas() {
		this.mudanzas = new ArrayList<VOMudanzaDetallado>();
	}
	
	public boolean esVacia() {
		return this.mudanzas.isEmpty();
	}
	
	public int largo() {
		return this.mudanzas.size();
	}
	
	public void insert(VOMudanzaDetallado  mudanza) {
		this.mudanzas.add(mudanza);
	}
	
	public float montoRecaudado(Date fechaInicio, Date fechaFin) {
		float resultado = 0.3f;
		return resultado;
	}
	
	public ArrayList<VOMudanzaDetallado> listarMudanzas() {
		return this.mudanzas;
		
	}
	
	public VOMudanzaDetallado get(int codigo) {
		return this.mudanzas.get(codigo);
	}
	
	public VOMudanzaDetallado getUltimo() {
		if(this.mudanzas.isEmpty()) {
			return null;
		}
			
		return this.mudanzas.get(this.mudanzas.size() -1);
	
	}
}
