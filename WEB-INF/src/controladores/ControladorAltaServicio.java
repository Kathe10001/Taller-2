package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaAltaServicio;
import logica.IFachada;
import logica.excepciones.ClienteException;
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
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void nuevoServicio(boolean armadoMuebles, boolean embalaje, String costoXhoraStr, String distanciaKmStr, String codigoServicio) {
		
		 
		try {
			
			if("".equals(costoXhoraStr) || "".equals(distanciaKmStr) || "".equals(codigoServicio)) {
				JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				
				float costoXhora = Float.parseFloat(costoXhoraStr);  
				float distanciaKm = Float.parseFloat(distanciaKmStr); 
				fachada.nuevoServicio(armadoMuebles, embalaje, costoXhora, distanciaKm, codigoServicio);
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
				ventana.dispose();
			}
			
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ServicioException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}

