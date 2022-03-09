package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JLabel lblDuracionTotalRes;
	private JLabel lblNumeroContratacionRes;
	private JLabel lblFinalizacionRes;
	
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
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCodigoMudanza = new JTextField();
		txtCodigoMudanza.setColumns(10);
		txtCodigoMudanza.setBounds(190, 41, 202, 26);
		contentPane.add(txtCodigoMudanza);

		JLabel lblIngreseLosDatos =  new JLabel("Detalle de mudanza");
		lblIngreseLosDatos.setBounds(152, 6, 240, 28);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblCodigoMudanza = new JLabel("Numero de mudanza");
		lblCodigoMudanza.setBounds(11, 46, 154, 16);
		contentPane.add(lblCodigoMudanza);
		
		JLabel lblFechaMudanza = new JLabel("Fecha de mudanza");
		lblFechaMudanza.setBounds(11, 74, 154, 16);
		contentPane.add(lblFechaMudanza);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(11, 102, 117, 16);
		contentPane.add(lblHoraInicio);
		
		JLabel lblDomicilioInicio = new JLabel("Domicilio de inicio");
		lblDomicilioInicio.setBounds(11, 130, 138, 16);
		contentPane.add(lblDomicilioInicio);
		
		JLabel lblDomicilioDestino = new JLabel("Domicilio de destino");
		lblDomicilioDestino.setBounds(11, 158, 138, 16);
		contentPane.add(lblDomicilioDestino);
		
		JLabel lblDuracionTotal = new JLabel("Duracion total");
		lblDuracionTotal.setBounds(11, 186, 138, 16);
		contentPane.add(lblDuracionTotal);
		
		JLabel lblNumeroContratacion = new JLabel("Numero contratacion");
		lblNumeroContratacion.setBounds(11, 237, 138, 16);
		contentPane.add(lblNumeroContratacion);
		
		JLabel lblFinalizacion = new JLabel("Finalizacion");
		lblFinalizacion.setBounds(11, 214, 138, 16);
		contentPane.add(lblFinalizacion);
		
		JLabel lblCodigoServicio = new JLabel("Codigo del servicio");
		lblCodigoServicio.setBounds(11, 265, 138, 16);
		contentPane.add(lblCodigoServicio);
		
		JLabel lblCedulaCliente = new JLabel("Cedula del cliente");
		lblCedulaCliente.setBounds(11, 293, 138, 16);
		contentPane.add(lblCedulaCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre del cliente");
		lblNombreCliente.setBounds(11, 321, 138, 16);
		contentPane.add(lblNombreCliente);
		
		JLabel lblApellidoCliente = new JLabel("Apellido del cliente");
		lblApellidoCliente.setBounds(11, 349, 138, 16);
		contentPane.add(lblApellidoCliente);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono del cliente");
		lblTelefonoCliente.setBounds(11, 377, 129, 16);
		contentPane.add(lblTelefonoCliente);
		
		lblFechaMudanzaRes = new JLabel("-");
		lblFechaMudanzaRes.setBounds(190, 74, 154, 16);
		contentPane.add(lblFechaMudanzaRes);
		
		lblHoraInicioRes = new JLabel("-");
		lblHoraInicioRes.setBounds(190, 102, 154, 16);
		contentPane.add(lblHoraInicioRes);
		
		lblDomicilioInicioRes = new JLabel("-");
		lblDomicilioInicioRes.setBounds(190, 130, 154, 16);
		contentPane.add(lblDomicilioInicioRes);
		
		lblDomicilioDestinoRes = new JLabel("-");
		lblDomicilioDestinoRes.setBounds(190, 158, 154, 16);
		contentPane.add(lblDomicilioDestinoRes);
		
		lblDuracionTotalRes = new JLabel("-");
		lblDuracionTotalRes.setBounds(190, 186, 154, 16);
		contentPane.add(lblDuracionTotalRes);
		
		lblNumeroContratacionRes = new JLabel("-");
		lblNumeroContratacionRes.setBounds(190, 237, 154, 16);
		contentPane.add(lblNumeroContratacionRes);
		
		lblFinalizacionRes = new JLabel("-");
		lblFinalizacionRes.setBounds(190, 214, 154, 16);
		contentPane.add(lblFinalizacionRes);
		
		lblCodigoServicioRes = new JLabel("-");
		lblCodigoServicioRes.setBounds(190, 265, 154, 16);
		contentPane.add(lblCodigoServicioRes);
		
		lblCedulaClienteRes = new JLabel("-");
		lblCedulaClienteRes.setBounds(190, 293, 154, 16);
		contentPane.add(lblCedulaClienteRes);
		
		lblNombreClienteRes = new JLabel("-");
		lblNombreClienteRes.setBounds(190, 321, 154, 16);
		contentPane.add(lblNombreClienteRes);
		
		lblApellidoClienteRes = new JLabel("-");
		lblApellidoClienteRes.setBounds(190, 349, 154, 16);
		contentPane.add(lblApellidoClienteRes);
		
		lblTelefonoClienteRes = new JLabel("-");
		lblTelefonoClienteRes.setBounds(190, 377, 154, 16);
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

		JButton btnCancelar = new JButton("Cerrar");
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
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		 DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		 
	     String strDate = dateFormat.format(detalleMudanza.getFechaMudanza()); 
	     String strHora = timeFormat.format(detalleMudanza.getHoraInicio()); 
         String duracionTotal = String.valueOf(detalleMudanza.getDuracionTotal());
         String numeroContratacion = String.valueOf(detalleMudanza.getNumContratacion());
         String finalizacion = detalleMudanza.isFinalizacion() ? "Finalizada" : "No finalizada";
	     
		lblFechaMudanzaRes.setText(strDate);
		lblHoraInicioRes.setText(strHora);
		lblDomicilioInicioRes.setText(detalleMudanza.getDomicilioOrigen());
		lblDomicilioDestinoRes.setText(detalleMudanza.getDomicilioDestino());
		lblDuracionTotalRes.setText(duracionTotal);
		lblNumeroContratacionRes.setText(numeroContratacion);
		lblFinalizacionRes.setText(finalizacion);
		lblCodigoServicioRes.setText(detalleMudanza.getCodigoServicio());
		lblCedulaClienteRes.setText(detalleMudanza.getCedula());
		lblNombreClienteRes.setText(detalleMudanza.getNombre());
		lblApellidoClienteRes.setText(detalleMudanza.getApellido());
		lblTelefonoClienteRes.setText(detalleMudanza.getTelefono());
	
	}
}