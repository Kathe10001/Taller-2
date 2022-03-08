package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaListadoServicios;
import grafica.VentanaMenu;
import logica.IFachada;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;

public class ControladorListadoServicios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaListadoServicios ventana;	

	
	public ControladorListadoServicios(VentanaListadoServicios v) {

		
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
	
	public void listadoServicios() {	
		try {
			fachada.listadoServicios();
			new VentanaMenu().setVisible(true);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ServicioException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje());
		}
	}

}



