package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;

import grafica.VentanaAltaCliente;
import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.PersistenciaException;
import persistencia.Propiedades;

public class ControladorAltaCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaAltaCliente ventana;	

	
	public ControladorAltaCliente(VentanaAltaCliente v) {

		
		this.ventana = v;
		
		try {
		
			Propiedades propiedades = new Propiedades();
		
			fachada = (IFachada) Naming.lookup(propiedades.getRutaFachada());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altaCliente(String cedula, String nombre, String apellido, String telefono) throws ClienteException, RemoteException {
		fachada.altaNuevoCliente(cedula, nombre, apellido, telefono);
		
	}

}



