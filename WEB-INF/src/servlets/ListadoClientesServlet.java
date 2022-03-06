package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.IFachada;
import logica.excepciones.ClienteException;
import valueObjects.VOCliente;


public class ListadoClientesServlet extends HttpServlet {

	public ListadoClientesServlet() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    boolean error = true;
	    String msgError = "Hubo un error, inténtelo más tarde";

	    ArrayList<VOCliente> clientes = null;

		try {

			Properties p = new Properties();
			String nomArch = "/Users/kathe/Develop/Taller-2/WEB-INF/src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/fachada";

			IFachada fachada = (IFachada) Naming.lookup(ruta);
			clientes = fachada.listadoClientes();
			if (clientes != null && clientes.isEmpty()) {
				msgError = "No hay datos de los clientes";
			} else {
				error = false;
			}

		} catch (ClienteException e) {
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
		    	System.out.println(clientes.isEmpty());
		        session.setAttribute("clientes", clientes);
		    }
	    }

	    req.setAttribute("msgError", msgError);
		RequestDispatcher rd;
		if (!error) {
			rd = req.getRequestDispatcher("ListadoClientes.jsp");
		} else {
			rd = req.getRequestDispatcher("Error.jsp");
		}
		rd.forward(req, resp);
		
	}
}