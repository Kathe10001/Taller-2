package cliente;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class Cliente {

	public static void main (String [] args) throws ClienteException, ServicioException, MudanzaException, PersistenciaException {
		try{
	
			Propiedades propiedades = new Propiedades();

		
			IFachada fachada = (IFachada) Naming.lookup(propiedades.getRutaFachada());
			fachada.nuevoServicio(true, false, 1, 200, "Nuevo");
			fachada.altaNuevoCliente("1", "A", "B", "dasd");
			Date fecha = new Date();
			fachada.altaMudanza(1, fecha, "dasd", "asdsad", "1", "Nuevo");
			fachada.guardarCambios();
			//fachada.restaurarInformacion();
	

		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (NotBoundException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

