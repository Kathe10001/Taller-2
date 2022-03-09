package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controladores.ControladorMontoRecaudadoRangoFechas;

public class VentanaMontoRecaudadoRangoFechas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private ControladorMontoRecaudadoRangoFechas controlador = new ControladorMontoRecaudadoRangoFechas(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 238);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setBounds(11, 81, 117, 16);
		contentPane.add(lblFechaInicio);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(167, 76, 238, 26);
		contentPane.add(txtFechaInicio);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese fecha de inicio y fecha de fin en formato dd-mm-yyyy");
		lblIngreseLosDatos.setBounds(30, 6, 416, 45);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblFechaFin = new JLabel("Fecha de finalizacion");
		lblFechaFin.setBounds(11, 118, 144, 16);
		contentPane.add(lblFechaFin);

		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(167, 113, 238, 26);
		contentPane.add(txtFechaFin);
		
		VentanaMontoRecaudadoRangoFechas ventana = this;
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.montoRecaudado(txtFechaInicio.getText(), txtFechaFin.getText());
			}
		});
		btnAceptar.setBounds(272, 161, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnCancelar.setBounds(63, 161, 117, 29);
		contentPane.add(btnCancelar);

	}
}