package negocio;

public class Servicio {
	private boolean armadoMuebles;

    private boolean embalaje;

    private float costoXhora;

    private float distanciaKm;

    private int codigo;
    

	public Servicio(boolean armadoMuebles, boolean embalaje, float costoXhora, float distanciaKm, int codigo) {
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
    
}
