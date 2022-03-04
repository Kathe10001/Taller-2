package logica.colecciones;

import java.io.Serializable;
import java.util.ArrayList;

import negocio.Mudanza;
import valueObjects.VOMudanzaDetallado;

public class Mudanzas implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Mudanza> mudanzas = new ArrayList<>();

	public Mudanzas() {
		this.mudanzas = new ArrayList<>();
	}

	public Mudanzas(ArrayList<Mudanza> m) {
		this.mudanzas = m;
	}

	public boolean esVacia() {
		return this.mudanzas.isEmpty();
	}

	public int largo() {
		return this.mudanzas.size();
	}

	public void insert(Mudanza  mudanza) {
		this.mudanzas.add(mudanza);
	}

	public ArrayList<VOMudanzaDetallado> listarMudanzas() {
		ArrayList<VOMudanzaDetallado> list = new ArrayList<>();
		this.mudanzas.forEach(mudanza -> list.add(mudanza.toVO()));
		return list;
	}

	public Mudanza get(int codigo) {
		return this.mudanzas.get(codigo);
	}

	public Mudanza getUltimo() {
		if(this.mudanzas.isEmpty()) {
			return null;
		}

		return this.mudanzas.get(this.mudanzas.size() -1);

	}
}
