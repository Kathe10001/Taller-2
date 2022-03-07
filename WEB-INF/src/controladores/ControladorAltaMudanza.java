package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import grafica.VentanaAltaMudanza;
import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorAltaMudanza extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaAltaMudanza ventana;	

	
	public ControladorAltaMudanza(VentanaAltaMudanza v) {

		
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
	
	public void altaMudanza(String horaInicioStr, String fechaMudanzaStr, String domicilioOrigen, String domicilioDestino, String cedula,
			String codigoServicio) throws ClienteException, ServicioException, MudanzaException, RemoteException, ParseException {
		
		int horaInicio = Integer.parseInt(horaInicioStr);
		Date fechaMudanza = new SimpleDateFormat("yyyy-MM-dd").parse(horaInicioStr);
		fachada.altaMudanza(horaInicio, fechaMudanza, domicilioOrigen, domicilioDestino, cedula, codigoServicio);
	}
}