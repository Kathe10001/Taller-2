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

public class VentanaMontoRecaudadoRangoFechas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMontoRecaudadoRangoFechas frame = new VentanaMontoRecaudadoRangoFechas();
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
	public VentanaMontoRecaudadoRangoFechas() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 238);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha de Inicio");
		lblFechaInicio.setBounds(11, 81, 93, 16);
		contentPane.add(lblFechaInicio);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(151, 76, 254, 26);
		contentPane.add(txtFechaInicio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 204, 51));
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "El Monto recaudado es: $...");
			}
		});
		btnAceptar.setBounds(272, 161, 117, 29);
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
		btnCancelar.setBounds(63, 161, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese Fecha Inicio y Fecha Fin para saber el monto recaudado");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIngreseLosDatos.setBounds(10, 3, 416, 45);
		contentPane.add(lblIngreseLosDatos);
		
		JLabel lblFechaFin = new JLabel("Fecha de Finalizacion");
		lblFechaFin.setBounds(11, 112, 130, 16);
		contentPane.add(lblFechaFin);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(151, 113, 254, 26);
		contentPane.add(txtFechaFin);
	}
}