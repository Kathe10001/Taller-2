package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class Cliente {

	public static void main (String [] args) throws ClienteException, ServicioException, MudanzaException, PersistenciaException, ParseException {
		try{
	
			Propiedades propiedades = new Propiedades();
			IFachada fachada = (IFachada) Naming.lookup(propiedades.getRutaFachada());
			fachada.nuevoServicio(true, false, 2, 200, "Nuevo");
			fachada.altaNuevoCliente("", "", "", "");
		
			
			
			/*Date fecha1 = new SimpleDateFormat("dd-MM-yyyy").parse("05-04-2022");
			Date fecha2 = new SimpleDateFormat("dd-MM-yyyy").parse("06-04-2022");
			Date fecha3 = new SimpleDateFormat("dd-MM-yyyy").parse("03-03-2022");
			
			Date hora1 = new SimpleDateFormat("HH:mm").parse("13:30");
			Date hora2 = new SimpleDateFormat("HH:mm").parse("14:30");
			Date hora3 = new SimpleDateFormat("HH:mm").parse("22:30");
			
			fachada.altaMudanza(hora1, fecha1, "dasd", "asdsad", "1", "Nuevo");
			fachada.altaMudanza(hora2, fecha2, "dasd", "asdsad", "1", "Nuevo");*/
			//fachada.altaMudanza(hora3, fecha2, "dasd", "asdsad", "1", "Nuevo");
			
			//fachada.finalizacionMudanza(1, 2);
			//float costo = fachada.montoRecaudado(fecha1, fecha3);
			//System.out.println("costo" + costo);
			//fachada.altaMudanza(1, fecha2, "dasd", "asdsad", "1", "Nuevo");
			/*fachada.guardarCambios();
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
			
			System.out.println("costo" + costo);*/

		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (NotBoundException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
	}

}

