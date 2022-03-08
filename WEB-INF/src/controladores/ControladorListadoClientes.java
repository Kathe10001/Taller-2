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

import grafica.VentanaListadoClientes;
import logica.IFachada;
import logica.excepciones.ClienteException;
import persistencia.Propiedades;
import valueObjects.VOCliente;

public class ControladorListadoClientes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private VentanaListadoClientes ventana;	

	
	public ControladorListadoClientes(VentanaListadoClientes v) {

		
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
	
	public void listadoClientes() {	
		try {
			ArrayList<VOCliente> clientes = fachada.listadoClientes();
			
			String[] columnas = {"Cedula","Nombre" ,"Apellido", "Telefono"};
			String[][] datos = null;
			DefaultTableModel model= new DefaultTableModel(datos, columnas);
			JTable tabla = new JTable(model);
			tabla.setEnabled(false);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 434, 262);
			ventana.getContentPane().add(scrollPane);
			
			System.out.print("ACA");
			if(clientes != null && !clientes.isEmpty()) {
				
	
				for (int i = 0; i < clientes.size(); i++) {
					System.out.print(clientes.get(i).getCedula());
					Object[] row = {clientes.get(i).getCedula(), clientes.get(i).getApellido(),clientes.get(i).getNombre(), clientes.get(i).getTelefono()};
					DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
					modelo.addRow(row);
				}			
			}
			
			scrollPane.setViewportView(tabla);
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClienteException e) {
			JOptionPane.showMessageDialog(null, e.darMensaje());
		}
	}

}



