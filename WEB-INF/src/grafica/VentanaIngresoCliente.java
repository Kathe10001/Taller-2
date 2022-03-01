package grafica;

import java.awt.Color;
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

public class VentanaIngresoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
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
			public void run() {
				try {
					VentanaIngresoCliente frame = new VentanaIngresoCliente();
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
	public VentanaIngresoCliente() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 63, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 95, 61, 16);
		contentPane.add(lblApellido);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(102, 58, 254, 26);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(102, 90, 254, 26);
		contentPane.add(tfApellido);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.GREEN);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensaje");
			}
		});
		btnAceptar.setBounds(278, 226, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(70, 226, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseUnNuevo = new JLabel("Ingrese un nuevo Cliente");
		lblIngreseUnNuevo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblIngreseUnNuevo.setBounds(94, 21, 221, 26);
		contentPane.add(lblIngreseUnNuevo);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(40, 131, 61, 16);
		contentPane.add(lblCedula);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 126, 254, 26);
		contentPane.add(textField);
		
		JLabel lblTeleono = new JLabel("Telefono");
		lblTeleono.setBounds(40, 170, 61, 16);
		contentPane.add(lblTeleono);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 165, 254, 26);
		contentPane.add(textField_1);
	}
}