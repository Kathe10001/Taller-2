package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaFinalizacionMudanza;
import logica.IFachada;
import logica.excepciones.MudanzaException;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorFinalizacionMudanza extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaFinalizacionMudanza ventana;	

	
	public ControladorFinalizacionMudanza(VentanaFinalizacionMudanza v) {

		
		this.ventana = v;
		
		try {
		
			Propiedades propiedades = new Propiedades();
		
			fachada = (IFachada) Naming.lookup(propiedades.getRutaFachada());
		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void finalizacionMudanza(String codigoMudanzaStr, String duracionStr) {		
		try {
			int codigoMudanza =  Integer.parseInt(codigoMudanzaStr);
			float duracion =  Float.parseFloat(duracionStr);
			
			float costo = fachada.finalizacionMudanza(codigoMudanza, duracion);
			JOptionPane.showMessageDialog(null, "Se finalizo la mudanza, el costo es: $" + costo);
		
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (MudanzaException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ServicioException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}



