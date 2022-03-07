package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaAltaServicio;
import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorAltaServicio extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaAltaServicio ventana;	

	
	public ControladorAltaServicio(VentanaAltaServicio v) {

		
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
	
	public void nuevoServicio(boolean armadoMuebles, boolean embalaje, String costoXhoraStr, String distanciaKmStr, String codigoServicio) {
		
		 
		try {
			float costoXhora = Float.parseFloat(costoXhoraStr);  
			float distanciaKm = Float.parseFloat(distanciaKmStr); 
			fachada.nuevoServicio(armadoMuebles, embalaje, costoXhora, distanciaKm, codigoServicio);
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
			new VentanaMenu().setVisible(true);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ServicioException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje());
		}
		
	}
}

