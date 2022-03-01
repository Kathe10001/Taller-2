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
import java.awt.SystemColor;

public class VentanaFinalizacionMudanza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoServicio;
	private JTextField txtDuracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFinalizacionMudanza frame = new VentanaFinalizacionMudanza();
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
	public VentanaFinalizacionMudanza() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 204, 51));
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente, el costo de la mudanza es: $...");
			}
		});
		btnAceptar.setBounds(275, 228, 117, 29);
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
		btnCancelar.setBounds(66, 228, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseLosDatos =  new JLabel("Seleccione Finalizacion de Mudanza");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIngreseLosDatos.setBounds(34, 11, 358, 28);
		contentPane.add(lblIngreseLosDatos);
		
		JLabel lblCodigoServicio = new JLabel("Codigo del Servicio");
		lblCodigoServicio.setBounds(11, 71, 117, 16);
		contentPane.add(lblCodigoServicio);
		
		txtCodigoServicio = new JTextField();
		txtCodigoServicio.setColumns(10);
		txtCodigoServicio.setBounds(127, 66, 254, 26);
		contentPane.add(txtCodigoServicio);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(127, 109, 254, 26);
		contentPane.add(txtDuracion);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(11, 114, 117, 16);
		contentPane.add(lblDuracion);
	}
}