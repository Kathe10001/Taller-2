package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;

import grafica.VentanaMontoRecaudadoRangoFechas;
import logica.IFachada;
import logica.excepciones.MudanzaException;
import persistencia.Propiedades;

public class ControladorMontoRecaudadoRangoFechas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaMontoRecaudadoRangoFechas ventana;	

	
	public ControladorMontoRecaudadoRangoFechas(VentanaMontoRecaudadoRangoFechas v) {

		
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
	
	public void montoRecaudado(String fechaInicioStr, String fechaFinStr) {
		try {
			Date fechaInicio = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicioStr);
			Date fechaFin = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFinStr);
			
		
		float monto = fachada.montoRecaudado(fechaInicio, fechaFin);
		
		JOptionPane.showMessageDialog(null, "El monto recaudado es: $" + monto);
		} catch (MudanzaException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}



