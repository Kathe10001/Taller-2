package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraficaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GraficaPrincipal frame = new GraficaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraficaPrincipal() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 486);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAceptar = new JButton("Alta de nuevo cliente");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(Color.ORANGE);

		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "El costo de la mudanza es: $...");
			}
		});
		btnAceptar.setBounds(40, 104, 356, 29);
		contentPane.add(btnAceptar);

		JLabel lblIngreseLosDatos =  new JLabel("Menu Principal ");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIngreseLosDatos.setBounds(127, 11, 147, 28);
		contentPane.add(lblIngreseLosDatos);
		
		JButton btnListadoDeClientes = new JButton("Listado de clientes");
		btnListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListadoDeClientes.setForeground(Color.WHITE);
		btnListadoDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListadoDeClientes.setBackground(Color.ORANGE);
		btnListadoDeClientes.setBounds(40, 144, 356, 29);
		contentPane.add(btnListadoDeClientes);
		
		JButton btnContratacionDeNuevo = new JButton("Contratacion de nuevo servicio de mudanza");
		btnContratacionDeNuevo.setForeground(Color.WHITE);
		btnContratacionDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContratacionDeNuevo.setBackground(Color.ORANGE);
		btnContratacionDeNuevo.setBounds(40, 184, 356, 29);
		contentPane.add(btnContratacionDeNuevo);
		
		JButton btnFinalizacionDeNuevo = new JButton(" Finalizacion de nuevo servicio de mudanza");
		btnFinalizacionDeNuevo.setForeground(Color.WHITE);
		btnFinalizacionDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizacionDeNuevo.setBackground(Color.ORANGE);
		btnFinalizacionDeNuevo.setBounds(40, 224, 356, 29);
		contentPane.add(btnFinalizacionDeNuevo);
		
		JButton btnDetalleDeUna = new JButton("Detalle de una Mudanza");
		btnDetalleDeUna.setForeground(Color.WHITE);
		btnDetalleDeUna.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDetalleDeUna.setBackground(Color.ORANGE);
		btnDetalleDeUna.setBounds(40, 264, 356, 29);
		contentPane.add(btnDetalleDeUna);
		
		JButton btnMontoRecaudadoPor = new JButton("Monto recaudado por rango de fechas");
		btnMontoRecaudadoPor.setForeground(Color.WHITE);
		btnMontoRecaudadoPor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMontoRecaudadoPor.setBackground(Color.ORANGE);
		btnMontoRecaudadoPor.setBounds(40, 304, 356, 29);
		contentPane.add(btnMontoRecaudadoPor);
		
		JButton btnListadoDeServicios = new JButton("Listado de servicios de mudanza ofrecidos");
		btnListadoDeServicios.setForeground(Color.WHITE);
		btnListadoDeServicios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListadoDeServicios.setBackground(Color.ORANGE);
		btnListadoDeServicios.setBounds(40, 344, 356, 29);
		contentPane.add(btnListadoDeServicios);
		
		JButton btnListadoDeContrataciones = new JButton("Listado de contrataciones realizadas por fecha");
		btnListadoDeContrataciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListadoDeContrataciones.setForeground(Color.WHITE);
		btnListadoDeContrataciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListadoDeContrataciones.setBackground(Color.ORANGE);
		btnListadoDeContrataciones.setBounds(40, 384, 356, 29);
		contentPane.add(btnListadoDeContrataciones);
		
		JButton btnAltaDeNuevo = new JButton("Alta de nuevo servicio de Mudanza");
		btnAltaDeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaDeNuevo.setForeground(Color.WHITE);
		btnAltaDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAltaDeNuevo.setBackground(Color.ORANGE);
		btnAltaDeNuevo.setBounds(40, 64, 356, 29);
		contentPane.add(btnAltaDeNuevo);
	}
}