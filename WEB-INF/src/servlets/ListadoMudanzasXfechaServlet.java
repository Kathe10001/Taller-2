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
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.IFachada;
import logica.excepciones.MudanzaException;
import valueObjects.VOMudanzaDetallado;


public class ListadoMudanzasXfechaServlet extends HttpServlet {

	public ListadoMudanzasXfechaServlet() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    String strFecha = req.getParameter("fecha");

	    boolean error = true;
	    String msgError = "Hubo un error, inténtelo más tarde";

	    ArrayList<VOMudanzaDetallado> mudanzas = null;

	    if ((strFecha == null) || strFecha.trim().equals("")) {
			msgError = "La fecha no puede estar vacía";
	    }

	    Date fecha = null;
		try {

			Properties p = new Properties();
			String nomArch = "/Users/kathe/Develop/Taller-2/WEB-INF/src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/fachada";

			IFachada fachada = (IFachada) Naming.lookup(ruta);

			fecha = new SimpleDateFormat("dd-mm-yyyy").parse(strFecha);

			mudanzas = fachada.listadoMudanzasXfecha(fecha);

			if (mudanzas.isEmpty()) {
				msgError = "No hay datos de mudanzas";
			} else {
				error = false;
			}
		} catch (ParseException e) {
			msgError = "Error de parseo";

		} catch (MudanzaException e) {
			msgError = e.darMensaje();
		} catch (NotBoundException e) {
			msgError = e.getMessage();
		} catch (RemoteException e) {
			msgError = e.getMessage();
		}

	    if (!error){

	        HttpSession session = req.getSession();
		    synchronized (session) {
		        session.setAttribute("mundanzas", mudanzas);
		    }
	    }


		RequestDispatcher rd;
		if (!error)
			rd = req.getRequestDispatcher("ListadoMudanzasXfechaResultados.jsp");
		else
			req.setAttribute("msgError", msgError);
			rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(req, resp);
	}
}