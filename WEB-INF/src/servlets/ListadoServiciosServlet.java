package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Fachada;
import logica.IFachada;
import logica.colecciones.Mudanzas;
import logica.colecciones.Servicios;
import logica.excepciones.MudanzaException;
import logica.excepciones.ServicioException;
import valueObjects.VOMudanzaDetallado;
import valueObjects.VOServicio;


public class ListadoServiciosServlet extends HttpServlet {
	
	public ListadoServiciosServlet() throws RemoteException {
	}
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    boolean error = true;
	    String msgError = "Hubo un error, inténtelo más tarde";
	    
	    ArrayList<VOServicio> servicios = null;
	    
		try {
			
			Properties p = new Properties();
			String nomArch = "/Users/kathe/Develop/Taller-2/WEB-INF/src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/fachada";
			
			IFachada fachada = (IFachada) Naming.lookup(ruta);
	
			servicios = fachada.listadoServicios();
			
			if (servicios.isEmpty()) {
				msgError = "No hay datos de servicios";
			} else {
				error = false;
			}
			
		} catch (ServicioException e) {
			msgError = e.darMensaje();
		} catch (NotBoundException e) {
			msgError = e.getMessage();
		} catch (RemoteException e) {
			msgError = e.getMessage();
		}
		
	    if (!error){
	    	
	        HttpSession session = req.getSession();
		    synchronized (session) {
		        session.setAttribute("servicios", servicios);    
		    }		    
	    }    
	    
	  
		RequestDispatcher rd;
		if (!error)
			rd = req.getRequestDispatcher("ListadoServicios.jsp");
		else
			req.setAttribute("msgError", msgError);
			rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(req, resp);
	}
}