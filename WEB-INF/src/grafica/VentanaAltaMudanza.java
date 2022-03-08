package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controladores.ControladorAltaMudanza;
import logica.excepciones.ClienteException;
import logica.excepciones.MudanzaException;
//import controladores.ControladorMenu;
import logica.excepciones.PersistenciaException;
import logica.excepciones.ServicioException;

public class VentanaAltaMudanza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFechaMudanza;
	private JTextField tfHoraInicio;
	private JTextField tfDomicilioDestino;
	private JTextField tfDomicilioInicio;
	private JTextField tfCodigoServicio;
	private JTextField tfCedulaCliente;
	private ControladorAltaMudanza controlador = new ControladorAltaMudanza(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaAltaMudanza frame = new VentanaAltaMudanza();
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
	public VentanaAltaMudanza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLosDatos = new JLabel("Alta de mudanza");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblIngreseLosDatos.setBounds(176, 14, 142, 19);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblFechaMudanza = new JLabel("Fecha de mudanza dd-mm-yyyy");
		lblFechaMudanza.setBounds(11, 50, 216, 16);
		contentPane.add(lblFechaMudanza);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(11, 81, 93, 16);
		contentPane.add(lblHoraInicio);

		tfFechaMudanza = new JTextField();
		tfFechaMudanza.setBounds(239, 45, 142, 26);
		contentPane.add(tfFechaMudanza);
		tfFechaMudanza.setColumns(10);

		tfHoraInicio = new JTextField();
		tfHoraInicio.setColumns(10);
		tfHoraInicio.setBounds(175, 76, 206, 26);
		contentPane.add(tfHoraInicio);

		JLabel lblDomicilioInicio = new JLabel("Domicilio de inicio");
		lblDomicilioInicio.setBounds(11, 112, 132, 16);
		contentPane.add(lblDomicilioInicio);

		tfDomicilioDestino = new JTextField();
		tfDomicilioDestino.setColumns(10);
		tfDomicilioDestino.setBounds(175, 140, 206, 26);
		contentPane.add(tfDomicilioDestino);

		JLabel lblDomicilioDestino = new JLabel("Domicilio de destino");
		lblDomicilioDestino.setBounds(10, 145, 133, 16);
		contentPane.add(lblDomicilioDestino);

		tfDomicilioInicio = new JTextField();
		tfDomicilioInicio.setColumns(10);
		tfDomicilioInicio.setBounds(175, 108, 206, 26);
		contentPane.add(tfDomicilioInicio);

		tfCodigoServicio = new JTextField();
		tfCodigoServicio.setColumns(10);
		tfCodigoServicio.setBounds(175, 172, 206, 26);
		contentPane.add(tfCodigoServicio);

		JLabel lblCodigoServicio = new JLabel("Código del dervicio");
		lblCodigoServicio.setBounds(11, 177, 132, 16);
		contentPane.add(lblCodigoServicio);

		tfCedulaCliente = new JTextField();
		tfCedulaCliente.setColumns(10);
		tfCedulaCliente.setBounds(175, 204, 206, 26);
		contentPane.add(tfCedulaCliente);

		JLabel lblCedulaCliente = new JLabel("Cédula del cliente");
		lblCedulaCliente.setBounds(11, 209, 132, 16);
		contentPane.add(lblCedulaCliente);
		
		VentanaAltaMudanza ventana = this;
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controlador.altaMudanza(tfHoraInicio.getText(), tfFechaMudanza.getText(), tfDomicilioInicio.getText(), tfDomicilioDestino.getText(), tfCedulaCliente.getText(), tfCodigoServicio.getText());
				ventana.dispose();
			}
		});
		btnAceptar.setBounds(274, 255, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnCancelar.setBounds(65, 255, 117, 29);
		contentPane.add(btnCancelar);
	}
	
}