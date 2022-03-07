package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import grafica.VentanaMontoRecaudadoRangoFechas;
import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import persistencia.Propiedades;

public class ControladorMontoRecaudadoRangoFechas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaMontoRecaudadoRangoFechas ventana;	

	
	public ControladorMontoRecaudadoRangoFechas(VentanaMontoRecaudadoRangoFechas v) {

		
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
	
	public void montoRecaudado(Date fechaInicio, Date fechaFin) throws RemoteException, MudanzaException {
		fachada.montoRecaudado(fechaInicio, fechaFin);
		
	}

}



