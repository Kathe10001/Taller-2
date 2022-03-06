package servidor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import logica.Fachada;
import persistencia.Propiedades;

public class Servidor {

	public Servidor() {

	}

	public static void main (String [] args) {
		try {
			
			Propiedades propiedades = new Propiedades();			
			int port = Integer.parseInt(propiedades.getPuertoServidor());
			LocateRegistry.createRegistry(port);

			Fachada fachada = new Fachada();
			System.out.println("Antes de publicar");
			Naming.rebind(propiedades.getRutaFachada(), fachada);
			System.out.println("Luego de publicar");
		} catch (RemoteException e) {
			e.printStackTrace(); }
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
