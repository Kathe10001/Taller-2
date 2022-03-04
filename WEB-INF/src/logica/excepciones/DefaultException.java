package logica.excepciones;

public class DefaultException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensaje;

	public DefaultException (String mensaje) { this.mensaje = mensaje; }

	public String darMensaje(){
		return mensaje;
	}
}
