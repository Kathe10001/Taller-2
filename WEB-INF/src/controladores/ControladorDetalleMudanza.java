package controladores;

import java.awt.Container;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import grafica.VentanaDetalleMudanza;
import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.MudanzaException;
import persistencia.Propiedades;
import valueObjects.VOMudanzaDetallado;

public class ControladorDetalleMudanza extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaDetalleMudanza ventana;	

	
	public ControladorDetalleMudanza(VentanaDetalleMudanza v) {

		
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
	
	public void detalleMudanza(String codigoMuanzaStr) {
		
		 
		try {
			int codigoMudanza = Integer.parseInt(codigoMuanzaStr);  
			VOMudanzaDetallado detalleMudanza = fachada.detalleMudanza(codigoMudanza);
			ventana.mostrarDetalle(detalleMudanza);
			
			
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (MudanzaException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}