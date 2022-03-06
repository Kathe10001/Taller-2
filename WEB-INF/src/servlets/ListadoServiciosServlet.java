package servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.IFachada;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;
import valueObjects.VOServicio;


public class ListadoServiciosServlet extends HttpServlet {

	public ListadoServiciosServlet() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    boolean error = true;
	    String msgError = "Hubo un error, inténtelo más tarde";

	    ArrayList<VOServicio> servicios = null;

		try {

			Propiedades p = new Propiedades();
			String ip = p.getIpServidor();
			String puerto = p.getPuertoServidor();
			
			String ruta = "//" + ip + ":" + puerto + "/fachada";

			IFachada fachada = (IFachada) Naming.lookup(ruta);
			servicios = fachada.listadoServicios();
			if (servicios != null && servicios.isEmpty()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	    if (!error){

	        HttpSession session = req.getSession();
		    synchronized (session) {
		        session.setAttribute("servicios", servicios);
		    }
	    }

	    req.setAttribute("msgError", msgError);
		RequestDispatcher rd;
		if (!error) {
			rd = req.getRequestDispatcher("ListadoServicios.jsp");
		} else {
			rd = req.getRequestDispatcher("Error.jsp");
		}
		rd.forward(req, resp);
		
	}
}