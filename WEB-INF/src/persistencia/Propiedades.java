package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {

	String nomArch = "config/config.properties";
	
	public String getIpServidor() {
			
			Properties p = new Properties();
			
			String ip = null;
		try {
			p.load (new FileInputStream (nomArch));
			ip = p.getProperty("ipServidor");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ip;
	}

	public String getPuertoServidor() {
		
		Properties p = new Properties();
		String puerto= null;
		try {
			p.load (new FileInputStream (nomArch));
			puerto = p.getProperty("puertoServidor");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return puerto;
	
	}	
	
	public String getArchivoRespaldo() {
		
		Properties p = new Properties();
		String archivo = null;
		try {
			p.load (new FileInputStream (nomArch));
			archivo = p.getProperty("archivo");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		return archivo;
	
	}	
	
	public String getRutaFachada() {
		
		Propiedades p = new Propiedades();
		String ip = p.getIpServidor();
		String puerto = p.getPuertoServidor();
	
			
		return "//" + ip + ":" + puerto + "/fachada";
	
	}
	
}
