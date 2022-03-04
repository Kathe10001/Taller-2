package negocio;

import valueObjects.VOServicio;

public class Servicio {
	
	private boolean armadoMuebles;

    private boolean embalaje;

    private float costoXhora;

    private float distanciaKm;

    private String codigo;


    public Servicio() {
	}

	public Servicio(boolean armadoMuebles, boolean embalaje, float costoXhora, float distanciaKm, String codigo) {
		super();
		this.armadoMuebles = armadoMuebles;
		this.embalaje = embalaje;
		this.costoXhora = costoXhora;
		this.distanciaKm = distanciaKm;
		this.codigo = codigo;
	}

	public boolean isArmadoMuebles() {
		return armadoMuebles;
	}

	public void setArmadoMuebles(boolean armadoMuebles) {
		this.armadoMuebles = armadoMuebles;
	}

	public boolean isEmbalaje() {
		return embalaje;
	}

	public void setEmbalaje(boolean embalaje) {
		this.embalaje = embalaje;
	}

	public float getCostoXhora() {
		return costoXhora;
	}

	public void setCostoXhora(float costoXhora) {
		this.costoXhora = costoXhora;
	}

	public float getDistanciaKm() {
		return distanciaKm;
	}

	public void setDistanciaKm(float distanciaKm) {
		this.distanciaKm = distanciaKm;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public VOServicio toVO() {
		VOServicio servicio = new VOServicio();
		servicio.setArmadoMuebles(this.armadoMuebles);
		servicio.setEmbalaje(this.embalaje);
		servicio.setCostoXhora(this.costoXhora);
		servicio.setDistanciaKm(this.distanciaKm);
		servicio.setCodigo(this.codigo);
		return servicio;
	}
}
