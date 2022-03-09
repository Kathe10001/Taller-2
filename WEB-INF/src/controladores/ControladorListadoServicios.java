package controladores;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import grafica.VentanaListadoServicios;
import logica.IFachada;
import logica.excepciones.ServicioException;
import persistencia.Propiedades;
import valueObjects.VOServicio;

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
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void listadoServicios() {	
		try {
			ArrayList<VOServicio> servicios = fachada.listadoServicios();
			
			String[] columnas = {"Codigo", "Armdo muebles" ,"Embalaje", "Costo por hora", "Distancia Km"};
			String[][] datos = null;
			DefaultTableModel model= new DefaultTableModel(datos, columnas);
			JTable tabla = new JTable(model);
			tabla.setEnabled(false);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 55, 400, 150);
			ventana.getContentPane().add(scrollPane);
			
			if(servicios != null && !servicios.isEmpty()) {
				
	
				for (int i = 0; i < servicios.size(); i++) {
					Object[] row = {servicios.get(i).getCodigo(), servicios.get(i).isArmadoMuebles(),servicios.get(i).isEmbalaje(), servicios.get(i).getCostoXhora(), servicios.get(i).getDistanciaKm()};
					DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
					modelo.addRow(row);
				}			
			}
			
			scrollPane.setViewportView(tabla);
			
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



