package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaListadoMudanzasPorFecha;
import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.MudanzaException;
import persistencia.Propiedades;

public class ControladorListadoMudanzasPorFecha extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaListadoMudanzasPorFecha ventana;	

	
	public ControladorListadoMudanzasPorFecha(VentanaListadoMudanzasPorFecha v) {

		
		this.ventana = v;
		
		try {
		
			Propiedades propiedades = new Propiedades();
		
			fachada = (IFachada) Naming.lookup(propiedades.getRutaFachada());
		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void listadoMudanzasPorFecha(String fechaStr) {	
		try {
			Date fecha = new Date();
			fachada.listadoMudanzasXfecha(fecha);
			new VentanaMenu().setVisible(true);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (MudanzaException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje());
		}
	}

}



