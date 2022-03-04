package cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import logica.IFachada;
import logica.excepciones.ClienteException;
import logica.excepciones.ServicioException;

public class Cliente {

	public static void main (String [] args) throws ClienteException, ServicioException {
		try{
	
			Properties p = new Properties();
			String nomArch = "/Users/kathe/Develop/Taller-2/WEB-INF/src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/fachada";

			IFachada fachada = (IFachada) Naming.lookup(ruta);
			fachada.nuevoServicio(true, false, 1, 200, "Nuevo");
			System.out.println(fachada.listadoServicios().size());

		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (NotBoundException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
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