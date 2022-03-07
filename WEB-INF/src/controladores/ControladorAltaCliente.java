package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaAltaCliente;
import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.ClienteException;
import persistencia.Propiedades;

public class ControladorAltaCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaAltaCliente ventana;	

	
	public ControladorAltaCliente(VentanaAltaCliente v) {

		
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
	
	public void altaCliente(String cedula, String nombre, String apellido, String telefono) {
		try {
			fachada.altaNuevoCliente(cedula, nombre, apellido, telefono);
			JOptionPane.showMessageDialog(null, "Se ha dado de alta correctamente");
			new VentanaMenu().setVisible(true);
		} catch (ClienteException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

}



