package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controladores.ControladorMenu;
import logica.excepciones.PersistenciaException;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorMenu controladorMenu = new ControladorMenu(this);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 536);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseLosDatos =  new JLabel("Menu principal ");
		lblIngreseLosDatos.setBounds(172, 24, 147, 28);
		contentPane.add(lblIngreseLosDatos);
		
		JButton btnAltaCliente = new JButton("Alta de cliente");
		btnAltaCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAltaCliente().setVisible(true);
			}
		});
		btnAltaCliente.setBounds(40, 104, 356, 29);
		contentPane.add(btnAltaCliente);
		
		JButton btnAltaMudanza = new JButton("Alta de mudanza");
		btnAltaMudanza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAltaMudanza().setVisible(true);
			}
		});
		btnAltaMudanza.setBounds(40, 145, 356, 29);
		contentPane.add(btnAltaMudanza);
		
		JButton btnAltaServicio = new JButton("Alta de servicio");
		btnAltaServicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAltaServicio().setVisible(true);
			}
		});
		btnAltaServicio.setBounds(40, 64, 356, 29);
		contentPane.add(btnAltaServicio);
		
		JButton btnFinalizacionMudanza = new JButton("Finalizacion de mudanza");
		btnFinalizacionMudanza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaFinalizacionMudanza().setVisible(true);
			}
		});
		btnFinalizacionMudanza.setBounds(40, 186, 356, 29);
		contentPane.add(btnFinalizacionMudanza);
		
		JButton btnDetalleMudanza = new JButton("Detalle de mudanza");
		btnDetalleMudanza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaDetalleMudanza().setVisible(true);
			}
		});
		btnDetalleMudanza.setBounds(40, 227, 356, 29);
		contentPane.add(btnDetalleMudanza);
		
		JButton btnMontoRecaudadoPorRangoFechas = new JButton("Monto recaudado por rango de fechas");
		btnMontoRecaudadoPorRangoFechas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMontoRecaudadoRangoFechas().setVisible(true);
			}
		});
		btnMontoRecaudadoPorRangoFechas.setBounds(40, 268, 356, 29);
		contentPane.add(btnMontoRecaudadoPorRangoFechas);
		
		JButton btnListadoClientes = new JButton("Listado de clientes");
		btnListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaListadoClientes().setVisible(true);
			}
		});
		btnListadoClientes.setBounds(40, 309, 356, 29);
		contentPane.add(btnListadoClientes);
		
		JButton btnListadoServicios = new JButton("Listado de servicios");
		btnListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaListadoServicios().setVisible(true);
			}
		});
		btnListadoServicios.setBounds(40, 350, 356, 29);
		contentPane.add(btnListadoServicios);
		
		JButton btnMudanzaPorFecha = new JButton("Listado de mudanzas por fecha");
		btnListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaListadoMudanzasPorFecha().setVisible(true);
			}
		});
		btnMudanzaPorFecha.setBounds(40, 391, 356, 29);
		contentPane.add(btnMudanzaPorFecha);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					controladorMenu.guardarCambios();
					JOptionPane.showMessageDialog(null, "Se guardaron los datos");
				} catch (PersistenciaException e) {
					JOptionPane.showMessageDialog(null, e.darMensaje());
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnGuardar.setBounds(40, 456, 135, 29);
		contentPane.add(btnGuardar);
		
		JButton btnRestaurar = new JButton("Restaurar");
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					controladorMenu.restaurarInformacion();
					JOptionPane.showMessageDialog(null, "Se restauraron los datos");
				} catch (PersistenciaException e) {
					JOptionPane.showMessageDialog(null, e.darMensaje());
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnRestaurar.setBounds(261, 456, 135, 29);
		contentPane.add(btnRestaurar);
	}
}