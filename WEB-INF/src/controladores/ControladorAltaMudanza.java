package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import grafica.VentanaAltaMudanza;
import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorAltaMudanza extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaAltaMudanza ventana;	

	
	public ControladorAltaMudanza(VentanaAltaMudanza ventanaAltaMudanza) {

		
		this.ventana = ventanaAltaMudanza;
		
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
	
	public void altaMudanza (int horaInicio, Date fechaMudanza, String domicilioOrigen, String domicilioDestino, String cedula,
			String codigoServicio) throws PersistenciaException, RemoteException, ClienteException, ServicioException, MudanzaException {
		
		fachada.altaMudanza(horaInicio,fechaMudanza, domicilioOrigen,domicilioDestino, cedula, codigoServicio);
	}

	
}

	


