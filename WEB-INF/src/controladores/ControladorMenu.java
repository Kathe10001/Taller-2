package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;

import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.PersistenciaException;
import persistencia.Propiedades;

public class ControladorMenu extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaMenu ventana;	

	
	public ControladorMenu(VentanaMenu v) {

		
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

	public void restaurarInformacion () throws PersistenciaException, RemoteException {
		fachada.restaurarInformacion();
	}
	
	public void guardarCambios () throws PersistenciaException, RemoteException {
		fachada.guardarCambios();
	}
}



