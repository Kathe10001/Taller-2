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

public class VentanaDetalleMudanza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoServicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaDetalleMudanza frame = new VentanaDetalleMudanza();
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
	public VentanaDetalleMudanza() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 484);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAceptar = new JButton("Buscar");
		btnAceptar.setBackground(new Color(0, 204, 51));

		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "El costo de la mudanza es: $...");
				new VentanaMenu().setVisible(true);
			}
		});
		btnAceptar.setBounds(277, 405, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha cancelado la operación");
				new VentanaMenu().setVisible(true);
			}
		});
		btnCancelar.setBounds(68, 405, 117, 29);
		contentPane.add(btnCancelar);

		JLabel lblIngreseLosDatos =  new JLabel("Detalle de mudanza");
		lblIngreseLosDatos.setBounds(152, 17, 240, 28);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblCodigoMudanza = new JLabel("Número de mudanza");
		lblCodigoMudanza.setBounds(11, 71, 154, 16);
		contentPane.add(lblCodigoMudanza);

		txtCodigoServicio = new JTextField();
		txtCodigoServicio.setColumns(10);
		txtCodigoServicio.setBounds(190, 71, 202, 26);
		contentPane.add(txtCodigoServicio);
		
		JLabel lblFechaMudanza = new JLabel("Fecha de mudanza");
		lblFechaMudanza.setBounds(11, 103, 154, 16);
		contentPane.add(lblFechaMudanza);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(11, 134, 117, 16);
		contentPane.add(lblHoraInicio);
		
		JLabel lblDomicilioInicio = new JLabel("Domicilio de inicio");
		lblDomicilioInicio.setBounds(11, 165, 138, 16);
		contentPane.add(lblDomicilioInicio);
		
		JLabel lblDomicilioDestino = new JLabel("Domicilio de destino");
		lblDomicilioDestino.setBounds(10, 198, 138, 16);
		contentPane.add(lblDomicilioDestino);
		
		JLabel lblCodigoServicio = new JLabel("Código del servicio");
		lblCodigoServicio.setBounds(11, 230, 138, 16);
		contentPane.add(lblCodigoServicio);
		
		JLabel lblCedulaCliente = new JLabel("Cédula del cliente");
		lblCedulaCliente.setBounds(11, 262, 138, 16);
		contentPane.add(lblCedulaCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre del cliente");
		lblNombreCliente.setBounds(11, 294, 138, 16);
		contentPane.add(lblNombreCliente);
		
		JLabel lblApellidoCliente = new JLabel("Apellido del cliente");
		lblApellidoCliente.setBounds(11, 326, 138, 16);
		contentPane.add(lblApellidoCliente);
		
		JLabel lblTelefonoCliente = new JLabel("Télefono del cliente");
		lblTelefonoCliente.setBounds(11, 358, 129, 16);
		contentPane.add(lblTelefonoCliente);
		
		JLabel lblFechaMudanzaRes = new JLabel("-");
		lblFechaMudanzaRes.setBounds(190, 103, 154, 16);
		contentPane.add(lblFechaMudanzaRes);
		
		JLabel lblHoraInicioRes = new JLabel("-");
		lblHoraInicioRes.setBounds(190, 134, 154, 16);
		contentPane.add(lblHoraInicioRes);
		
		JLabel lblDomicilioInicioRes = new JLabel("-");
		lblDomicilioInicioRes.setBounds(190, 165, 154, 16);
		contentPane.add(lblDomicilioInicioRes);
		
		JLabel lblDomicilioDestinoRes = new JLabel("-");
		lblDomicilioDestinoRes.setBounds(190, 198, 154, 16);
		contentPane.add(lblDomicilioDestinoRes);
		
		JLabel lblCodigoServicioRes = new JLabel("-");
		lblCodigoServicioRes.setBounds(190, 230, 154, 16);
		contentPane.add(lblCodigoServicioRes);
		
		JLabel lblCedulaClienteRes = new JLabel("-");
		lblCedulaClienteRes.setBounds(190, 262, 154, 16);
		contentPane.add(lblCedulaClienteRes);
		
		JLabel lblNombreClienteRes = new JLabel("-");
		lblNombreClienteRes.setBounds(190, 294, 154, 16);
		contentPane.add(lblNombreClienteRes);
		
		JLabel lblApellidoClienteRes = new JLabel("-");
		lblApellidoClienteRes.setBounds(190, 326, 154, 16);
		contentPane.add(lblApellidoClienteRes);
		
		JLabel lblTelefonoClienteRes = new JLabel("-");
		lblTelefonoClienteRes.setBounds(190, 358, 154, 16);
		contentPane.add(lblTelefonoClienteRes);
	}
}