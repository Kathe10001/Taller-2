package grafica;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorAltaServicio;
import controladores.ControladorDetalleMudanza;
import valueObjects.VOMudanzaDetallado;

public class VentanaDetalleMudanza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoMudanza;
	private ControladorDetalleMudanza controlador = new ControladorDetalleMudanza(this);
	private JLabel lblHoraInicioRes;
	private JLabel lblFechaMudanzaRes;
	private JLabel lblDomicilioInicioRes;
	private JLabel lblDomicilioDestinoRes;
	private JLabel lblCodigoServicioRes;
	private JLabel lblCedulaClienteRes;
	private JLabel lblNombreClienteRes;
	private JLabel lblApellidoClienteRes;
	private JLabel lblTelefonoClienteRes;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 484);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseLosDatos =  new JLabel("Detalle de mudanza");
		lblIngreseLosDatos.setBounds(152, 17, 240, 28);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblCodigoMudanza = new JLabel("Numero de mudanza");
		lblCodigoMudanza.setBounds(11, 71, 154, 16);
		contentPane.add(lblCodigoMudanza);

		txtCodigoMudanza = new JTextField();
		txtCodigoMudanza.setColumns(10);
		txtCodigoMudanza.setBounds(190, 71, 202, 26);
		contentPane.add(txtCodigoMudanza);
		
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
		
		JLabel lblCodigoServicio = new JLabel("Codigo del servicio");
		lblCodigoServicio.setBounds(11, 230, 138, 16);
		contentPane.add(lblCodigoServicio);
		
		JLabel lblCedulaCliente = new JLabel("Cedula del cliente");
		lblCedulaCliente.setBounds(11, 262, 138, 16);
		contentPane.add(lblCedulaCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre del cliente");
		lblNombreCliente.setBounds(11, 294, 138, 16);
		contentPane.add(lblNombreCliente);
		
		JLabel lblApellidoCliente = new JLabel("Apellido del cliente");
		lblApellidoCliente.setBounds(11, 326, 138, 16);
		contentPane.add(lblApellidoCliente);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono del cliente");
		lblTelefonoCliente.setBounds(11, 358, 129, 16);
		contentPane.add(lblTelefonoCliente);
		
		lblFechaMudanzaRes = new JLabel("-");
		lblFechaMudanzaRes.setBounds(190, 103, 154, 16);
		contentPane.add(lblFechaMudanzaRes);
		
		lblHoraInicioRes = new JLabel("-");
		lblHoraInicioRes.setBounds(190, 134, 154, 16);
		contentPane.add(lblHoraInicioRes);
		
		lblDomicilioInicioRes = new JLabel("-");
		lblDomicilioInicioRes.setBounds(190, 165, 154, 16);
		contentPane.add(lblDomicilioInicioRes);
		
		lblDomicilioDestinoRes = new JLabel("-");
		lblDomicilioDestinoRes.setBounds(190, 198, 154, 16);
		contentPane.add(lblDomicilioDestinoRes);
		
		lblCodigoServicioRes = new JLabel("-");
		lblCodigoServicioRes.setBounds(190, 230, 154, 16);
		contentPane.add(lblCodigoServicioRes);
		
		lblCedulaClienteRes = new JLabel("-");
		lblCedulaClienteRes.setBounds(190, 262, 154, 16);
		contentPane.add(lblCedulaClienteRes);
		
		lblNombreClienteRes = new JLabel("-");
		lblNombreClienteRes.setBounds(190, 294, 154, 16);
		contentPane.add(lblNombreClienteRes);
		
		lblApellidoClienteRes = new JLabel("-");
		lblApellidoClienteRes.setBounds(190, 326, 154, 16);
		contentPane.add(lblApellidoClienteRes);
		
		lblTelefonoClienteRes = new JLabel("-");
		lblTelefonoClienteRes.setBounds(190, 358, 154, 16);
		contentPane.add(lblTelefonoClienteRes);
		
		VentanaDetalleMudanza ventana = this;
		
		JButton btnAceptar = new JButton("Buscar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.detalleMudanza(txtCodigoMudanza.getText());
			}
		});
		btnAceptar.setBounds(277, 405, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnCancelar.setBounds(68, 405, 117, 29);
		contentPane.add(btnCancelar);
	
	}
	
	public void mostrarDetalle(VOMudanzaDetallado detalleMudanza) {
		
		lblFechaMudanzaRes.setText(detalleMudanza.getFechaMudanza().toString());
		lblHoraInicioRes.setText(String.valueOf(detalleMudanza.getHoraInicio()));
		lblDomicilioInicioRes.setText(detalleMudanza.getDomicilioOrigen());
		lblDomicilioDestinoRes.setText(detalleMudanza.getDomicilioDestino());
		lblCodigoServicioRes.setText(detalleMudanza.getCodigoServicio());
		lblCedulaClienteRes.setText(detalleMudanza.getCedula());
		lblNombreClienteRes.setText(detalleMudanza.getNombre());
		lblApellidoClienteRes.setText(detalleMudanza.getApellido());
		lblTelefonoClienteRes.setText(detalleMudanza.getTelefono());
	
	}
}