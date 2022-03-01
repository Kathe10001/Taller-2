package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaIngresoServicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaMudanza;
	private JTextField txtHoraInicio;
	private JTextField txtDomicilioDestino;
	private JTextField txtDomicilioInicio;
	private JTextField txtCodigoServicio;
	private JTextField txtCedulaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoServicio frame = new VentanaIngresoServicio();
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
	public VentanaIngresoServicio() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaMudanza = new JLabel("Fecha de Mudanza");
		lblFechaMudanza.setBounds(11, 50, 106, 16);
		contentPane.add(lblFechaMudanza);
		
		JLabel lblHoraInicio = new JLabel("Hora de Inicio");
		lblHoraInicio.setBounds(11, 81, 93, 16);
		contentPane.add(lblHoraInicio);
		
		txtFechaMudanza = new JTextField();
		txtFechaMudanza.setBounds(127, 45, 254, 26);
		contentPane.add(txtFechaMudanza);
		txtFechaMudanza.setColumns(10);
		
		txtHoraInicio = new JTextField();
		txtHoraInicio.setColumns(10);
		txtHoraInicio.setBounds(127, 76, 254, 26);
		contentPane.add(txtHoraInicio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 204, 51));
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha ingresado correctamente la mudanza");
			}
		});
		btnAceptar.setBounds(274, 255, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(204, 51, 51));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha cancelado la operacion");
			}
		});
		btnCancelar.setBounds(65, 255, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos de un nuevo Servicio");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIngreseLosDatos.setBounds(10, 3, 416, 19);
		contentPane.add(lblIngreseLosDatos);
		
		JLabel lblDomicilioInicio = new JLabel("Domicilio de Inicio");
		lblDomicilioInicio.setBounds(11, 112, 106, 16);
		contentPane.add(lblDomicilioInicio);
		
		txtDomicilioDestino = new JTextField();
		txtDomicilioDestino.setColumns(10);
		txtDomicilioDestino.setBounds(127, 140, 254, 26);
		contentPane.add(txtDomicilioDestino);
		
		JLabel lblDomicilioDestino = new JLabel("Domicilio de Destino");
		lblDomicilioDestino.setBounds(10, 145, 118, 16);
		contentPane.add(lblDomicilioDestino);
		
		txtDomicilioInicio = new JTextField();
		txtDomicilioInicio.setColumns(10);
		txtDomicilioInicio.setBounds(127, 108, 254, 26);
		contentPane.add(txtDomicilioInicio);
		
		txtCodigoServicio = new JTextField();
		txtCodigoServicio.setColumns(10);
		txtCodigoServicio.setBounds(127, 172, 254, 26);
		contentPane.add(txtCodigoServicio);
		
		JLabel lblCodigoServicio = new JLabel("Codigo del Servicio");
		lblCodigoServicio.setBounds(11, 177, 117, 16);
		contentPane.add(lblCodigoServicio);
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setColumns(10);
		txtCedulaCliente.setBounds(127, 204, 254, 26);
		contentPane.add(txtCedulaCliente);
		
		JLabel lblCedulaCliente = new JLabel("Cedula del Cliente");
		lblCedulaCliente.setBounds(11, 209, 106, 16);
		contentPane.add(lblCedulaCliente);
	}
}