package cliente;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;
import valueObjects.VOCliente;
import valueObjects.VOMudanzaDetallado;
import valueObjects.VOServicio;

public class Cliente {

	public static void main (String [] args) throws ClienteException, ServicioException, MudanzaException, PersistenciaException {
		try{
	
			Propiedades propiedades = new Propiedades();
			IFachada fachada = (IFachada) Naming.lookup(propiedades.getRutaFachada());
			fachada.nuevoServicio(true, false, 2, 200, "Nuevo");
			fachada.altaNuevoCliente("1", "A", "B", "dasd");
			
			Date desde = new Date();
			Date fecha = new Date();
			fachada.altaMudanza(1, fecha, "dasd", "asdsad", "1", "Nuevo");
			fachada.guardarCambios();
			fachada.restaurarInformacion();
			fachada.detalleMudanza(0);
	
			float valor = fachada.finalizacionMudanza(0, 2);
			//System.out.println(valor);
			fachada.detalleMudanza(0);
			
			
		    Calendar calendar = Calendar.getInstance();
	        calendar.setTime(desde);
	        calendar.add(Calendar.DATE, 1);
	        Date hasta = calendar.getTime();        
			float costo = fachada.montoRecaudado(desde, hasta);
			
			System.out.println("costo" + costo);

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

