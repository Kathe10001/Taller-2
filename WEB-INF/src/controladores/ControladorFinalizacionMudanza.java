package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;

import grafica.VentanaFinalizacionMudanza;
import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorFinalizacionMudanza extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaFinalizacionMudanza ventana;	

	
	public ControladorFinalizacionMudanza(VentanaFinalizacionMudanza v) {

		
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
	
	public void altaCliente(int codigoMudanza, float duracion) throws RemoteException, MudanzaException, ServicioException {
		fachada.finalizacionMudanza(codigoMudanza, duracion);
		
	}

}



