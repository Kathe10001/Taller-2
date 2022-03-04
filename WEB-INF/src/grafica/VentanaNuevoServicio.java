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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaNuevoServicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCostoHora;
	private JTextField txtDistanciaKm;
	private JTextField txtCodigoServicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaNuevoServicio frame = new VentanaNuevoServicio();
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
	public VentanaNuevoServicio() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblArmadoMuebles = new JLabel("Armado de Muebles");
		lblArmadoMuebles.setBounds(11, 50, 118, 16);
		contentPane.add(lblArmadoMuebles);

		JLabel lblHoraInicio = new JLabel("Embalaje");
		lblHoraInicio.setBounds(11, 85, 93, 16);
		contentPane.add(lblHoraInicio);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 204, 51));

		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
			}
		});
		btnGuardar.setBounds(275, 228, 117, 29);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(204, 51, 51));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha cancelado la operacion");
			}
		});
		btnCancelar.setBounds(66, 228, 117, 29);
		contentPane.add(btnCancelar);

		JLabel lblIngreseLosDatos = new JLabel("Seleccione las opciones deseadas");
		lblIngreseLosDatos.setForeground(new Color(51, 51, 0));
		lblIngreseLosDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIngreseLosDatos.setBounds(46, 11, 329, 28);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblCostoHora = new JLabel("Costo por Hora");
		lblCostoHora.setBounds(11, 118, 106, 16);
		contentPane.add(lblCostoHora);

		JLabel lblDistanciaKm = new JLabel("Distancia en km");
		lblDistanciaKm.setBounds(11, 150, 118, 16);
		contentPane.add(lblDistanciaKm);

		JLabel lblCodigoServicio = new JLabel("Codigo del Servicio");
		lblCodigoServicio.setBounds(11, 184, 117, 16);
		contentPane.add(lblCodigoServicio);

		JRadioButton rdbtnSi = new JRadioButton(" SI");
		rdbtnSi.setBackground(SystemColor.activeCaptionBorder);
		rdbtnSi.setBounds(126, 47, 39, 23);
		contentPane.add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton(" NO");
		rdbtnNo.setBackground(SystemColor.activeCaptionBorder);
		rdbtnNo.setBounds(192, 47, 49, 23);
		contentPane.add(rdbtnNo);

		JRadioButton rdbtn2No = new JRadioButton(" NO");
		rdbtn2No.setBackground(SystemColor.activeCaptionBorder);
		rdbtn2No.setBounds(192, 81, 49, 23);
		contentPane.add(rdbtn2No);

		JRadioButton rdbtn2Si = new JRadioButton(" SI");
		rdbtn2Si.setBackground(SystemColor.activeCaptionBorder);
		rdbtn2Si.setBounds(126, 81, 39, 23);
		contentPane.add(rdbtn2Si);

		txtCostoHora = new JTextField();
		txtCostoHora.setBounds(127, 116, 105, 20);
		contentPane.add(txtCostoHora);
		txtCostoHora.setColumns(10);

		txtDistanciaKm = new JTextField();
		txtDistanciaKm.setColumns(10);
		txtDistanciaKm.setBounds(127, 147, 105, 20);
		contentPane.add(txtDistanciaKm);

		txtCodigoServicio = new JTextField();
		txtCodigoServicio.setColumns(10);
		txtCodigoServicio.setBounds(126, 182, 105, 20);
		contentPane.add(txtCodigoServicio);
	}
}