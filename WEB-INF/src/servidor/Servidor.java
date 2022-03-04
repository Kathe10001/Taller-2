package servidor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import logica.Fachada;

public class Servidor {

	public Servidor() {

	}

	public static void main (String [] args) {
		try {
			//obtengo ip y puerto de un archivo de configuracion
			Properties p = new Properties();
			String nomArch = "/Users/kathe/Develop/Taller-2/WEB-INF/src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);

			//pongo a correr el rmiregistry
			LocateRegistry.createRegistry(port);

			//publico el objeto remoto en dicha ip y puerto
			String ruta = "//" + ip + ":" + puerto + "/fachada";
			Fachada fachada = new Fachada();
			System.out.println("Antes de publicar");
			Naming.rebind(ruta, fachada);
			System.out.println("Luego de publicar");
		} catch (RemoteException e) {
			e.printStackTrace(); }
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
