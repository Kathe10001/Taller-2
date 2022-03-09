package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorAltaCliente;

public class VentanaAltaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorAltaCliente controlador = new ControladorAltaCliente(this);
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfCedula;
	private JTextField tfTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaAltaCliente frame = new VentanaAltaCliente();
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
	public VentanaAltaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseUnNuevo = new JLabel("Alta de clientes");
		lblIngreseUnNuevo.setBounds(143, 19, 221, 26);
		contentPane.add(lblIngreseUnNuevo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 63, 61, 16);
		contentPane.add(lblNombre);

		tfNombre = new JTextField();
		tfNombre.setBounds(102, 58, 254, 26);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 95, 61, 16);
		contentPane.add(lblApellido);

		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(102, 90, 254, 26);
		contentPane.add(tfApellido);

		JLabel lblCedula = new JLabel("Cédula");
		lblCedula.setBounds(40, 131, 61, 16);
		contentPane.add(lblCedula);

		tfCedula = new JTextField();
		tfCedula.setColumns(10);
		tfCedula.setBounds(102, 126, 254, 26);
		contentPane.add(tfCedula);

		JLabel lblTelefono = new JLabel("Télefono");
		lblTelefono.setBounds(40, 170, 61, 16);
		contentPane.add(lblTelefono);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(102, 165, 254, 26);
		contentPane.add(tfTelefono);
		
		VentanaAltaCliente ventana = this;
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controlador.altaCliente(tfCedula.getText(), tfNombre.getText(), tfApellido.getText(), tfTelefono.getText());
				ventana.dispose();
			}
		});
		btnAceptar.setBounds(278, 226, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnCancelar.setBounds(70, 226, 117, 29);
		contentPane.add(btnCancelar);
	}
}