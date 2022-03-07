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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setBackground(new Color(0, 204, 51));

		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "El costo de la mudanza es: $...");
			}
		});
		btnAceptar.setBounds(277, 405, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(204, 51, 51));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha cancelado la operacion");
			}
		});
		btnCancelar.setBounds(68, 405, 117, 29);
		contentPane.add(btnCancelar);

		JLabel lblIngreseLosDatos =  new JLabel("Detalle de una Mudanza");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIngreseLosDatos.setBounds(81, 11, 240, 28);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblCodigoServicio = new JLabel("Numero de Contratacion");
		lblCodigoServicio.setBounds(11, 71, 128, 16);
		contentPane.add(lblCodigoServicio);

		txtCodigoServicio = new JTextField();
		txtCodigoServicio.setColumns(10);
		txtCodigoServicio.setBounds(138, 71, 254, 26);
		contentPane.add(txtCodigoServicio);
		
		JLabel label = new JLabel("Fecha de Mudanza");
		label.setBounds(11, 103, 106, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(138, 103, 254, 26);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Hora de Inicio");
		label_1.setBounds(11, 134, 93, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 134, 254, 26);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Domicilio de Inicio");
		label_2.setBounds(11, 165, 106, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 166, 254, 26);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Domicilio de Destino");
		label_3.setBounds(10, 198, 118, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(138, 198, 254, 26);
		contentPane.add(textField_3);
		
		JLabel label_4 = new JLabel("Codigo del Servicio");
		label_4.setBounds(11, 230, 117, 16);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(138, 230, 254, 26);
		contentPane.add(textField_4);
		
		JLabel label_5 = new JLabel("Cedula del Cliente");
		label_5.setBounds(11, 262, 106, 16);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(138, 262, 254, 26);
		contentPane.add(textField_5);
		
		JLabel lblTeleonoCliente = new JLabel("Nombre Cliente");
		lblTeleonoCliente.setBounds(11, 294, 106, 16);
		contentPane.add(lblTeleonoCliente);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(138, 294, 254, 26);
		contentPane.add(textField_6);
		
		JLabel lblApellidoCliente = new JLabel("Apellido Cliente");
		lblApellidoCliente.setBounds(11, 326, 106, 16);
		contentPane.add(lblApellidoCliente);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(138, 326, 254, 26);
		contentPane.add(textField_7);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono Cliente");
		lblTelefonoCliente.setBounds(11, 358, 106, 16);
		contentPane.add(lblTelefonoCliente);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(138, 358, 254, 26);
		contentPane.add(textField_8);
	}
}