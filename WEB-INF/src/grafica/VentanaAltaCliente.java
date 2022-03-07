package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorAltaCliente;
import controladores.ControladorMenu;
import logica.excepciones.ClienteException;

public class VentanaAltaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorAltaCliente controladorAltaCliente = new ControladorAltaCliente(this);
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField textField;
	private JTextField textField_1;

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
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseUnNuevo = new JLabel("Ingrese un nuevo Cliente");
		lblIngreseUnNuevo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblIngreseUnNuevo.setBounds(94, 21, 221, 26);
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

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(40, 131, 61, 16);
		contentPane.add(lblCedula);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 126, 254, 26);
		contentPane.add(textField);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(40, 170, 61, 16);
		contentPane.add(lblTelefono);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
			
					controladorAltaCliente.altaCliente(lblCedula.getText(), lblNombre.getText(), lblApellido.getText(), lblTelefono.getText());
					JOptionPane.showMessageDialog(null, "Se ha dado de alta correctamente");
					new VentanaMenu().setVisible(true);
				} catch (ClienteException e) {
					JOptionPane.showMessageDialog(null, e.darMensaje());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		btnAceptar.setBounds(278, 226, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha cancelado la operación");
				new VentanaMenu().setVisible(true);
			}
		});
		btnCancelar.setBounds(70, 226, 117, 29);
		contentPane.add(btnCancelar);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 165, 254, 26);
		contentPane.add(textField_1);
	}
}