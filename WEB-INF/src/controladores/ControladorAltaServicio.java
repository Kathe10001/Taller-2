package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorAltaServicio extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaMenu ventana;	

	
	public ControladorAltaServicio(VentanaMenu v) {

		
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

	public void nuevoServicio (boolean armadoMuebles, boolean embalaje, float costoXhora, float distanciaKm,
			String codigoServicio) throws PersistenciaException, RemoteException, ClienteException, ServicioException, MudanzaException {
		fachada.nuevoServicio(armadoMuebles, embalaje, costoXhora, distanciaKm, codigoServicio);
	}
}






