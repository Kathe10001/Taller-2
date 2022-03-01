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
import javax.swing.JTable;

public class VentanaListadoMudanzasXFecha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFecha;
	private JTable table;
	private JTable table_1;
	private JTable lbltable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoMudanzasXFecha frame = new VentanaListadoMudanzasXFecha();
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
	public VentanaListadoMudanzasXFecha() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 204, 51));
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha procesado correctamente");
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
		
		JLabel lblIngreseLosDatos = new JLabel("Listado de Mudanzas por Fecha");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIngreseLosDatos.setBounds(54, 11, 338, 28);
		contentPane.add(lblIngreseLosDatos);
		
		JLabel lblFecha = new JLabel("Ingrese una Fecha");
		lblFecha.setBounds(11, 71, 117, 16);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(127, 66, 254, 26);
		contentPane.add(txtFecha);
		
		lbltable = new JTable();
		lbltable.setBounds(81, 182, 300, -58);
		contentPane.add(lbltable);
		
			}
}