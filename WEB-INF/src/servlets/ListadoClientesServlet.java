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
import logica.excepciones.ClienteException;
import persistencia.Propiedades;
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

			Propiedades p = new Propiedades();
			String ip = p.getIpServidor();
			String puerto = p.getPuertoServidor();
			
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