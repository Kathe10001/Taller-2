package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import grafica.VentanaListadoMudanzasPorFecha;
import logica.IFachada;
import logica.excepciones.MudanzaException;
import persistencia.Propiedades;
import valueObjects.VOMudanzaDetallado;

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
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void listadoMudanzasPorFecha(String fechaStr) {				
		
		try {
			
			Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaStr);
			
			ArrayList<VOMudanzaDetallado> mudanzas = fachada.listadoMudanzasXfecha(fecha);
			 
			String[] columnas = {"Codigo", "Hora de inicio" ,"Estado"};
			String[][] datos = null;
			DefaultTableModel model= new DefaultTableModel(datos, columnas);
			JTable tabla = new JTable(model);
			tabla.setEnabled(false);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 70, 400, 140);
			ventana.getContentPane().add(scrollPane);
			
			if(mudanzas != null && !mudanzas.isEmpty()) {
				
			
				for (int i = 0; i < mudanzas.size(); i++) {
					String finalizada = mudanzas.get(i).isFinalizacion() ? "Finalizada" : "No finalizada";
					String horaInicio = new SimpleDateFormat("HH:mm").format(mudanzas.get(i).getHoraInicio());
					
					Object[] row = {mudanzas.get(i).getNumContratacion(), horaInicio, finalizada};
					DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
					modelo.addRow(row);
				}			
			}
			
			scrollPane.setViewportView(tabla);
			
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



